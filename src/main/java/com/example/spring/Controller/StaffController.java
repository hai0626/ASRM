package com.example.spring.Controller;


import com.example.spring.Dto.StaffDto;
import com.example.spring.Model.Staff;

import com.example.spring.Service.AccountLockService;
import com.example.spring.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;


@RestController

@RequestMapping("/api/v1")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @Autowired
    AccountLockService accountLockService;
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody StaffDto staffDto){
        Staff check = staffService.findStaffbyStaffId(staffDto.getStaffId());
        Staff staff = staffService.Login(staffDto);

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
            //accountLockService.lockAccount(staffDto.getStaffId());
            check.setAttempt(check.getAttempt() + 1);
            /*check.setLast_login(new Date(22/01/2024));
            check.setCreate_dated(new Date(22/01/2024));
            check.setLast_updated_dated(new Date(22/01/2024));
            check.setLast_updated_dated(new Date(22/01/2024));
            check.setStatus("active");
            check.setTerritory_code("abvc");*/
            staffService.Save(check);
            return new ResponseEntity<Object>("Sai thong tin mat khau" , HttpStatus.BAD_REQUEST);
        }
        else{
            check.setAttempt(0);
            return new ResponseEntity<Object>(staff, HttpStatus.OK);
        }

    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

//    @PostMapping("/authenticate")
//    public String authenticateAndGetToken(@RequestBody StaffDto staffDto){
//        return jwtService.generateToken(staffDto.getStaffId());
//    }

}
