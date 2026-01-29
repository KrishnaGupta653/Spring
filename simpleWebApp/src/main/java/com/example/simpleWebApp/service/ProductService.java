package com.example.simpleWebApp.service;
import com.example.simpleWebApp.model.Product;
import com.example.simpleWebApp.repository.ProductRepo;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;


    List<Product> products=new ArrayList<>(Arrays.asList(
            new Product(1,"Laptop",800.00),
            new Product(2,"Smartphone",500.00),
            new Product(3,"Tablet",300.00),
            new Product(4,"Monitor",150.00)
    ));

    public List<Product> getAllProducts() {
        // return products;
        //using JPA
        return productRepo.findAll();
    }
    //1
    // public Product findById(int id){
    //     for(Product product:products){
    //         if(product.getId()==id){
    //             return product;
    //         }
    //     }
    //     return null;
    // }

    //2 using Stream API
    public Product findById(int id){
        // return products.stream()
        //         .filter(product -> product.getProductId() == id)
        //         .findFirst()
        //         .orElse(new Product(0,"Not Found",0.00));

        return productRepo.findById(id).orElse(new Product());
    }
    public void addProduct(Product product){
        // products.add(product);
        productRepo.save(product);
    }
    public Product deleteProduct(int id){
        // Product product = findById(id); // Reuse findById method to get the product which user wants to delete as we need to return it
        // products.remove(product);
        // return product;
        productRepo.deleteById(id);
        return new Product();
         
    }
    public Product updateProduct(int id, Product entity) {
        // Find the product by id
        Product existingProduct = findById(id);
        // Update the product details (for simplicity, just updating the name here)
        System.out.println("Updating product with id: " + id + " to new entity: " + entity);
        existingProduct.setProductId(id);
        if (entity.getProductName() != null) {
        existingProduct.setProductName(entity.getProductName());
        }
        if (entity.getProductPrice() != null) {
            existingProduct.setProductPrice(entity.getProductPrice());
        }

        return existingProduct;
    }
    public Product updateProduct(Product entity) {
        // int index=-1;
        // for(int i=0;i<products.size();i++){
        //     if(products.get(i).getProductId().equals(entity.getProductId())) {
        //         index=i;
        //         break;
        //     }
        // }
        // if(index==-1){
        //     throw new RuntimeException("Product not found with id: " + entity.getProductId()); 
        // }
        // products.set(index, entity);
        // return entity;
       
        // Using JPA
        //what save method does is if the entity with given id exists it updates else it creates a new one so it can be used for both create and update
        return productRepo.save(entity);

    }
}
