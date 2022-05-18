package com.oop.agency.controller;

import com.oop.agency.model.HotelReserve;
import com.oop.agency.model.TourReserve;
import com.oop.agency.object.ServiceFacade;
import com.oop.agency.repository.HReserveRepo;
import com.oop.agency.repository.TReserveRepo;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView("../tour_reserve.fxml")
public class TReserveController {

    private ServiceFacade serviceFacade;
    private TourReserve tourReserve;

    @Autowired
    private TReserveRepo tReserveRepo;

    @FXML
    private MFXTextField name;

    @FXML
    private MFXTextField phone;

    @FXML
    private MFXDatePicker date;

    @FXML
    private MFXTextField email;

    @FXML
    private MFXTextField count;

    @FXML
    public void initialize() {
        serviceFacade = new ServiceFacade();
        tourReserve = new TourReserve();
    }

    public void reserve(ActionEvent actionEvent) {
        tourReserve.setMusteri_adi(name.getText());
        tourReserve.setMusteri_email(email.getText());
        tourReserve.setMusteri_tel(phone.getText());
        tourReserve.setTarih(date.getValue());
        tourReserve.setKisi_sayisi(Short.parseShort(count.getText()));
        tourReserve.setTour(null);

        serviceFacade.tourReservation(tourReserve, tReserveRepo);
    }
}