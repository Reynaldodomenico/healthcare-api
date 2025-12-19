package com.healthcare.model;

import jakarta.persistence.*;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;
    private String gender;
    private String email;
    private String phoneNumber;

    @Column(length = 1000)
    private String medicalHistory;

    public Patient() {}

    public Patient(String name, Integer age, String gender,
                   String email, String phoneNumber, String medicalHistory) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.medicalHistory = medicalHistory;
    }

    // Getters & Setters (required by JPA)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getMedicalHistory() { return medicalHistory; }
    public void setMedicalHistory(String medicalHistory) { this.medicalHistory = medicalHistory; }
}
