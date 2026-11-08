public class Storage<T> {

    private final T value;
    private final T altValue;

    public Storage(T value, T altValue) {
        this.value = value;
        this.altValue = altValue;
    }

    public T getValue() {
        if (value == null) {
            return altValue;
        }
        return value;
    }

    @Override
    public String toString() {
        return "\nStorage{ " +
                "value = " + value +
                ", altValue = " + altValue +
                " }";
    }
}

