package com.finartz.booking.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name= "Flight")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@SequenceGenerator(name="seq_Flight",initialValue = 1,allocationSize = 1)
@EqualsAndHashCode(of={"id"}, callSuper = false)
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_Flight")
    private Long id;

    private String name;

    private String code;

    private int quota;

    private int count;

    private double basePrice;

    private double currentPrice;

    @Basic
    private java.util.Date departureDate;

    @Basic
    private java.util.Date arrivalDate;

    @OneToOne(targetEntity =AirCarrier.class ,cascade = CascadeType.ALL)
    @JoinColumn(name = "carrier_id", referencedColumnName = "id")
    private AirCarrier airCarrier;

    @OneToOne(targetEntity =Route.class ,cascade = CascadeType.ALL)
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    private Route route;

}
