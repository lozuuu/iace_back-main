package com.garage.garage.Reservation;

import com.garage.garage.Client.Client;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Getter
@Setter
@Entity

@Table(name = "Reservation", schema = "mydb")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_rezerwacji", nullable = false)
    private Integer id;

    @Column(name = "Opis_problemu", length = 200)
    private String opisProblemu;

    @Column(name = "Data_rezerwacji", nullable = true)
    private LocalDate dataRezerwacji;

    @Column(name = "Godzina_rezerwacji", nullable = true)
    private LocalTime godzinaRezerwacji;

    @Column(name = "Status", length = 45)
    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_klienta", nullable = true)
    private Client idKlienta;

}