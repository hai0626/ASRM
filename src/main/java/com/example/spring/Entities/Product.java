package com.example.spring.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String Product_code;
    private String Product_name;
    private long Territory_code;
    private BigDecimal price;
    private String Decription;
    private long Image_id;
    private long Discout_code;
    private String Status;
    private String Created_by;
    private Date Create_dated;
    private String Last_updated_by;
    private Date Last_updated_dated;

}
