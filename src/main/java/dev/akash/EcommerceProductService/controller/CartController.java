package dev.akash.EcommerceProductService.controller;

import dev.akash.EcommerceProductService.client.FakeStoreClient;
import dev.akash.EcommerceProductService.dto.FakeStoreCartResponseDTO;
import dev.akash.EcommerceProductService.exception.CartNotFoundException;
import dev.akash.EcommerceProductService.exception.RandomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    private FakeStoreClient fakeStoreClient;
    @GetMapping("/cart/{user_id}")
    public ResponseEntity getCartForUser(@PathVariable("user_id") int user_id){
        List<FakeStoreCartResponseDTO> cartResponseDTOS = fakeStoreClient.getCartByUserId(user_id);
        if (cartResponseDTOS == null){
            throw new CartNotFoundException("cart not found");
        }
        return ResponseEntity.ok(cartResponseDTOS);
    }

    @GetMapping("/cartexception")
    public ResponseEntity cartException(){
        throw new RandomException("exception from cart");
    }
}
