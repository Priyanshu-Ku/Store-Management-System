package models;
import utils.Billing;
import utils.EntityValidation;
import java.util.Scanner;
import java.util.Date;

public class Order implements EntityValidation, Billing { 
    public int orderId;
    public Customer customer;
    public Date orderDate;
    private Staff staff;
    public OrderItem[] orderItem;

    // Constructor
    public Order(int orderId, Customer customer, Date orderDate, Date requiredDate, Date shippedDate,
                 Store store, Staff staff, OrderItem[] orderItem) {
        this.orderId = orderId;
        setCustomer(customer);
        this.orderDate = orderDate;
        this.staff = staff;
        this.orderItem = orderItem;
    }

    // Getters and setters

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    // interface methods defining

    public double calculateTotalPrice(Scanner sc) {
        double totalPrice = 0.0;
        double discountRate = 0.0;
    
        System.out.println("====== Discount options ======");
        System.out.println("1. Super Discount (50%)");
        System.out.println("2. Regular Discount (30%)");
        System.out.println("3. No Discount");
        System.out.println("==============================");
        System.out.print("Enter your choice of discount: ");
        int choice = sc.nextInt();
    
        switch (choice) {
            case 1:
                discountRate = SUPER_DISCOUNT;
                break;
            case 2:
                discountRate = MAX_DISCOUNT;
                break;
            case 3:
                discountRate = 0.0;
                break;
            default:
                System.out.println("Invalid choice. No discount applied.");
        }
    
        for (OrderItem item : orderItem) {
            item.setDiscount(discountRate); // Set discount for each item
            double itemPrice = item.product.price * item.quantity * (1 - item.getDiscount());
            totalPrice += itemPrice;
        }
    
        return totalPrice;
    }
    public boolean isValid() {
        if (orderId <= 0 || customer == null ||  orderDate == null || staff == null) {
            return false;
        }
        for (OrderItem item : orderItem) {  //check if the order item is valid
            if (!item.isValid()) { 
                return false;
            }
        }
        return true;
    }

    public int returnstock() {
        int lastStock = 0;
        for (OrderItem item : orderItem) {
            item.product.stock -= item.quantity;
            lastStock = item.product.stock; // Store the stock of the last processed item
        }
        return lastStock;
    }
    public void displayDetails() {
        System.out.println("==== Order Details ====");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + (customer != null ? customer.getName(): "N/A"));
        System.out.println("Order Date: " + orderDate);
        System.out.println("Staff: " + (staff != null ? staff.getName() : "N/A"));
        System.out.println("=======================");
    }
}