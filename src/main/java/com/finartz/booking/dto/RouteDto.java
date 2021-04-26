package com.finartz.booking.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of={"id"},callSuper = false)
public class RouteDto {

    private Long id;

    private String name;

    private String code;

    private int travelTime;

    private Long departureAirportId;

    private Long arrivalAirportId;

}
