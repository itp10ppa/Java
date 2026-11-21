package Cat;

import java.util.Collections;

public class Cat implements Meowable {
    private final String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void meow() {
        System.out.println(name + ": мяу!");
    }

    public void meow(int n) {
        String meows = String.join("-", Collections.nCopies(n, "мяу"));
        System.out.println(name + ": " + meows + "!");
    }

    @Override
    public String toString() {
        return "Кот: " + name;
    }
}
