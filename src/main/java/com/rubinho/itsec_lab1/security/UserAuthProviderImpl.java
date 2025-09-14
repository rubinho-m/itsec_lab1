package com.rubinho.itsec_lab1.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;

@Component
public class UserAuthProviderImpl implements UserAuthProvider {
    @Value("${security.jwt.token.secret-key:default-secret-value}")
    private String secretKey;

    private static final int MS_IN_DAY = 86_400_000;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public String createToken(String login) {
        final Date now = new Date();
        final Date validity = new Date(now.getTime() + MS_IN_DAY);

        return JWT.create()
                .withIssuer(login)
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .sign(Algorithm.HMAC256(secretKey));
    }

    @Override
    public Authentication validateToken(String token) {
        final JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretKey))
                .build();
        final String login = verifier.verify(token).getIssuer();

        return new UsernamePasswordAuthenticationToken(login, null, Collections.emptyList());
    }
}