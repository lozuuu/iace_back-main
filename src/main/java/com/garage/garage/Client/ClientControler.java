package com.garage.garage.Client;



import com.garage.garage.Client.Client;
import com.garage.garage.Client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/clients/")
public class ClientControler {
    @GetMapping("cos/")
    public String viewHomePage(){
        return "index";
    }
    @Autowired
    ClientRepository clientRepository;
    ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return ResponseEntity.ok(clients);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Client>> getClientById(@PathVariable int id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            return ResponseEntity.ok(client);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/register/")
    public String registerClient(@RequestBody Client client) {
        Client savedClient = new Client();
        savedClient = client;
        //savedClient.setIsClient(Boolean.TRUE);

        clientRepository.save(savedClient);
        return "SUCCESS";
    }
}

