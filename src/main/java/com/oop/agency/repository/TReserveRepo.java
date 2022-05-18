package com.oop.agency.repository;

import com.oop.agency.model.District;
import com.oop.agency.model.Tour;
import com.oop.agency.model.TourReserve;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TReserveRepo extends JpaRepository<TourReserve, Integer> {

}
