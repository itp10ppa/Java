import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n-- Выбор задания --");
        System.out.println(" 1 - Задание 1.1");
        System.out.println(" 2 - Задание 1.2");
        System.out.println(" 3 - Задание 2.3");
        System.out.println(" 4 - Задание 3.1");
        System.out.println(" 5 - Задание 3.2");
        System.out.println(" 6 - Задание 3.3");
        System.out.println(" 7 - Задание 3.4");
        System.out.println("-------");
        System.out.print("Введите номер: ");

        int choice = sc.nextInt();
        sc.nextLine(); // очистка буфера после nextInt()
        System.out.println();

        switch (choice) {
            case 1 -> task11();
            case 2 -> task12();
            case 3 -> task23();
            case 4 -> task31();
            case 5 -> task32();
            case 6 -> task33();
            case 7 -> task34();
            default -> System.out.println("Нет такого задания");
        }
        sc.close();
    }

    static void task11() {
        Box<Integer> box = new Box<>();
        System.out.println("\nКоробка пуста? - " + box.isEmpty() + "\n");

        box.setItem(3);
        System.out.println(box);
        System.out.println("Коробка пуста? - " + box.isEmpty() + "\n");

        // box.setItem(5);
        method11(box);
        System.out.println(box);
        System.out.println("Коробка пуста? - " + box.isEmpty() + "\n");
    }
    
    static <T> void method11(Box<T> box) {
        System.out.println("Извлекаем объект из коробки: " + box.getItem());
    }



    static void task12() {
        Storage<Integer> storage1 = new Storage<>(null, 0);
        System.out.println(storage1);
        method12(storage1);

        Storage<Integer> storage2 = new Storage<>(99, -1);
        System.out.println(storage2);
        method12(storage2);

        Storage<String> storage3 = new Storage<>(null, "default");
        System.out.println(storage3);
        method12(storage3);

        Storage<String> storage4 = new Storage<>("hello", "hello world");
        System.out.println(storage4);
        method12(storage4);
    }

    static <T> void method12(Storage<T> storage) {
        System.out.println("Извлекаем объект из хранилища: " + storage.getValue());
    }



    static void task23() {
        Box<Point3D> box1 = new Box<>();
        System.out.println(box1);
        method23(box1);

        Box<Point> box2 = new Box<>();
        System.out.println(box2);
        method23(box2);
    }

    static void method23(Box<? super Point3D> box) {
        Point3D point = new Point3D(1, 2, 3);
        box.setItem(point);
        System.out.println("Извлекаем объект из коробки: " + box.getItem());
    }



    static void task31() {
        List<String> strList = createStrList();
        List<Integer> intList = createIntList();
        List<int[]> arrList = createArrList();

        Function<String, Integer> func1 = new StringLength();
        Function<Integer, Integer> func2 = new AbsNumbers();
        Function<int[], Integer> func3 = new MaxArray();

        List<Integer> result1 = apply(strList, func1);
        List<Integer> result2 = apply(intList, func2);
        List<Integer> result3 = apply(arrList, func3);

        System.out.println("Длины строк: " + result1);
        System.out.println("Положительные числа: " + result2);
        System.out.println("Максимумы массивов: " + result3);
    }

    static <T, P> List<P> apply(List<T> strList, Function<T, P> func) {
        List<P> list = new ArrayList<>();

        for (T l : strList) {
            list.add(func.apply(l));
        }
        return list;
    }



    static void task32() {
        List<String> strList = createStrList();
        List<Integer> intList = createIntList();
        List<int[]> arrList = createArrList();

        Function2<String> func1 = new LengthFilter();
        Function2<Integer> func2 = new PositiveFilter();
        Function2<int[]> func3 = new NegativeFilter();

        List<String> result1 = test(strList, func1);
        List<Integer> result2 = test(intList, func2);
        List<int[]> result3 = test(arrList, func3);

        System.out.println("Строки не короче трех символов: " + result1);
        System.out.println("Положительные числа: " + result2);
        System.out.print("Отрицательные массивы: ");
        for (int[] r : result3) {
            System.out.println(Arrays.toString(r));
        }
    }

    static <T> List<T> test(List<T> strList, Function2<T> func) {
        List<T> list = new ArrayList<>();

        for (T l : strList) {
            if (func.test(l)) {
                list.add(l);
            }
        }
        return list;
    }



    static void task33() {
        List<String> strList = createStrList();
        List<Integer> intList = createIntList();
        List<List<Integer>> listsList = List.of(List.of(1,2,3), List.of(4,5), List.of(6,7,8,9));
        List<Integer> sizes = apply(listsList, new ListLength());

        Combiner<String> func1 = new StringConcat();
        Combiner<Integer> func2 = new IntegerSum();
        Combiner<Integer> func3 = new IntegerSum();

        String result1 = reduce(strList, "", func1);
        Integer result2 = reduce(intList, 0, func2);
        Integer result3 = reduce(sizes, 0, func3);

        System.out.println("Общая строка: " + result1);
        System.out.println("Общая сумма: " + result2);
        System.out.println("Общее кол-во элементов в списках: " + result3);
    }

    static <T> T reduce(List<T> list, T initial, Combiner<T> comb) {
        T result = initial;

        for (T l : list) {
            result = comb.combine(result, l);
        }
        return result;
    }



    static void task34() {
        List<Integer> intList = createIntList();
        List<String> strList1 = List.of("qwerty", "asdfg", "zx", "qw");
        List<String> strList2 = List.of("qwerty", "asdfg", "qwerty", "qw");

        ResultFactory<List<List<Integer>>> f1 = new Factory1();
        ResultWriter<List<List<Integer>>, Integer> w1 = new Writer1();
        List<List<Integer>> result1 = collectValues(intList, f1, w1);
        System.out.println(result1);

        ResultFactory<Map<Integer, List<String>>> f2 = new Factory2();
        ResultWriter<Map<Integer, List<String>>, String> w2 = new Writer2();
        Map<Integer, List<String>> result2 = collectValues(strList1, f2, w2);
        System.out.println(result2);

        ResultFactory<Set<String>> f3 = new Factory3();
        ResultWriter<Set<String>, String> w3 = new Writer3();
        Set<String> result3 = collectValues(strList2, f3, w3);
        System.out.println(result3);
    }

    public static <T, R> R collectValues(
            List<T> source,
            ResultFactory<R> factory,
            ResultWriter<R, T> writer
    ) {
        R result = factory.create();
        for (T s : source) {
            writer.add(result, s);
        }
        return result;
    }


    static List<String> createStrList() {
        return List.of("qwerty", "asdfg", "zx");
    }

    static List<Integer> createIntList() {
        return List.of(1, -3, 7);
    }

    static List<int[]> createArrList() {
        return List.of(new int[]{2, 7, -1}, new int[]{-2, -7, 1}, new int[]{-2, -7, -1});
    }
}
