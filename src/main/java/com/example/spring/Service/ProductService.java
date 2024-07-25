package com.example.spring.Service;

import com.example.spring.Dto.ProductDto;
import com.example.spring.Entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService{
    List<ProductDto> getAllProducts();
    ProductDto createProduct(ProductDto productDto);

    ProductDto findProductById(String productCOde);

    List<ProductDto> findProductByKeyword(String keyword);

    boolean deleteProduct(ProductDto product);

    boolean updateProduct(String id,ProductDto product);

    Page<Product> getAllProductsWithPagination(int offset, int pageSize);
    Page<Product> getAllProductsWithPaginationAndSorting(int offset, int pageSize,String field);
}
