package com.oop.agency.service;

import com.oop.agency.interfaces.Reservation;
import com.oop.agency.model.HotelReserve;
import com.oop.agency.repository.HReserveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class HotelService implements Reservation {

    private HReserveRepo hReserveRepo;

    private HotelReserve hotelReserve;

    public HotelReserve getHotelReserve() {
        return hotelReserve;
    }

    public void setHotelReserve(HotelReserve hotelReserve) {
        this.hotelReserve = hotelReserve;
    }

    public HReserveRepo gethReserveRepo() {
        return hReserveRepo;
    }

    public void sethReserveRepo(HReserveRepo hReserveRepo) {
        this.hReserveRepo = hReserveRepo;
    }

    @Override
    public void makeReservation() {
        this.hReserveRepo.save(hotelReserve);
    }
}
