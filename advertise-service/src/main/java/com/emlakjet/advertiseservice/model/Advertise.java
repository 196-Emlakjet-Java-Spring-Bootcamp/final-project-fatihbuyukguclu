package com.emlakjet.advertiseservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "advertise")
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Advertise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String title;
    private BigDecimal price;
    private AdvertiseState state;

}
