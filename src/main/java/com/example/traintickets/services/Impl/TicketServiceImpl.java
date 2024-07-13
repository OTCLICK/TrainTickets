package com.example.traintickets.services.Impl;

import com.example.traintickets.entities.Ticket;
import com.example.traintickets.repositories.TicketRepository;
import com.example.traintickets.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<Ticket> findAllByTicketPrice(float ticketPrice) {
        return ticketRepository.findAllByTicketPrice(ticketPrice);
    }

    @Override
    public List<Ticket> findTicketsByDepartureTime(Date departureTime) {
        return ticketRepository.findTicketsByDepartureTime(departureTime);
    }
}
