package com.ecommerce.orders;
import com.ecommerce.Customer;
import com.ecommerce.Product;
import java.util.List;
import java.util.ArrayList;

public class Order {
    private int orderID;
    private Customer customer;
    private List<Product> products;
    private double orderTotal;
    private String status;

    public Order(int orderID, Customer customer, List<Product> products) {
        this.orderID = orderID;
        this.customer = customer;
        this.products = new ArrayList<>(products);
        this.orderTotal = customer.calculateTotal();
        this.status = "Placed";
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public String generateSumary() {
        String sumary = "Order ID: " + orderID + "\n";
        sumary += "Customer: " + customer.getName() + "\n";
        sumary += "Items:\n";
        for(Product p : products) {
            sumary += " - " + p.getInfo() + "\n";
        }
        sumary += "Total: $" + orderTotal + "\n";
        sumary += "Status: " + status;
        return sumary;
    }
}
