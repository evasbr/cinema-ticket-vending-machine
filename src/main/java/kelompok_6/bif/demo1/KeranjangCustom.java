package kelompok_6.bif.demo1;

import components.KeranjangItem;
import data.Film;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class KeranjangCustom extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ArrayList<Film> daftarFilm = new ArrayList<>();
        daftarFilm.add(new Film("WICKED", "petualangan", "Minggu 19 Nov, 17:00", "AMBA.jpg"));
        daftarFilm.add(new Film("ZuPa", "horror", "Sabtu 12 Mei, 21:00", "ZuPa.jpg"));

        ScrollPane root = new ScrollPane();
        VBox vbox = new VBox();
        vbox.setSpacing(10);
//        root.getChildren().add(vbox);
        root.setContent(vbox);
        root.setStyle("-fx-background-color: darksalmon;");
        root.setPrefWidth(800);
        root.setPrefHeight(500);
        double y = 0;
        for (Film f : daftarFilm) {
            for (int i = 0; i < 2; i++) {
                KeranjangItem keranjangItem = new KeranjangItem();
                keranjangItem.setTiketInfoMsg(f.getJudul() + ", " + f.getTayang() + ", " + "A" + (i + 1));
//                keranjangItem.setLayoutX(0);
//                keranjangItem.setLayoutY(y);
                vbox.getChildren().add(keranjangItem);
//                y += keranjangItem.getPrefHeight();
            }
        }

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CustomButton.fxml"));
        FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("CustomButton.fxml"));
        Button customButton = fxmlLoader.load();
        Button customButton2 = fxmlLoader2.load();
        customButton2.setText("WOW");
        customButton2.setPrefHeight(800);

        vbox.getChildren().addAll(customButton, customButton2);

        Scene scene = new Scene(root);
        stage.setTitle("Keranjang");
        stage.setScene(scene);
        stage.show();
        Platform.runLater(() -> root.requestFocus());
    }

    public static void main(String[] args) {
        launch();
    }
}