package com.example.spring.Service.ImpService;

import com.example.spring.Dto.StaffLoginDto;
import com.example.spring.Entities.Staff;
import com.example.spring.Repository.StaffRepository;
import com.example.spring.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StaffServiceImp implements StaffService {
    @Autowired
    private StaffRepository staffRepository;

    @Override
    public Staff Login(Staff staff) {
        return staffRepository.findStaff(staff.getStaff_id(),staff.getStaff_password());
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
