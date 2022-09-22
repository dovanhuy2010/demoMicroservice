package com.demo.authservice.payload;


import lombok.Getter;
import lombok.Setter;

public class JwtAuthenticationResponse {

    @Setter
    @Getter
    private String accessToken;
    @Getter
    private String tokenType = "Bearer";

    public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
