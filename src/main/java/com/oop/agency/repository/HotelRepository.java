package com.oop.agency.repository;

import com.oop.agency.model.City;
import com.oop.agency.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    List<Hotel> findByCity(City city);
}
