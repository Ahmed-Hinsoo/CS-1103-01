package com.ecommerce;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int customerID;
    private String name;
    private List<Product> shopingCart;

    public Customer(int customerID, String name) {
        this.customerID = customerID;
        this.name = name;
        this.shopingCart = new ArrayList<>();
    }

    public int getCustomerID() { return customerID; }
    public void setCustomerID(int id) { this.customerID = id; }
    public String getName() { return name; }
    public void setName(String n) { this.name = n; }

    public void addProduct(Product p) {
        shopingCart.add(p);
    }

    public void removeProduct(Product p) {
        shopingCart.remove(p);
    }

    public double calculateTotal() {
        double total = 0;
        for(Product p : shopingCart) {
            total += p.getPrice();
        }
        return total;
    }

    public List<Product> getCart() {
        return shopingCart;
    }
}

