package gohkh.serveup;

import javafx.application.Application;
import javafx.stage.Stage;

import gohkh.serveup.ui.Ui;
import gohkh.serveup.ui.manager.ManagerUi;

public class ManagerApp extends Application {
    private Ui ui;

    public static void main(String[] args) {
        System.setProperty("javafx.preloader", ManagerAppPreloader.class.getCanonicalName());
        Application.launch(args);
    }

    @Override
    public void init() {
        ui = new ManagerUi();
    }

    @Override
    public void start(Stage stage) {
        ui.start(stage);
    }
}
