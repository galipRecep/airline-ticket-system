package com.finartz.booking.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name= "Airport")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of={"id"},callSuper = false)
@SequenceGenerator(name="seq_Airport",initialValue = 1,allocationSize = 1)
public class Airport  implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_Airport")
    private Long id;

    @NonNull
    private String name;

    private String code;

    private String country;

    private String city;
}
