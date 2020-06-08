package gohkh.serveup;

import javafx.application.Preloader;
import javafx.stage.Stage;

public class ManagerAppPreloader extends Preloader {
    @Override
    public void start(Stage stage) {
        com.sun.glass.ui.Application.GetApplication().setName("ServeUp");
    }
}
