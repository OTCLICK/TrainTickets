package com.example.traintickets.services;

import com.example.traintickets.entities.Ticket;

import java.util.Date;
import java.util.List;

public interface TicketService {

    List<Ticket> findAllByTicketPrice(float ticketPrice);

    List<Ticket> findTicketsByDepartureTime(Date departureTime);
}
