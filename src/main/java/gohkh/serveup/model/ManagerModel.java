package gohkh.serveup.model;

public interface ManagerModel {
    public void addSectionToMenu(Section section);

    public void removeSectionFromMenu(Section section);

    public void addItemToMenu(Item item, Section section);

    public void removeItemFromMenu(Item item, Section section);
}
