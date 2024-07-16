package com.example.traintickets.controllers;

import com.example.traintickets.dtos.BookingPlaceDTO;
import com.example.traintickets.dtos.TicketDTO;
import com.example.traintickets.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/book")
    public ResponseEntity<String> bookPlace(@RequestBody BookingPlaceDTO bookingPlaceDTO) {
//        Date bookingTime = bookingPlaceDTO.getBookingTime();
        Date paymentTime = bookingPlaceDTO.getPaymentTime() != null ? bookingPlaceDTO.getPaymentTime() : new Date();
        String result = bookingService.bookPlace(
                bookingPlaceDTO.getPlaceId(),
                bookingPlaceDTO.getPassengerId(),
                bookingPlaceDTO.getTicketPrice(),
                bookingPlaceDTO.getBookingTime(),
                paymentTime
        );
        return ResponseEntity.ok(result);
    }

    @PostMapping("/create-ticket")
    public ResponseEntity<TicketDTO> createTicket(@RequestBody BookingPlaceDTO bookingPlaceDTO) {
//        Date bookingTime = bookingPlaceDTO.getBookingTime();
        Date paymentTime = bookingPlaceDTO.getPaymentTime() != null ? bookingPlaceDTO.getPaymentTime() : new Date();
        TicketDTO ticketDTO = bookingService.createTicket(
                bookingPlaceDTO.getPlaceId(),
                bookingPlaceDTO.getPassengerId(),
                bookingPlaceDTO.getTicketPrice(),
                bookingPlaceDTO.getBookingTime(),
                paymentTime
        );
        return ResponseEntity.ok(ticketDTO);
    }
}
