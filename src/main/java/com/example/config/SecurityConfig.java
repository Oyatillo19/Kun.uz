package com.example.config;
import com.example.config.security.CustomUserDetails;
import com.example.config.security.CustomUserDetailsService;
import com.example.util.MD5Util;
import com.fasterxml.jackson.core.filter.TokenFilter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.UUID;

@EnableWebSecurity
@Component
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService userDetails;


//    @Bean
//    public AuthenticationProvider authenticationProvider1() {
//
//        // authentication
//        // login,password ACTIVE,
//        String password = UUID.randomUUID().toString();
//        System.out.println("User Pasword mazgi: " + password);
//
//        UserDetails user = User.builder()
//                .username("user")
//                .password("{noop}" + password)
//                .roles("USER")
//                .build();
//
//        final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(new InMemoryUserDetailsManager(user));
//        return authenticationProvider;
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().disable().cors().disable();

        http.authorizeHttpRequests()

                .requestMatchers(AUTH_WHITELIST).permitAll()
                .requestMatchers("api/v1/*/public/**").permitAll()
                .requestMatchers("api/v1/*/article/private").hasRole("MODERATOR")
                .requestMatchers("api/v1/auth/**").permitAll()
                .anyRequest()
                .authenticated();
        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetails);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                if (MD5Util.getMd5Hash(rawPassword.toString()).equals(encodedPassword)) {
                    return true;
                }
                return false;
            }
        };
    }

    public static String[] AUTH_WHITELIST = {"/api/v1/*/public/**",
            "/api/v1/auth/**",
            "/api/v1/auth"
    };

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }


}
