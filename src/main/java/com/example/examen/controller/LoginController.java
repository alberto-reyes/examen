package com.example.examen.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examen.auth.JwtService;
import com.example.examen.dto.LoginRequest;
import com.example.examen.dto.TokenDto;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class LoginController {

    final private  AuthenticationManager authenticationManager;
    private JwtService jwtService;


    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginRequest logginRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(logginRequest.getUser(), logginRequest.getPassword()));

        var token = jwtService.generateToken(logginRequest.getUser());

        return ResponseEntity.ok(new TokenDto(token));
    }

}
