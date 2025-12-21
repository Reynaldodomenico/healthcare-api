package com.healthcare.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PatientDTO {

    private String name;
    private Integer age;
    private String gender;
    private String email;
    private String phoneNumber;
    private String medicalHistory;

}
