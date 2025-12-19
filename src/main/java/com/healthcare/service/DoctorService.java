package com.healthcare.service;

import com.healthcare.model.Doctor;
import com.healthcare.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
        return doctorRepository.findById(id)
                .map(doctor -> {
                    doctor.setFirstName(updatedDoctor.getFirstName());
                    doctor.setLastName(updatedDoctor.getLastName());
                    doctor.setEmail(updatedDoctor.getEmail());
                    doctor.setSpecialty(updatedDoctor.getSpecialty());
                    return doctorRepository.save(doctor);
                }).orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
