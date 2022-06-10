package com.bridgelabz.cartservices.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.cartservices.dto.ResponseDTO;


@ControllerAdvice
public class CartExceptionalHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception){

        List<ObjectError> errorList=exception.getBindingResult().getAllErrors();
        List<String> errMesg = errorList.stream()
                .map(objErr->objErr.getDefaultMessage())
                .collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST requests",errMesg);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CartException.class)
    public ResponseEntity<ResponseDTO> handleCartNotFound(CartException exception) {
        ResponseDTO response = new ResponseDTO("Invalid CartID input", exception.getMessage());
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.BAD_REQUEST);
    }
}