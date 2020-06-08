package gohkh.serveup.ui.manager;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainWindow extends ManagerFxmlComponent<Stage> {
    private final Stage stage;

    @FXML
    private Pane sidebar;
    @FXML
    private Pane mainContent;

    public MainWindow(Stage stage) {
        super("MainWindow.fxml", stage);
        this.stage = stage;
    }

    public void show() {
        stage.show();
        loadSidebar();
        loadContent(new Pane());
    }

    public void loadSidebar() {
        Sidebar sb = new Sidebar();
        sb.addListener((observableSection, previousSection, currentSection) ->
                loadContent(currentSection.getContent()));
        sidebar.getChildren().setAll(sb.getRoot());
    }

    public void loadContent(Pane content) {
        mainContent.getChildren().setAll(content);
    }
}
