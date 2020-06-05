package gohkh.serveup.ui.manager;

import java.net.URL;

import gohkh.serveup.ui.FxmlComponent;

public abstract class ManagerFxmlComponent<T> extends FxmlComponent<T> {
    public static final String FXML_SUBDIRECTORY = "manager/";

    public ManagerFxmlComponent(URL fxmlFileUrl) {
        super(fxmlFileUrl);
    }

    public ManagerFxmlComponent(String fxmlFileName) {
        super(fxmlFileName);
    }

    public ManagerFxmlComponent(URL fxmlFileUrl, T root) {
        super(fxmlFileUrl, root);
    }

    public ManagerFxmlComponent(String fxmlFileName, T root) {
        super(fxmlFileName, root);
    }

    @Override
    protected URL getFxmlFileUrl(String fxmlFileName) {
        return super.getFxmlFileUrl(FXML_SUBDIRECTORY + fxmlFileName);
    }
}
