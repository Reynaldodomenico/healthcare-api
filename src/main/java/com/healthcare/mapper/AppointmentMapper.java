package com.healthcare.mapper;

import com.healthcare.dto.AppointmentResponseDTO;
import com.healthcare.model.Appointment;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {

    /**
     * Convert Appointment entity to AppointmentResponseDTO
     */
    public AppointmentResponseDTO toDTO(Appointment appointment) {
        if (appointment == null) return null;

        AppointmentResponseDTO dto = new AppointmentResponseDTO();
        dto.setId(appointment.getId());
        dto.setAppointmentTime(appointment.getAppointmentTime());

        if (appointment.getDoctor() != null) {
            AppointmentResponseDTO.DoctorInfo doctorInfo = new AppointmentResponseDTO.DoctorInfo();
            doctorInfo.setId(appointment.getDoctor().getId());
            doctorInfo.setFirstName(appointment.getDoctor().getFirstName());
            doctorInfo.setLastName(appointment.getDoctor().getLastName());
            doctorInfo.setSpecialty(appointment.getDoctor().getSpecialty());
            dto.setDoctor(doctorInfo);
        }

        if (appointment.getPatient() != null) {
            AppointmentResponseDTO.PatientInfo patientInfo = new AppointmentResponseDTO.PatientInfo();
            patientInfo.setId(appointment.getPatient().getId());
            patientInfo.setName(appointment.getPatient().getName());
            patientInfo.setEmail(appointment.getPatient().getEmail());
            dto.setPatient(patientInfo);
        }

        return dto;
    }
}