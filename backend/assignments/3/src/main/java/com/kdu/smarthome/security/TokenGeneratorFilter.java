package com.kdu.smarthome.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class TokenGeneratorFilter extends OncePerRequestFilter {
    public static final String JWT_KEY = "jxgEQeXHuPq8VdbyYFNkANdudQ53YUn4";
    public static final String JWT_HEADER = "jwtToken";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (null != authentication) {
            String jwt = generateJWT(authentication.getName());
            response.setHeader(JWT_HEADER, jwt);
        }

        filterChain.doFilter(request, response);
    }

    public String generateJWT(String username){
        SecretKey key = Keys.hmacShaKeyFor(JWT_KEY.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder().issuer("kdu").subject("JWT Token")
                .claim("username", username)
                .issuedAt(new Date())
                .expiration(new Date((new Date()).getTime() + 30000000))
                .signWith(key).compact();
    }


}
