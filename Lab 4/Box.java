public class Box<T> {

    private T item;

    public T getItem() {
        T savedItem = item;
        item = null;
        return savedItem;
    }

    public void setItem(T item) {
        if (isEmpty()) {
            this.item = item;
        }
        else {
            throw new IllegalArgumentException("Ошибка: коробка не пуста!");
        }
    }

    @Override
    public String toString() {
        return "\nСодержимое коробки: " + item;
    }

    public boolean isEmpty() {
        return this.item == null;
    }
}
