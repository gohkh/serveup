package gohkh.serveup.model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Section {
    private final String title;
    private final Map<Item, Price> entries;

    public Section(String title) {
        this(title, Map.of());
    }

    private Section(String title, Map<Item, Price> entries) {
        this.title = title;
        this.entries = entries;
    }

    public Section add(Item item, Price price) {
        Map<Item, Price> newEntries = new LinkedHashMap<>(entries);
        newEntries.put(item, price);
        return new Section(title, Collections.unmodifiableMap(newEntries));
    }

    public Section remove(Item item) {
        Map<Item, Price> newEntries = new LinkedHashMap<>(entries);
        newEntries.remove(item);
        return new Section(title, Collections.unmodifiableMap(newEntries));
    }

    @Override
    public boolean equals(Object obj) {
        if (!(getClass().equals(obj.getClass()))) {
            return false;
        }

        Section section = (Section) obj;
        return title.equals(section.title) && entries.equals(section.entries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, entries);
    }

    @Override
    public String toString() {
        return title;
    }
}
