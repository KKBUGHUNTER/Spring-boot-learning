package com.sample.demoapp.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    // A Patient Can Visit Any Number of Clinics
    @ManyToMany
    @JoinTable(
        name = "patient_clinic_visit",
        joinColumns = @JoinColumn(name = "patient_id"),
        inverseJoinColumns = @JoinColumn(name = "clinic_id")
    )
    private List<Clinic> clinics;

    // A Patient Can Visit Any Number of Doctors
    @ManyToMany
    @JoinTable(
        name = "patient_doctor_visit",
        joinColumns = @JoinColumn(name = "patient_id"),
        inverseJoinColumns = @JoinColumn(name = "doctor_id")
    )
    private List<Doctor> doctors;
}
