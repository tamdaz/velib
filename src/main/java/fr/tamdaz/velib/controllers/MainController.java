package fr.tamdaz.velib.controllers;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import fr.tamdaz.velib.models.Station;
import fr.tamdaz.velib.models.collection.StationCollection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
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
     * Une box verticale qui affiche toutes les informations sur la station sélectionné.
     */
    @FXML
    private VBox infoBox;

    /**
     * Texte pour afficher la ville.
     */
    @FXML
    private Text cityText;

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
     * Contient tous les boutons radio pour la sélection d'un département.
     */
    @FXML
    private ToggleGroup departmentGroup;

    /**
     * Contient tous les boutons radio pour la sélection d'un arrondissement.
     */
    @FXML
    private ToggleGroup arrondissementsGroup;

    /**
     * Contient tous les boutons radio pour sélectionner les stations mobiles.
     */
    @FXML
    private ToggleGroup otherParamGroup;

    /**
     * Petite vue représentant les arrondissements à sélectionner.
     */
    @FXML
    private TitledPane arrondissementView;

    /**
     * Une liste de toutes stations.
     */
    private final ObservableList<Station> data = FXCollections.observableArrayList(StationCollection.getStations());

    /**
     * Fermer le programme
     */
    @FXML
    private void closeProgram() {
        System.exit(0);
    }

    /**
     * Références de l'application / à propos
     */
    @FXML
    private void refProgram(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("À propos");
        alert.setHeaderText("Projets Velib'");
        alert.setContentText("Développés par Zohir TAMDA & Jacky HUYNH.");

        alert.showAndWait();
    }

    /**
     * Une fois que la vue et le controller se délenche.
     */
    @FXML
    public void initialize() {
        // Récupérer la valeur des attributs grâce à la clase PropertyValueFactory.
        // Tant que certains attributs possèdent un getter et un setter,
        // les données pourront être affichés sous forme de tableau.
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("stationCode"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        isRentingColumn.setCellValueFactory(new PropertyValueFactory<>("isRenting"));
        isInstalledColumn.setCellValueFactory(new PropertyValueFactory<>("isInstalled"));

        this.dataTable.getItems().addAll(this.data);
    }

    /**
     * Se déclenche lorsqu'un utilisateur choisit un département.
     */
    @FXML
    public void onSelectedDepartment() {
        RadioButton selectedRadioButton = (RadioButton) departmentGroup.getSelectedToggle();
        String departmentValue = selectedRadioButton.getText();

        boolean isParisSelected = departmentValue.equals("75");
        
        if (!isParisSelected) {
            this.arrondissementsGroup.selectToggle(null);
        }

        this.infoBox.setVisible(false);
        
        this.arrondissementView.setDisable(!isParisSelected);

        this.dataTable.getItems().clear();
        this.dataTable.getItems().addAll(StationCollection.filterStationByDepartement(departmentValue));

        this.otherParamGroup.selectToggle(null);
    }

    /**
     * Se déclenche lorsqu'un utilisateur choisit un arrondissement.
     */
    @FXML
    public void onSelectedArrondissement() {
        RadioButton selectedRadioButton = (RadioButton) arrondissementsGroup.getSelectedToggle();
        String arrondissementValue = selectedRadioButton.getText();

        this.infoBox.setVisible(false);

        this.dataTable.getItems().clear();
        this.dataTable.getItems().addAll(StationCollection.filterStationByArrondissement(arrondissementValue));
        
        this.otherParamGroup.selectToggle(null);
    }

    /**
     * Se déclenche lors de la sélection d'une ligne dans un tableau.
     */
    @FXML
    public void onSelectedStation() {
        if (!this.dataTable.getSelectionModel().isEmpty()) {
            Station selectedStation = this.dataTable.getSelectionModel().getSelectedItem();
            this.displayAdditionalInformation(selectedStation);
            this.infoBox.setVisible(true);
        }
    }

    /**
     * Se déclenche lorsqu'un utilisateur choisit le filtre des stations mobiles.
     */
    public void onSelectedMobile() {
        this.infoBox.setVisible(false);

        this.dataTable.getItems().clear();
        this.dataTable.getItems().addAll(StationCollection.filterStationByMobile());

        /**
         * Dès lors que le bouton Mobiles est sélectionné,
         * on désactive les boutons départements et arrondissements.
        */
        this.departmentGroup.selectToggle(null);
        this.arrondissementsGroup.selectToggle(null);
    }

    /**
     * Affiche des informations complémentaires sur la station sélectionnée.
     * 
     * @param selectedStation
     */
    private void displayAdditionalInformation(Station selectedStation) {
        this.stationCodeText.setText("Station n°" + selectedStation.getStationCode());

        this.nameText.setText("Nom : " + selectedStation.getName());
        this.capacityText.setText("Capacité : " + selectedStation.getBikesCapacity().getCapacity());
        this.numBikesText.setText("Nombre de vélos disponibles : " + selectedStation.getBikesCapacity().getNumberBikesAvailable());
        this.numDocksText.setText("Nombre de bornettes disponibles : " + selectedStation.getBikesCapacity().getEbike());
        this.inseeCodeText.setText("Code INSEE : " + selectedStation.getMunicipalityCodeInsee());

        if (selectedStation.getIsRenting().equals("Oui")) {
            this.isRentingText.setText("Borne de paiement : Disponible");
            this.isRentingText.setFill(Color.GREEN);
        } else {
            this.isRentingText.setText("Borne de paiement : Occupé");
            this.isRentingText.setFill(Color.RED);
        }

        this.numEbikesText.setText("Nombre de vélos électriques : " + selectedStation.getBikesCapacity().getEbike());

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

        this.cityText.setText("Ville : " + selectedStation.getCityName());

        if (selectedStation.getMunicipalityCodeInsee().startsWith("75")) {
            this.arrondissementText.setText("Arrondissement : " + selectedStation.getArrondissement());
        } else {
            this.arrondissementText.setText("----");
        }
        
        this.numMecanicBikesText.setText("Nombre de vélos mécaniques : " + selectedStation.getBikesCapacity().getEbike());

        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("dd/MM/YYYY à HH:mm:ss")
                .withZone(ZoneId.systemDefault());

        String dueDateString = formatter.format(selectedStation.getDueDate());

        this.dueDateText.setText("Date d'actualisation des données : " + dueDateString);

        this.longitudeText.setText(selectedStation.getCoordinates().getLitteralLongitude());
        this.latitudeText.setText(selectedStation.getCoordinates().getLitteralLattitude());
    }
}
