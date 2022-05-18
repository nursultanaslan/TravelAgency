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
@Table(name = "otel_rezervasyon")
public class HotelReserve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short rezervasyon_id;

    private String musteri_adi;
    private String musteri_tel;
    private String musteri_email;
    private LocalDate tarih;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "otel_id")
    private Hotel hotel;
}