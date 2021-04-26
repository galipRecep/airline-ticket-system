package com.finartz.booking.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Enumerated;

@Data
@EqualsAndHashCode(of={"id"},callSuper = false)
public class TicketDto {

    private Long id;

    private String name;

    private String surName;

    private String ticketNumber;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date bookingDate;

    private String cardName;

    private String cardNumber;

    private int cardExpiryMonth;

    private int cardExpiryYear;

    private Long flightID;

    private double ticketPrice;
}
