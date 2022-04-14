module com.nesne.acente {
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;

    opens com.nesne.acente to javafx.fxml;
    exports com.nesne.acente;
}