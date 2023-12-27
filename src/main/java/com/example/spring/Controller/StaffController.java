package com.example.spring.Controller;


import com.example.spring.Dto.StaffDto;
import com.example.spring.Model.Staff;
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
        Staff staff = staffService.Login(staffDto);
        if(staff!=null){
            return new ResponseEntity<Object>(staff, HttpStatus.OK);
        }
        return new ResponseEntity<Object>("Thong tin tai khoan hoac mat khau khong dung", HttpStatus.BAD_REQUEST);
    }
    @GetMapping("course")
    public String getLogout(){
        return "course";
    }
}
