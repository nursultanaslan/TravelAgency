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
@Table(name = "sezonlar")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Short sezon_id;
    private String sezon_adi;
    private LocalDate sezon_baslangic;
    private LocalDate sezon_bitis;
}