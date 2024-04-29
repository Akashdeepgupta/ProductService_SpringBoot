package dev.akash.EcommerceProductService.client;

import dev.akash.EcommerceProductService.dto.FakeStoreCartResponseDTO;
import dev.akash.EcommerceProductService.dto.FakeStoreResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreClient {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Value("${fakestore.api.base.url}") //this annotation will fetch the value from application properties and inject here
    private String fakeStoreAPIBaseUrl;
    @Value("${fakestore.api.product.path}")
    private String fakeStoreAPIProductPath;
    @Value("${fakestore.api.cartForUser.path}")
    private String fakeStoreApiCartForUser;

    public List<FakeStoreResponseDTO> getAllProducts(){
        String fakeStoreGetAllProductURL = fakeStoreAPIBaseUrl.concat(fakeStoreAPIProductPath);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreResponseDTO[]> productResponseList = restTemplate.getForEntity(fakeStoreGetAllProductURL,FakeStoreResponseDTO[].class);
        return List.of(productResponseList.getBody());
    }

    public FakeStoreResponseDTO getProductById(int productId){
        String fakeStoreProductURL = fakeStoreAPIBaseUrl.concat(fakeStoreAPIProductPath).concat("/"+productId);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreResponseDTO> fakeStoreProductResponse = restTemplate.getForEntity(
                fakeStoreProductURL,FakeStoreResponseDTO.class
        );
        return fakeStoreProductResponse.getBody();
    }

    public List<FakeStoreCartResponseDTO> getCartByUserId(int user_id){
        if(user_id < 1){
            return null;
        }
        String getCartForUser = fakeStoreAPIBaseUrl.concat(fakeStoreApiCartForUser).concat("/"+user_id);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreCartResponseDTO[]> cartResponse = restTemplate.getForEntity(
                getCartForUser,FakeStoreCartResponseDTO[].class
        );
        return List.of(cartResponse.getBody());
    }
}

/*

{
    "id": 1,
    "userId": 1,
    "date": "2020-03-02T00:00:00.000Z",
    "products": [
      {
        "productId": 1,
        "quantity": 4
      },
      {
        "productId": 2,
        "quantity": 1
      },
      {
        "productId": 3,
        "quantity": 6
      }
    ],
    "__v": 0
  },

*/
