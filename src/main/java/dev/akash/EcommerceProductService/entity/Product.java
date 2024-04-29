package dev.akash.EcommerceProductService.entity;

//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Product {
    @Id
    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String imageURL;
    private double rating;
}
