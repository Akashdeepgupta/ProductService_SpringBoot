package dev.akash.EcommerceProductService.service;

import dev.akash.EcommerceProductService.cllient.FakeStoreClient;
import dev.akash.EcommerceProductService.dto.FakeStoreResponseDTO;
import dev.akash.EcommerceProductService.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements ProductService{

    @Autowired
    private FakeStoreClient fakeStoreClient;
    @Override
    public List<FakeStoreResponseDTO> getAllProducts() {
        List<FakeStoreResponseDTO> fakeStoreProduct = fakeStoreClient.getAllProducts();
        return fakeStoreProduct;
    }

    @Override
    public Product getProduct(int productId) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
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
