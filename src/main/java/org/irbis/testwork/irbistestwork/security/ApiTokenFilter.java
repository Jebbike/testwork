package org.irbis.testwork.irbistestwork.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class ApiTokenFilter extends OncePerRequestFilter {

    private static final String BEARER_AUTHORIZATION_SCHEME = "Bearer";

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain
    ) throws ServletException, IOException {
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith(BEARER_AUTHORIZATION_SCHEME)) {
            UUID token = extractApiToken(authorizationHeader);
            Authentication authentication = new ApiAuthenticationToken(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

    private UUID extractApiToken(String header) {
        String token = header.substring(BEARER_AUTHORIZATION_SCHEME.length()).strip();
        return UUID.fromString(token);
    }

}
