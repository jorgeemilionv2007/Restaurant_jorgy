package co.edu.umanizales.restaurant_jorgy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;

    public abstract String getRole();

    public String getPersonInfo() {
        return String.format("ID: %s, Name: %s, Email: %s, Phone: %s, Address: %s",
                id, name, email, phone, address);
    }
}
