package com.gostack.fastfeetbackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class DeliveryManException extends RuntimeException {

    public DeliveryManException(String message) {
        super(message);
    }
}
