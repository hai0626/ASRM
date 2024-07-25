package com.example.spring.Controller;


import com.example.spring.Dto.ProductDto;
import com.example.spring.Dto.StaffDto;
import com.example.spring.Dto.StaffLoginDto;
import com.example.spring.Entities.Product;
import com.example.spring.Service.ProductService;
import com.example.spring.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController

@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    public ResponseEntity<Object> getAllStaff() {
        List<ProductDto> products = productService.getAllProducts();
        if (products == null) {
            return new ResponseEntity<Object>("Khong co danh sach", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Object>(products, HttpStatus.OK);
        }
    }
    @PostMapping("/createProduct")
    public ResponseEntity<Object> createProduct(@RequestBody ProductDto productDto) {
        ProductDto products = productService.createProduct(productDto);
        if (products == null) {
            return new ResponseEntity<Object>("Tao san pham khong thanh cong", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Object>(products, HttpStatus.OK);
        }
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Object> findProductByProductCode(@PathVariable String id) {
        ProductDto product = productService.findProductById(id);
        if (product == null || product.getId()==0) {
            return new ResponseEntity<Object>("Khong tim thay san pham", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Object>(product, HttpStatus.OK);
        }
    }
    @PostMapping("/deleteProduct/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable String id) {
        ProductDto product = productService.findProductById(id);
        if (product == null || product.getId()==0) {
            return new ResponseEntity<Object>("Khong tim thay san pham", HttpStatus.BAD_REQUEST);
        }
        boolean checkDeleteProduct = productService.deleteProduct(product);
        if(!checkDeleteProduct){
            return new ResponseEntity<Object>("Xoa san pham khong thanh cong", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>("Xoa san pham thanh cong", HttpStatus.OK);
    }

    @PostMapping("/updateProduct/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable String id, @RequestBody ProductDto productDto) {
        ProductDto productUpdate = productService.findProductById(id);
        if (productUpdate == null || productUpdate.getId()==0) {
            return new ResponseEntity<Object>("Khong tim thay san pham", HttpStatus.BAD_REQUEST);
        }
        boolean checkUpdateProduct = productService.updateProduct(id,productDto);
        if(!checkUpdateProduct){
            return new ResponseEntity<Object>("Sua san pham khong thanh cong", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>("Sua san pham thanh cong", HttpStatus.OK);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    public ResponseEntity<Object> getProductWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<Product> productsWithPagination = productService.getAllProductsWithPagination(offset,pageSize);
        if (productsWithPagination == null) {
            return new ResponseEntity<Object>("Khong tim thay san pham", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Object>(productsWithPagination, HttpStatus.OK);
        }
    }

    @GetMapping("/pagination/{offset}/{pageSize}/{field}")
    public ResponseEntity<Object> getProductWithPaginationAndSorting(@PathVariable int offset, @PathVariable int pageSize,@PathVariable String field) {
        Page<Product> productsWithPagination = productService.getAllProductsWithPaginationAndSorting(offset,pageSize,field);
        if (productsWithPagination == null) {
            return new ResponseEntity<Object>("Khong tim thay san pham", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Object>(productsWithPagination, HttpStatus.OK);
        }
    }

    @GetMapping("/product")
    public ResponseEntity<Object> findProductByKeyword(@RequestParam String keyword) {
        List<ProductDto> product = productService.findProductByKeyword(keyword);
        if (product == null) {
            return new ResponseEntity<Object>("Khong tim thay san pham", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Object>(product, HttpStatus.OK);
        }
    }
}
