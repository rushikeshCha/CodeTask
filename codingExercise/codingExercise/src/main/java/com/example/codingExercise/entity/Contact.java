package com.example.codingExercise.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactId;
    private String fullName;
    private LocalDate dateOfBirth;
    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;
}
