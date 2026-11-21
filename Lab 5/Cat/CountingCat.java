package Cat;

public class CountingCat implements Meowable {
    private final Meowable delegate;
    private int meowCount = 0;

    public CountingCat(Meowable delegate) {
        this.delegate = delegate;
    }

    @Override
    public void meow() {
        meowCount++;
        delegate.meow();
    }

    public int getMeowCount() {
        return meowCount;
    }
}
