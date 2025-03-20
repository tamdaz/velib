module fr.tamdaz.velib {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires org.json;

    opens fr.tamdaz.velib to javafx.fxml;
    opens fr.tamdaz.velib.controllers to javafx.fxml;
    opens fr.tamdaz.velib.models to javafx.base;
    exports fr.tamdaz.velib;
    exports fr.tamdaz.velib.controllers;
}
