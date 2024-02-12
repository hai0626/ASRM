package com.example.spring.Service;

import com.example.spring.Dto.StaffLoginDto;
import com.example.spring.Entities.Staff;
import org.springframework.stereotype.Service;

@Service
public interface StaffService {
    Staff Login(Staff staff);
    Staff  findStaffbyStaffId(String staffId);
    Staff Save(Staff staff);
}
