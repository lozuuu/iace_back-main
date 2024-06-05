package com.garage.garage.Car;

import com.garage.garage.Client.Client;
import com.garage.garage.Client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@RestController
@RequestMapping(path = "cars")
public class CarControler {
    @Autowired
    CarRepository carRepository;
    ClientRepository clientRepository;

    @PostMapping(path = "/clients/register/{id}")
    public ResponseEntity<Car> registerCar(@PathVariable int id, @RequestBody Car car){
        Optional<Client> client = Optional.of(new Client());
        client = clientRepository.findById(id);
        Client foundClient = new Client();
        if(client.isPresent()){
            foundClient.setId(client.get().getId());
            foundClient.setImie(client.get().getImie());
            foundClient.setNazwisko(client.get().getNazwisko());
            foundClient.setAdresEmail(client.get().getAdresEmail());
            foundClient.setHaslo(client.get().getHaslo());
            foundClient.setNumerTelefonu(client.get().getNumerTelefonu());
        }
        car.setIdKlienta(foundClient);
        carRepository.save(car);
        return ResponseEntity.ok(car);
    }

}
