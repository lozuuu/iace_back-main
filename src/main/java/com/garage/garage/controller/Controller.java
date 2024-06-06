package com.garage.garage.controller;

import com.garage.garage.Client.Client;
import com.garage.garage.Client.ClientRepository;
import com.garage.garage.Reservation.Reservation;
import com.garage.garage.Reservation.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class Controller {
    @Autowired
    private ClientRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ReservationRepository reservationRepo;

    @GetMapping("/")
        public String goHome() {
        return "Hello World";
    }
    @PostMapping("/user/save/")
    public ResponseEntity<Object> saveUser(@RequestBody Client client) {
        client.setHaslo(passwordEncoder.encode(client.getHaslo()));
        client.setRoles("USER");
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

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    @PostMapping(path = "/reservate/")
    public ResponseEntity<Object> createReservation(@RequestBody Reservation reservation) {
//
//        if(reservationRepo.checkDate(reservation.getDataRezerwacji(),reservation.getGodzinaRezerwacji()).isPresent())
//        {
//           //
//            return ResponseEntity.ok("Rezerwacja wyswietl");
//        }
//        else
//        {
//            reservationRepo.save(reservation);
//        }
        Optional<Reservation> reservationOp = Optional.of(new Reservation());
        reservationRepo.save(reservation);



        return ResponseEntity.ok("Reservation created");
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    @GetMapping(path = "/getReservations/")
    public ResponseEntity<Object> getReservations() {
        return ResponseEntity.ok(reservationRepo.findAll());
//        List<Reservation> reservations = reservationRepo.findAll();
//        return ResponseEntity.ok(reservations);
    }
}
