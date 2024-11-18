package com.hosing.back.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hosing.back.dto.response.ResponseDto;

@RestControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class, HttpMessageConversionException.class})
    public ResponseEntity<ResponseDto> validationExcepthionHandler(Exception exception) {
        return ResponseDto.validationFaill();
    }
    
}
