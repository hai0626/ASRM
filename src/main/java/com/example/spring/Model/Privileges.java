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
    long Role_id;
    String Module_code;
    String Access_code;
}
