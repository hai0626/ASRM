package com.example.spring.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Staff_role")
public class Staff_role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Role_id;
    long Staff_id;
    String Module_code;
}
