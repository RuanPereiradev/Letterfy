package tech.biuldrun.spotify.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.biuldrun.spotify.controller.dto.AuthenticationDto;
import tech.biuldrun.spotify.controller.dto.CreateUserDto;
import tech.biuldrun.spotify.controller.dto.RegisterDto;
import tech.biuldrun.spotify.entity.User;
import tech.biuldrun.spotify.repository.UserRepository;
import jakarta.validation.Valid;

import java.time.Instant;
import java.util.UUID;


@RestController
@RequestMapping("/auth")
public class AuthenticatorController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDto data){
        var usernamePassoword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassoword);

        return ResponseEntity.ok().build();

    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDto data){
        if(this.userRepository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        //pegando o rash da senha do usuário
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(
                UUID.randomUUID(),
                data.email(), encryptedPassword,
                data.password(),
                Instant.now(),
                data.role()
        );
        this.userRepository.save(newUser);
        return ResponseEntity.ok().build();


    }


    }


