package com.example.traintickets.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ticket")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Ticket extends BaseEntity {
    private Train train;
    private RailwayCarriage railwayCarriage;
    private Place place;
    private Passenger passenger;
    private float ticketPrice;
    private Date bookingTime;
    private Date paymentTime;

    public Ticket(Train train, RailwayCarriage railwayCarriage, Place place, Passenger passenger,
                  float ticketPrice, Date bookingTime, Date paymentTime) {
        setTrain(train);
        setRailwayCarriage(railwayCarriage);
        setPlace(place);
        setPassenger(passenger);
        setTicketPrice(ticketPrice);
        setBookingTime(bookingTime);
        setPaymentTime(paymentTime);
    }

    protected Ticket() {
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "train_id", referencedColumnName = "id", nullable = false)
    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "railway_carriage_id", referencedColumnName = "id", nullable = false)
    public RailwayCarriage getRailwayCarriage() {
        return railwayCarriage;
    }

    public void setRailwayCarriage(RailwayCarriage railwayCarriage) {
        this.railwayCarriage = railwayCarriage;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id", referencedColumnName = "id", nullable = false)
    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passenger_id", referencedColumnName = "id", nullable = false)
    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    @Column(name = "ticket_price", nullable = false)
    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Column(name = "booking_time", nullable = false)
    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    @Column(name = "payment_time")
    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }
}
