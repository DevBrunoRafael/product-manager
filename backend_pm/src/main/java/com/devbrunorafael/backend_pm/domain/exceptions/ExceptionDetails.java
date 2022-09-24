package com.devbrunorafael.backend_pm.domain.exceptions;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
public class ExceptionDetails {

    protected int status;
    protected String title;
    protected String description;
    protected LocalDateTime timestamp;
    protected String developerMessage;
}
