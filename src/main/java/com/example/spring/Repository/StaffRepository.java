package com.example.spring.Repository;

import com.example.spring.Entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Long> {
    @Query("SELECT s FROM Staff s WHERE s.Staff_id = :staffid and s.Staff_password = :staffpassword")
    Staff findStaff(@Param("staffid") String staffid,@Param("staffpassword") String staffpassword);

    @Query("SELECT s FROM Staff s WHERE s.Staff_id = :staffid")
    Staff findStaffbyStaffId(String staffid);

}
