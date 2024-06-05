package com.garage.garage.controller;

import com.garage.garage.Client.Client;
import com.garage.garage.Client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class Controller {
    @Autowired
    private ClientRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
        public String goHome() {
        return "Hello World";
    }
    @PostMapping("/user/save/")
    public ResponseEntity<Object> saveUser(@RequestBody Client client) {
        client.setHaslo(passwordEncoder.encode(client.getHaslo()));
        repo.save(client);
        if (client.getId() > 0){
            return ResponseEntity.ok("USer Was Saved");
        }
        return ResponseEntity.status(404).body("Error, USer Not Saved");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/user/getall/")
    public ResponseEntity<Object> getAllUsers() {
        return ResponseEntity.ok(repo.findAll());
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    @GetMapping("/user/single/")
    public ResponseEntity<Object> getSingleUser() {
        return ResponseEntity.ok(repo.findByAdresEmail(getLoggedInUserDetails().getUsername()));
    }

    public UserDetails getLoggedInUserDetails(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.getPrincipal() instanceof UserDetails){
            return (UserDetails) authentication.getPrincipal();
        }
        return null;
    }
}
