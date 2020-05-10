package gohkh.serveup.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Menu {
    private final List<Item> items;

    private Menu(List<Item> items) {
        this.items = items;
    }

    public static Menu create() {
        return new Menu(List.of());
    }

    public Menu add(Item toAdd) {
        return new Menu(Stream.concat(items.stream(), Stream.of(toAdd))
                .collect(Collectors.toUnmodifiableList()));
    }

    public Menu remove(Item toRemove) {
        return new Menu(items.stream().filter(item -> !toRemove.equals(item))
                .collect(Collectors.toUnmodifiableList()));
    }
}
