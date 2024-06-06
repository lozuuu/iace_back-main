package com.garage.garage.Reservation;

import com.garage.garage.Client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    @Query(value = "select * from reservation where data_rezerwacji = ?1 ", nativeQuery = true)
    Optional<Reservation>checkDate(LocalDate date, LocalTime time);

}
