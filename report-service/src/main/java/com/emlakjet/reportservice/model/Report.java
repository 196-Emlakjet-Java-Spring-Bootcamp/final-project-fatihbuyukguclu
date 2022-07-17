package com.emlakjet.reportservice.model;

import lombok.*;

import javax.persistence.*;

@Getter@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "app_report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long advertId;
    private Long viewed;
    private String message;
}
