package com.finartz.booking.model;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@Entity
@Table(name= "Ticket")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of={"id"}, callSuper = false)
@SequenceGenerator(name="seq_Ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Ticket")
    private Long id;

    private String ticketNumber;

    private String name;

    private String surName;

    @Basic
    private java.util.Date bookingDate;

    private String cardNumber;

    private String cardName;

    private int cardExpiryMonth;

    private int cardExpiryYear;


    @ManyToOne(targetEntity =Flight.class ,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "flight_id", referencedColumnName = "id")
    private Flight flight;

    private double ticketPrice;
}
