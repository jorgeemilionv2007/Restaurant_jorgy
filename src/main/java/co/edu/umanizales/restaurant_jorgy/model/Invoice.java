package co.edu.umanizales.restaurant_jorgy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoice implements Billable {
    private String id;
    private String orderId;
    private String clientId;
    private String invoiceDate;
    private Double subtotal;
    private Double tax;
    private Double discount;
    private String paymentMethod;
    private String status;

    public Invoice(String id, String orderId, String clientId, String invoiceDate, Double subtotal) {
        this.id = id;
        this.orderId = orderId;
        this.clientId = clientId;
        this.invoiceDate = invoiceDate;
        this.subtotal = subtotal;
        this.tax = subtotal * 0.08;
        this.discount = 0.0;
        this.status = "PENDING";
    }

    @Override
    public Double calculateTotal() {
        return subtotal + tax - discount;
    }

    @Override
    public String generateBill() {
        StringBuilder bill = new StringBuilder();
        bill.append("=== INVOICE ===\n");
        bill.append("Invoice ID: ").append(id).append("\n");
        bill.append("Order ID: ").append(orderId).append("\n");
        bill.append("Client ID: ").append(clientId).append("\n");
        bill.append("Date: ").append(invoiceDate).append("\n");
        bill.append("--- AMOUNTS ---\n");
        bill.append("Subtotal: $").append(String.format("%.2f", subtotal)).append("\n");
        bill.append("Tax (8%): $").append(String.format("%.2f", tax)).append("\n");
        bill.append("Discount: $").append(String.format("%.2f", discount)).append("\n");
        bill.append("Total: $").append(String.format("%.2f", calculateTotal())).append("\n");
        bill.append("Payment Method: ").append(paymentMethod).append("\n");
        bill.append("Status: ").append(status).append("\n");
        return bill.toString();
    }

    @Override
    public void applyDiscount(Double amount) {
        if (amount >= 0 && amount <= subtotal) {
            this.discount = amount;
        }
    }

    public void markAsPaid() {
        this.status = "PAID";
    }

    public String getInvoiceInfo() {
        return String.format("Invoice %s - Order: %s - Total: $%.2f - Status: %s",
                id, orderId, calculateTotal(), status);
    }
}
