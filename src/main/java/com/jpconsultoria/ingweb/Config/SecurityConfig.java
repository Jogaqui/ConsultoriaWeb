package com.jpconsultoria.ingweb.Config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity

public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
            return http
                .formLogin(form->form
                    .loginPage("/login")
                    .successHandler(successHandler())
                    .permitAll())
                .authorizeHttpRequests(auth->auth
                    .requestMatchers("/img/**", "/css/**").permitAll() 
                    .anyRequest()
                    .authenticated())
                .build();

   }

   public AuthenticationSuccessHandler successHandler(){
        return ((request, response, authentication)->{
            response.sendRedirect("/");
        });
   }



}
