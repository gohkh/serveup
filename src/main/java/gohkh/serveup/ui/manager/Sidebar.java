package gohkh.serveup.ui.manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import gohkh.serveup.ManagerApp;

public class Sidebar extends ManagerFxmlComponent<VBox> {
    private static final ObservableList<String> MENU_ITEMS =
            FXCollections.observableArrayList("Lorem", "Ipsum");

    @FXML
    private ListView<String> menu;

    public Sidebar() {
        super("Sidebar.fxml");
        menu.setItems(MENU_ITEMS);
    }
}
