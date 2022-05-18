package com.oop.agency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tur_rezervasyon")
public class TourReserve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short rezervasyon_id;

    private String musteri_adi;
    private String musteri_tel;
    private String musteri_email;
    private Short kisi_sayisi;
    private LocalDate tarih;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tur_id")
    private Tour tour;
}