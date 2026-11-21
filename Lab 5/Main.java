import Fraction.Fraction;
import Fraction.CachedFraction;
import Cat.Cat;
import Cat.Meowable;
import Cat.Robocat;
import Cat.CountingCat;
import Point.Point;
import Point.Polyline;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n-- Выбор задания --");
        System.out.println(" 1 - Задание 1.1");
        System.out.println(" 2 - Задание 2.1");
        System.out.println(" 3 - Задание 3.9");
        System.out.println(" 4 - Задание 4.4");
        System.out.println(" 5 - Задание 5.5");
        System.out.println(" 6 - Задание 6.1");
        System.out.println(" 7 - Задание 7.1");
        System.out.println(" 8 - Задание 7.2");
        System.out.println("-------");
        System.out.print("Введите номер: ");

        int choice = sc.nextInt();
        sc.nextLine(); // очистка буфера после nextInt()
        System.out.println();

        switch (choice) {
            case 1 -> task11();
            case 2 -> task21();
            case 3 -> task39();
            case 4 -> task44();
            case 5 -> task55();
            case 6 -> task61();
            case 7 -> task71();
            case 8 -> task72();
            default -> System.out.println("Нет такого задания");
        }
        sc.close();
    }

    public static void task11() {
        Fraction fr1 = new Fraction(1, -3);
        Fraction fr2 = new Fraction(-2, -5);
        System.out.println(fr1);
        System.out.println(fr2);

        CachedFraction cf = new CachedFraction(3, 4);
        System.out.println(cf.getValue());
        System.out.println(cf.getValue());
        cf.setNumerator(1);
        cf.setDenominator(2);
        System.out.println(cf.getValue());
    }

    public static void task21() {
        Cat cat = new Cat("Барсик");
        System.out.println(cat);
        cat.meow();
        cat.meow(3);

        Cat c = new Cat("Фитцджеральд");
        Robocat rc = new Robocat("Felix2000");
        meowAll(List.of(cat, c, rc));

        CountingCat countingCat = new CountingCat(cat);
        meowAll(List.of(countingCat, countingCat, countingCat, countingCat, countingCat));
        System.out.println("Кот мяукал " + countingCat.getMeowCount() + " раз");
    }

    public static void meowAll(List<Meowable> meowables) {
        for (Meowable m : meowables) {
            m.meow();
        }
    }

    public static void task39() {
        List<String> l1 = new ArrayList<>(List.of("яблоко", "банан", "апельсин"));
        List<String> l2 = new ArrayList<>(List.of("банан", "киви", "апельсин", "груша"));
        List<String> result = new ArrayList<>();

        for (String item : l1) {
            if (!l2.contains(item) && !result.contains(item)) {
                result.add(item);
            }
        }
        for (String item : l2) {
            if (!l1.contains(item) && !result.contains(item)) {
                result.add(item);
            }
        }
        System.out.println("Список L1: " + l1);
        System.out.println("Список L2: " + l2);
        System.out.println("Результат: " + result);
    }

    public static void task44() {
        Path path = Path.of("data.txt");
        Map<String, int[]> students = new HashMap<>();

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String n = reader.readLine();
            if (n == null) {
                System.out.println("Файл пуст");
                return;
            }
            int count = Integer.parseInt(n.trim());

            for (int i = 0; i < count; i++) {
                String line = reader.readLine();
                String[] parts = line.split("\\s+");

                String fullName = parts[0] + " " + parts[1];
                int p1 = Integer.parseInt(parts[2]);
                int p2 = Integer.parseInt(parts[3]);
                students.put(fullName, new int[]{p1, p2});
            }
        }
        catch (IOException e) {
            System.out.println("Не удалось прочитать файл");
        }

        System.out.println("Не допущены к экзаменам:");
        for (Map.Entry<String, int[]> entry : students.entrySet()) {
            String name = entry.getKey();
            int[] scores = entry.getValue();

            if (scores[0] < 30 || scores[1] < 30) {
                System.out.println(name);
            }
        }
    }

    public static void task55() {
        String text = "без нулей нет единиц, а без единиц нет нулей".toLowerCase();
        String[] words = text.split("[^а-яё]+");
        Set<Character> voicedConsonants = Set.of('б', 'в', 'г', 'д', 'ж', 'з', 'й', 'л', 'м', 'н', 'р');

        Set<Character> seenLetters = new HashSet<>();
        Set<Character> result = new TreeSet<>();

        for (String word : words) {
            if (word.isEmpty()) continue;

            // множество уникальных букв текущего слова
            Set<Character> wordLetters = new HashSet<>();
            for (char c : word.toCharArray()) {
                wordLetters.add(c);
            }

            // проверяем эти уникальные буквы
            for (char c : wordLetters) {
                if (voicedConsonants.contains(c)) {
                    if (seenLetters.contains(c)) {
                        result.add(c);
                    }
                    else {
                        seenLetters.add(c);
                    }
                }
            }
        }
        System.out.println("Звонкие согласные более чем в одном слове: " + result);
    }

    public static void task61() {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");
        System.out.println("Исходная очередь: " + queue);

        List<String> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }

        System.out.print("Элементы в обратном порядке: ");
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }

    public static void task71() {
        List<Point> points = List.of(
                new Point(3, -4),
                new Point(1, 2),
                new Point(3, -4),
                new Point(2, -5),
                new Point(1, 2)
        );
        Polyline polyline = points.stream()
                .distinct()
                .map(p -> p.positiveY())
                .sorted((p1, p2) -> Integer.compare(p1.getX(), p2.getX()))
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> new Polyline(list)
                ));
        System.out.println(polyline);
    }

    public static void task72() {
        try (Stream<String> lines = Files.lines(Path.of("data2.txt"))) {
            Map<Integer, List<String>> result = lines
                    .filter(line -> line.contains(":"))
                    .map(line -> {
                        String parts[] = line.split(":");
                        String name = parts[0].trim();
                        int number = Integer.parseInt(parts[1].trim());

                        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
                        return Map.entry(name, number);
                    })
                    .collect(Collectors.groupingBy(
                            entry -> entry.getValue(),
                            Collectors.mapping(entry -> entry.getKey(), Collectors.toList())
                    ));
            System.out.println(result);
        }
        catch (IOException e) {
            System.out.println("Не удалось прочитать файл");
        }
    }
}
