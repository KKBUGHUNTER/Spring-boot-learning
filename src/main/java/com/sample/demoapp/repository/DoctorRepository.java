package com.sample.demoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sample.demoapp.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
