package com.emlakjet.reportservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Advertise implements Serializable {
    private Long id;

    private Long userId;
    private String title;
    private BigDecimal price;
    private Long viewedCount;
    private AdvertiseState state;
}
