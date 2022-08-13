package com.devbrunorafael.backend_pm.api.controllers;

import com.devbrunorafael.backend_pm.domain.model.Product;
import com.devbrunorafael.backend_pm.domain.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/produtos")
public class ProductController {

    private ProductService productService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product findProduct(@PathVariable Long id){
        return this.productService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findAllProducts(){
        return this.productService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product registerProduct(@RequestBody Product product){
        return this.productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        this.productService.deleteById(id);
    }
}
