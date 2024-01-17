package com.example.spring.Controller;


import com.example.spring.Dto.StaffDto;
import com.example.spring.Model.Staff;

import com.example.spring.Service.AccountLockService;
import com.example.spring.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/v1")
public class StaffController {

    @Autowired
    private StaffService staffService;


    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody StaffDto staffDto){
        Optional<Staff> check = staffService.findStaffbyStaffId(staffDto.getStaffId());
        Staff staff = staffService.Login(staffDto);
        AccountLockService accountLockService = new AccountLockService();
        if(!check.isPresent()){
            return new ResponseEntity<Object>("Khong ton tai tai khoan", HttpStatus.BAD_REQUEST);
        }
        if(staff==null){
            accountLockService.lockAccount(staffDto.getStaffId());
            return new ResponseEntity<Object>("Sai thong tin tai khoan", HttpStatus.BAD_REQUEST);
        }
        if(staffDto.getAttempts() >3){
            return new ResponseEntity<Object>("Account locked", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(staff, HttpStatus.OK);
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
