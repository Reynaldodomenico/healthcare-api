package com.healthcare.mapper;

import com.healthcare.dto.DoctorRequestDTO;
import com.healthcare.dto.DoctorResponseDTO;
import com.healthcare.model.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {

    public Doctor toEntity(DoctorRequestDTO dto) {
        if (dto == null) return null;
        Doctor doctor = new Doctor();
        doctor.setFirstName(dto.getFirstName());
        doctor.setLastName(dto.getLastName());
        doctor.setEmail(dto.getEmail());
        doctor.setSpecialty(dto.getSpecialty());
        return doctor;
    }

    public DoctorResponseDTO toDTO(Doctor doctor) {
        if (doctor == null) return null;
        DoctorResponseDTO dto = new DoctorResponseDTO();
        dto.setId(doctor.getId());
        dto.setFirstName(doctor.getFirstName());
        dto.setLastName(doctor.getLastName());
        dto.setEmail(doctor.getEmail());
        dto.setSpecialty(doctor.getSpecialty());
        return dto;
    }
}
