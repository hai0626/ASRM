package com.example.spring.Controller;


import com.example.spring.Dto.StaffCreateDto;
import com.example.spring.Dto.StaffLoginDto;
import com.example.spring.Entities.Staff;

import com.example.spring.Mapper.MapStructMapper;
import com.example.spring.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController

@RequestMapping("/api/v1")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private MapStructMapper mapstructMapper;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody StaffLoginDto staffDto){

        Staff check = staffService.findStaffbyStaffId(staffDto.getStaffId());
        Staff staff = staffService.Login(mapstructMapper.staffLoginDtoToStaff(staffDto));
        if(check==null){
            return new ResponseEntity<Object>("Khong ton tai tai khoan", HttpStatus.BAD_REQUEST);
        }
        if(check.getStatus().equals("Inactive")){
            return new ResponseEntity<Object>("Your account inactivate. Please contact admin.", HttpStatus.BAD_REQUEST);
        }
        if(check.getAttempt()>=3){
            check.setStatus("Inactive");
            staffService.Save(check);
            return new ResponseEntity<Object>("Account locked", HttpStatus.BAD_REQUEST);
        }

        if(staff==null){
            check.setAttempt(check.getAttempt() + 1);
            staffService.Save(check);
            return new ResponseEntity<Object>("Sai thong tin mat khau" , HttpStatus.BAD_REQUEST);
        }
        else{
            check.setAttempt(0);
            check.setLast_login(new Date());
            staffService.Save(check);
            return new ResponseEntity<Object>(mapstructMapper.staffToStaffLoginDto(staff), HttpStatus.OK);
        }


    }

    @GetMapping("/CreateStaff")
    public ResponseEntity<Object> create(@RequestBody StaffCreateDto staffCreateDto){

        return new ResponseEntity<Object>("Sai thong tin mat khau" , HttpStatus.BAD_REQUEST);
    }


}
