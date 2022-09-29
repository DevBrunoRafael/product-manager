package com.devbrunorafael.backend_pm.api.controllers;

import com.devbrunorafael.backend_pm.api.dto.request.ProductRequest;
import com.devbrunorafael.backend_pm.api.dto.response.ProductResponse;
import com.devbrunorafael.backend_pm.api.mapper.ProductMapper;
import com.devbrunorafael.backend_pm.domain.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/produtos")
public class ProductController {

    private ProductService productService;
    private ProductMapper productMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findProduct(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productMapper.toProductResponse(productService.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAllProducts(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productMapper.toListProductResponse(productService.findAll()));
    }

    @PostMapping
    public ResponseEntity<ProductResponse> registerProduct(@RequestBody @Valid ProductRequest productRequest){
        var product = productMapper.toProduct(productRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productMapper.toProductResponse(productService.save(product)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        productService.deleteById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("deleted product.");
    }
}
