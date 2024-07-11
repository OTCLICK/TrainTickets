package com.example.traintickets.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "place")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Place extends BaseEntity {
    private int placeNumber;
    private RailwayCarriage railwayCarriage;
    private BookingStatusEnum bookingStatus;

    public Place(int placeNumber, RailwayCarriage railwayCarriage, BookingStatusEnum bookingStatus) {
        setPlaceNumber(placeNumber);
        setRailwayCarriage(railwayCarriage);
        setBookingStatus(bookingStatus);
    }

    protected Place() {
    }

    @Column(name = "place_number")
    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "railway_carriage_id", referencedColumnName = "id")
    public RailwayCarriage getRailwayCarriage() {
        return railwayCarriage;
    }

    public void setRailwayCarriage(RailwayCarriage railwayCarriage) {
        this.railwayCarriage = railwayCarriage;
    }
    @Column(name = "booking_status")
    public BookingStatusEnum getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatusEnum bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
