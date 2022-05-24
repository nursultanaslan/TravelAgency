package com.oop.agency.controller;

import com.oop.agency.model.HotelReserve;
import com.oop.agency.object.ServiceFacade;
import com.oop.agency.repository.HReserveRepo;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@FxmlView("../hotel_reserve.fxml")
public class HReserveController {

    private ServiceFacade serviceFacade;
    private HotelReserve hotelReserve;

    @Autowired
    private HReserveRepo hReserveRepo;

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

        if(date != null)
            date.setLocale(Locale.forLanguageTag("tr-TR"));

        serviceFacade = new ServiceFacade();
        hotelReserve = new HotelReserve();
    }

    public void reserve(ActionEvent actionEvent) {
        hotelReserve.setMusteri_adi(name.getText());
        hotelReserve.setMusteri_email(email.getText());
        hotelReserve.setMusteri_tel(phone.getText());
        hotelReserve.setTarih(date.getValue());
        hotelReserve.setHotel(null);

        serviceFacade.hotelReservation(hotelReserve, hReserveRepo);
    }
}