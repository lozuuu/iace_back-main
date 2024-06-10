package com.garage.garage.Client;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


//@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Query(value = "select * from client where adres_email = ?1", nativeQuery = true)
    Client findByAdresEmail(String email);

}


