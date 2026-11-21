package Cat;

public class Robocat implements Meowable {
    private final String model;

    public Robocat(String model) {
        this.model = model;
    }

    @Override
    public void meow() {
        System.out.println(model + ": бип-мяу!");
    }
}
