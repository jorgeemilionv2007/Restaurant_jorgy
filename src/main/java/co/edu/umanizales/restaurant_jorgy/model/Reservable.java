package co.edu.umanizales.restaurant_jorgy.model;

public interface Reservable {
    Boolean reserve(String date, String time);
    Boolean cancel();
    String getReservationStatus();
}
