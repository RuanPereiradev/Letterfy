package tech.biuldrun.spotify.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.biuldrun.spotify.controller.dto.AuthenticationDto;
import tech.biuldrun.spotify.controller.dto.RegisterDto;
import tech.biuldrun.spotify.entity.User;

import tech.biuldrun.spotify.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/auth")
public class UserController {


    @Autowired
    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }//injeção de dependencia

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDto registerDto) {
        userService.RegisterUser(registerDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDto authenticationDto){
       return userService.loginUser(authenticationDto);
    }


    @GetMapping("/users")
    public ResponseEntity<List<User>> listUsers(){
        var users =  userService.listUsers();
        return ResponseEntity.ok(users);
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
