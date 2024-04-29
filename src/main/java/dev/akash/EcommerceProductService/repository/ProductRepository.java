package dev.akash.EcommerceProductService.repository;

import dev.akash.EcommerceProductService.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
