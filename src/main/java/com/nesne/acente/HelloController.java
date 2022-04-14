package com.nesne.acente;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import io.github.palexdev.materialfx.font.MFXFontIcon;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private final Stage stage;
    private double xOffset;
    private double yOffset;
    private boolean isMaximized = false;

    @FXML
    private MFXFontIcon closeIcon;

    @FXML
    private MFXFontIcon minimizeIcon;

    @FXML
    private MFXFontIcon maximizeIcon;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Pane pane;

    public HelloController(Stage stage) {
        this.stage = stage;
    }

    private void toggleWindow() {
        isMaximized = !isMaximized;
        ((Stage) rootPane.getScene().getWindow()).setMaximized(isMaximized);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        closeIcon.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> Platform.exit());
        maximizeIcon.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> toggleWindow());
        minimizeIcon.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> ((Stage) rootPane.getScene().getWindow()).setIconified(true));

        rootPane.setOnMousePressed(event -> {
            xOffset = stage.getX() - event.getScreenX();
            yOffset = stage.getY() - event.getScreenY();
        });

        rootPane.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() + xOffset);
            stage.setY(event.getScreenY() + yOffset);
        });
    }
}