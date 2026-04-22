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

File 3: com/ecommerce/orders/Order.java

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
