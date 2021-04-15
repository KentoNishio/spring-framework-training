package com.example.demo.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("dbUserDetailsService")
    @Autowired
    UserDetailsService userDetailsService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/authenticate")
                .usernameParameter("mail")
                .passwordParameter("password")
                .defaultSuccessUrl("/hello")
                .failureUrl("/login?error")
                .permitAll();


        http.authorizeRequests()
                .mvcMatchers("/api/**").permitAll()
                .anyRequest()
                .authenticated();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    void configureAuthenticationManager(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}
