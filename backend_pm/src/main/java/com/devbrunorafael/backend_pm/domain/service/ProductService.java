package com.devbrunorafael.backend_pm.domain.service;

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
        return this.productRepository.findById(id).get();
    }

    public List<Product> findAll(){
        return this.productRepository.findAll();
    }

    public Product save(Product product){
        return this.productRepository.save(product);
    }

    public void deleteById(Long id){
        this.productRepository.deleteById(id);
    }
}