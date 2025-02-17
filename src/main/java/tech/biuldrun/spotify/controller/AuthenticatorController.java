package tech.biuldrun.spotify.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.biuldrun.spotify.controller.dto.AuthenticationDto;
import tech.biuldrun.spotify.controller.dto.RegisterDto;
import tech.biuldrun.spotify.entity.User;
import tech.biuldrun.spotify.repository.UserRepository;


@RestController
@RequestMapping("/v1/authorization")
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
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.email(), encryptedPassword, data.role());
        this.userRepository.save(newUser);
        return ResponseEntity.ok().build();


    }


    }

}
