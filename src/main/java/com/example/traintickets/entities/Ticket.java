package com.example.traintickets.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Ticket extends BaseEntity {
    private Train train;
    private RailwayCarriage railwayCarriage;
    private Place place;
    private Passenger passenger;
    private float ticketPrice;

    public Ticket(Train train, RailwayCarriage railwayCarriage, Place place, Passenger passenger, float ticketPrice) {
        setTrain(train);
        setRailwayCarriage(railwayCarriage);
        setPlace(place);
        setPassenger(passenger);
        setTicketPrice(ticketPrice);
    }

    protected Ticket() {
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "train_id", referencedColumnName = "id")
    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "railway_carriage_id", referencedColumnName = "id")
    public RailwayCarriage getRailwayCarriage() {
        return railwayCarriage;
    }

    public void setRailwayCarriage(RailwayCarriage railwayCarriage) {
        this.railwayCarriage = railwayCarriage;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id", referencedColumnName = "id")
    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passenger_id", referencedColumnName = "id")
    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    @Column(name = "ticket_price")
    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
