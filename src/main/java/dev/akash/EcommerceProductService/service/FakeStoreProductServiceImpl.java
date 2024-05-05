package dev.akash.EcommerceProductService.service;

import dev.akash.EcommerceProductService.client.FakeStoreClient;
import dev.akash.EcommerceProductService.dto.FakeStoreResponseDTO;
import dev.akash.EcommerceProductService.entity.Product;
import dev.akash.EcommerceProductService.exception.NoProductFoundException;
import dev.akash.EcommerceProductService.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fakestore")
public class FakeStoreProductServiceImpl {

    @Autowired
    private FakeStoreClient fakeStoreClient;

    public List<FakeStoreResponseDTO> getAllProducts() {
        List<FakeStoreResponseDTO> fakeStoreProduct = fakeStoreClient.getAllProducts();
        if(fakeStoreProduct ==null){
            throw new NoProductFoundException("there is no products available");
        }
        return fakeStoreProduct;
    }


    public FakeStoreResponseDTO getProduct(int productId) throws ProductNotFoundException{
        FakeStoreResponseDTO fakeStoreResponseDTO = fakeStoreClient.getProductById(productId);
        if(fakeStoreResponseDTO == null){
            throw new ProductNotFoundException("The Product you requested does not exist, the product id : "+ productId + " is not found");
        }
        return fakeStoreResponseDTO;
    }




    public Product createProduct(Product product) {
        return null;
    }


    public Product updateProduct(Product product, int productId) {
        return null;
    }


    public boolean deleteProduct(int productId) {
        return false;
    }
}
