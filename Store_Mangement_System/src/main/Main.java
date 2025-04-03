package main;

import java.util.Scanner;
import models.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;

public class Main {
    private static List<Staff> staffList = new ArrayList<>();
    private static List<Product> productList = new ArrayList<>();
    private static List<Order> orderList = new ArrayList<>();
    private static List<Customer> customerList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Store Management System!");
        boolean running = true;

        while (running) {
            System.out.println("======= Main Menu =======");
            System.out.println("\n1. Add Staff");
            System.out.println("2. Add Product");
            System.out.println("3. Create Customer");
            System.out.println("4. Create Order");
            System.out.println("5. Display All Details");
            System.out.println("6. Exit");
            System.out.println("===========================");
            System.out.print("Enter your choice: ");

            try {
                int choice = getValidIntInput(1, 6);
                switch (choice) {
                    case 1:
                        addStaff();
                        break;
                    case 2:
                        addProduct();
                        break;
                    case 3:
                        createCustomer();
                        break;
                    case 4:
                        createOrder();
                        break;
                    case 5:
                        displayAllDetails();
                        break;
                    case 6:
                        running = false;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine(); // Clear the invalid input
            }
        }
        sc.close();
        System.out.println("Thank you for using the Store Management System!");
    }

    private static void createCustomer() {
        try {
            System.out.print("Enter customer name: ");
            String name = sc.next();
            
            System.out.print("Enter customer phone (11 digits): ");
            String phone = sc.next();
            if (!phone.matches("\\d{11}")) {
                throw new IllegalArgumentException("Phone must be 11 digits.");
            }
            
            System.out.print("Enter customer email: ");
            String email = sc.next();
            if (!email.contains("@")) {
                throw new IllegalArgumentException("Invalid email format.");
            }
            
            System.out.print("Enter customer ID: ");
            int customerId = getValidIntInput(1, Integer.MAX_VALUE);
            
            Customer customer = new Customer(name, phone, email, customerId);
            customerList.add(customer);
            System.out.println("Customer created successfully!");
            customer.displayDetails();
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            sc.nextLine(); // Clear buffer
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            sc.nextLine();
        }
    }

    private static void displayAllDetails() {
        try {
            System.out.print("PROVE THAT YOU ARE THE MANAGER BY ENTERING THE NAME OF THE CHARACTER WHO SAID THE PHRASE 'SAY MY NAME' 😎😎: ");
            String managerName = sc.next();
            
            if (!managerName.equalsIgnoreCase("Heisenberg")) {
                System.out.println("You are not authorized to view details.");
                return;
            }
            
            System.out.println("YOU ARE GODDAMN RIGHT, MANAGER!");
            
            if (staffList.isEmpty()) {
                System.out.println("No staff records found.");
            } else {

                staffList.forEach(Staff::displayDetails);
            }
            
            if (productList.isEmpty()) {
                System.out.println("No products found.");
            } else {
                productList.forEach(Product::displayDetails);
            }
            
            if (customerList.isEmpty()) {
                System.out.println("No customers found.");
            } else {
                customerList.forEach(Customer::displayDetails);
            }
            
            if (orderList.isEmpty()) {
                System.out.println("No orders found.");
            } else {
                orderList.forEach(Order::displayDetails);
            }
            
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            sc.nextLine();
        }
    }

    private static int getValidIntInput(int min, int max) {
        while (true) {
            try {
                int input = sc.nextInt();
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.printf("Input must be between %d and %d. Try again: ", min, max);
                }
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number: ");
                sc.nextLine(); // Clear the invalid input
            }
        }
    }

    private static void addStaff() {
        try {
            System.out.print("PROVE THAT YOU ARE THE MANAGER BY ENTERING THE NAME OF THE CHARACTER WHO SAID THE PHRASE 'SAY MY NAME' 😎😎: ");
            String managerName = sc.next();
            if (!managerName.equalsIgnoreCase("Heisenberg")) {
                System.out.println("You are not authorized to add staff.");
                return;
            }
            System.out.println("YOU ARE GODDAMN RIGHT, MANAGER!");

            System.out.print("Enter staff name: ");
            String staffName = sc.next();

            System.out.print("Enter staff email: ");
            String staffEmail = sc.next();
            if (!staffEmail.contains("@")) {
                throw new IllegalArgumentException("Invalid email format.");
            }

            System.out.print("Enter staff phone number (11 digits): ");
            String staffPhone = sc.next();
            if (!staffPhone.matches("\\d{11}")) {
                throw new IllegalArgumentException("Phone must be 11 digits.");
            }

            System.out.print("Enter staff ID: ");
            int id = getValidIntInput(1, Integer.MAX_VALUE);

            System.out.print("Enter staff salary: ");
            double salary = sc.nextDouble();
            if (salary <= 0) {
                throw new IllegalArgumentException("Salary must be positive.");
            }

            Staff staff = new Staff(staffName, staffEmail, staffPhone, id, salary);
            staffList.add(staff);
            System.out.println("Staff added successfully!");
            staff.displayDetails();

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            sc.nextLine(); // Clear buffer
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            sc.nextLine();
        }
    }

    private static void addProduct() {
        try {
            System.out.print("PROVE THAT YOU ARE THE MANAGER BY ENTERING THE NAME OF THE CHARACTER WHO SAID THE PHRASE 'SAY MY NAME' 😎😎: ");
            String managerName = sc.next();
            if (!managerName.equalsIgnoreCase("Heisenberg")) {
                System.out.println("You are not authorized to add products.");
                return;
            }
            System.out.println("YOU ARE GODDAMN RIGHT, MANAGER!");

            System.out.print("Enter product brand: ");
            String brand = sc.next();

            System.out.print("Enter product category: ");
            String category = sc.next();

            System.out.print("Enter product name: ");
            String productName = sc.next();

            System.out.print("Enter product stock: ");
            int stock = getValidIntInput(0, Integer.MAX_VALUE);

            System.out.print("Enter product model year: ");
            int modelYear = sc.nextInt();
            if (modelYear < 1900 || modelYear > java.time.Year.now().getValue()) {
                throw new IllegalArgumentException("Invalid model year.");
            }

            System.out.print("Enter product price: ");
            double price = sc.nextDouble();
            if (price <= 0) {
                throw new IllegalArgumentException("Price must be positive.");
            }

            Product product = new Product(brand, category, productName, stock, modelYear, price);
            productList.add(product);
            System.out.println("Product added successfully!");
            product.displayDetails();

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            sc.nextLine();
        }
    }

    private static void createOrder() {

        try {
            if (customerList.isEmpty() || staffList.isEmpty() || productList.isEmpty()) {
                System.out.println("Cannot create order. Missing customers, staff, or products.");
                return;
            }
            System.out.println("======== Create Order ====");
            System.out.print("Enter order ID: ");
            int orderId = getValidIntInput(1, Integer.MAX_VALUE);
    
            // Select customer
            System.out.println("Select a customer:");
            for (int i = 0; i < customerList.size(); i++) {
                System.out.println((i + 1) + ". " + customerList.get(i).getName());
            }
            int customerIndex = getValidIntInput(1, customerList.size()) - 1;
            Customer customer = customerList.get(customerIndex);
    
            // Select staff
            System.out.println("Select a staff member:");
            for (int i = 0; i < staffList.size(); i++) {
                System.out.println((i + 1) + ". " + staffList.get(i).getName());
            }
            int staffIndex = getValidIntInput(1, staffList.size()) - 1;
            Staff staff = staffList.get(staffIndex);
    
            // Add order items
            List<OrderItem> orderItems = new ArrayList<>();
            boolean addingItems = true;
            while (addingItems) {
                // Filter and display only products with stock > 0
                List<Product> availableProducts = new ArrayList<>();
                for (Product p : productList) {
                    if (p.stock > 0) {
                        availableProducts.add(p);
                    }
                }
                
                if (availableProducts.isEmpty()) {
                    System.out.println("No products available in stock.");
                    break;
                }
    
                System.out.println("Select a product:");
                for (int i = 0; i < availableProducts.size(); i++) {
                    Product p = availableProducts.get(i);
                    System.out.printf("%d. %s (Stock: %d, Price: $%.2f)\n", 
                        (i + 1), p.productName, p.stock, p.price);
                }
                
                int productIndex = getValidIntInput(1, availableProducts.size()) - 1;
                Product product = availableProducts.get(productIndex);
    
                System.out.print("Enter quantity: ");
                int quantity = getValidIntInput(1, product.stock); // Ensures quantity <= stock
    
                // Update stock immediately
                product.stock -= quantity;
                
                OrderItem item = new OrderItem(orderId, product, quantity, 0.0);
                orderItems.add(item);
                
                System.out.print("Add another item? (1=Yes/0=No): ");
                addingItems = getValidIntInput(0, 1) == 1;
            }
    
            if (orderItems.isEmpty()) {
                System.out.println("Order cancelled - no items were added.");
                return;
            }
    
            // Create and validate order
            Order order = new Order(
                orderId, customer, new Date(), null, null,
                new Store(staffList.toArray(new Staff[0]), productList.toArray(new Product[0])),
                staff, orderItems.toArray(new OrderItem[0])
            );
    
            if (order.isValid()) {
                double total = order.calculateTotalPrice(sc);
                System.out.printf("Total price after discount: $%.2f\n", total);
                orderList.add(order);
                System.out.println("Order created successfully!");
                order.displayDetails();
            } else {
                // If order is invalid, restore the stock
                for (OrderItem item : orderItems) {
                    Product p = item.product;  // Access product directly
                    p.stock += item.quantity;  // Access quantity directly
                }
                System.out.println("Order is invalid. Check order details. Stock has been restored.");
            }
    
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            sc.nextLine();
        }
    }
}