package com.bachelor.backend.security;

import com.bachelor.backend.domain.users.UsersService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.Collections;

@Component
public class CustomTokenAuthenticationProvider implements AuthenticationProvider {

    @Inject
    UsersService usersService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String token = authentication.getCredentials().toString();

        if (usersService.isTokenValid(email, token)) {
            return new UsernamePasswordAuthenticationToken(email, token, Collections.emptyList());
        } else {
            throw new BadCredentialsException("Authentication failed");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

