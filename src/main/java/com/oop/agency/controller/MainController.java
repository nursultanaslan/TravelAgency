package com.oop.agency.controller;

import com.oop.agency.model.City;
import com.oop.agency.model.Hotel;
import com.oop.agency.repository.CityRepository;
import com.oop.agency.repository.HotelRepository;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.utils.others.FunctionalStringConverter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
@FxmlView("../home.fxml")
public class MainController {
    private ObservableList<City> city_list;

    @FXML
    private FlowPane itemPane;

    @FXML
    private MFXComboBox city_cbx;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    HotelRepository hotelRepository;

    // singleton pattern
    public ObservableList<City> getCity_list() {
        if(this.city_list == null) {
            this.city_list = FXCollections.observableArrayList(cityRepository.findAll());
        }
        return city_list;
    }

    public ObservableList<Hotel> getHotel_list() {
        City selectedCity = (City) city_cbx.getSelectedItem();
        return FXCollections.observableArrayList(hotelRepository.findByCity(selectedCity));
    }

    @FXML
    public void initialize() {
        StringConverter<City> converter = FunctionalStringConverter.to(city -> (city == null) ? "" : city.getSehir_adi());
        city_cbx.setConverter(converter);
        city_cbx.setItems(getCity_list());
    }

    public void search(ActionEvent actionEvent) throws IOException {
        itemPane.getChildren().clear();
        for(Hotel hotel : getHotel_list()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../component/item.fxml"));
            GridPane gridPane = loader.load();

            Image image = new Image(hotel.getOtel_url());
            ImageView imageView = (ImageView) gridPane.lookup("#item_img");
            imageView.setImage(image);

            Label title_lbl = (Label) gridPane.lookup("#title_lbl");
            title_lbl.setText(hotel.getOtel_adi());
            Label city_lbl = (Label) gridPane.lookup("#city_lbl");
            city_lbl.setText(hotel.getCity().getSehir_adi());

            itemPane.getChildren().add(gridPane);
        }
    }
}