package com.example.spring.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String Staff_id;
    private String Staff_name;
    private String Department_id;
    private String Territory_code;
    private String Staff_password;
    private Date Last_login;
    private String Status;
    private int Attempt;
    private String Created_by;
    private Date Create_dated;
    private String Last_updated_by;
    private Date Last_updated_dated;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "staffs_roles",
            joinColumns = @JoinColumn(name = "staff_id"),
            inverseJoinColumns = @JoinColumn(name = "role_code")
    )
    private Set<Role> roles = new HashSet<>();

}
