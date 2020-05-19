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
        boolean hasDuplicateSection = sections.contains(toAdd);
        if (hasDuplicateSection) {
            throw new DuplicateSectionException(
                    String.format("The menu already contains a %s section.", toAdd));
        }

        boolean hasDuplicateItem = sections.stream()
                .anyMatch(section -> toAdd.containsDuplicateItems(section));
        if (hasDuplicateItem) {
            throw new DuplicateItemException(
                    String.format("The %s section contains items that are already in the menu.", toAdd));
        }

        return new Menu(Stream.concat(sections.stream(), Stream.of(toAdd))
                .collect(Collectors.toUnmodifiableList()));
    }

    public Menu removeSection(Section toRemove) {
        if (!sections.contains(toRemove)) {
            throw new NoSuchSectionException();
        }

        return new Menu(sections.stream().filter(section -> !toRemove.equals(section))
                .collect(Collectors.toUnmodifiableList()));
    }

    public Menu addItem(Item toAdd, Section section) {
        Function<Section, Section> addItemToSection = s -> {
            if (section.equals(s)) {
                return s.add(toAdd);
            }
            return s;
        };
        return new Menu(sections.stream().map(addItemToSection)
                .collect(Collectors.toUnmodifiableList()));
    }

    public Menu removeItem(Item toRemove, Section section) {
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
