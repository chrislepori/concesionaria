package com.tech.concesionaria.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponseDto> handleApiException(ApiException apiException, HttpServletRequest request) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                LocalDateTime.now(),
                apiException.getError().getCode().value(),
                apiException.getError().getCode().toString(),
                apiException.getError().getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(errorResponseDto, apiException.getError().getCode());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleApiException(MethodArgumentNotValidException apiException, HttpServletRequest request) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                LocalDateTime.now(),
                apiException.getStatusCode().value(),
                apiException.getStatusCode().toString(),
                apiException.getLocalizedMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(errorResponseDto, apiException.getStatusCode());
    }


}
