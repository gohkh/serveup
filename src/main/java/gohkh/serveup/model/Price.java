package gohkh.serveup.model;

public class Price {
    private final double value;

    public Price(double value) {
        this.value = value;
    }

    @Override
    public final boolean equals(Object obj) {
        if (!(obj instanceof Price)) {
            return false;
        }

        Price price = (Price) obj;
        return value == price.value;
    }

    @Override
    public final int hashCode() {
        return Double.hashCode(value);
    }

    @Override
    public String toString() {
        return String.format("$%s", value);
    }
}
