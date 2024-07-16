package com.example.traintickets.services;

import com.example.traintickets.dtos.TicketDTO;

import java.util.Date;

public interface BookingService {

    String bookPlace(int placeId, int passengerId, float ticketPrice, Date bookingTime, Date paymentTime);

    TicketDTO createTicket(int placeId, int passengerId, float ticketPrice, Date bookingTime, Date paymentTime);

}
