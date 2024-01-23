package com.example.spring.Service.ImpService;

import com.example.spring.Dto.StaffDto;
import com.example.spring.Model.Staff;
import com.example.spring.Repository.StaffRepository;
import com.example.spring.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Optional;

@Component
public class StaffServiceImp implements StaffService {
    @Autowired
    private StaffRepository staffRepository;

    @Override
    public Staff Login(StaffDto staffDto) {
        return staffRepository.findStaff(staffDto.getStaffId(),staffDto.getStaffPassword());
    }

    @Override
    public Staff  findStaffbyStaffId(String staffId) {
        return staffRepository.findStaffbyStaffId(staffId);
    }

    @Override
    public Staff Save(Staff staff) {
        return staffRepository.save(staff);
    }


}
