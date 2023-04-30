package com.example.codingExercise.entity;

import io.swagger.v3.oas.annotations.info.Contact;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String city;
    @Column(unique = true)
    private String postalCode;

}
