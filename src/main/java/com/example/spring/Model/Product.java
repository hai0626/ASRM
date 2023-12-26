package com.example.spring.Model;

import javax.xml.soap.Text;
import java.math.BigDecimal;
import java.util.Date;

public class Product {
    long Id;
    String Product_code;
    String Product_name;
    long Territory_code;
    BigDecimal price;
    Text Decription;
    long Image_id;
    long Discout_code;
    String Status;
    String Created_by;
    Date Create_dated;
    String Last_updated_by;
    Date Last_updated_dated;

}
