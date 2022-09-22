package com.demo.authservice.security;

import com.demo.authservice.common.CommonResource;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.stream.Collectors;


@Component
public class JwtTokenProvider {

    @Autowired
    private CommonResource commonResource;

    public String generateToken(Authentication authentication) {

        Long now = System.currentTimeMillis();

        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim("authorities", authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + commonResource.getExpiration() * 1000))
                .signWith(SignatureAlgorithm.HS512, commonResource.getSecret().getBytes())
                .compact();
    }
}