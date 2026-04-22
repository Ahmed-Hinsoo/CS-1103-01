import com.ecommerce.Product;
import com.ecommerce.Customer;
import com.ecommerce.orders.Order;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        
        Product p1 = new Product(101, "Laptop", 899.99);
        Product p2 = new Product(102, "Smartphone", 499.50);
        Product p3 = new Product(103, "Headphones", 75.00);
        
        System.out.print("Enter your name to begin shoping: ");
        String cName = scaner.nextLine();
        Customer c1 = new Customer(1, cName);
        
        System.out.println("Availble items:");
        System.out.println("1. " + p1.getInfo());
        System.out.println("2. " + p2.getInfo());
        System.out.println("3. " + p3.getInfo());
        
        while(true) {
            System.out.print("Enter product number to add to cart (or 0 to checkout): ");
            if(!scaner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid number.");
                scaner.next();
                continue;
            }
            int choice = scaner.nextInt();
            
            if(choice == 0) {
                break;
            } else if(choice == 1) {
                c1.addProduct(p1);
                System.out.println("Laptop added.");
            } else if(choice == 2) {
                c1.addProduct(p2);
                System.out.println("Smartphone added.");
            } else if(choice == 3) {
                c1.addProduct(p3);
                System.out.println("Headphones added.");
            } else {
                System.out.println("Item not found. Try again.");
            }
        }
        
        if(c1.getCart().size() > 0) {
            Order ord = new Order(9901, c1, c1.getCart());
            System.out.println("\n--- Order Sumary ---");
            System.out.println(ord.generateSumary());
        } else {
            System.out.println("Your cart is empty.");
        }
        
        scaner.close();
    }
}
