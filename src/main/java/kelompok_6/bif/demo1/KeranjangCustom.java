package kelompok_6.bif.demo1;

import components.KeranjangItem;
import data.Film;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

        AnchorPane root = new AnchorPane();
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        root.getChildren().add(vbox);
        root.setPrefWidth(800);
        root.setPrefHeight(500);
        double y = 0;
        for (Film f : daftarFilm) {
            for (int i = 0; i < 2; i++) {
                KeranjangItem keranjangItem = new KeranjangItem();
                keranjangItem.setTiketInfoMsg(f.getJudul() + ", " + f.getTayang() + ", " + "A" + (i + 1));
//                card.setLayoutX(0);
//                card.setLayoutY(y);
                vbox.getChildren().add(keranjangItem);
//                y += card.getPrefHeight();
            }
        }

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CustomButton.fxml"));
        Button customButton = fxmlLoader.load();

        vbox.getChildren().add(customButton);

        Scene scene = new Scene(root);
        stage.setTitle("Keranjang");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}