package dev.akash.EcommerceProductService.controller;

import dev.akash.EcommerceProductService.dto.FakeStoreResponseDTO;
import dev.akash.EcommerceProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService; //

    @GetMapping("/product")
    public ResponseEntity getAllProducts(){
        List<FakeStoreResponseDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }
}
