package com.example.spring.Service;

import com.example.spring.Dto.StaffDto;
import com.example.spring.Model.Staff;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface StaffService {
    Staff Login(StaffDto staffDto);
    Staff  findStaffbyStaffId(String staffId);
    Staff Save(Staff staff);
}
