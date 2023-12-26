package com.example.spring.Repository;

import com.example.spring.Model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface StaffRepository extends JpaRepository<Staff,Long> {
}
