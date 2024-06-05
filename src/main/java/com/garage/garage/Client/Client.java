package com.garage.garage.Client;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Client", schema = "mydb")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "Imie", length = 45)
    private String imie;

    @Column(name = "Nazwisko", length = 45)
    private String nazwisko;

    @Column(name = "Numer_telefonu", length = 45)
    private String numerTelefonu;

    @Column(name = "Adres_email", length = 45)
    private String adresEmail;

    @Column(name = "Haslo", length = 45)
    private String haslo;

    @Column(name = "Roles", length = 45)
    private String Roles;

}