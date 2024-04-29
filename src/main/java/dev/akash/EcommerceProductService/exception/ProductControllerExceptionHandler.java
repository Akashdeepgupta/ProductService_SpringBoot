package dev.akash.EcommerceProductService.exception;

import dev.akash.EcommerceProductService.controller.ProductController;
import dev.akash.EcommerceProductService.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = ProductController.class)
public class ProductControllerExceptionHandler {
    @ExceptionHandler(RandomException.class)
    public ResponseEntity handleProductRandomException(RandomException re){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                re.getMessage(),
                404
        );
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.NOT_FOUND);
    }
}
