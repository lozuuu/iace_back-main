package com.garage.garage.controller;

import com.garage.garage.Client.Client;
import com.garage.garage.Client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {
    @Autowired
    private ClientRepository client;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
        public String goHome(){
        return "Hello World";

    @PostMapping("/user/save")
    }
}
