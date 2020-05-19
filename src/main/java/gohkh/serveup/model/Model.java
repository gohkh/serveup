package gohkh.serveup.model;

public class Model implements ManagerModel, ServerModel {
    private Menu menu;
    private OrderHistory orderHistory;

    public Model() {
        this(new Menu(), new OrderHistory());
    }

    public Model(Menu menu, OrderHistory orderHistory) {
        this.menu = menu;
        this.orderHistory = orderHistory;
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

    @Override
    public void createOrder() {
        orderHistory = orderHistory.add(new Order(""));
    }

    @Override
    public void addItemToOrder(Item item, Integer quantity, Order order) {
        Order updatedOrder = order.add(item, quantity);
        orderHistory = orderHistory.update(updatedOrder);
    }

    @Override
    public void removeItemFromOrder(Item item, Order order) {
        Order updatedOrder = order.remove(item);
        orderHistory = orderHistory.update(updatedOrder);
    }

}
