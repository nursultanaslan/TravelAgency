package com.oop.agency.service;

import com.oop.agency.interfaces.Reservation;
import com.oop.agency.model.TourReserve;
import com.oop.agency.repository.TReserveRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class TourService implements Reservation {

    private TReserveRepo tReserveRepo;

    private TourReserve tourReserve;

    public TourReserve getTourReserve() {
        return tourReserve;
    }

    public void setTourReserve(TourReserve tourReserve) {
        this.tourReserve = tourReserve;
    }

    public TReserveRepo gettReserveRepo() {
        return tReserveRepo;
    }

    public void settReserveRepo(TReserveRepo tReserveRepo) {
        this.tReserveRepo = tReserveRepo;
    }

    @Override
    public void makeReservation() {
        tReserveRepo.save(tourReserve);
    }
}
