package models;
import utils.EntityValidation;

public class Product implements EntityValidation {
    public String Brand;
    public String Category;
    public String productName;
    public int stock;
    public int modelYear;
    public double price;

    // Constructor
    public Product(String Brand, String Category, String productName, int stock, int modelYear, double price) {
        this.Brand = Brand;
        this.Category = Category;
        this.productName = productName;
        this.stock = stock; ///check whether this is correct or not
        setModelYear(modelYear);
        setprice(price);
    }

    // setters
    public void setBrand(String Brand) { this.Brand = Brand; }

    public void setCategory(String Category) { this.Category = Category; }

    public void setStock(int stock) { this.stock = stock; }

    public void setProductName(String productName) { this.productName = productName; }

    public void setModelYear(int modelYear) {
        if (modelYear > 1900 && modelYear <= java.time.Year.now().getValue()) {
            this.modelYear = modelYear;
        } else {
            throw new IllegalArgumentException("Invalid model year.");
        }
    }

    public void setprice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("List price must be positive.");
        }
    }

    @Override
    public void displayDetails() {
        System.out.println("===== Product Details =====");
        System.out.println("Brand: " + Brand);
        System.out.println("Category: " + Category);
        System.out.println("Product Name: " + productName);
        System.out.println("Model Year: " + modelYear);
        System.out.println("Price: $" + price);
        System.out.println("Stock: " + stock);
        System.out.println("=============================");
    }
}