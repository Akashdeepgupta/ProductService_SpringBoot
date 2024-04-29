package dev.akash.EcommerceProductService.service;

import dev.akash.EcommerceProductService.dto.FakeStoreResponseDTO;
import dev.akash.EcommerceProductService.entity.Product;
import dev.akash.EcommerceProductService.exception.ProductNotFoundException;
import dev.akash.EcommerceProductService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productDB")
public class ProductDBImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<FakeStoreResponseDTO> getAllProducts() {
        return null;
    }

    @Override
    public FakeStoreResponseDTO getProduct(int productId) throws ProductNotFoundException {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    public Product updateProduct(Product product, int productId) {
        return null;
    }

    @Override
    public boolean deleteProduct(int productId) {
        return false;
    }
}
