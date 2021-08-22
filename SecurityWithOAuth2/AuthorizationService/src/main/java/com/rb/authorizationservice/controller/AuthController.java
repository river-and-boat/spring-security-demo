package com.rb.authorizationservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @RequestMapping("/auth/success")
    public String authorizationSuccessful() {
        return "Authorize successful";
    }
}
