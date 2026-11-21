import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n-- Выбор задания --");
        System.out.println(" 1 - Задание 1.1");
        System.out.println(" 2 - Задание 1.2");
        System.out.println(" 3 - Задание 1.3");
        System.out.println(" 4 - Задание 1.4");
        System.out.println(" 5 - Задание 1.5");
        System.out.println(" 6 - Задание 1.6");
        System.out.println("-------");
        System.out.print("Введите номер: ");

        int choice = sc.nextInt();
        sc.nextLine(); // очистка буфера после nextInt()
        System.out.println();

        Example example = new Example(8, 123);
        Class<?> clazz = example.getClass();

        switch (choice) {
            case 1 -> task11(clazz, example);
            case 2 -> task12(clazz);
            case 3 -> System.out.println(task13(clazz, example));
            case 4 -> task14(clazz);
            case 5 -> task15(clazz);
            case 6 -> System.out.println(Arrays.toString(task16(clazz)));
            default -> System.out.println("Нет такого задания");
        }
        sc.close();
    }

    public static void task11(Class<?> clazz, Example example) throws Exception {
        System.out.println("\n--- @Invoke ---");
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Invoke.class)) {
                System.out.println("Найден метод: " + method.getName());
                method.invoke(example);
            }
        }
    }

    public static void task12(Class<?> clazz) throws NoSuchFieldException {
        System.out.println("\n--- @Default ---");

        if (clazz.isAnnotationPresent(Default.class)) {
            Default annotation = clazz.getAnnotation(Default.class);
            Class<?> defaultClass = annotation.value();
            System.out.println("Аннотация найдена на классе: " + clazz.getSimpleName());
            System.out.println("Класс по умолчанию: " + defaultClass.getSimpleName());
        }

        Field field = clazz.getDeclaredField("value");
        if (field.isAnnotationPresent(Default.class)) {
            Default fieldAnn = field.getAnnotation(Default.class);
            System.out.println("Тип по умолчанию для поля value: " + fieldAnn.value().getSimpleName());
        }
    }

    public static String task13(Class<?> clazz, Example example) throws IllegalAccessException {
        System.out.println("\n--- @ToString ---");
        StringBuilder sb = new StringBuilder(clazz.getSimpleName() + "{");
        boolean first = true;

        for (Field field : clazz.getDeclaredFields()) {
            boolean include = true;

            if (field.isAnnotationPresent(ToString.class)) {
                ToString ann = field.getAnnotation(ToString.class);
                if (ann.value() == Mode.NO) {
                    include = false;
                }
            }

            if (include) {
                field.setAccessible(true); // открываем доступ, т.к. поля могут быть private
                Object value = field.get(example);

                if (!first) sb.append(", ");
                sb.append(field.getName()).append("=").append(value);
                first = false;
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static void task14(Class<?> clazz) {
        System.out.println("\n--- @Validate ---");
        validate(clazz);
        validate(Invoke.class);
        validate(Default.class);
    }

    public static void validate(Class<?> clazz) {
        if (clazz.isAnnotationPresent(Validate.class)) {
            Validate validateAnn = clazz.getAnnotation(Validate.class);
            Class<?>[] classesToValidate = validateAnn.value();

            System.out.println(clazz.getSimpleName() + " требует проверки типов:");
            for (Class<?> c : classesToValidate) {
                System.out.println(" - " + c.getSimpleName());
            }
        }
        else System.out.println("Аннотация @Validate не найдена на " + clazz);
    }

    public static void task15(Class<?> clazz) {
        System.out.println("\n--- @Two ---");

        if (clazz.isAnnotationPresent(Two.class)) {
            Two twoAnn = clazz.getAnnotation(Two.class);
            String firstValue = twoAnn.first();
            int secondValue = twoAnn.second();

            System.out.println("Класс: " + clazz.getSimpleName());
            System.out.println("Значение first: " + firstValue);
            System.out.println("Значение second: " + secondValue);
        }
        else System.out.println("Аннотация @Two не найдена.");
    }

    public static String[] task16(Class<?> clazz) {
        System.out.println("\n--- @Cache ---");

        if (clazz.isAnnotationPresent(Cache.class)) {
            Cache cacheAnn = clazz.getAnnotation(Cache.class);
            String[] areas = cacheAnn.value();

            if (areas.length == 0) {
                System.out.println("Список кешируемых областей пуст.");
            }
            else {
                System.out.println("Кешируемые области для класса " + clazz.getSimpleName() + ":");
                for (String area : areas) {
                    System.out.println(" - " + area);
                }
            }
            return areas;
        }
        else System.out.println("Аннотация @Cache не найдена.");
        return new String[0];
    }
}
