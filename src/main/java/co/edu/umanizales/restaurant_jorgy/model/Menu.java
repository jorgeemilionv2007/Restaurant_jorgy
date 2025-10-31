package co.edu.umanizales.restaurant_jorgy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    private String id;
    private String name;
    private String description;
    private String season;
    private List<Dish> dishes;
    private Boolean active;

    public Menu(String id, String name, String season) {
        this.id = id;
        this.name = name;
        this.season = season;
        this.dishes = new ArrayList<>();
        this.active = true;
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

    public Integer getDishCount() {
        return dishes == null ? 0 : dishes.size();
    }

    public Double getAveragePrice() {
        if (dishes == null || dishes.isEmpty()) {
            return 0.0;
        }
        return dishes.stream()
                .mapToDouble(Dish::getPrice)
                .average()
                .orElse(0.0);
    }

    public String getMenuInfo() {
        return String.format("Menu: %s - Season: %s - Dishes: %d - Average Price: $%.2f - Active: %s",
                name, season, getDishCount(), getAveragePrice(), active);
    }
}
