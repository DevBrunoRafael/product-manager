package com.devbrunorafael.backend_pm.domain.service;

import com.devbrunorafael.backend_pm.domain.exceptions.product.ProductNotFoundException;
import com.devbrunorafael.backend_pm.domain.model.Product;
import com.devbrunorafael.backend_pm.domain.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    public Product findById(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }
}