package com.example.spring.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Territory")
public class Territory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;
    String Territory_code;
    String Territory_name;
    String Status;
    String Created_by;
    Date Create_dated;
    String Last_updated_by;
    Date Last_updated_dated;

}
