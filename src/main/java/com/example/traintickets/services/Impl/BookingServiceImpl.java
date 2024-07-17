package com.example.traintickets.services.Impl;

import com.example.traintickets.dtos.*;
import com.example.traintickets.entities.*;
import com.example.traintickets.repositories.*;
import com.example.traintickets.services.BookingService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private RailwayCarriageRepository railwayCarriageRepository;

    @Override
    @Transactional
    public String bookPlace(int placeId, int passengerId, float ticketPrice, Date bookingTime, Date paymentTime) {
        List<Place> placeList = placeRepository.findById(placeId);
        if (placeList.isEmpty()) {
            return "Такого места не существует!";
        }

        Place place = placeList.get(0);
        if (place.getBookingStatus() != BookingStatusEnum.FREE) {
            return "Место уже забронировано или занято!";
        }

        List<Passenger> passengerList = passengerRepository.findById(passengerId);
        if (passengerList.isEmpty()) {
            return "Такого пассажира не существует!";
        }

        Passenger passenger = passengerList.get(0);

        boolean isPrivileged = passenger.getPassportDetails().contains("privileges");

        place.setBookingStatus(BookingStatusEnum.BOOKED);
        placeRepository.save(place);

        Ticket ticket = new Ticket(
                place.getRailwayCarriage().getTrain(),
                place.getRailwayCarriage(),
                place,
                passenger,
                ticketPrice,
                bookingTime,
                paymentTime
        );
        ticketRepository.save(ticket);

        long timeLimit = isPrivileged ? 1800000L : 900000L;
        long bookingTimeMillis = ticket.getBookingTime().getTime();
        long paymentTimeMillis = paymentTime != null ? paymentTime.getTime() : 0;

        if (paymentTime == null || (paymentTimeMillis - bookingTimeMillis) > timeLimit) {
            place.setBookingStatus(BookingStatusEnum.FREE);
            placeRepository.save(place);
            return "Вы не успели оплатить билет в отведённое время!";
        } else {
            place.setBookingStatus(BookingStatusEnum.BUSY);
            placeRepository.save(place);
            passenger.setTripsNumber(passenger.getTripsNumber() + 1);
            passengerRepository.save(passenger);
            return "Билет успешно оплачен!";
        }
    }

    @Override
    @Transactional
    public TicketDTO createTicket(int placeId, int passengerId, float ticketPrice, Date bookingTime, Date paymentTime) {
        List<Place> placeList = placeRepository.findById(placeId);
        if (placeList.isEmpty()) {
            throw new IllegalArgumentException("Такого места не существует!");
        }

        Place place = placeList.get(0);
        if (place.getBookingStatus() != BookingStatusEnum.FREE) {
            throw new IllegalStateException("Место уже забронировано или занято!");
        }

        List<Passenger> passengerList = passengerRepository.findById(passengerId);
        if (passengerList.isEmpty()) {
            throw new IllegalArgumentException("Такого пассажира не существует!");
        }

        Passenger passenger = passengerList.get(0);

        place.setBookingStatus(BookingStatusEnum.BUSY);
        placeRepository.save(place);

        Ticket ticket = new Ticket(
                place.getRailwayCarriage().getTrain(),
                place.getRailwayCarriage(),
                place,
                passenger,
                ticketPrice,
                bookingTime,
                paymentTime
        );
        ticketRepository.save(ticket);

        if (passenger.getTripsNumber() >= 5) {
            ticket.setTicketPrice(ticket.getTicketPrice() / 2);
        }

        ticketRepository.save(ticket);
        passenger.setTripsNumber(passenger.getTripsNumber() + 1);
        passengerRepository.save(passenger);
//        return ticket;
        return mapToDTO(ticket);
    }

    private TicketDTO mapToDTO(Ticket ticket) {
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setId(ticket.getId());
        ticketDTO.setTrain(mapToDTO(ticket.getTrain()));
        ticketDTO.setRailwayCarriage(mapToDTO(ticket.getRailwayCarriage()));
        ticketDTO.setPlace(mapToDTO(ticket.getPlace()));
        ticketDTO.setPassenger(mapToDTO(ticket.getPassenger()));
        ticketDTO.setTicketPrice(ticket.getTicketPrice());
        ticketDTO.setBookingTime(ticket.getBookingTime());
        ticketDTO.setPaymentTime(ticket.getPaymentTime());
        return ticketDTO;
    }

    private TrainDTO mapToDTO(Train train) {
        TrainDTO trainDTO = new TrainDTO();
        trainDTO.setId(train.getId());
        trainDTO.setTrainNumber(train.getTrainNumber());
        trainDTO.setDepartureTime(train.getDepartureTime());
        trainDTO.setArrivalTime(train.getArrivalTime());
        trainDTO.setRoute(train.getRoute());
        return trainDTO;
    }

    private RailwayCarriageDTO mapToDTO(RailwayCarriage railwayCarriage) {
        RailwayCarriageDTO railwayCarriageDTO = new RailwayCarriageDTO();
        railwayCarriageDTO.setId(railwayCarriage.getId());
        railwayCarriageDTO.setCarNumber(railwayCarriage.getCarNumber());
        railwayCarriageDTO.setTrain(mapToDTO(railwayCarriage.getTrain()));
        railwayCarriageDTO.setSeatsNumber(railwayCarriage.getSeatsNumber());
        railwayCarriageDTO.setCarType(railwayCarriage.getCarType());
        return railwayCarriageDTO;
    }

    private PlaceDTO mapToDTO(Place place) {
        PlaceDTO placeDTO = new PlaceDTO();
        placeDTO.setId(place.getId());
        placeDTO.setPlaceNumber(place.getPlaceNumber());
        placeDTO.setRailwayCarriage(mapToDTO(place.getRailwayCarriage()));
        placeDTO.setBookingStatus(place.getBookingStatus());
        return placeDTO;
    }

    private PassengerDTO mapToDTO(Passenger passenger) {
        PassengerDTO passengerDTO = new PassengerDTO();
        passengerDTO.setId(passenger.getId());
        passengerDTO.setPassengerName(passenger.getPassengerName());
        passengerDTO.setPassportDetails(passenger.getPassportDetails());
        passengerDTO.setEmail(passenger.getEmail());
        passengerDTO.setTripsNumber(passenger.getTripsNumber());
        return passengerDTO;
    }

}
