import java.util.Arrays;

class Path {

    public City destination;
    public int price;

    public Path(City destination, int price) {
        this.destination = destination;
        this.price = price;
    }

    @Override
    public String toString() {
        return destination.name + ":" + price;
    }
}


public class City {

    public String name;
    public Path[] path;

    public City(String name) {
        this(name, new Path[0]);
    }

    public City(String name, Path[] path) {
        this.name = name;
        this.path = path;
    }

    @Override
    public String toString() {
        return name + " - " + Arrays.toString(path);
    }
}
