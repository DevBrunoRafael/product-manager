package com.devbrunorafael.backend_pm.api.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class ProductRequest {

    @NotBlank(message = "este campo não pode ser vazio")
    private String name;

    @NotBlank(message = "este campo não pode ser vazio")
    private String category;

    @NotNull(message = "este campo não pode ser null")
    private BigDecimal price;
}
