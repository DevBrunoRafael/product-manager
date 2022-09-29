package com.devbrunorafael.backend_pm.api.mapper;

import com.devbrunorafael.backend_pm.api.dto.request.ProductRequest;
import com.devbrunorafael.backend_pm.api.dto.response.ProductResponse;
import com.devbrunorafael.backend_pm.domain.model.Product;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class ProductMapper {

    private ModelMapper modelMapper;

    public Product toProduct(ProductRequest productRequest){
        return modelMapper.map(productRequest, Product.class);
    }

    public ProductResponse toProductResponse(Product product){
        return modelMapper.map(product, ProductResponse.class);
    }

    public List<ProductResponse> toListProductResponse(List<Product> products){
        return products.stream().map(this::toProductResponse)
                .collect(Collectors.toList());
    }

}
