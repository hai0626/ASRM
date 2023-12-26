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
@Table(name = "Territory")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;
    String StaffId;
    String Staff_name;
    String Department_id;
    String Territory_code;
    Date Last_login;
    String Status;
    String Created_by;
    Date Create_dated;
    String Last_updated_by;
    Date Last_updated_dated;

}
