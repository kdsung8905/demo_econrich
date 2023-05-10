package com.example.econrich.handler;

import com.example.econrich.dto.ResponseDto;
import com.example.econrich.handler.exception.CustomApiException;
import com.example.econrich.handler.exception.CustomValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class CustomExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(CustomApiException.class)
    public ResponseEntity apiException(CustomApiException e){
        log.error(e.getMessage());
        return ResponseEntity.badRequest().body(new ResponseDto<>(-1, e.getMessage(), null));
    }

    @ExceptionHandler(CustomValidationException.class)
    public ResponseEntity validationApiException(CustomValidationException e){
        log.error(e.getMessage());
        return ResponseEntity.badRequest().body(new ResponseDto<>(-1, e.getMessage(), e.getErrorMap()));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e){
        log.error(e.getMessage());
        return ResponseEntity.badRequest().body(new ResponseDto<>(-1, e.getMessage(), null));
    }
}
