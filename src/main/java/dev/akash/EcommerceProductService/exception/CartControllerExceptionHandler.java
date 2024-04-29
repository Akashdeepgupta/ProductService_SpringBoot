package dev.akash.EcommerceProductService.exception;

import dev.akash.EcommerceProductService.controller.CartController;
import dev.akash.EcommerceProductService.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = CartController.class)
public class CartControllerExceptionHandler {
    @ExceptionHandler(RandomException.class)
    public ResponseEntity handleCartRandomException(RandomException re){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                re.getMessage(),
                504
        );
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.NOT_FOUND);
    }
}
