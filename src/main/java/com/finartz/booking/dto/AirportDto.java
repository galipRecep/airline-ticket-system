package com.finartz.booking.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(of={"id"},callSuper = false)
public class AirportDto  {

    private Long id;

    private String name;

    private String code;

    private String country;

    private String city;
}
