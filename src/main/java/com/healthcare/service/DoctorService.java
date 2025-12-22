package com.healthcare.service;

import com.healthcare.dto.DoctorRequestDTO;
import com.healthcare.dto.DoctorResponseDTO;
import com.healthcare.exception.ResourceNotFoundException;
import com.healthcare.model.Doctor;
import com.healthcare.repository.DoctorRepository;
import com.healthcare.mapper.DoctorMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    public DoctorService(DoctorRepository doctorRepository, DoctorMapper doctorMapper) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }

    public DoctorResponseDTO createDoctor(DoctorRequestDTO dto) {
        if (doctorRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalStateException("Doctor with email " + dto.getEmail() + " already exists");
        }
        Doctor doctor = doctorMapper.toEntity(dto);
        Doctor saved = doctorRepository.save(doctor);
        return doctorMapper.toDTO(saved);
    }

    public List<DoctorResponseDTO> getAllDoctors() {
        return doctorRepository.findAll().stream()
                .map(doctorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public DoctorResponseDTO getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + id));
        return doctorMapper.toDTO(doctor);
    }

    public DoctorResponseDTO updateDoctor(Long id, DoctorRequestDTO dto) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + id));

        doctor.setFirstName(dto.getFirstName());
        doctor.setLastName(dto.getLastName());
        doctor.setEmail(dto.getEmail());
        doctor.setSpecialty(dto.getSpecialty());

        Doctor updated = doctorRepository.save(doctor);
        return doctorMapper.toDTO(updated);
    }

    public void deleteDoctor(Long id) {
        if (!doctorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Doctor not found with id: " + id);
        }
        doctorRepository.deleteById(id);
    }
}
