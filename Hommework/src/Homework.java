public class Homework {

    public static void printThreeWords() {
        System.out.println("Задание 1:\nOrange\nBanana\nApple\n");
    }

    public static void checkSumSign(int a, int b) {
        System.out.print("Задание 2: ");
        int sum = a + b;
        String result = sum >= 0 ? "Сумма положительная" : "Сумма отрицательная";
        System.out.println(result + "\n");
    }

    public static void printColor(int value) {
        System.out.print("Задание 3: ");
        if (value <= 0) {
            System.out.println("Красный\n");
        } else if (value <= 100) {
            System.out.println("Жёлтый\n");
        } else {
            System.out.println("Зелёный\n");
        }
    }

    public static void compareNumbers(int a, int b) {
        System.out.print("Задание 4: ");
        String result = a >= b ? "a >= b" : "a < b";
        System.out.println(result + "\n");
    }

    public static void resultat(int a, int b) {
        System.out.print("Задание 5: ");
        boolean result = a + b >= 10 && a + b <= 20;
        System.out.println(result + "\n");
    }

    public static void nature(int a) {
        System.out.print("Задание 6: ");
        String result = a >= 0 ? "Число " + a + " положительное" : "Число " + a + " отрицательное";
        System.out.println(result + "\n");

    }

    public static void beneficial(int a) {
        System.out.print("Задание 7: ");
        boolean res1 = a <= 0;
        System.out.println(res1 + "\n");
    }

    public static void bass(String str, int num) {
        System.out.println("Задание 8: ");
        for (int i = 0; i < num; i++) {
            System.out.println(str);
        }
    }

    public static void leapYear(int year) {
        System.out.println("\nЗадание 9: ");
        boolean result = (year % 4 == 0 || year % 100 == 0);
        System.out.println(result);

    }

    public static void metMassed() {
        System.out.println("\nЗадание 10: ");
        int[] arr = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else if (arr[i] == 0) {
                arr[i] = 1;
            }
            System.out.print(arr[i] + "\n");
        }
    }

    public static void massiveMethod() {
        System.out.println("Задание 11: ");
        int[] array = new int[101];
        for (int i = 1; i < array.length; i++) {
            System.out.print((array[i] = i) + " \n");
        }
    }

    public static void bigMethod() {
        System.out.println("Задание 12: ");
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
            System.out.println(arr[i]);
        }
    }

    public static void cubeMass() {
        System.out.println("Задание 13: ");
        int[][] arr = new int[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0, x = arr[i].length - 1; j < arr[i].length; j++, x--) {
                if (i == j || i == x) arr[i][j] = 1;
                else arr[i][j] = 0;
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.println("От такие пироги :) ");
    }

    public static int[] createArray(int len, int initialValue) {
        System.out.println("Задание 14: ");
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        for (int num : array) {
            System.out.print(num + " ");
        }
        return array;
    }
}


