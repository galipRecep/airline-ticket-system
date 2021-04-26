package com.finartz.booking.model;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "Air_Carrier")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of={"id"}, callSuper = false)
@SequenceGenerator(name="seq_AirCarrier",initialValue = 1,allocationSize = 1)
public class AirCarrier {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "seq_AirCarrier")
    private Long id;

    private String name;

    private String address;

    private String telephone;


}
