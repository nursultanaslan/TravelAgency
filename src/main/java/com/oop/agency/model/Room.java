package com.oop.agency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "odalar")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Short oda_id;
    private String oda_adi;
    private String oda_url;
    private Boolean oda_durum;
    private Short oda_tur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "otel_id")
    private Hotel hotel;
}