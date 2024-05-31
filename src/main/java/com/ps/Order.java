package com.ps;

/*
This class represents a single "order" from the deli. It is used to store/contain "products".
 */

import java.util.ArrayList;

public class Order implements Priceable {
    private ArrayList<Product> products;
    
    public Order() {
        this.products = new ArrayList<>();
    }
    
    public void add(Product product) {
        this.products.add(product);
    }
    
    public void clear() {
        this.products.clear();
    }
    
    public void checkout() {
        double orderPrice = this.calcPrice();
    
        System.out.println("Your Order details:\n");
        for (Product product : this.products) {
            System.out.println(product);
        }
    
        System.out.printf("\u001b[1;4mTotal price:\u001b[24m $%.2f\u001b[22m\n", orderPrice);
    }
    
    @Override
    public double calcPrice() {
        double price = 0;
        for (int i = 0; i < this.products.size(); i++) {
            price += products.get(i).calcPrice();
        }
        return price;
    }
    
    
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
