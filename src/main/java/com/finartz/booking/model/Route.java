package com.finartz.booking.model;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name= "Route")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of={"id"}, callSuper = false)
@SequenceGenerator(name="seq_Route",initialValue = 1,allocationSize = 1)
public class Route {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq_Route")
    private Long id;

    private String name;

    private String code;

    @Column(name = "travel_time")
    private int travelTime;

    @OneToOne(targetEntity =Airport.class ,cascade = CascadeType.ALL)
    @JoinColumn(name = "departure_airport_id", referencedColumnName = "id")
    private Airport departureAirport;


    @OneToOne(targetEntity =Airport.class ,cascade = CascadeType.ALL)
    @JoinColumn(name = "arrival_airport_id", referencedColumnName = "id")
    private Airport arrivalAirport;
}
