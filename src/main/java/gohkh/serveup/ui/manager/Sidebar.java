package gohkh.serveup.ui.manager;

import java.util.Arrays;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class Sidebar extends ManagerFxmlComponent<VBox> {
    private static final ObservableList<Section> SECTIONS =
            FXCollections.observableArrayList(Arrays.asList(Section.values()));

    @FXML
    private ListView<Section> menu;

    public Sidebar() {
        super("Sidebar.fxml");
        menu.setItems(SECTIONS);
    }
}
