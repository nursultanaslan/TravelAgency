package com.oop.agency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ilceler")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Short ilce_id;
    private String ilce_adi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sehir_id")
    private City city;
}