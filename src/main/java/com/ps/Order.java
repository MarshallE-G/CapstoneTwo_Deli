package com.ps;

/*
This class represents a single "order" from the deli. It is used to store/contain "products".
 */

import java.util.ArrayList;

public class Order implements Chargeable{
    private ArrayList<Product> products;
    
    // Constructor
    
    public Order(ArrayList<Product> products) {
        this.products = products;
    }
    
    // add(product) : void (adds products to order)
    public void add(Product product) {
        this.products.add(product);
    }
    
    // checkout() : void (calculates order price and displays order details)
    public void checkout() {
        double orderPrice = this.calcPrice();
        
        for (int i = 0; i < this.products.size(); i++) {
            System.out.println(products.get(i));
        }
    
        System.out.println("Total price: " + orderPrice);
    }
    
    @Override
    public double calcPrice() {
        double price = 0;
        for (int i = 0; i < this.products.size(); i++) {
            price += products.get(i).calcPrice();
        }
        return price;
    }
    
    
    // Getters and Setters
    public ArrayList<Product> getProducts() {
        return products;
    }
    
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    
    @Override
    public String toString() {
        return "Order{" +
                "products=" + products +
                '}';
    }
}
