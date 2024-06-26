package com.garage.garage.Config;

import com.garage.garage.Client.Client;
import com.garage.garage.Client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@Configuration
public class OurUserInfoUserDetailsService implements UserDetailsService {
    @Autowired
    private ClientRepository repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Client> user = Optional.ofNullable(repo.findByAdresEmail(username));
        return user.map(OurUserInfoUserDetails::new).orElseThrow(()->new UsernameNotFoundException("user does not exist"));

    }
}
