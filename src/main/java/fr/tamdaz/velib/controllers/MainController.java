package fr.tamdaz.velib.controllers;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import fr.tamdaz.velib.models.Station;
import fr.tamdaz.velib.models.collection.StationCollection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class MainController {
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
    private VBox infoBox;

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

    @FXML
    private Text dueDateText;

    /**
     * Une liste de toutes stations.
     */
    private final ObservableList<Station> data = FXCollections.observableArrayList(
        StationCollection.getStations()
    );

    /**
     * Une fois que la vue et le controller se délenche.
     */
    @FXML
    public void initialize() {
        // Récupérer la valeur des attributs grâce à la clase PropertyValueFactory.
        // Tant que certains attributs sont de type SimpleStringProperty, SimpleBooleanProperty
        // ou SimpleIntegerProperty et que chaque attribut possèdent un getter et un setter,
        // les données pourront être affichés sous forme de tableau.
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("stationCode"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        isRentingColumn.setCellValueFactory(new PropertyValueFactory<>("isRenting"));
        isInstalledColumn.setCellValueFactory(new PropertyValueFactory<>("isInstalled"));

        for (Station station : this.data) {
            this.dataTable.getItems().add(station);
        }
    }

    /**
     * Se déclenche lors de la sélection d'une ligne dans un tableau.
     */
    @FXML
    public void onSelectedStation() {
        Station selectedStation = this.dataTable.getSelectionModel().getSelectedItem();
        this.displayAdditionalInformation(selectedStation);
    }

    /**
     * Affiche des informations complémentaires sur la station sélectionnée.
     * @param selectedStation
     */
    private void displayAdditionalInformation(Station selectedStation) {
        this.stationCodeText.setText("Station n°" + selectedStation.getStationCode());

        this.nameText.setText("Nom : " + selectedStation.getName());
        this.capacityText.setText("Capacité : " + selectedStation.getCapacity());
        this.numBikesText.setText("Nombre de vélos disponibles : " + selectedStation.getNumberBikesAvailable());
        this.numDocksText.setText("Nombre de bornettes disponibles : " + selectedStation.getEbike());
        this.inseeCodeText.setText("Code INSEE : " + selectedStation.getMunicipalityCodeInsee());

        if (selectedStation.getIsRenting().equals("Oui")) {
            this.isRentingText.setText("Borne de paiement : Disponible");
            this.isRentingText.setFill(Color.GREEN);
        } else {
            this.isRentingText.setText("Borne de paiement : Occupé");
            this.isRentingText.setFill(Color.RED);
        }

        this.numEbikesText.setText("Nombre de vélos électriques : " + selectedStation.getEbike());

        if (selectedStation.getIsInstalled().equals("Oui")) {
            this.isInstalledText.setText("Station : Disponible");
            this.isInstalledText.setFill(Color.GREEN);
        } else {
            this.isInstalledText.setText("Station : Occupée");
            this.isInstalledText.setFill(Color.RED);
        }

        if (selectedStation.getIsReturning().equals("Oui")) {
            this.isReturningText.setText("Peut recevoir des vélos : Oui");
            this.isReturningText.setFill(Color.GREEN);
        } else {
            this.isReturningText.setText("Peut recevoir des vélos : Non");
            this.isReturningText.setFill(Color.RED);
        }

        this.arrondissementText.setText("Arrondissment : " + selectedStation.getArrondissementName());
        this.numMecanicBikesText.setText("Nombre de vélos mécaniques : " + selectedStation.getEbike());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY à HH:mm:ss").withZone(ZoneId.systemDefault());

        this.dueDateText.setText("Date d'actualisation des données : " + formatter.format(selectedStation.getDueDate()));
    }
}
