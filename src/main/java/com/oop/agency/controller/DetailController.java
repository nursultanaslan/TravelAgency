package com.oop.agency.controller;

import com.oop.agency.model.Hotel;
import com.oop.agency.model.HotelReserve;
import com.oop.agency.object.ServiceFacade;
import com.oop.agency.repository.HReserveRepo;
import com.oop.agency.repository.HotelRepository;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Locale;


@Component
@FxmlView("../component/hotel_detail.fxml")
public class DetailController {

    private ServiceFacade serviceFacade;
    private HotelReserve hotelReserve;

    @Autowired
    private HReserveRepo hReserveRepo;

    @Autowired
    private HotelRepository hotelRepository;

    @FXML
    private ImageView detail_img1;

    @FXML
    private Label detail_name;

    @FXML
    private Label detail_location;

    @FXML
    private Label detail_desc;

    public Hotel curHotel;

    public Hotel getCurHotel() {
        return curHotel;
    }

    public void setCurHotel(Hotel curHotel) {
        this.curHotel = curHotel;
    }

    @FXML
    private MFXTextField name;

    @FXML
    private MFXTextField phone;

    @FXML
    private MFXDatePicker date;

    @FXML
    private MFXTextField email;

    @FXML
    public void initialize() {
        serviceFacade = new ServiceFacade();
        hotelReserve = new HotelReserve();

        Platform.runLater(() -> {
            date.setLocale(Locale.forLanguageTag("tr-TR"));
            Hotel hotel = getCurHotel();
            Image image = new Image(hotel.getOtel_url(), detail_img1.getFitWidth(), detail_img1.getFitHeight(), false, false);
            detail_img1.setImage(image);

            detail_name.setText(hotel.getName());
            detail_location.setText(hotel.getDistrict().getIlce_adi() + ", " + hotel.getCity().getSehir_adi());
            detail_desc.setText(hotel.getOtel_detay());
        });
    }

    public void reserve(ActionEvent actionEvent) {
        hotelReserve.setMusteri_adi(name.getText());
        hotelReserve.setMusteri_email(email.getText());
        hotelReserve.setMusteri_tel(phone.getText());
        hotelReserve.setTarih(date.getValue());
        hotelReserve.setHotel(getCurHotel());

        serviceFacade.hotelReservation(hotelReserve, hReserveRepo);
    }
}
