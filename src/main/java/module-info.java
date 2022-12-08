module hu.petrik.adatbazis {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens hu.petrik.adatbazis to javafx.fxml;
    exports hu.petrik.adatbazis;
}