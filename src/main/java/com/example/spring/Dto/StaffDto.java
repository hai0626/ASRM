package com.example.spring.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffDto {
    private String staffId;
    private String staffPassword;
    private int attempts;

}
