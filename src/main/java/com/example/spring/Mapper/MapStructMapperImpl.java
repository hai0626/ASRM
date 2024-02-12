package com.example.spring.Mapper;

import com.example.spring.Dto.StaffDto;
import com.example.spring.Dto.StaffLoginDto;
import com.example.spring.Entities.Staff;
import org.springframework.stereotype.Component;

@Component
public class MapStructMapperImpl implements MapStructMapper{
    @Override
    public StaffLoginDto staffToStaffLoginDto(Staff staff) {
        if(staff == null){
            return null;
        }
        StaffLoginDto staffloginDto = new StaffLoginDto();
        staffloginDto.setStaffId(staff.getStaff_id());
        staffloginDto.setStaffPassword(staff.getStaff_password());
        return staffloginDto;
    }

    @Override
    public Staff staffLoginDtoToStaff(StaffLoginDto staffLoginDto) {
        if(staffLoginDto == null){
            return null;
        }
        Staff staff = new Staff();
        staff.setStaff_id(staffLoginDto.getStaffId());
        staff.setStaff_password(staffLoginDto.getStaffPassword());
        return staff;
    }

    @Override
    public StaffDto staffToStaffDto(Staff staff) {
        if(staff == null){
            return null;
        }
        StaffDto staffDto = new StaffDto();
        staffDto.setStaff_id(staff.getStaff_id());
        staffDto.setStaff_name(staff.getStaff_name());
        staffDto.setStaff_password(staff.getStaff_password());
        staffDto.setTerritory_code(staff.getTerritory_code());
        staffDto.setDepartment_id(staff.getDepartment_id());
        staffDto.setLast_login(staff.getLast_login());
        staffDto.setStatus(staff.getStatus());
        staffDto.setCreated_by(staff.getCreated_by());
        staffDto.setCreate_dated(staff.getCreate_dated());
        staffDto.setLast_updated_by(staff.getLast_updated_by());
        staffDto.setLast_updated_dated(staff.getLast_updated_dated());
        return staffDto;
    }
}
