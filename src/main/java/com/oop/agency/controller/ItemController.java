package com.oop.agency.controller;

import com.oop.agency.model.HotelReserve;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
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
    public void initialize() {

    }

    public void itemClick(MouseEvent event) throws IOException {
        FxWeaver fxWeaver = context.getBean(FxWeaver.class);
        MainController controller = fxWeaver.loadController(MainController.class);

        controller.contentPane.getChildren().clear();
        Parent root = fxWeaver.loadView(DetailController.class);

        controller.contentPane.getChildren().add(root);
    }
}