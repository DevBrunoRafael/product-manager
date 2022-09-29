package com.devbrunorafael.backend_pm.api.dto.response;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductResponse {

    private String name;
    private String category;
    private BigDecimal price;
}
