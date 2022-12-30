package org.irbis.testwork.irbistestwork.security;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TokenRepository extends JpaRepository<UsersTokens, Long> {
    boolean existsByToken(UUID token);
}
