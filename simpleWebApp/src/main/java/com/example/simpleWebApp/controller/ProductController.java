package com.example.simpleWebApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.simpleWebApp.model.Product;
import com.example.simpleWebApp.service.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/productDetails")
    public List<Product> getProductDetails(){
        return productService.getAllProducts();
    }

    @RequestMapping("/id/{myId}")
    public Product getProductbyId(@PathVariable int myId){
        return  productService.findById(myId);
    }
    @PostMapping("/add")
    public Product addProducts(@RequestBody Product product){
        productService.addProduct(product);
        return product;
    }
    @DeleteMapping("/delete/{id}")
    public Product delete(@PathVariable int id){
        return productService.deleteProduct(id);
        
    }
    @PutMapping("/update/{id}")
    public Product updateProducts(@PathVariable int id, @RequestBody Product entity) {
         return productService.updateProduct(id,entity);
        
    }
    @PutMapping("/update")
    public Product updateProducts(@RequestBody Product entity) {
         return productService.updateProduct(entity);
        
    }

    

}
