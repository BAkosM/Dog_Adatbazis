package hu.petrik.adatbazis;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DogController {
    private DogDB db;
    @FXML
    private TableView<Dog> dogTable;
    @FXML
    private TableColumn<Dog,String> namecol;
    @FXML
    private TableColumn<Dog,Integer> agecol;
    @FXML
    private TableColumn<Dog,String> breedcol;
    @FXML
    private TableColumn<Dog,Integer> idcol;

    @FXML
    private void initialize() {
        namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        agecol.setCellValueFactory(new PropertyValueFactory<>("age"));
        breedcol.setCellValueFactory(new PropertyValueFactory<>("breed"));
        idcol.setCellValueFactory(new PropertyValueFactory<>("id"));
        try {
            db = new DogDB();
            readDogs();
        } catch (SQLException e) {
            Platform.runLater(() -> {
                alert(Alert.AlertType.ERROR,
                        "Hiba történt az adatbázis kapcsolat kialakításakor",
                        e.getMessage());
                Platform.exit();
            });
        }
    }
    private void readDogs() throws SQLException {
        List<Dog> dogs = db.readDogs();
        dogTable.getItems().clear();
        dogTable.getItems().addAll(dogs);
    }
    private void alert(Alert.AlertType alertType, String headerText, String contentText) {
        Alert alert = new Alert(alertType);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
}