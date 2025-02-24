package tech.biuldrun.spotify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import tech.biuldrun.spotify.controller.dto.*;
import tech.biuldrun.spotify.entity.User;
import tech.biuldrun.spotify.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;



@Component
public class UserService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByLogin(username);
    }


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }//injeção de dependencia


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








