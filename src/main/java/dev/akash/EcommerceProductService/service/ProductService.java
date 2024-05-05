package dev.akash.EcommerceProductService.service;

import dev.akash.EcommerceProductService.dto.FakeStoreResponseDTO;
import dev.akash.EcommerceProductService.entity.Product;
import dev.akash.EcommerceProductService.exception.ProductNotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProduct(UUID productId) throws ProductNotFoundException;
    Product createProduct(Product product);
    Product updateProduct(Product product, UUID productId);
    boolean deleteProduct(UUID productId);
    Product findProductByTitle(String title);

    List<Product> findProductByPriceRange(double min, double max);
}
