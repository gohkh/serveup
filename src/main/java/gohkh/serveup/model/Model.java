package gohkh.serveup.model;

public class Model implements ManagerModel {
    private Menu menu;

    public Model() {
        this(Menu.createEmpty());
    }

    public Model(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void addSectionToMenu(Section section) {
        menu = menu.addSection(section);
    }

    @Override
    public void removeSectionFromMenu(Section section) {
        menu = menu.removeSection(section);
    }

    @Override
    public void addItemToMenu(Item item, Section section) {
        menu = menu.addItem(item, section);
    }

    @Override
    public void removeItemFromMenu(Item item, Section section) {
        menu = menu.removeItem(item, section);
    }
}
