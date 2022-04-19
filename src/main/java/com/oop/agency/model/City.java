package com.oop.agency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sehirler")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Short sehir_id;
    private String sehir_adi;
}