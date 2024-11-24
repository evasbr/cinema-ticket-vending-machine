package components;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class CustomButtonController {
    @FXML
    private Button customButton;

    @FXML
    private void mouseHoverEnter(MouseEvent event) {
        System.out.println("Custom button hovered!");
    }
}