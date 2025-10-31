package co.edu.umanizales.restaurant_jorgy.model;

public interface Preparable {
    String prepare();
    Integer getPreparationTime();
    Boolean isAvailable();
}
