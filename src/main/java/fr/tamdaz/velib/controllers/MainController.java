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
    /**
     * ID de la table de stations.
     */
    @FXML
    private TableView<Station> dataTable;

    /**
     * Colonne pour afficher un ensemble de numéros de stations.
     */
    @FXML
    private TableColumn<Station, String> numberColumn;

    /**
     * Colonne pour afficher un ensemble de noms de stations.
     */
    @FXML
    private TableColumn<Station, String> nameColumn;

    /**
     * Colonne pour afficher un ensemble de stations disponibles.
     */
    @FXML
    private TableColumn<Station, Boolean> isInstalledColumn;

    /**
     * Colonne pour afficher un ensemble de bornes de paiements disponibles.
     */
    @FXML
    private TableColumn<Station, Boolean> isRentingColumn;

    /**
     * Une box verticale qui affiche toutes les informations sur une station.
     */
    @FXML
    private VBox infoBox;

    /**
     * Texte pour afficher l'arrondissement.
     */
    @FXML
    private Text arrondissementText;

    /**
     * Texte pour afficher le nombre de vélos alloués à la station.
     */
    @FXML
    private Text capacityText;

    /**
     * Texte pour afficher si la station est disponible ou non.
     */
    @FXML
    private Text isInstalledText;

    /**
     * Texte pour afficher si la borne de paiements est disponible ou non.
     */
    @FXML
    private Text isRentingText;

    /**
     * Texte pour afficher si la station peut recevoir des vélos.
     */
    @FXML
    private Text isReturningText;

    /**
     * Texte pour afficher le nom de la station.
     */
    @FXML
    private Text nameText;

    /**
     * Texte pour afficher le nombre de vélos disponibles (mécaniques et
     * électriques).
     */
    @FXML
    private Text numBikesText;

    /**
     * Texte pour afficher le nombre de bornettes disponibles.
     */
    @FXML
    private Text numDocksText;

    /**
     * Texte pour afficher le nombre de vélos électriques disponibles.
     */
    @FXML
    private Text numEbikesText;

    /**
     * Texte pour afficher le nombre de vélos mécaniques disponibles.
     */
    @FXML
    private Text numMecanicBikesText;

    /**
     * Texte pour afficher le numéro de la station.
     */
    @FXML
    private Text stationCodeText;

    /**
     * Texte pour afficher le code INSEE.
     */
    @FXML
    private Text inseeCodeText;

    /**
     * Texte pour afficher la date d'actualisation des données de la station.
     */
    @FXML
    private Text dueDateText;

    /**
     * Texte pour afficher la lattitude.
     */
    @FXML
    private Text latitudeText;

    /**
     * Texte pour afficher la longitude.
     */
    @FXML
    private Text longitudeText;

    /**
     * Une liste de toutes stations.
     */
    private final ObservableList<Station> data = FXCollections.observableArrayList(StationCollection.getStations());

    /**
     * Une fois que la vue et le controller se délenche.
     */
    @FXML
    public void initialize() {
        // Récupérer la valeur des attributs grâce à la clase PropertyValueFactory.
        // Tant que certains attributs sont de type SimpleStringProperty,
        // SimpleBooleanProperty
        // ou SimpleIntegerProperty et que chaque attribut possèdent un getter et un
        // setter,
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
        if (!this.dataTable.getSelectionModel().isEmpty()) {
            Station selectedStation = this.dataTable.getSelectionModel().getSelectedItem();
            this.displayAdditionalInformation(selectedStation);
        }
    }

    /**
     * Affiche des informations complémentaires sur la station sélectionnée.
     * 
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

        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("dd/MM/YYYY à HH:mm:ss")
                .withZone(ZoneId.systemDefault());

        String dueDateString = formatter.format(selectedStation.getDueDate());

        this.dueDateText.setText("Date d'actualisation des données : " + dueDateString);

        String longitude = String.valueOf(selectedStation.getCoordinates().getLongitude());
        String latitude = String.valueOf(selectedStation.getCoordinates().getLatitude());

        this.longitudeText.setText(longitude);
        this.latitudeText.setText(latitude);
    }
}
