package co.edu.umanizales.restaurant_jorgy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish implements Preparable {
    private String id;
    private String name;
    private String description;
    private Double price;
    private Integer preparationTime;
    private Boolean available;
    private String category;
    private List<Ingredient> ingredients;

    public Dish(String id, String name, Double price, Integer preparationTime, Boolean available) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.preparationTime = preparationTime;
        this.available = available;
        this.ingredients = new ArrayList<>();
    }

    @Override
    public String prepare() {
        return String.format("Preparing dish: %s - Time: %d minutes", name, preparationTime);
    }

    @Override
    public Integer getPreparationTime() {
        return preparationTime;
    }

    @Override
    public Boolean isAvailable() {
        return available;
    }

    public void addIngredient(Ingredient ingredient) {
        if (ingredients == null) {
            ingredients = new ArrayList<>();
        }
        ingredients.add(ingredient);
    }

    public Double calculateCost() {
        if (ingredients == null || ingredients.isEmpty()) {
            return 0.0;
        }
        return ingredients.stream()
                .mapToDouble(Ingredient::getTotalCost)
                .sum();
    }

    public String getDishInfo() {
        return String.format("Dish: %s - Price: $%.2f - Time: %d min - Available: %s",
                name, price, preparationTime, available);
    }
}
