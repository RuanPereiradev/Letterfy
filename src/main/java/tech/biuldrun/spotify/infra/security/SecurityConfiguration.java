package tech.biuldrun.spotify.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    SecurityFilter securityFilter;



    @Bean
    //configuração de segurança para desabilitar o csrf e a criação de sessão
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(sessionManagement
                        -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(
                        //configuração de autorização para permitir o login e o registro de usuários
                        authorizeRequests -> authorizeRequests
                                .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                                .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                                .requestMatchers(HttpMethod.GET, "/spotify/api/albumsReleases").permitAll()
                                .requestMatchers(HttpMethod.POST, "/v1/album").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST, "/v1/reviews").hasRole("USER")
                                .requestMatchers(HttpMethod.GET, "/auth/users").hasRole("ADMIM")//desability filter before test
                                .requestMatchers(HttpMethod.DELETE, "/v1/album/{albumId}").hasRole("ADMIN")
                                .anyRequest().authenticated()
                        )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();

    }
    //configuração de autenticação para permitir a injeção de dependência do AuthenticationManager
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    //configuração de criptografia de senha
    @Bean
    public PasswordEncoder passwordEncouder(){ return new BCryptPasswordEncoder(); }
}
