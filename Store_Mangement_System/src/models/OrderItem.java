package models;


public class OrderItem {  
    public int orderId;
    public Product product;
    public int quantity;
    private double discount = 0.0;  // Default discount is 0.0

    // Constructor
    public OrderItem(int orderId, Product product, int quantity, double discount ) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public boolean isValid() {
        if (orderId <= 0 || product == null || quantity <= 0) {
            return false;
        }
        return true;
    }
    
    public void setDiscount(double discount) {
        this.discount = discount;
    }
}