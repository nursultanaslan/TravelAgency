package com.oop.agency.controller;

import com.oop.agency.model.City;
import com.oop.agency.repository.CityRepository;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.utils.others.FunctionalStringConverter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.util.StringConverter;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@FxmlView("../home.fxml")
public class CityController {
    @FXML
    private MFXComboBox city_cbx;

    @Autowired
    CityRepository cityRepository;

    @PostConstruct
    public ObservableList<City> findAll() {
        return FXCollections.observableArrayList(cityRepository.findAll());
    }

    public void loadCities(ActionEvent actionEvent) {
        StringConverter<City> converter = FunctionalStringConverter.to(city -> (city == null) ? "" : city.getSehir_adi());
        city_cbx.setConverter(converter);
        city_cbx.setItems(findAll());
    }
}