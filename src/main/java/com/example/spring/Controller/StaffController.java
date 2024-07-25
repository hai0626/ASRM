package com.example.spring.Controller;


import com.example.spring.Dto.StaffCreateDto;
import com.example.spring.Dto.StaffDto;
import com.example.spring.Dto.StaffLoginDto;
import com.example.spring.Entities.Staff;

import com.example.spring.Mapper.MapStructMapper;
import com.example.spring.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@RestController

@RequestMapping("/api/v1")
public class StaffController {

    @Autowired
    private StaffService staffService;


    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody StaffLoginDto staffDto) {
        StaffDto staff = staffService.Login(staffDto);
        if (staff == null) {
            return new ResponseEntity<Object>("Khong ton tai tai khoan", HttpStatus.BAD_REQUEST);
        }
        if (staff.getStatus().equals("Inactive")) {
            return new ResponseEntity<Object>("Your account inactivate. Please contact admin.", HttpStatus.BAD_REQUEST);
        }

        staff.setLast_login(new Date());
        staffService.Save(staff);
        return new ResponseEntity<Object>(staff, HttpStatus.OK);
    }

    @GetMapping("/staff/{id}")
    public ResponseEntity<Object> findStaffById(@PathVariable String id) {
        StaffDto staff = staffService.findStaffbyStaffId(id);
        if (staff == null || staff.getId()==0) {
            return new ResponseEntity<Object>("Khong ton tai tai khoan", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Object>(staff, HttpStatus.OK);

        }
    }

    @PostMapping("/CreateStaff")
    public ResponseEntity<Object> create(@RequestBody StaffDto staffDto) {
        StaffDto staff = staffService.Save(staffDto);
        if (staff == null) {
            return new ResponseEntity<Object>("Create unsuccesfull", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Object>(staff, HttpStatus.OK);
        }
    }

    @GetMapping("/staff")
    public ResponseEntity<Object> getAllStaff() {
        List<StaffDto> staff = staffService.getStaffDtoList();
        if (staff == null) {
            return new ResponseEntity<Object>("Khong co danh sach", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Object>(staff, HttpStatus.OK);
        }
    }

    @PostMapping("/deletestaff/{id}")
    public ResponseEntity<Object> deleteStaff(@PathVariable String id) {
        boolean check = staffService.deleteStaff(id);
        if (check == false) {
            return new ResponseEntity<Object>("Khong tim thay staff", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Object>("Xoa thanh cong", HttpStatus.OK);
        }
    }

    @PostMapping("/updatestaff/{id}")
    public ResponseEntity<Object> updateStaff(@PathVariable String id,@RequestBody StaffDto staffDto) {
        boolean check = staffService.updateStaff(id,staffDto);
        if (check == false) {
            return new ResponseEntity<Object>("Khong tim thay staff", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Object>("sua thanh cong", HttpStatus.OK);
        }
    }


}
