package com.garage.garage.Client;

import com.garage.garage.Client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public String saveClient(Client client){
        clientRepository.save(client);
        return "Success";
    }

}
