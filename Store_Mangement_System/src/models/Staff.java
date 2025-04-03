package models;
import utils.EntityValidation;

public class Staff extends Person implements EntityValidation {
    private int staffId;
    private double salary;
    
    // Constructor
    public Staff(String name, String email, String phone, int staffId, double salary) {
        super(name, email, phone);
        this.staffId = staffId;
        this.salary = salary;
    }

    // Getters and setters
    public int getStaffId() { return staffId; }
    public void setStaffId(int staffId) { this.staffId = staffId; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public void setEmail(String email) {
        if (email.contains("@")) {
            super.setEmail(email); // Use parent's setter
        } else {
            throw new IllegalArgumentException("Invalid email format.");
        }
    }

    @Override
    public void setPhone(String phone) {
        if (!phone.matches("\\d{11}")) {
            throw new IllegalArgumentException("Invalid phone number format.");
        }
        super.setPhone(phone); // Use parent's setter
    }

    public void displayDetails() {
        System.out.println("===== Staff Details =====");
        System.out.println("Staff ID: " + staffId);
        System.out.println("Staff Name: " + getName());
        System.out.println("Staff Email: " + getEmail());
        System.out.println("Staff Phone: " + getPhone());
        System.out.println("Staff Salary: " + salary);
        System.out.println("==========================");
    }
}