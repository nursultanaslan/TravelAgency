package com.oop.agency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "turlar")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tur_id;
    private String tur_adi;
    private String tur_detayi;
    private String tur_ucreti;
    private String tur_ulasim;
    private String tur_url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ilce_id")
    private District district;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sezon_id")
    private Season season;
}