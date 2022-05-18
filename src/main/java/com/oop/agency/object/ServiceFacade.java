package com.oop.agency.object;

import com.oop.agency.repository.HReserveRepo;
import com.oop.agency.repository.TReserveRepo;
import com.oop.agency.service.HotelService;
import com.oop.agency.service.TourService;
import com.oop.agency.model.*;
import org.springframework.stereotype.Service;

public class ServiceFacade {

    private HotelService hotelService;
    private TourService tourService;
    public ServiceFacade() {
        hotelService = new HotelService();
        tourService = new TourService();
    }

    public void hotelReservation(HotelReserve hotelReserve, HReserveRepo hReserveRepo) {
        hotelService.sethReserveRepo(hReserveRepo);
        hotelService.setHotelReserve(hotelReserve);
        hotelService.makeReservation();
    }

    public void tourReservation(TourReserve tourReserve, TReserveRepo tReserveRepo) {
        tourService.settReserveRepo(tReserveRepo);
        tourService.setTourReserve(tourReserve);
        tourService.makeReservation();
    }
}
