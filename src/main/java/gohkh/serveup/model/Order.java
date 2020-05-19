package gohkh.serveup.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Order {
    private final String id;
    private final Map<Item, Integer> entries;

    public Order(String id) {
        this(id, Map.of());
    }

    private Order(String id, Map<Item, Integer> entries) {
        this.id = id;
        this.entries = entries;
    }

    public Order add(Item item, Integer quantity) {
        Map<Item, Integer> newEntries = new HashMap<>(entries);
        newEntries.put(item, quantity);
        return new Order(id, Collections.unmodifiableMap(newEntries));
    }

    public Order remove(Item item) {
        Map<Item, Integer> newEntries = new HashMap<>(entries);
        newEntries.remove(item);
        return new Order(id, Collections.unmodifiableMap(newEntries));
    }

    @Override
    public final boolean equals(Object obj) {
        if (!(obj instanceof Order)) {
            return false;
        }

        Order order = (Order) obj;
        return id.equals(order.id);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("Order %s", id);
    }
}
