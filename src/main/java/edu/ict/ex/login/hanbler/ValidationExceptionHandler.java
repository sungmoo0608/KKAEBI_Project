package edu.ict.ex.login.hanbler;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import edu.ict.ex.login.dto.respose.auth.ResponseDto;

@RestControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class, HttpMessageConversionException.class})
    public ResponseEntity<ResponseDto> validationExcepthionHandler(Exception exception) {
        return ResponseDto.validationFaill();
    }
    
}
