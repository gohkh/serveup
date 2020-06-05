package gohkh.serveup.ui;

import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;

public abstract class FxmlComponent<T> {
    public static final String FXML_DIRECTORY = "/view/";

    private final FXMLLoader fxmlLoader = new FXMLLoader();

    public FxmlComponent(URL fxmlFileUrl) {
        this(fxmlFileUrl, null);
    }

    public FxmlComponent(String fxmlFileName) {
        this(fxmlFileName, null);
    }

    public FxmlComponent(URL fxmlFileUrl, T root) {
        loadFxmlFile(fxmlFileUrl, root);
    }

    public FxmlComponent(String fxmlFileName, T root) {
        loadFxmlFile(fxmlFileName, root);
    }

    private void loadFxmlFile(URL location, T root) {
        fxmlLoader.setLocation(location);
        fxmlLoader.setRoot(root);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    private void loadFxmlFile(String fxmlFileName, T root) {
        URL fxmlFileUrl = getFxmlFileUrl(fxmlFileName);
        loadFxmlFile(fxmlFileUrl, root);
    }

    protected URL getFxmlFileUrl(String fxmlFileName) {
        String fxmlFilePath = FXML_DIRECTORY + fxmlFileName;
        URL fxmlFileUrl = getClass().getResource(fxmlFilePath);
        if (fxmlFileUrl == null) {
            throw new AssertionError("FXML file not found: " + fxmlFilePath);
        }
        return fxmlFileUrl;
    }

    public T getRoot() {
        return fxmlLoader.getRoot();
    }
}
