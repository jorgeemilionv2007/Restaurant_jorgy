package co.edu.umanizales.restaurant_jorgy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Client extends Person {
    private String loyaltyLevel;
    private Double totalSpent;
    private Integer visitCount;

    @Override
    public String getRole() {
        return "CLIENT";
    }

    @Override
    public String getPersonInfo() {
        return super.getPersonInfo() + String.format(", Loyalty Level: %s, Total Spent: %.2f, Visits: %d",
                loyaltyLevel, totalSpent, visitCount);
    }

    public void addVisit(Double amount) {
        this.visitCount++;
        this.totalSpent += amount;
    }

    public String getClientStatus() {
        return String.format("%s - Level: %s - Total: $%.2f", getName(), loyaltyLevel, totalSpent);
    }
}
