package com.garage.garage.Reservation;

import com.garage.garage.Car.CarRepository;
import com.garage.garage.Client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/reservations/")

public class ReservationControler {
    @Autowired
    ReservationRepository reservationRepository;


    @GetMapping
    public ResponseEntity<List<Reservation>> getReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return ResponseEntity.ok(reservations);
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    @PostMapping(path = "/reservate/")
    public ResponseEntity<Object> createReservation(@RequestBody Reservation reservation) {
       //Reservation check = reservationRepository.checkDate(reservation.getDataRezerwacji(),reservation.getGodzinaRezerwacji()).map(Reservation.class);
//        if(check  == null)
//        {
         reservationRepository.save(reservation);
//        }



        return ResponseEntity.ok("Reservation created");
    }

  /*  @GetMapping(path = "/reservations/{id}")
    public ResponseEntity<List<Reservation>> getReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return ResponseEntity.ok(reservations);
    }
*/


}
