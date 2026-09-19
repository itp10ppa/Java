public class Main {

    public static void main(String[] args) {
        System.out.println("\nЗадание № 1.1");
        Point point1 = new Point(1, 3);
        Point point2 = new Point(23, 8);
        Point point3 = new Point(5, 10);
        Point point4 = new Point(25, 10);

        System.out.println(point1);
        System.out.println(point2);
        System.out.println(point3);
        System.out.println(point4);


        System.out.println("\nЗадание № 1.3");
        Name name1 = new Name("Клеопатра");
        Name name2 = new Name("Пушкин", "Александр", "Сергеевич");
        Name name3 = new Name("Маяковский", "Владимир");

        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);


        System.out.println("\nЗадание № 2.1");
        Line line1 = new Line(point1, point2);
        Line line2 = new Line(point3, point4);
        Line line3 = new Line(point1, point4);

        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);


        System.out.println("\nЗадание № 3.3");
        City a = new City("A");
        City b = new City("B");
        City c = new City("C");
        City d = new City("D");
        City e = new City("E");
        City f = new City("F");

        a.path = new Path[] {new Path(b, 5), new Path(d, 6), new Path(f, 1)};
        b.path = new Path[] {new Path(a, 5), new Path(c, 3)};
        c.path = new Path[] {new Path(b, 3), new Path(d, 4)};
        d.path = new Path[] {new Path(a, 6), new Path(c, 4), new Path(e, 2)};
        e.path = new Path[] {new Path(f, 2)};
        f.path = new Path[] {new Path(b, 1), new Path(e, 2)};

        City[] city = {a, b, c, d, e, f};
        for (int i = 0; i < city.length; i++) {
            System.out.println(city[i]);
        }


        System.out.println("\nЗадание № 4.8");
        City g = new City("G");
        System.out.println(g);

        City h = new City("H", new Path[]{new Path(g, 5), new Path(c, 3)});
        System.out.println(h);


        System.out.println("\nЗадание № 5.5");
        Fraction fr1 = new Fraction(1, 3);
        Fraction fr2 = new Fraction(2, 5);
        Fraction fr3 = new Fraction(1, 4);

        System.out.println(fr1);
        System.out.println(fr2);
        System.out.println(fr3);

        System.out.println(fr1 + " + " + fr3 + " = " + fr1.plus(fr2));
        System.out.println(fr2 + " - " + fr3 + " = " + fr2.minus(fr3));
        System.out.println(fr1 + " * " + fr2 + " = " + fr1.mul(fr2));
        System.out.println(fr1 + " / " + fr3 + " = " + fr1.div(fr3));

        Fraction res = fr1.plus(fr2).div(fr3).minus(5);
        System.out.println("fr1.plus(fr2).div(fr3).minus(5) = " + res);
    }
}

