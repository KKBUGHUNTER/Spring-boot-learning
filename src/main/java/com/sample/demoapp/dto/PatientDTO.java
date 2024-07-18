package com.sample.demoapp.dto;

import lombok.Data;
import java.util.List;

@Data
public class PatientDTO {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private List<ClinicDTO> clinics;
    private List<DoctorDTO> doctors;
}
