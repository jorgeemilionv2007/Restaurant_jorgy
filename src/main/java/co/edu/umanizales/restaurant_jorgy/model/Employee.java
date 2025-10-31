package co.edu.umanizales.restaurant_jorgy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Employee extends Person {
    private String position;
    private Double salary;
    private String hireDate;

    @Override
    public String getRole() {
        return "EMPLOYEE";
    }

    @Override
    public String getPersonInfo() {
        return super.getPersonInfo() + String.format(", Position: %s, Salary: %.2f, Hire Date: %s",
                position, salary, hireDate);
    }

    public String getEmployeeDetails() {
        return String.format("%s - Position: %s", getName(), position);
    }
}
