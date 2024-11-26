module kelompok_6.bif.demo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens kelompok_6.bif.demo1 to javafx.fxml;
    exports kelompok_6.bif.demo1;
    exports data;
    opens data to javafx.fxml;
    exports components;
    opens components to javafx.fxml;
}