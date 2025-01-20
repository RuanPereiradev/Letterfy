package tech.biuldrun.spotify.service;

import org.springframework.stereotype.Service;
import tech.biuldrun.spotify.controller.CreateUserDto;
import tech.biuldrun.spotify.controller.UpdateUserDto;
import tech.biuldrun.spotify.entity.User;
import tech.biuldrun.spotify.repository.UserRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {


    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }//injeção de dependencia

    public UUID createUser(CreateUserDto createUserDto) {

        var entity = new User(
                UUID.randomUUID(),
                createUserDto.username(),
                createUserDto.email(),
                createUserDto.password(),//criptografar senha posteriormente
                Instant.now(),
                null
        );

        var userSaved = userRepository.save(entity);

        return userSaved.getUserId();
    }

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


    public void deleteById(String userId){

        var id = UUID.fromString(userId);

       var userExist = userRepository.existsById(id);

       if (userExist){
              userRepository.deleteById(id);
       }
    }
}
