package com.example.coderock.controller;

import com.example.coderock.security.JwtSecurity.JwtHelper;
import com.example.coderock.security.model.JwtRequest;
import com.example.coderock.security.model.JwtResponse;
import com.example.coderock.service.serviceImpl.CustomeUserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/coderock/auth")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private CustomeUserServiceImpl userService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtHelper helper;

    @PostMapping(value = "/login", consumes = "application/json")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
        logger.info("login api called.");
        logger.info("Request: " + request);
        this.doAuthenticate(request.getUsername(), request.getPassword());
        UserDetails userDetails = userService.loadUserByUsername(request.getUsername());
        logger.info("user Details: " + userDetails);
        String token = this.helper.generateToken(userDetails);
        logger.info("Generated Token: " + token);

        JwtResponse response = JwtResponse.builder()
                .jwtToken(token)
                .username(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String username, String password) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, password);
        logger.info("authentication ticket: " + authentication);
        try {
            manager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Invalid Username or Password!!");
        } finally {
            logger.info("Authentication process done.");
        }
    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid!!";
    }


}
