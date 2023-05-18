package com.example.estateagency.model;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@Entity
@Table(name = "booking")

public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long booking_id;
    private String time_slot;

    public Booking() {
    }

    public Booking(long booking_id, String time_slot) {
        this.booking_id = booking_id;
        this.time_slot = time_slot;
    }

    public long getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(long booking_id) {
        this.booking_id = booking_id;
    }

    public String getTime_slot() {
        return time_slot;
    }

    public void setTime_slot(String time_slot) {
        this.time_slot = time_slot;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "booking_id=" + booking_id +
                ", time_slot='" + time_slot + '\'' +
                '}';
    }
}
