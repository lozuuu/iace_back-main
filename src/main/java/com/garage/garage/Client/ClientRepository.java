package com.garage.garage.Client;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Query(value = "select * from client where email = ?1", nativeQuery = true)
    Optional<Client> findByAdresEmail(String email);

}


