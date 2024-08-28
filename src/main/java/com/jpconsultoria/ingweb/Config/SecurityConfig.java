package com.jpconsultoria.ingweb.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import com.jpconsultoria.ingweb.Servicios.UserDetailServicesImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    	return httpSecurity
    			.addFilterBefore(loggingFilter(), UsernamePasswordAuthenticationFilter.class)
    			.csrf(csrf -> csrf.disable())
            		.formLogin(form -> form
                    .loginPage("/login")
                    .successHandler(authenticationSuccessHandler())
                    .permitAll())
                .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/img/**", "/css/**").permitAll() 
                    .anyRequest().authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
                .build();
   }

    @Bean
    CommonsRequestLoggingFilter loggingFilter() {
        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
        filter.setIncludeQueryString(true);
        filter.setIncludePayload(true);
        filter.setMaxPayloadLength(10000);
        filter.setIncludeHeaders(true);
        return filter;
    }
    
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
 	   return ((request, response, authentication)->{
             response.sendRedirect("/");
             System.out.println("Redireccionando...");
         });
    }
    
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
	   return authenticationConfiguration.getAuthenticationManager();
   }
   
   @Bean
   AuthenticationProvider authenticationProvider(UserDetailServicesImpl userDetailServicesImpl) {
	   DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
	   provider.setPasswordEncoder(passwordEncoder());
	   provider.setUserDetailsService(userDetailServicesImpl);
	   return provider;
   }
   
   @Bean
   PasswordEncoder passwordEncoder() {
	   return new BCryptPasswordEncoder();
   }
   
}
