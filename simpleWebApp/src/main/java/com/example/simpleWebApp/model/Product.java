package com.example.simpleWebApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor // Generates constructor with all arguments
// @AllArgsConstructor generates only constructor
// @Data generates getters, setters, toString, equals, hashCode
@NoArgsConstructor  
public class Product {
    // Nothing is “wrong” syntactically if you use int and double, but your REST API will break on partial JSON updates because Jackson cannot assign null to primitive types.
    @Id
    private Integer productId;
    private String productName;
    private Double productPrice;

    //Already created by Lombok
    // public int getProductId() {
    //     return productId;
    // }
    // public String getProductName() {
    //     return productName;
    // }
    // public void setProductName(String productName) {
    //     this.productName = productName;
    // }
    // public double getProductPrice() {
    //     return productPrice;
    // }
    // public void setProductPrice(double productPrice) {
    //     this.productPrice = productPrice;
    // }
}