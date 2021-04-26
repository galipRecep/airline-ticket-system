package com.finartz.booking.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class FlightDto {

    private Long id;

    private String name;

    private String code;

    private int quota;

    private int count;

    private double basePrice;

    private double currentPrice;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date departureDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date arrivalDate;

    private Long airCarrierId;

    private Long routeId;
/*
    private AirCarrierDto airCarrier;

    private RouteDto route;

 */
}
