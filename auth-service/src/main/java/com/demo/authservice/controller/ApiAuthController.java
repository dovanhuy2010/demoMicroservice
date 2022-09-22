package com.demo.authservice.controller;

import com.demo.authservice.common.CommonResource;
import com.demo.authservice.dto.UserRequest;
import com.demo.authservice.security.JwtTokenProvider;
import com.netflix.client.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api/auth")
public class ApiAuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CommonResource commonResource;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ResponseEntity<?> authUser(HttpServletRequest request,HttpServletResponse response, @RequestBody UserRequest userRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userRequest.getUsername(),
                        userRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt =tokenProvider.generateToken(authentication);
        response.addHeader(commonResource.getHeader(),commonResource.getPrefix()+jwt);
        return ResponseEntity.ok("jwt:Bearer "+jwt);
    }
}
