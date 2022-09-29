package com.devbrunorafael.backend_pm.api.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class ProductRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String category;

    @NotNull
    private BigDecimal price;
}
