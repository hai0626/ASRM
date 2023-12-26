package com.example.spring.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Access")
public class Access {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;
    String Access_code;
    String Access_name;
    String Status;
}
