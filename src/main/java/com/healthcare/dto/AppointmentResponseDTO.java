package com.healthcare.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class AppointmentResponseDTO {

    private Long id;
    private LocalDateTime appointmentTime;

    private DoctorInfo doctor;
    private PatientInfo patient;

    @Setter
    @Getter
    public static class DoctorInfo {
        private Long id;
        private String firstName;
        private String lastName;
        private String specialty;

    }

    @Setter
    @Getter
    public static class PatientInfo {
        private Long id;
        private String name;
        private String email;

    }

}
