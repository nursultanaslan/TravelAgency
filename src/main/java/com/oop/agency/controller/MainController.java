package com.oop.agency.controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.dialogs.MFXGenericDialog;
import io.github.palexdev.materialfx.dialogs.MFXGenericDialogBuilder;
import io.github.palexdev.materialfx.dialogs.MFXStageDialog;
import io.github.palexdev.materialfx.enums.ScrimPriority;
import io.github.palexdev.materialfx.font.MFXFontIcon;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import javax.print.DocFlavor;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;

@Component
@FxmlView("../home.fxml")
public class MainController {

    private Stage stage;

    private double xOffset;
    private double yOffset;

    @FXML
    private FlowPane itemPane;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private FontAwesomeIconView closeIcon;

    @FXML
    private FontAwesomeIconView maximizeIcon;

    @FXML
    private FontAwesomeIconView minimizeIcon;

    @FXML
    private VBox navBar;

    @FXML
    public StackPane contentPane;

    @Autowired
    private ApplicationContext context;

    private MFXGenericDialog dialogContent;
    private MFXStageDialog dialog;

    public void DialogInit() {
        this.dialogContent = MFXGenericDialogBuilder.build()
                .setHeaderText("Hakkında")
                .setContentText("hjvhjvjhvbhj")
                .get();
        this.dialog = MFXGenericDialogBuilder.build(dialogContent)
                .toStageDialogBuilder()
                .initOwner((Stage) rootPane.getScene().getWindow())
                .initModality(Modality.APPLICATION_MODAL)
                .setDraggable(true)
                .setTitle("Hakkında")
                .setOwnerNode(rootPane)
                .setScrimPriority(ScrimPriority.WINDOW)
                .setScrimOwner(true)
                .get();

        dialogContent.setMaxSize(400, 200);
    }

    @FXML
    public void initialize() {
        Platform.runLater(() -> {
            if(rootPane.getScene() != null) {
                stage = (Stage) rootPane.getScene().getWindow();
                closeIcon.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> Platform.exit());
                maximizeIcon.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> toggleWindow());
                minimizeIcon.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> stage.setIconified(true));

                rootPane.setOnMousePressed(event -> {
                    xOffset = stage.getX() - event.getScreenX();
                    yOffset = stage.getY() - event.getScreenY();
                });

                rootPane.setOnMouseDragged(event -> {
                    stage.setX(event.getScreenX() + xOffset);
                    stage.setY(event.getScreenY() + yOffset);
                });

                navigate(HotelController.class);
                DialogInit();
            }
        });
    }

    public void navigate(Class<?> controller) {
        contentPane.getChildren().clear();

        if(controller != null) {
            FxWeaver fxWeaver = context.getBean(FxWeaver.class);
            Parent root = fxWeaver.loadView(controller);

            contentPane.getChildren().add(root);
        }
    }

    public void navClick(ActionEvent actionEvent) {
        MFXButton button = (MFXButton) actionEvent.getSource();
        String id = button.getId();

        if (id.equals("hotels"))
            navigate(HotelController.class);
        else if (id.equals("hreserve"))
            navigate(HReserveController.class);
        else
            navigate(null);
    }

    @FXML
    private void openDialog(ActionEvent event) {
        dialog.showDialog();
    }

    private void toggleWindow() {
        if (stage.isMaximized()) {
            stage.setMaximized(false);
            maximizeIcon.setGlyphName("WINDOW_MAXIMIZE");
        }
        else {
            stage.setMaximized(true);
            maximizeIcon.setGlyphName("WINDOW_RESTORE");
        }
    }
}