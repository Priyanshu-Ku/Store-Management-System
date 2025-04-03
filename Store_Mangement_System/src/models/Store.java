package models;
import utils.EntityValidation;

public class Store implements EntityValidation {
    private Staff[] staff;
    private Product[] product;
    public Store(Staff[] staff , Product[] product) {
        this.staff = staff;
        this.product = product;
    }

    public void displayDetails() {
        System.out.println("All Staff Details:");
        System.out.println("=======================");
        for (int i=0; i< staff.length; i++) {
            System.out.println("Staff ID: " + staff[i].getStaffId());
            System.out.println("Staff Name: " + staff[i].getName());
            System.out.println("Staff Email: " + staff[i].getEmail());
            System.out.println("Staff Phone: " + staff[i].getPhone());
            System.out.println("Staff Salary: " + staff[i].getSalary());
        }
        System.out.println("All Product Details:");
        System.out.println("=======================");
        for (int i=0; i< product.length; i++) {
            System.out.println("Brand: " + product[i].Brand);
            System.out.println("Category: " + product[i].Category);
            System.out.println("Product Name: " + product[i].productName);
            System.out.println("Model Year: " + product[i].modelYear);
            System.out.println("Price: " + product[i].price);
        }
        System.out.println("=======================");
    }
}