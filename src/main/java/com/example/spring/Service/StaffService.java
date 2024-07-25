package com.example.spring.Service;


import com.example.spring.Dto.StaffDto;
import com.example.spring.Dto.StaffLoginDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StaffService {

    StaffDto Login(StaffLoginDto staff);
    StaffDto findStaffbyStaffId(String staffId);
    List<StaffDto> getStaffDtoList();
    StaffDto Save(StaffDto staff);

    boolean deleteStaff(String staffId);

    boolean updateStaff(String staffId, StaffDto staffDto);
}
