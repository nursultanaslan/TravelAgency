package com.oop.agency.controller;

import com.oop.agency.model.City;
import com.oop.agency.model.Hotel;
import com.oop.agency.object.CityList;
import com.oop.agency.object.ServiceFacade;
import com.oop.agency.repository.CityRepository;
import com.oop.agency.repository.HotelRepository;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.utils.others.FunctionalStringConverter;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.util.StringConverter;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Component
@FxmlView("../hotels.fxml")
public class HotelController {
    private ObservableList<City> city_list;

    @FXML
    private FlowPane itemPane;

    @FXML
    private MFXComboBox city_cbx;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    private ApplicationContext context;


    public ObservableList<Hotel> getHotel_list() {
        City selectedCity = (City) city_cbx.getSelectedItem();
        return FXCollections.observableArrayList(hotelRepository.findByCity(selectedCity));
    }

    @FXML
    public void initialize() {
        CityList object = CityList.getInstance();

        StringConverter<City> converter = FunctionalStringConverter.to(city -> (city == null) ? "" : city.getSehir_adi());
        city_cbx.setConverter(converter);
        city_cbx.setItems(object.getList(cityRepository));
        city_cbx.selectIndex(4);
    }

    public void search(ActionEvent actionEvent) throws IOException {
        itemPane.getChildren().clear();
        ServiceFacade serviceFacade = new ServiceFacade();
        ExecutorService service = Executors.newCachedThreadPool();

        for(Hotel hotel : getHotel_list()) {
            Platform.runLater(() -> {
                FxWeaver fxWeaver = context.getBean(FxWeaver.class);
                ItemController controller = fxWeaver.loadController(ItemController.class);
                controller.setCurHotel(hotel);
                GridPane gridPane = fxWeaver.loadView(controller.getClass());

                Image image = new Image(hotel.getOtel_url());
                ImageView imageView = (ImageView) gridPane.lookup("#item_img");
                imageView.setImage(image);

                Label title_lbl = (Label) gridPane.lookup("#title_lbl");
                title_lbl.setText(hotel.getName());
                Label city_lbl = (Label) gridPane.lookup("#city_lbl");
                city_lbl.setText(hotel.getCity().getSehir_adi());

                itemPane.getChildren().add(gridPane);
            });
        }
    }
}