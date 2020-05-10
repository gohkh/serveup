package gohkh.serveup.model;

import java.util.Objects;

public class Item {
    private final String name;

    public Item(String name) {
        this.name = name;
    }

    @Override
    public final boolean equals(Object obj) {
        if (!(obj instanceof Item)) {
            return false;
        }

        Item item = (Item) obj;
        return name.equals(item.name);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
