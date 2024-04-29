package dev.akash.EcommerceProductService.service;

import dev.akash.EcommerceProductService.dto.FakeStoreResponseDTO;
import dev.akash.EcommerceProductService.entity.Product;
import dev.akash.EcommerceProductService.exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    List<FakeStoreResponseDTO> getAllProducts();
    FakeStoreResponseDTO getProduct(int productId) throws ProductNotFoundException;
    Product createProduct(Product product);
    Product updateProduct(Product product, int productId);
    boolean deleteProduct(int productId);
}
