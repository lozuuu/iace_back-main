package com.garage.garage.Reservation;

import com.garage.garage.Car.Car;
import com.garage.garage.Client.Client;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "Reservation", schema = "mydb")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_rezerwacji", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_samochodu")
    private Car idSamochodu;

    @Column(name = "Opis_problemu", length = 200)
    private String opisProblemu;

    @Column(name = "Data_rezerwacji")
    private LocalDate dataRezerwacji;

    @Column(name = "Godzina_rezerwacji")
    private LocalTime godzinaRezerwacji;

    @Column(name = "Status", length = 45)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_klienta", nullable = true)
    private Client idKlienta;

}