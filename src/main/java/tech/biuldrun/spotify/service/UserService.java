package tech.biuldrun.spotify.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tech.biuldrun.spotify.controller.dto.*;
import tech.biuldrun.spotify.entity.Account;
import tech.biuldrun.spotify.entity.Reviews;
import tech.biuldrun.spotify.entity.User;
import tech.biuldrun.spotify.repository.AccountRepository;
import tech.biuldrun.spotify.repository.UserRepository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class UserService {


    private UserRepository userRepository;

    private AccountRepository accountRepository;

    public UserService(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
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


    public void createAccount(String userId, CreateAccountDto createAccountDto) {
       var user =  userRepository.findById(UUID.fromString(userId))
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));


       //DTO->Entity
        var account = new Account(
                UUID.randomUUID(),
                createAccountDto.provider(),
                createAccountDto.providerId(),
                new ArrayList<>(),
                user
        );

        var accountCreated = accountRepository.save(account);

    }

    public AccountResponseDto getAccountByUserId(String userId) {
        Account account = accountRepository.findByUserUserId(UUID.fromString(userId))
                .orElseThrow(() ->  new RuntimeException("Account not found for userId: " + userId));

        return new AccountResponseDto(
                account.getAccountId().toString(),
                account.getProvider(),
                account.getProviderId(),
                account.getUser().getUserId().toString(),
                account.getUser().getUserName(),
                account.getUser().getEmail()
        );
    }





}








