package org.irbis.testwork.irbistestwork.configuration.security;

import lombok.RequiredArgsConstructor;
import org.irbis.testwork.irbistestwork.security.ApiTokenAuthenticationProvider;
import org.irbis.testwork.irbistestwork.security.ApiTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final ApiTokenFilter tokenFilter;
    private final ApiTokenAuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .cors().disable()
                .csrf().disable()
                .authenticationProvider(authenticationProvider)
                .authorizeHttpRequests().anyRequest().authenticated().and()
                .addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class)
                .build();

    }

}
