package gohkh.serveup.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderHistory {
    private List<Order> orders;

    public OrderHistory() {
        this(List.of());
    }

    private OrderHistory(List<Order> orders) {
        this.orders = orders;
    }

    public OrderHistory add(Order toAdd) {
        return new OrderHistory(Stream.concat(orders.stream(), Stream.of(toAdd))
                .collect(Collectors.toUnmodifiableList()));
    }

    public OrderHistory update(Order toUpdate) {
        Function<Order, Order> updateOrder = order -> {
            if (toUpdate.equals(order)) {
                return toUpdate;
            }
            return order;
        };
        return new OrderHistory(orders.stream().map(updateOrder)
                .collect(Collectors.toUnmodifiableList()));
    }
}
