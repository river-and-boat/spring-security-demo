package com.rb.authorizationservice.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/user/detail")
    public Authentication getUserDetail(Authentication authentication) {
        return authentication;
    }
}
