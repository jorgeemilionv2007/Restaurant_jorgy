package co.edu.umanizales.restaurant_jorgy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
    private String id;
    private String name;
    private String unit;
    private Double quantity;
    private Double unitPrice;

    public Double getTotalCost() {
        return quantity * unitPrice;
    }

    public String getIngredientInfo() {
        return String.format("%s (%s): %.2f %s @ $%.2f = $%.2f",
                name, id, quantity, unit, unitPrice, getTotalCost());
    }
}
