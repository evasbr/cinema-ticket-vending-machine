module Beranda {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens Beranda to javafx.fxml;
    exports Beranda;
}

