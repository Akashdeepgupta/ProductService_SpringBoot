package dev.akash.EcommerceProductService.service;

import dev.akash.EcommerceProductService.dto.FakeStoreResponseDTO;
import dev.akash.EcommerceProductService.entity.Product;

import java.util.List;

public interface ProductService {
    List<FakeStoreResponseDTO> getAllProducts();
    Product getProduct(int productId);
    Product createProduct(Product product);
    Product updateProduct(Product product, int productId);
    boolean deleteProduct(int productId);
}
