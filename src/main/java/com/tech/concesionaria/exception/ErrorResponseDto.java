package com.tech.concesionaria.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ErrorResponseDto {

    private LocalDateTime timeStamp;
    private int status;
    private String errorCode;
    private String message;
    private String path;

}
