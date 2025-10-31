package co.edu.umanizales.restaurant_jorgy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Billable {
    private String id;
    private String clientId;
    private String orderDate;
    private String status;
    private List<Dish> dishes;
    private Double discount;
    private String notes;

    public Order(String id, String clientId, String orderDate) {
        this.id = id;
        this.clientId = clientId;
        this.orderDate = orderDate;
        this.status = "PENDING";
        this.dishes = new ArrayList<>();
        this.discount = 0.0;
    }

    public void addDish(Dish dish) {
        if (dishes == null) {
            dishes = new ArrayList<>();
        }
        dishes.add(dish);
    }

    public void removeDish(Dish dish) {
        if (dishes != null) {
            dishes.remove(dish);
        }
    }

    @Override
    public Double calculateTotal() {
        if (dishes == null || dishes.isEmpty()) {
            return 0.0;
        }
        Double total = dishes.stream()
                .mapToDouble(Dish::getPrice)
                .sum();
        return total - (total * (discount / 100.0));
    }

    @Override
    public String generateBill() {
        StringBuilder bill = new StringBuilder();
        bill.append("=== ORDER BILL ===\n");
        bill.append("Order ID: ").append(id).append("\n");
        bill.append("Client ID: ").append(clientId).append("\n");
        bill.append("Date: ").append(orderDate).append("\n");
        bill.append("Status: ").append(status).append("\n");
        bill.append("--- DISHES ---\n");
        if (dishes != null) {
            dishes.forEach(d -> bill.append(d.getDishInfo()).append("\n"));
        }
        bill.append("--- TOTALS ---\n");
        bill.append("Subtotal: $").append(String.format("%.2f", getSubtotal())).append("\n");
        bill.append("Discount: ").append(discount).append("%\n");
        bill.append("Total: $").append(String.format("%.2f", calculateTotal())).append("\n");
        return bill.toString();
    }

    @Override
    public void applyDiscount(Double percentage) {
        if (percentage >= 0 && percentage <= 100) {
            this.discount = percentage;
        }
    }

    public Double getSubtotal() {
        if (dishes == null || dishes.isEmpty()) {
            return 0.0;
        }
        return dishes.stream()
                .mapToDouble(Dish::getPrice)
                .sum();
    }

    public String getOrderInfo() {
        return String.format("Order %s - Client: %s - Status: %s - Total: $%.2f",
                id, clientId, status, calculateTotal());
    }
}
