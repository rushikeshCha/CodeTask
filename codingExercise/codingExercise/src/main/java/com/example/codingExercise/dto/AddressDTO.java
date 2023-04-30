package com.example.codingExercise.dto;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AddressDTO {
    private Long id;
    private String city;
    private String postalCode;

}
