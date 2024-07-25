package com.example.spring.Service.ImpService;

import com.example.spring.Dto.StaffDto;
import com.example.spring.Dto.StaffLoginDto;
import com.example.spring.Entities.Staff;
import com.example.spring.Repository.StaffRepository;
import com.example.spring.Service.StaffService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StaffServiceImp implements StaffService {
    @Autowired
    private StaffRepository staffRepository;
    final private ModelMapper mapper;

    public StaffServiceImp(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public StaffDto Login(StaffLoginDto staff) {
        Staff sta = staffRepository.findStaff(staff.getStaffId(),staff.getStaffPassword());
        return mapper.map(sta, StaffDto.class);
    }

    @Override
    public StaffDto findStaffbyStaffId(String staffId) {
        Staff sta = staffRepository.findStaffbyStaffId(staffId);
        if(sta == null){
            return new StaffDto();
        }
        return mapper.map(sta, StaffDto.class);
    }

    @Override
    public List<StaffDto> getStaffDtoList() {
        return staffRepository.findAll().stream().map(staff->mapper.map(staff,StaffDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public StaffDto Save(StaffDto staff) {
        //staff.setLast_updated_dated(LocalDateTime.now());
        Staff staff1 = mapper.map(staff, Staff.class);
        return mapper.map(staffRepository.save(staff1),StaffDto.class);
    }

    @Override
    public boolean deleteStaff(String staffId) {
        Staff sta = staffRepository.findStaffbyStaffId(staffId);
        if(sta != null){
            staffRepository.delete(sta);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateStaff(String staffId, StaffDto staffDto) {
        Staff sta = staffRepository.findStaffbyStaffId(staffId);
        if(sta != null){
            sta.setStaff_password(staffDto.getStaff_password() != null ? staffDto.getStaff_password() : sta.getStaff_password());
            sta.setStaff_name(staffDto.getStaff_name() != null ? staffDto.getStaff_name()  :sta.getStaff_name());
            sta.setStaff_id(staffDto.getStaff_id() !=null ? staffDto.getStaff_id() :sta.getStaff_id());
            sta.setCreated_by(staffDto.getCreated_by() !=null  ? staffDto.getCreated_by() : sta.getCreated_by());
            sta.setCreate_dated(staffDto.getCreate_dated().toString() !=null  ? staffDto.getCreate_dated() : sta.getCreate_dated());
            sta.setLast_login(staffDto.getLast_login().toString() !=null ?staffDto.getCreate_dated() :sta.getCreate_dated());
            sta.setDepartment_id(staffDto.getDepartment_id() !=null ?staffDto.getDepartment_id() :sta.getDepartment_id());
            sta.setStatus(staffDto.getStatus() !=null ?staffDto.getStatus() :sta.getStatus());
            sta.setTerritory_code(staffDto.getTerritory_code() !=null ?staffDto.getTerritory_code() :sta.getTerritory_code());
            sta.setLast_updated_by(staffDto.getLast_updated_by() !=null ?staffDto.getLast_updated_by() :sta.getLast_updated_by());
            sta.setLast_updated_dated(staffDto.getLast_updated_dated().toString() !=null ? staffDto.getLast_updated_dated() :sta.getLast_updated_dated());
            staffRepository.save(sta);
            return true;
        }
        return false;
    }


}
