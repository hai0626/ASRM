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
    private long Role_id;
    private long Staff_id;
    private String Module_code;
}
