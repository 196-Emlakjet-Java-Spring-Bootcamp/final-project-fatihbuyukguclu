package com.emlakjet.advertiseservice.model;

import lombok.*;

import java.io.Serializable;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdvertiseDTO implements Serializable {

    private Long id;
    private Long viewCount;

}
