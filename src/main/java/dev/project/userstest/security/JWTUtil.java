package dev.project.userstest.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.security.Key;
import java.util.Date;
import java.util.Optional;

@Component
public class JWTUtil {

    public String generateToken(UserDetails user) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, key)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * expiration))
                .compact();
    }

    public String getUserName(Claims claims) {
        return Optional.ofNullable(claims)
                .map(Claims::getSubject)
                .orElse(null);
    }

    public Date expirationDate(Claims claims) {
        return Optional.ofNullable(claims)
                    .map(Claims::getExpiration)
                .orElse(null);
    }

    public boolean validateToken(UserDetails user, String token) {
        return validateToken(user, getClaims(token));
    }

    public boolean validateToken(UserDetails user, Claims claims) {
        return Optional.ofNullable(claims)
                .filter(cls -> !isExpired(cls))
                .map(Claims::getSubject)
                .filter(user.getUsername()::equals)
                .isPresent();
    }

    public boolean isExpired(Claims claims) {
        if (claims == null)
            return true;

        Date today = new Date(System.currentTimeMillis());
        return claims.getExpiration().compareTo(today) <= 0;
    }

    public Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();
    }

    public String getUserName(String token) {
        return getUserName(getClaims(token));
    }

    public boolean isExpired(String token) {
        return isExpired(getClaims(token));
    }

    public String getToken(HttpServletRequest request) {
        String token =request.getHeader(AUTHORIZATION);

        if (StringUtils.hasText(token) && token.contains(BEARER))
            token = token.replaceAll(BEARER, "");

        return token;
    }

    private static final String AUTHORIZATION = "authorization";
    private static final String BEARER = "Bearer";

    @Value("${token.key}")
    private String key;

    @Value("${token.expiration}")
    private Long expiration;
}
