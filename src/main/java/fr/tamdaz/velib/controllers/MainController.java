package fr.tamdaz.velib.controllers;

import fr.tamdaz.velib.models.Station;
import fr.tamdaz.velib.models.collection.StationCollection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MainController {
    @FXML
    private VBox infoBox;

    @FXML
    private TableView<Station> dataTable;

    @FXML
    private TableColumn<Station, String> numberColumn;

    @FXML
    private TableColumn<Station, String> nameColumn;

    @FXML
    private TableColumn<Station, Boolean> isInstalledColumn;

    @FXML
    private TableColumn<Station, Boolean> isRentingColumn;

    @FXML
    private Text arrondissementText;

    @FXML
    private Text capacityText;

    @FXML
    private Text isInstalledText;

    @FXML
    private Text isRentingText;

    @FXML
    private Text isReturningText;

    @FXML
    private Text nameText;

    @FXML
    private Text numBikesText;

    @FXML
    private Text numDocksText;

    @FXML
    private Text numEbikesText;

    @FXML
    private Text numMecanicBikesText;

    @FXML
    private Text stationCodeText;

    @FXML
    private Text inseeCodeText;

    private final ObservableList<Station> data = FXCollections.observableArrayList(
        StationCollection.getStations()
    );

    @FXML
    public void initialize() {
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("stationCode"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        isRentingColumn.setCellValueFactory(new PropertyValueFactory<>("isRenting"));
        isInstalledColumn.setCellValueFactory(new PropertyValueFactory<>("isInstalled"));

        for (Station station : this.data) {
            this.dataTable.getItems().add(station);
        }
    }

    @FXML
    public void onSelectedStation() {
        Station selectedStation = this.dataTable.getSelectionModel().getSelectedItem();

        this.stationCodeText.setText("Station n°" + selectedStation.getStationCode());

        this.nameText.setText("Nom : " + selectedStation.getName());
        this.capacityText.setText("Capacité : " + selectedStation.getCapacity());
        this.numBikesText.setText("Nombre de vélos disponibles : " + selectedStation.getNumberBikesAvailable());
        this.numDocksText.setText("Nombre de bornettes disponibles : " + selectedStation.getEbike());
        this.inseeCodeText.setText(null);
        this.isRentingText.setText(null);
        this.numEbikesText.setText(null);
        this.isInstalledText.setText(null);
        this.isReturningText.setText(null);
        this.arrondissementText.setText(null);
        this.numMecanicBikesText.setText(null);
    }
}
