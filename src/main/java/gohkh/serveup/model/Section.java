package gohkh.serveup.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Section {
    private final String title;
    private final List<Item> items;

    private Section(String title, List<Item> items) {
        this.title = title;
        this.items = items;
    }

    public static Section createEmpty(String title) {
        return new Section(title, List.of());
    }

    public static Section createWithItems(String title, List<Item> items) {
        Section section = createEmpty(title);
        for (Item item : items) {
            section = section.add(item);
        }
        return section;
    }

    public List<Item> getItems() {
        return items;
    }

    public boolean contains(Item item) {
        return items.contains(item);
    }

    public Section add(Item toAdd) {
        if (contains(toAdd)) {
            throw new DuplicateItemException();
        }

        return new Section(title, Stream.concat(items.stream(), Stream.of(toAdd))
                .collect(Collectors.toUnmodifiableList()));
    }

    public Section remove(Item toRemove) {
        if (!contains(toRemove)) {
            throw new NoSuchItemException();
        }

        return new Section(title, items.stream().filter(item -> !toRemove.equals(item))
                .collect(Collectors.toUnmodifiableList()));
    }

    @Override
    public final boolean equals(Object obj) {
        if (!(obj instanceof Section)) {
            return false;
        }

        Section section = (Section) obj;
        return title.equals(section.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return title;
    }
}
