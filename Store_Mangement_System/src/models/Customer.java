package models;
import utils.EntityValidation;

public class Customer extends Person implements EntityValidation {
    private int customerId;
    
    // Constructor
    public Customer(String name, String phone, String email, int customerId) {
        super(name, email, phone);
        this.customerId = customerId;
    }

    // Getters and setters
    public int getCustomerId() { return customerId; }

    @Override
    public void setPhone(String phone) {
        if (!phone.matches("\\d{11}")) {
            throw new IllegalArgumentException("Phone number must contain exactly 11 digits.");
        }
        super.setPhone(phone); // Use parent's setter
    }

    @Override
    public void setEmail(String email) {
        if (email.contains("@")) {
            super.setEmail(email); // Use parent's setter
        } else {
            throw new IllegalArgumentException("Invalid email format.");
        }
    }

    public void displayDetails() {
        System.out.println("===== Customer Details =====");
        System.out.println("Customer ID: " + customerId);
        System.out.println("Customer Name: " + getName());
        System.out.println("Customer Phone: " + getPhone());
        System.out.println("Customer Email: " + getEmail());
        System.out.println("============================");
    }
}