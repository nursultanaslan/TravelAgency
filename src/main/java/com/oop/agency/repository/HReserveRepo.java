package com.oop.agency.repository;

import com.oop.agency.model.HotelReserve;
import com.oop.agency.model.TourReserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HReserveRepo extends JpaRepository<HotelReserve, Integer> {

}
