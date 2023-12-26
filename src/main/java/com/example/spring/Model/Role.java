package com.example.spring.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;
    String Role_code;
    String Role_name;
    String Status;
    String Created_by;
    Date Create_dated;
    String Last_updated_by;
    Date Last_updated_dated;

}
