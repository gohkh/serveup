package gohkh.serveup.model;

public interface ServerModel {
    public void createOrder();

    public void addItemToOrder(Item item, Integer quantity, Order order);

    public void removeItemFromOrder(Item item, Order order);
}
