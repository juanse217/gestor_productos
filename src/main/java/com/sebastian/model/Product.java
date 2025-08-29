package com.sebastian.model;

/**
 * This class allows you to model a Product with some basic parameters. The ID is the primary key. 
 */
public class Product {
    private String name; 
    private String description;
    private int id; 
    private double price; 
    private int stock;

    public Product(String name, String description, int id, double price, int stock) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    //Genera un codigo hash que identifica nuestro objeto en memoria, especialmente en Maps. 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + id;
        long temp;
        temp = Double.doubleToLongBits(price);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + stock;
        return result;
    }

    //Compara los valores de las fields para determinar si son iguales. 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (id != other.id)
            return false;
        if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
            return false;
        if (stock != other.stock)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", description=" + description + ", id=" + id + ", price=" + price + ", stock="
                + stock + "]";
    } 

    
    
}
