package com.demo.authservice.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommonResource {
    @Getter
    @Value("${security.jwt.uri:/auth/**}")
    private String Uri;

    @Getter
    @Value("${security.jwt.header:Authorization}")
    private String header;

    @Getter
    @Value("${security.jwt.prefix:Bearer }")
    private String prefix;

    @Getter
    @Value("${security.jwt.expiration:#{60*60}}")
    private int expiration;

    @Getter
    @Value("${security.jwt.secret:JwtSecretKey}")
    private String secret;
}
