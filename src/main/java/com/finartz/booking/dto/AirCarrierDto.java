package com.finartz.booking.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of={"id"},callSuper = false)
public class AirCarrierDto {

    private Long id;

    private String name;

    private String address;

    private String telephone;

}
