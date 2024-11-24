package kelompok_6.bif.demo1;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.IOException;

public class MySwitch extends AnchorPane {
    @FXML
    private Rectangle background;
    @FXML
    private Rectangle knob;

    boolean isOn = false;

    TranslateTransition translation;

    public MySwitch() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MySwitch.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(MySwitch.this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        initElements();
    }

    void initElements(){
        translation = new TranslateTransition(Duration.millis(200), knob);

        background.onMouseClickedProperty().set(event -> switchState());
        knob.onMouseClickedProperty().set(event -> switchState());
    }

    // you have to make public getters and setters to expose a
    // component property to the outer fxml templates

    public boolean getIsOn() {
        return isOn;
    }

    public void setIsOn(boolean value) {
        isOn = value;

        // update view
        if (isOn) {
            translation.setToX(40-18);
            translation.play();
            background.setFill(Paint.valueOf("#0C8CE9"));
        } else {
            translation.setToX(0);
            translation.play();
            background.setFill(Paint.valueOf("#d9d9d9"));
        }
    }

    public void switchState() {
        setIsOn(!isOn);

        System.out.println("Switch pressed");
    }
}
