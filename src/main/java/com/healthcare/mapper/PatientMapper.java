package com.healthcare.mapper;

import com.healthcare.dto.PatientRequestDTO;
import com.healthcare.dto.PatientResponseDTO;
import com.healthcare.model.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public Patient toEntity(PatientRequestDTO dto) {
        if (dto == null) return null;
        Patient patient = new Patient();
        patient.setName(dto.getName());
        patient.setAge(dto.getAge());
        patient.setGender(dto.getGender());
        patient.setEmail(dto.getEmail());
        patient.setPhoneNumber(dto.getPhoneNumber());
        patient.setMedicalHistory(dto.getMedicalHistory());
        return patient;
    }

    public PatientResponseDTO toDTO(Patient patient) {
        if (patient == null) return null;
        PatientResponseDTO dto = new PatientResponseDTO();
        dto.setId(patient.getId());
        dto.setName(patient.getName());
        dto.setAge(patient.getAge());
        dto.setGender(patient.getGender());
        dto.setEmail(patient.getEmail());
        dto.setPhoneNumber(patient.getPhoneNumber());
        dto.setMedicalHistory(patient.getMedicalHistory());
        return dto;
    }
}
