package com.oop.agency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "oteller")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer otel_id;
    private String otel_adi;
    private String otel_url;
    private String otel_detay;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ilce_id")
    private District district;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sehir_id")
    private City city;
}