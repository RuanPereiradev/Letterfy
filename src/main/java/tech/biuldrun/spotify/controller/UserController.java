package tech.biuldrun.spotify.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tech.biuldrun.spotify.controller.dto.AuthenticationDto;
import tech.biuldrun.spotify.controller.dto.LoginResponseDto;
import tech.biuldrun.spotify.controller.dto.RegisterDto;
import tech.biuldrun.spotify.entity.User;
import tech.biuldrun.spotify.infra.security.TokenService;
import tech.biuldrun.spotify.repository.UserRepository;
import tech.biuldrun.spotify.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;



    public UserController(UserService userService) {
        this.userService = userService;
    }//injeção de dependencia

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDto data){

        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        System.out.println("successful login: " + data.login());

        return ResponseEntity.ok(new LoginResponseDto(token));


    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> listUsers(){
        var users =  userService.listUsers();
        return ResponseEntity.ok(users);
    }



    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDto data) {
        if (this.userRepository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();
        //pegando o rash da senha do usuário
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.role());
        this.userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") String userId) {
        var user = userService.getUserById(userId);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }




    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteById(@PathVariable("userId") String userId){
        userService.deleteById(userId);
        return ResponseEntity.noContent().build();
    }



}
