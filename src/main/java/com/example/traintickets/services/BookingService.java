package com.example.traintickets.services;

import com.example.traintickets.entities.Ticket;

import java.util.Date;

public interface BookingService {

    String bookPlace(int placeId, int passengerId, float ticketPrice, Date bookingTime, Date paymentTime);

    Ticket createTicket(int placeId, int passengerId, float ticketPrice, Date bookingTime, Date paymentTime);

}
