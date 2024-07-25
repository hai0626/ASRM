package com.example.spring.Service.ImpService;

import com.example.spring.Dto.ProductDto;
import com.example.spring.Entities.Product;
import com.example.spring.Repository.ProductRepository;
import com.example.spring.Service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    final private ModelMapper mapper;

    public ProductServiceImp(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(product -> mapper.map(product,ProductDto.class)).
                collect(Collectors.toList());
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = mapper.map(productDto, Product.class);
        return mapper.map(productRepository.save(product), ProductDto.class);
    }

    @Override
    public ProductDto findProductById(String productCode) {
        Product product = productRepository.findProductByProductCode(productCode);
        if(product == null){
            return new ProductDto();
        }
        return mapper.map(product, ProductDto.class);
    }

    @Override
    public List<ProductDto> findProductByKeyword(String keyword) {
        return productRepository.findProductByKeyWord(keyword).stream().map(product -> mapper.map(product,ProductDto.class)).
                collect(Collectors.toList());
    }

    @Override
    public boolean deleteProduct(ProductDto product) {
        Product productDelete = mapper.map(product, Product.class);
        if(product != null){
            productRepository.delete(productDelete);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateProduct(String productCode,ProductDto product) {
        Product productUpdate = productRepository.findProductByProductCode(productCode);
        if(productUpdate != null){
            productUpdate.setProduct_name(product.getProduct_name());
            productUpdate.setProduct_code(product.getProduct_code());
            productUpdate.setDiscout_code(product.getDiscout_code());
            productUpdate.setDecription(product.getDecription());
            productUpdate.setLast_updated_by(product.getLast_updated_by());
            productUpdate.setPrice(product.getPrice());
            productUpdate.setStatus(product.getStatus());
            productUpdate.setCreate_dated(product.getCreate_dated());
            productUpdate.setCreated_by(product.getCreated_by());
            productUpdate.setLast_updated_dated(product.getLast_updated_dated());
            productUpdate.setImage_id(product.getImage_id());
            productRepository.save(productUpdate);
            return true;
        }
        return false;
    }

    @Override
    public Page<Product> getAllProductsWithPagination(int offset, int pageSize) {
        Page<Product> products = productRepository.findAll(PageRequest.of(offset, pageSize));
        return products;
    }
    public Page<Product> getAllProductsWithPaginationAndSorting(int offset, int pageSize, String field) {
        Page<Product> products = productRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return products;
    }
}
