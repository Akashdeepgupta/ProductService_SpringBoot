package dev.akash.EcommerceProductService.cllient;

import dev.akash.EcommerceProductService.dto.FakeStoreResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class FakeStoreClient {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Value("${fakestore.api.base.url}") //this annotation will fetch the value from application properties and inject here
    private String fakeStoreAPIBaseUrl;
    @Value("${fakestore.api.product.path}")
    private String fakeStoreAPIProductPath;

    public List<FakeStoreResponseDTO> getAllProducts(){
        String fakeStoreGetAllProductURL = fakeStoreAPIBaseUrl.concat(fakeStoreAPIProductPath);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreResponseDTO[]> productResponseList = restTemplate.getForEntity(fakeStoreGetAllProductURL,FakeStoreResponseDTO[].class);
        return List.of(productResponseList.getBody());
    }
}
