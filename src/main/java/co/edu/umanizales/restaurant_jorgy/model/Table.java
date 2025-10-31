package co.edu.umanizales.restaurant_jorgy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Table {
    private String id;
    private Integer capacity;
    private String location;
    private Boolean available;
    private String currentClientId;

    public Table(String id, Integer capacity, String location) {
        this.id = id;
        this.capacity = capacity;
        this.location = location;
        this.available = true;
        this.currentClientId = null;
    }

    public Boolean occupyTable(String clientId) {
        if (available) {
            this.available = false;
            this.currentClientId = clientId;
            return true;
        }
        return false;
    }

    public Boolean releaseTable() {
        if (!available) {
            this.available = true;
            this.currentClientId = null;
            return true;
        }
        return false;
    }

    public String getTableStatus() {
        return String.format("Table %s - Capacity: %d - Location: %s - Status: %s",
                id, capacity, location, available ? "AVAILABLE" : "OCCUPIED");
    }
}
