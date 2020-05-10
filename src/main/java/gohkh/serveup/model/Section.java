package gohkh.serveup.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Section {
    private final String title;
    private final List<Item> items;

    public Section(String title) {
        this(title, List.of());
    }

    private Section(String title, List<Item> items) {
        this.title = title;
        this.items = items;
    }

    public Section add(Item toAdd) {
        return new Section(title, Stream.concat(items.stream(), Stream.of(toAdd))
                .collect(Collectors.toUnmodifiableList()));
    }

    public Section remove(Item toRemove) {
        return new Section(title, items.stream().filter(item -> !toRemove.equals(item))
                .collect(Collectors.toUnmodifiableList()));
    }

    @Override
    public boolean equals(Object obj) {
        if (!(getClass().equals(obj.getClass()))) {
            return false;
        }

        Section section = (Section) obj;
        return title.equals(section.title) && items.equals(section.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, items);
    }

    @Override
    public String toString() {
        return title;
    }
}
