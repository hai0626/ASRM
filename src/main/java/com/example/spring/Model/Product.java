package com.example.spring.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.soap.Text;
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
    long Id;
    String Product_code;
    String Product_name;
    long Territory_code;
    BigDecimal price;
    String Decription;
    long Image_id;
    long Discout_code;
    String Status;
    String Created_by;
    Date Create_dated;
    String Last_updated_by;
    Date Last_updated_dated;

}
