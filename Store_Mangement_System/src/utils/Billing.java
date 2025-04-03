package utils;
import java.util.Scanner;
public interface Billing {
    double calculateTotalPrice(Scanner sc);
    int returnstock(); //to update the stock of the product after selling
    boolean isValid(); //to check whether the order is valid or not
    double SUPER_DISCOUNT = 0.5; // 50% discount for super users
    double MAX_DISCOUNT = 0.3; // 30% discount for regular users
}