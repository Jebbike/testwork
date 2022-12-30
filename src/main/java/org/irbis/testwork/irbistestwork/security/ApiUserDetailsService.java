package org.irbis.testwork.irbistestwork.security;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ApiUserDetailsService {

    private final TokenRepository tokenRepository;

    public boolean tokenIsActive(UUID token) {
        return !tokenRepository.existsByToken(token);
    }

}
