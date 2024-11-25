package components;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.AnchorPane;
import kelompok_6.bif.demo1.HelloApplication;

import java.io.IOException;

public class KeranjangItem extends SplitPane {
    @FXML
    public Label tiketInfo;
    
    @FXML
    private Label harga;

    @FXML
    private Button closeBtn;

    public KeranjangItem() {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("KeranjangItem.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(KeranjangItem.this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        // Tambahkan handler di sini
        closeBtn.setOnMouseEntered(this::mouseHover);
        closeBtn.setOnMouseClicked(this::handleClose);
        this.setMaxHeight(10);
    }

    private void handleClose(MouseEvent event) {
        // Mendapatkan parent container
        if (this.getParent() instanceof javafx.scene.layout.Pane parent) {
            parent.getChildren().remove(this); // Hapus KeranjangItem dari parent
        } else {
            System.out.println("Parent tidak ditemukan atau bukan Pane!");
        }
    }


    private void mouseHover(MouseEvent event) {
        System.out.println("Mouse entered close button!");
        closeBtn.setStyle("-fx-background-color: #FF0000;"); // Contoh: ganti warna tombol

    }

    public enum CardType {
        ERROR,
        WARNING,
        SUCCESS
    }

    private String tiketInfoMsg;
    private String hargaMsg;
    private CardType cardType;

    public String getTiketInfoMsg() {
        return tiketInfoMsg;
    }

    public void setTiketInfoMsg(String tiketInfoMsg) {
        this.tiketInfoMsg = tiketInfoMsg;
        tiketInfo.setText(tiketInfoMsg);
    }

    public String getHargaMsg() {
        return hargaMsg;
    }

    public void setHargaMsg(String hargaMsg) {
        this.hargaMsg = hargaMsg;
        harga.setText(hargaMsg);
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
        String css = "-fx-background-color: ";
        css += switch (cardType) {
            case ERROR -> "red";
            case WARNING -> "yellow";
            case SUCCESS -> "green";
        } + "; -fx-background-radius: 5px;";

        this.setStyle(css);
    }

//    @FXML
//    private void
}
