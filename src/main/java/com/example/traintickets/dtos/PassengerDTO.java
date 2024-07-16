package com.example.traintickets.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PassengerDTO {
    private int id;
    private String passengerName;
    private String passportDetails;
    private String email;
    private int tripsNumber;
}
