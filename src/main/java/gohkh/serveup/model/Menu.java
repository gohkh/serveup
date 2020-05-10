package gohkh.serveup.model;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Menu {
    private final List<Section> sections;

    public Menu() {
        this(List.of());
    }

    private Menu(List<Section> sections) {
        this.sections = sections;
    }

    public Menu addSection(Section toAdd) {
        return new Menu(Stream.concat(sections.stream(), Stream.of(toAdd))
                .collect(Collectors.toUnmodifiableList()));
    }

    public Menu removeSection(Section toRemove) {
        return new Menu(sections.stream().filter(section -> !toRemove.equals(section))
                .collect(Collectors.toUnmodifiableList()));
    }

    public Menu addItem(Section section, Item toAdd) {
        Function<Section, Section> addItemToSection = s -> {
            if (section.equals(s)) {
                return s.add(toAdd);
            }
            return s;
        };
        return new Menu(sections.stream().map(addItemToSection)
                .collect(Collectors.toUnmodifiableList()));
    }

    public Menu removeItem(Section section, Item toRemove) {
        Function<Section, Section> removeItemFromSection = s -> {
            if (section.equals(s)) {
                return s.remove(toRemove);
            }
            return s;
        };
        return new Menu(sections.stream().map(removeItemFromSection)
                .collect(Collectors.toUnmodifiableList()));
    }
}
