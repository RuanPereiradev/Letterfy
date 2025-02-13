package tech.biuldrun.spotify.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.biuldrun.spotify.controller.dto.AccountResponseDto;
import tech.biuldrun.spotify.controller.dto.CreateAccountDto;
import tech.biuldrun.spotify.controller.dto.CreateUserDto;
import tech.biuldrun.spotify.entity.User;
import tech.biuldrun.spotify.service.UserService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("v1/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }//injeção de dependencia

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserDto createUserDto) {
        var userId = userService.createUser(createUserDto);
        return ResponseEntity.created(URI.create("/v1/users/" + userId.toString())).build();

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

    @GetMapping
    public ResponseEntity<List<User>> listUsers(){
     var users =  userService.listUsers();
     return ResponseEntity.ok(users);
    }



    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteById(@PathVariable("userId") String userId){
        userService.deleteById(userId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{userId}/accounts")
    public ResponseEntity<Void> createAccount(@PathVariable("userId") String userId,
                                              @RequestBody CreateAccountDto createAccountDto){
        userService.createAccount(userId, createAccountDto);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{userId}/accounts")
    public ResponseEntity<AccountResponseDto> getAccountByUserId(@PathVariable("userId") String userId) {
        AccountResponseDto accountResponseDto = userService.getAccountByUserId(userId);
        return ResponseEntity.ok(accountResponseDto);
    }


}
