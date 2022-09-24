package com.devbrunorafael.backend_pm.domain.exceptions.validation;

import com.devbrunorafael.backend_pm.domain.exceptions.ExceptionDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder
public class ValidationExceptionDetails extends ExceptionDetails {

    private final List<Fields> fields;

    @Getter
    @Builder
    public static class Fields{
        String name;
        String message;
    }
}
