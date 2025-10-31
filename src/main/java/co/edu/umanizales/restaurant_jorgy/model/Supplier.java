package co.edu.umanizales.restaurant_jorgy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {
    private String id;
    private String name;
    private String contactPerson;
    private String email;
    private String phone;
    private String address;
    private String productType;
    private Double averageDeliveryDays;

    public String getSupplierInfo() {
        return String.format("Supplier: %s - Contact: %s - Phone: %s - Products: %s - Delivery: %.0f days",
                name, contactPerson, phone, productType, averageDeliveryDays);
    }

    public String getSupplierDetails() {
        return String.format("ID: %s, Name: %s, Email: %s, Address: %s",
                id, name, email, address);
    }
}
