import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int result1 = sumLastNums(257);
        boolean result2 = isPositive(-8);
        boolean result3 = isUpperCase('w');
        boolean result4 = isDivisor(40, 8);

        int result5 = 5;
        result5 = lastNumSum(result5, 53);
        result5 = lastNumSum(result5, 90);
        result5 = lastNumSum(result5, 51);
        result5 = lastNumSum(result5, 74);

        // 2. Условия
        double result6 = safeDiv(5, 2);
        String result7 = makeDecision(5, 7);
        boolean result8 = sum3(2, 8, 6);
        String result9 = age(21);
        //printDays("среда");

        // 3. Циклы
        String result11 = reverseListNums(5);
        int result12 = pow(2, 4);
        boolean result13 = equalNum(2222);
        //leftTriangle(5);
        //guessGame();

        // 4. Массивы
        int result16 = findLast(new int[]{1, 2, 1, 1, 7}, 0);
        int[] result17 = add(new int[]{1, 2, 3, 4}, 0, 2);
        //reverse(new int[]{1, 2, 3, 4, 5});
        int[] result19 = concat(new int[]{1, 2, 3}, new int[]{5, 6, 7});
        int[] result20 = deleteNegative(new int[]{1, -2, 3, -4, 5});

        //System.out.println("\nРезультат: " + result16);
        System.out.println("\nРезультат: " + Arrays.toString(result20));
    }

// Задание 1. Методы

    public static int sumLastNums(int x) {
        int x1 = x % 10;
        int x2 = x / 10 % 10;
        return x1 + x2;
    }

    public static boolean isPositive(int x) {
        return x > 0;
    }

    public static boolean isUpperCase(char x) {
        return x >= 'A' && x <= 'Z';
    }

    public static boolean isDivisor(int a, int b) {
        return a % b == 0 || b % a == 0;
    }

    public static int lastNumSum(int a, int b) {
        return a % 10 + b % 10;
    }

    // Задание 2. Условия

    public static double safeDiv(int x, int y) {
        if (y == 0) {
            return 0;
        }
        return (double) x / y;
    }

    public static String makeDecision(int x, int y) {
        if (x < y) {
            return x + " < " + y;
        } else if (x > y) {
            return x + " > " + y;
        } else {
            return x + " == " + y;
        }
    }

    public static boolean sum3(int x, int y, int z) {
        return x + y == z || x + z == y || y + z == x;
    }

    public static String age(int x) {
        if (x % 10 == 1 && x != 11) {
            return x + " год";
        } else if ((x % 10 == 2 || x % 10 == 3 || x % 10 == 4) && x != 12 && x != 13 && x != 14) {
            return x + " года";
        } else {
            return x + " лет";
        }
    }

    public static void printDays(String x) {
        switch (x) {
            case "понедельник":
                System.out.println("понедельник");
            case "вторник":
                System.out.println("вторник");
            case "среда":
                System.out.println("среда");
            case "четверг":
                System.out.println("четверг");
            case "пятница":
                System.out.println("пятница");
            case "суббота":
                System.out.println("суббота");
            case "воскресенье":
                System.out.println("воскресенье");
                break;
            default:
                System.out.println("это не день недели");
        }
    }

    // Задание 3. Циклы

    public static String reverseListNums(int x) {
        String res = "";
        if (x > 0) {
            while (x != -1) {
                res += x + " ";
                x--;
            }
        } else {
            while (x != 1) {
                res += x + " ";
                x++;
            }
        }
        return res;
    }

    public static int pow(int x, int y) {
        int result = 1;
        while (y != 0) {
            result *= x;
            y--;
        }
        return result;
    }

    public static boolean equalNum(int x) {
        int lastNum = x % 10;
        x = x / 10;

        while (x != 0) {
            if (x % 10 != lastNum) {
                return false;
            }
            x = x / 10;
        }
        return true;
    }

    public static void leftTriangle(int x) {
        for (int i = 0; i != x; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    public static void guessGame() {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        int secretNum = (int) (Math.random() * 10);
        System.out.print("Введите число от 0 до 9: ");

        while (true) {
            int userNum = scanner.nextInt();
            attempts++;

            if (userNum == secretNum) {
                System.out.println("Вы угадали!");
                System.out.println("Количество попыток: " + attempts);
                break;
            }
            System.out.print("Вы не угадали, введите число от 0 до 9: ");
        }
    }

    // Задание 4. Массивы

    public static int findLast(int[] arr, int x) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                index = i;
            }
        }
        return index;
    }

    public static int[] add(int[] arr, int x, int pos) {
        int[] newArr = new int[arr.length + 1];

        for (int i = 0; i < pos; i++) {
            newArr[i] = arr[i];
        }
        newArr[pos] = x;

        for (int i = pos; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }
        return newArr;
    }

    public static void reverse(int[] arr) {
        int archieve = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            archieve = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = arr[i];
            arr[i] = archieve;
        }
        System.out.println("Перевернутый массив: " + Arrays.toString(arr));
    }

    public static int[] concat(int[] arr1, int[] arr2) {
        int[] newArr = new int[arr1.length + arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            newArr[i] = arr1[i];
        }
        for (int i = arr1.length; i < arr1.length + arr2.length; i++) {
            newArr[i] = arr2[i - arr1.length];
        }
        return newArr;
    }

    public static int[] deleteNegative(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                count++;
            }
        }
        int[] newArr = new int[count];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                newArr[index] = arr[i];
                index++;
            }
        }
        return newArr;
    }
}
