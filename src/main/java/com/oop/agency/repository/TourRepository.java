package com.oop.agency.repository;

import com.oop.agency.model.District;
import com.oop.agency.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<Tour, Integer> {
    List<Tour> findByDistrict(District district);
}
