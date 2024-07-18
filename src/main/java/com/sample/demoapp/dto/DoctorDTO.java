package com.sample.demoapp.dto;

import lombok.Data;

@Data
public class DoctorDTO {
    private Integer id;
    private String email;
    private String name;
    private String password;
    private Integer specializationId;
    private String specializationName;
    private Long clinicId;  
    private String clinicName;
}
