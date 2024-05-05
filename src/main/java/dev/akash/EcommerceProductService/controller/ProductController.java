package dev.akash.EcommerceProductService.controller;

import dev.akash.EcommerceProductService.dto.FakeStoreResponseDTO;
import dev.akash.EcommerceProductService.entity.Product;
import dev.akash.EcommerceProductService.exception.InvalidInputException;
import dev.akash.EcommerceProductService.exception.RandomException;
import dev.akash.EcommerceProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    @Qualifier("productDB")
    ProductService productService; //

    @GetMapping
    public ResponseEntity getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity getProductById(@PathVariable("id") UUID id){
        if(id == null){
            throw new InvalidInputException("Input is not correct");
        }
        Product fakeStoreResponseDTO = productService.getProduct(id);
        return ResponseEntity.ok(fakeStoreResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") UUID id ){
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    @PostMapping
    public ResponseEntity addProduct(@RequestBody Product product){
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable("id") UUID id, @RequestBody Product product ){
        Product updatedProduct = productService.updateProduct(product,id);
        return ResponseEntity.ok(updatedProduct);
    }

    @GetMapping("/productexception")
    public ResponseEntity productException(){
        throw new RandomException("exception from product");
    }

    @GetMapping("/{productTitle}")
    public ResponseEntity findProductByTitle(@PathVariable("productTitle") String productTitle){
        return ResponseEntity.ok( productService.findProductByTitle(productTitle));
    }

    @GetMapping("/{min}/{max}")
    public ResponseEntity findProductByPriceRange(@PathVariable("min") double min, @PathVariable("max") double max){
        List<Product> products = productService.findProductByPriceRange(min, max);
        return ResponseEntity.ok(products);
    }
}
