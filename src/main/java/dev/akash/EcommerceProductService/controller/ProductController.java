package dev.akash.EcommerceProductService.controller;

import dev.akash.EcommerceProductService.dto.FakeStoreResponseDTO;
import dev.akash.EcommerceProductService.exception.InvalidInputException;
import dev.akash.EcommerceProductService.exception.RandomException;
import dev.akash.EcommerceProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    @Qualifier("productDB")
    ProductService productService; //

    @GetMapping("/product")
    public ResponseEntity getAllProducts(){
        List<FakeStoreResponseDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity getProductById(@PathVariable("id") int id){
        if(id<1){
            throw new InvalidInputException("Input is not correct");
        }
        FakeStoreResponseDTO fakeStoreResponseDTO = productService.getProduct(id);
        return ResponseEntity.ok(fakeStoreResponseDTO);
    }
    @GetMapping("/productexception")
    public ResponseEntity productException(){
        throw new RandomException("exception from product");
    }
}
