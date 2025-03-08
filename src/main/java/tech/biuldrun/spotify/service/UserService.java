package tech.biuldrun.spotify.service;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import tech.biuldrun.spotify.controller.dto.*;
import tech.biuldrun.spotify.entity.User;
import tech.biuldrun.spotify.infra.security.TokenService;
import tech.biuldrun.spotify.repository.UserRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;



@Component
public class UserService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;


    @Autowired
    @Lazy
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userRepository.findByLogin(login);
    }


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }//injeção de dependencia


    public ResponseEntity RegisterUser(RegisterDto registerDto){
        if(this.userRepository.findByLogin(registerDto.login()) != null){
            throw new IllegalArgumentException("Usuário já existe");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDto.password());
        User newUser = new User(UUID.randomUUID(), registerDto.login(), encryptedPassword, Instant.now(), registerDto.role());
        this.userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity loginUser(AuthenticationDto authenticationDto){
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationDto.login(),authenticationDto.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDto(token));
    }

//
//
//    @PostMapping("/login")
//    public ResponseEntity login(@RequestBody @Valid AuthenticationDto data){
//
//        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
//        var auth = this.authenticationManager.authenticate(usernamePassword);
//
//        var token = tokenService.generateToken((User) auth.getPrincipal());
//
//        System.out.println("successful login: " + data.login());
//
//        return ResponseEntity.ok(new LoginResponseDto(token));
//
//
//    }

    public Optional<User> getUserById(String userId) {
        return userRepository.findById(UUID.fromString(userId));

    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public void updateUserById(String userId, UpdateUserDto updateUserDto){
        var id = UUID.fromString(userId);
        var userEntity = userRepository.findById(id);

        if (userEntity.isPresent()){
            var user = userEntity.get();
            if (updateUserDto.username() != null){
                user.setUserName(updateUserDto.username());

            }
            if (updateUserDto.password() != null){
                user.setPassword(updateUserDto.password());

            }

            userRepository.save(user);
        }
    }


    //necessita de revisão
    public void deleteById(String userId) {
        UUID id;

        try {
            id = UUID.fromString(userId);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID inválido");
        }

        boolean userExists = userRepository.existsById(id);

        if (!userExists) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }

        userRepository.deleteById(id);
    }



}








