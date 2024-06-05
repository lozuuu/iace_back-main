//package com.garage.garage.Client;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
////czat kazał dodać service zeby dzialalo @autowired
//@Service
//public class CustomClientDetailsService implements UserDetailsService {
//
//     @Autowired
//    private ClientRepository repo;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Client client = repo.findByAdresEmail(email);
//        if(client == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        return new CustomClientDetails(client);
//    }
//}