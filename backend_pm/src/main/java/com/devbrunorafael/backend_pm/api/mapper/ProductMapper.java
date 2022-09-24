package com.devbrunorafael.backend_pm.api.mapper;

import com.devbrunorafael.backend_pm.api.dto.request.ProductRequest;
import com.devbrunorafael.backend_pm.domain.model.Product;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ProductMapper {

    private ModelMapper modelMapper;

    public Product toProduct(ProductRequest productRequest){
        return modelMapper.map(productRequest, Product.class);
    }

}
