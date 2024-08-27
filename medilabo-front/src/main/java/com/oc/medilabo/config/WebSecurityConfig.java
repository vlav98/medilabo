package com.oc.medilabo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers(new AntPathRequestMatcher("/**"));
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
            (req) -> req.requestMatchers("/patients/**").authenticated()
                .requestMatchers("/notes/**").authenticated()
                .requestMatchers("/login/*").permitAll()
        ).formLogin(
            form -> form.loginPage("/login")
                .defaultSuccessUrl("/patients")
                .failureUrl("/login")
        ).logout(
            logout -> logout.logoutUrl("/logout")
                .deleteCookies("remove")
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .permitAll()
        )
        .csrf(AbstractHttpConfigurer::disable);

        return httpSecurity.build();
    }
}
