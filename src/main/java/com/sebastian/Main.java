package com.sebastian;


import com.sebastian.model.Product;
import com.sebastian.service.ProductService;

public class Main {
    public static void main(String[] args) {
        ProductService service = new ProductService();

        service.addProduct(new Product("Speaker", "Speaker cool", 4, 12090, 5));
        System.out.println(service.SearchProduct(1).getName());
        service.updateProduct(new Product("Phone x", "Iphone cool wow", 5, 10009, 12), 3);
        service.deleteProduct(5);
        service.allProducts().forEach(System.out::println);
    }
}