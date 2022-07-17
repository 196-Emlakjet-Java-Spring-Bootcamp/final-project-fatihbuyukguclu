package com.example.adminservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Advertise {

    private Long id;

    private Long userId;
    private String title;
    private BigDecimal price;
    private AdvertiseState state;

}
