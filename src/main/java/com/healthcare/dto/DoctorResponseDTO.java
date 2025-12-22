package com.healthcare.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DoctorResponseDTO {

    // Getters & Setters
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String specialty;

}
