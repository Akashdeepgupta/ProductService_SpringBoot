package dev.akash.EcommerceProductService.repository;

import dev.akash.EcommerceProductService.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product findProductByTitle(String title);
    Product findFirstProductByTitle(String title);

    List<Product> findByPriceBetween(double minPrice, double maxPrice);
}
/**
 Custom JPA Queries
 - write in camel case with attribute name as method

 */
