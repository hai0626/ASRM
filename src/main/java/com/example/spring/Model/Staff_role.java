//package com.example.spring.Model;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "Staff_role")
//public class Staff_role {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long Id;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "role_code", referencedColumnName = "role_code")
//    private Role role;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id")
//    private Staff staff;
//    private String Module_code;
//}
