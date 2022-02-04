package com.example.restapi.utility.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(UserNotFoundException.class) // exception handled
    public ResponseEntity<ErrorResponse> handleUserNotFoundExceptions(Exception exception){
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()), HttpStatus.NOT_FOUND);
    }
//    @ExceptionHandler(NullPointerException.class) // exception handled
//    public ResponseEntity<ErrorResponse> handleNullPointerExceptions( Exception exception){
//        HttpStatus status = HttpStatus.NOT_FOUND; //404
//        return new ResponseEntity<>(new ErrorResponse(status, exception.getMessage()), status);
//    }
//
//    @ExceptionHandler(Exception.class) // exception handled
//    public ResponseEntity<ErrorResponse> handleExceptions(Exception exception){
//        HttpStatus status = HttpStatus.MULTI_STATUS; // 500
//        // Converting the stack trace to a String
//        StringWriter stringWriter = new StringWriter();
//        PrintWriter printWriter = new PrintWriter(new StringWriter());
//        exception.printStackTrace(printWriter);
//        String stackTrace = stringWriter.toString();
//        return new ResponseEntity<>(new ErrorResponse(status, exception.getMessage(), stackTrace), status);
//    }
 }
