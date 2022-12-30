package org.irbis.testwork.irbistestwork.security;

import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;

import java.util.Collections;
import java.util.UUID;

@Getter
public class ApiAuthenticationToken extends AbstractAuthenticationToken {

    private final UUID token;

    public ApiAuthenticationToken(UUID token) {
        super(Collections.emptyList());
        this.token = token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}
