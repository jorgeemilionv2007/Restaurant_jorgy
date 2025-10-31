package co.edu.umanizales.restaurant_jorgy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation implements Reservable {
    private String id;
    private String clientId;
    private String tableId;
    private String reservationDate;
    private String reservationTime;
    private Integer guestCount;
    private String status;
    private String notes;

    public Reservation(String id, String clientId, String tableId, String reservationDate, String reservationTime, Integer guestCount) {
        this.id = id;
        this.clientId = clientId;
        this.tableId = tableId;
        this.reservationDate = reservationDate;
        this.reservationTime = reservationTime;
        this.guestCount = guestCount;
        this.status = "CONFIRMED";
    }

    @Override
    public Boolean reserve(String date, String time) {
        this.reservationDate = date;
        this.reservationTime = time;
        this.status = "CONFIRMED";
        return true;
    }

    @Override
    public Boolean cancel() {
        this.status = "CANCELLED";
        return true;
    }

    @Override
    public String getReservationStatus() {
        return String.format("Reservation %s - Client: %s - Table: %s - Date: %s at %s - Status: %s",
                id, clientId, tableId, reservationDate, reservationTime, status);
    }

    public String getReservationInfo() {
        return String.format("Reservation ID: %s - Guests: %d - Date: %s - Time: %s - Status: %s",
                id, guestCount, reservationDate, reservationTime, status);
    }
}
