package com.garage.garage.Reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    @Query(value = "select * from reservation where data_rezerwacji = ?1 and godzina_rezerwacji = ?2 ", nativeQuery = true)
    Optional<Reservation>checkDate(LocalDate date, LocalTime time);

    @Query(value = "select * from reservation where data_rezerwacji = ?1",nativeQuery = true)
    Optional<List<Reservation>> checkAdminDate(LocalDate date);

    @Query(value = "select * from reservation where id_klienta = ?1", nativeQuery = true)
    Optional<List<Reservation>> checkUserId(int id);

}
