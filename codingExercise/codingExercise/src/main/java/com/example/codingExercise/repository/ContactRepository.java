package com.example.codingExercise.repository;

import com.example.codingExercise.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {
//    @Query(value = "select * from Contact c where c.contactId in (select contactId from Address a where a.postalCode = :postalCode)", nativeQuery = true)
//    List<Contact> findByAddressPostalCode(String postalCode);

    List<Contact> findByAddressPostalCode(String postalCode);

}
