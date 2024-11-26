package Beranda;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.awt.event.MouseEvent;

public class BerandaController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}