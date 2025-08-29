package com.sebastian.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sebastian.model.Product;

public class ProductService {
    private List<Product> products; 

    public ProductService(){
        products = new ArrayList<>(); 
        loadProducts();
    }

    /**
     * THis method loads the "Recently viewed" when an instance is created. 
     */
    private void loadProducts(){
        products.add(new Product("Computer", "Macbook Air", 1, 12000, 12));
        products.add(new Product("Phone", "Iphone", 2, 13000, 20));
        products.add(new Product("Monitor", "AOC", 3, 120, 2));
    }

    //CRUD
    /**
     * This method allows you to add a new product avoiding the use of equal ids
     * @param product the product you want to add
     * @return the product added. 
     */
    public Product addProduct(Product product){
        if(products.contains(product) || products.stream().anyMatch(x -> x.getId() == product.getId())){
            throw new ProductInExistenceException("The product " + product.getName() + " Already exists");
        }

        products.add(product);
        System.out.println("Succesfull adding");
        return product; 
    }

    /**
     * THis method allows you to search for a product using its primary key
     * @param id the key of the product you want to search. 
     * @return the product found with that id
     */
    public Product SearchProduct(int id){
        Optional<Product> productFound = products.stream().filter(x -> x.getId() == id).findFirst();

        if(productFound.isPresent()){
            return productFound.get();
        }else{
            throw new ProductNotFoundException("The product with the specified id wasn't found");
        }
    }

    public ArrayList<Product> allProducts(){
        //return (ArrayList<Product>) products; 
        return new ArrayList<>(products);
    }

    /**
     * This method allows you to update a product already in existence
     * @param newProduct the object Product you want to replace the old one with
     * @param id the id of the old product
     * @return the product updated
     */
    public Product updateProduct(Product newProduct, int id){
        Optional<Product> productFound = products.stream().filter(x -> x.getId() == id).findFirst();

        if(productFound.isPresent()){
            Product existingProduct = productFound.get();
            existingProduct.setName(newProduct.getName());
            existingProduct.setName(newProduct.getDescription());
            existingProduct.setId(newProduct.getId());
            existingProduct.setPrice(newProduct.getPrice());
            existingProduct.setStock(newProduct.getStock());
            System.out.println("The update was succesful");
            return existingProduct;
        }else{
            throw new ProductNotFoundException("The product with the specified id can't be updatet, not found");
        }
    }

    public Product deleteProduct(int id){
        Optional<Product> productFound = products.stream().filter(x -> x.getId() == id).findFirst();

        if(productFound.isPresent()){
            products.remove(productFound.get());
            System.out.println("Deletion Completed");
            return productFound.get();
        }else{
            throw new ProductNotFoundException("The product with the specified id can't be deleted, not found");
        }
    }
}
