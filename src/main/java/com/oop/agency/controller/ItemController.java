package com.oop.agency.controller;

import com.oop.agency.model.Hotel;
import com.oop.agency.model.HotelReserve;
import com.oop.agency.repository.HotelRepository;
import io.github.palexdev.materialfx.controls.MFXScrollPane;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.jboss.jandex.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@FxmlView("../component/item.fxml")
public class ItemController {

    @Autowired
    private MainController mainController;

    @Autowired
    private ApplicationContext context;

    @FXML
    private GridPane item_grid;

    @FXML
    private Label title_lbl;

    public Hotel curHotel;

    public Hotel getCurHotel() {
        return curHotel;
    }

    public void setCurHotel(Hotel curHotel) {
        this.curHotel = curHotel;
    }

    @FXML
    public void initialize() {
    }

    public void itemClick(MouseEvent event) throws IOException {
        Platform.runLater(() -> {
            Scene scene = item_grid.getScene();
            Pane contentPane = (Pane) scene.lookup("#contentPane");

            FxWeaver fxWeaver = context.getBean(FxWeaver.class);
            DetailController controller = fxWeaver.loadController(DetailController.class);
            controller.setCurHotel(getCurHotel());
            Pane pane = fxWeaver.loadView(controller.getClass());

            contentPane.getChildren().clear();
            contentPane.getChildren().add(pane);
        });
    }
}