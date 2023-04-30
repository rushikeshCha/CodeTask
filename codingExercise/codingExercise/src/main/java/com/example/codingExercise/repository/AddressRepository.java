package com.example.codingExercise.repository;

import com.example.codingExercise.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
    Optional<Address> findAddressByPostalCode(String postalCode);
}
