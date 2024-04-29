package dev.akash.EcommerceProductService.exception;


import dev.akash.EcommerceProductService.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductServiceExceptionHandler {
    @ExceptionHandler({ProductNotFoundException.class, NoProductFoundException.class})
    public ResponseEntity handleProductNotFoundException(ProductNotFoundException pe){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                pe.getMessage(),
                404
        );
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity handleInvalidInputException(InvalidInputException ie){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                ie.getMessage(),
                400
        );
        return new ResponseEntity<>(exceptionResponseDTO,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity handleCartNotFoundException(CartNotFoundException ce){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                ce.getMessage(),
                404
        );
        return new ResponseEntity<>(exceptionResponseDTO,HttpStatus.NOT_FOUND);
    }


}
