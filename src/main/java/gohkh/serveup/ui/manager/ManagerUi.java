package gohkh.serveup.ui.manager;

import javafx.stage.Stage;

import gohkh.serveup.ui.Ui;

public class ManagerUi implements Ui {
    private MainWindow mainWindow;

    @Override
    public void start(Stage stage) {
        mainWindow = new MainWindow(stage);
        mainWindow.show();
    }
}
