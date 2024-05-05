package dev.akash.EcommerceProductService.service;

import dev.akash.EcommerceProductService.dto.FakeStoreResponseDTO;
import dev.akash.EcommerceProductService.entity.Product;
import dev.akash.EcommerceProductService.exception.ProductNotFoundException;
import dev.akash.EcommerceProductService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("productDB")
public class ProductDBImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(UUID productId) throws ProductNotFoundException {
        /*
            //basic code to implement null check
         Product savedProduct = productRepository.findById(productId).orElse(null);
         if (savedProduct == null){
             throw new ProductNotFoundException("product not found for id :" + productId);
         }
         return  savedProduct;
         */

        return productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("product not found for id: " + productId)
        );
    }

    @Override
    public Product createProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    public Product updateProduct(Product updatedProduct, UUID productId) {
        Product savedProduct = getProduct(productId);
        savedProduct.setCategory(updatedProduct.getCategory());
        savedProduct.setPrice(updatedProduct.getPrice());
        savedProduct.setRating(updatedProduct.getRating());
        savedProduct.setTitle(updatedProduct.getTitle());
        savedProduct.setDescription(updatedProduct.getDescription());
        savedProduct.setImageURL(updatedProduct.getImageURL());
        savedProduct = productRepository.save(savedProduct);
        return savedProduct;
    }

    @Override
    public boolean deleteProduct(UUID productId) {
        productRepository.deleteById(productId);
        return true;
    }

    @Override
    public Product findProductByTitle(String title) {
        Product product = productRepository.findProductByTitle(title);
        return product;
    }

    @Override
    public List<Product> findProductByPriceRange(double min, double max) {
        List<Product> products = productRepository.findByPriceBetween(min,max);
        return products;
    }
}
