package com.example.codingExercise.dto;

import com.example.codingExercise.entity.Address;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ContactDTO {
    private Long id;
    private String fullName;
    private LocalDate dateOfBirth;
    private AddressDTO addressDTO;
}
