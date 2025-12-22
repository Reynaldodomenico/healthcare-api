package com.healthcare.service;

import com.healthcare.dto.AppointmentRequestDTO;
import com.healthcare.dto.AppointmentResponseDTO;
import com.healthcare.exception.ResourceNotFoundException;
import com.healthcare.model.Appointment;
import com.healthcare.model.Doctor;
import com.healthcare.model.Patient;
import com.healthcare.repository.AppointmentRepository;
import com.healthcare.repository.DoctorRepository;
import com.healthcare.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public AppointmentService(AppointmentRepository appointmentRepository,
                              DoctorRepository doctorRepository,
                              PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    public AppointmentResponseDTO createAppointment(AppointmentRequestDTO dto) {
        Doctor doctor = doctorRepository.findById(dto.getDoctorId())
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + dto.getDoctorId()));
        Patient patient = patientRepository.findById(dto.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + dto.getPatientId()));

        Appointment appointment = new Appointment();
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setAppointmentTime(dto.getAppointmentTime());

        Appointment saved = appointmentRepository.save(appointment);
        return mapToResponseDTO(saved);
    }

    public List<AppointmentResponseDTO> getAllAppointments() {
        return appointmentRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    public AppointmentResponseDTO getAppointmentById(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id: " + id));
        return mapToResponseDTO(appointment);
    }

    public void deleteAppointment(Long id) {
        if (!appointmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Appointment not found with id: " + id);
        }
        appointmentRepository.deleteById(id);
    }

    private AppointmentResponseDTO mapToResponseDTO(Appointment appointment) {
        AppointmentResponseDTO dto = new AppointmentResponseDTO();
        dto.setId(appointment.getId());
        dto.setAppointmentTime(appointment.getAppointmentTime());

        AppointmentResponseDTO.DoctorInfo doctorInfo = new AppointmentResponseDTO.DoctorInfo();
        Doctor doctor = appointment.getDoctor();
        doctorInfo.setId(doctor.getId());
        doctorInfo.setFirstName(doctor.getFirstName());
        doctorInfo.setLastName(doctor.getLastName());
        doctorInfo.setSpecialty(doctor.getSpecialty());
        dto.setDoctor(doctorInfo);

        AppointmentResponseDTO.PatientInfo patientInfo = new AppointmentResponseDTO.PatientInfo();
        Patient patient = appointment.getPatient();
        patientInfo.setId(patient.getId());
        patientInfo.setName(patient.getName());
        patientInfo.setEmail(patient.getEmail());
        dto.setPatient(patientInfo);

        return dto;
    }
}
