package dev.akash.EcommerceProductService.mapper;

import dev.akash.EcommerceProductService.dto.ProductResponseDTO;
import dev.akash.EcommerceProductService.entity.Product;

public class ProductEntityDTOMapper {
    public static ProductResponseDTO convertProductEntityToProductResponseDTO(Product product){
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        responseDTO.setProductId(product.getId());
        responseDTO.setTitle(product.getTitle());
        responseDTO.setCategory(product.getCategory());
        responseDTO.setRating(responseDTO.getRating());
        responseDTO.setPrice(responseDTO.getPrice());
        responseDTO.setImageURL(responseDTO.getImageURL());
        responseDTO.setDescription(product.getDescription());
        return responseDTO;
    }
}
