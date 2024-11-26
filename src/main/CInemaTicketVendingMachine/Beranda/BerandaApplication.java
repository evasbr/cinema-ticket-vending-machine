package Beranda;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class BerandaApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Memuat FXML
        FXMLLoader fxmlLoader = new FXMLLoader(BerandaApplication.class.getResource("/Beranda/beranda-view.fxml"));

        // Membuat ScrollPane dan membungkus konten FXML
        ScrollPane scrollPane = new ScrollPane(fxmlLoader.load());

        // Menambahkan stylesheet CSS
        String css = this.getClass().getResource("/Beranda/style.css").toExternalForm();
        Scene scene = new Scene(scrollPane);
        scene.getStylesheets().add(css);

        // Mengatur dan menampilkan stage
        stage.setTitle("Cinema Ticket Vending Machine");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
