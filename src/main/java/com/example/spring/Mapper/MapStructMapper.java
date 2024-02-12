package com.example.spring.Mapper;

import com.example.spring.Dto.StaffDto;
import com.example.spring.Dto.StaffLoginDto;
import com.example.spring.Entities.Staff;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {
    StaffLoginDto staffToStaffLoginDto(Staff staff);

    Staff staffLoginDtoToStaff (StaffLoginDto staffLoginDto);

    StaffDto staffToStaffDto(Staff staff);
}
