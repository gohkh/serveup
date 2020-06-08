package gohkh.serveup.ui.manager;

import javafx.scene.layout.Pane;

public enum Section {
    MENU(new MenuContent().getRoot()),
    LOREM(new Pane()),
    IPSUM(new Pane());

    private final Pane content;

    private Section(Pane content) {
        this.content = content;
    }

    public Pane getContent() {
        return content;
    }

    @Override
    public String toString() {
        return name().substring(0,1).toUpperCase() + name().substring(1).toLowerCase();
    }
}
