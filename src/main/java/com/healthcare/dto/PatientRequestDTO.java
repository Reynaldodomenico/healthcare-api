package com.healthcare.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PatientRequestDTO {

    @NotBlank(message = "Patient name is required")
    private String name;

    @PositiveOrZero(message = "Age must be zero or positive")
    private Integer age;

    private String gender;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    private String phoneNumber;

    private String medicalHistory;

}
