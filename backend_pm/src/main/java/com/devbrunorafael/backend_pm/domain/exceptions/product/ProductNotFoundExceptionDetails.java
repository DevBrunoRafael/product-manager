package com.devbrunorafael.backend_pm.domain.exceptions.product;

import com.devbrunorafael.backend_pm.domain.exceptions.ExceptionDetails;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ProductNotFoundExceptionDetails extends ExceptionDetails {
}
