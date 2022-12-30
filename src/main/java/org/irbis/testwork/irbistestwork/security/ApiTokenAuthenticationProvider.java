package org.irbis.testwork.irbistestwork.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ApiTokenAuthenticationProvider implements AuthenticationProvider {

    private final ApiUserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UUID apiToken = (UUID) authentication.getCredentials();
        if (userDetailsService.tokenIsActive(apiToken)) {
            authentication.setAuthenticated(true);
        }
        return authentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(ApiAuthenticationToken.class);
    }
}
