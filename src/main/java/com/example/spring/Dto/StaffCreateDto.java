package com.example.spring.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffCreateDto {
    private String Staff_id;
    private String Staff_name;
    private String Department_id;
    private String Territory_code;
    private String Staff_password;
    private Date Last_login;
    private String Status;
}
