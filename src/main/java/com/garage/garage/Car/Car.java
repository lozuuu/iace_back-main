package com.garage.garage.Car;

import com.garage.garage.Client.Client;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Car", schema = "mydb")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_samochodu", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "ID_klienta")
    private Client idKlienta;

    @Column(name = "Marka", length = 45)
    private String marka;

    @Column(name = "Model", length = 45)
    private String model;

    @Column(name = "Rok_produkcji", length = 45)
    private String rokProdukcji;

    @Column(name = "Numer_rejestracyjny", length = 45)
    private String numerRejestracyjny;

}