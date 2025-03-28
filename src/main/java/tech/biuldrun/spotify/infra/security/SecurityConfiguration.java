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

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    //configuração de segurança para desabilitar o csrf e a criação de sessão
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .cors(withDefaults()) // Habilita o CORS
                .csrf(csrf -> csrf.disable()) // Desabilita o CSRF, apropriado para APIs RESTful
                .sessionManagement(
                        sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll() // Permite o refresh
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll() // Permite o login
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll() // Permite o registro
                        .requestMatchers(HttpMethod.GET, "/spotify/api/albumsReleases").permitAll()
                        .requestMatchers(HttpMethod.GET, "/v1/album").permitAll()
                        .requestMatchers(HttpMethod.GET, "/v1/album/search").permitAll()

                        .requestMatchers(HttpMethod.GET, "/v1/album/{albumId}").permitAll()
                        .requestMatchers(HttpMethod.POST, "/v1/album").permitAll()
                        .requestMatchers(HttpMethod.POST, "/review").permitAll()
                        .requestMatchers(HttpMethod.GET, "/auth/users").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/v1/album/{albumId}").hasRole("ADMIN")
                        .anyRequest().authenticated() // Requer autenticação para outras requisições
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();

    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    //configuração de criptografia de senha
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Usando o BCrypt para criptografar senhas
    }
}
