package com.sample.demoapp.dto;

import lombok.Data;
import java.util.List;

@Data
public class ClinicDTO {
    private Long id;
    private String name;
    private String address;
    private List<DoctorDTO> doctors;
}
