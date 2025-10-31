package co.edu.umanizales.restaurant_jorgy.model;

public interface Billable {
    Double calculateTotal();
    String generateBill();
    void applyDiscount(Double percentage);
}
