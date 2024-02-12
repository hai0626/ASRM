package com.example.spring.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Privileges")
public class Privileges {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Role_id;
    private String Module_code;
    private String Access_code;
}
