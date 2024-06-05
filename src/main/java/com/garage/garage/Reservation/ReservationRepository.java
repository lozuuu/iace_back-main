package com.garage.garage.Reservation;

import com.garage.garage.Client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
