import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //First task
        /*
        Создайте массив из 12 случайных целых чисел из отрезка [-15;15].
        Определите какой элемент является в этом массиве максимальным и сообщите
        индекс его последнего вхождения в массив.
        */

        System.out.println("Задание 1:");

        int[] arr1 = createRandomArray(12, -15, 15);
        System.out.println("Массив: " + Arrays.toString(arr1));

        int[] arrS = new int[12];
        System.arraycopy(arr1, 0, arrS, 0, 12);
        Arrays.sort(arrS);

        int toFind = arrS[arrS.length - 1];

        int pos = find(toFind, arr1);

        if (pos == -1)
            System.out.println("Error");
        else
            System.out.println("Позиция наибольшего числа в массиве: " + (pos + 1) + "\nСамо число: " + arr1[pos]);

        System.out.println(System.lineSeparator());

        //Second task
        /*
        Создайте массив из 11 случайных чисел из промежутка [0;1].
        Выведите данный массив в консоль. Напишите программу, которая определяет,
        какой элемент встречается в массиве чаще всего. Выведите данную информацию в консоль.
        Если два разных элемента встречаются одинаковое количество раз, то выведите -1.
        */

        System.out.println("Задание 2:");

        int[] arr2 = createRandomArray(11, 0, 1);
        System.out.println("Массив: " + Arrays.toString(arr2));

        int count0 = 0;
        int count1 = 0;

        for (int i : arr2) {
            if (i == 0)
                count0++;
            if (i == 1)
                count1++;
        }

        if (count0 > count1)
            System.out.println("Элемент '0' встречается чаще");
        else if (count1 > count0)
            System.out.println("Элемент '1' встречается чаще");
        else
            System.out.println("-1");

        System.out.println(System.lineSeparator());

        //Third task
        /*
        Напишите программу, которая генерирует
        двумерный массив из 8 строк по 5 столбцов в каждой из случайных целых чисел
        из отрезка [10;99]. Результат программы выведите в консоль.
        */

        System.out.println("Задание 3:");

        int[][] matrix3 = new int[8][];
        for (int i = 0; i < matrix3.length; i++) {
            matrix3[i] = createRandomArray(5, 10, 99);
        }
        for (int[] line : matrix3) {
            System.out.println(Arrays.toString(line));
        }

        System.out.println(System.lineSeparator());

        //Fourth task
        /*
       Напишите программу, которая генерирует двумерный массив из 5 строк по 8 столбцов
       в каждой из случайных целых чисел из отрезка [-99;99].
       Результат программы выведите в консоль. Отдельно выведите значение максимального элемента этого массива.
        */

        System.out.println("Задание 5:");

        int[][] matrix4 = new int[5][];
        for (int i = 0; i < matrix4.length; i++) {
            matrix4[i] = createRandomArray(8, -99, 99);
        }

        printIntMatrix(matrix4);

        int maxValue = matrix4[0][0];

        for (int[] i : matrix4)
            for (int j : i) {
                maxValue = Math.max(maxValue, j);
            }

        System.out.println("Максимальное значение в массиве:" + maxValue);


        System.out.println(System.lineSeparator());

        //Fifth task
        /*
       Напишите программу, которая генерирует массив из 7 строк по 4 столбца в каждой
       из случайных целых чисел из отрезка [-5;5]. Результат программы выведите в консоль.
       Отдельно выведите индекс строки с наибольшим произведением элементов.
        */

        System.out.println("Задание 5:");

        int[][] matrix5 = new int[7][];

        for (int i = 0; i < matrix5.length; i++) {
            matrix5[i] = createRandomArray(4, -5, 5);
        }

        printIntMatrix(matrix5);


        int matrixLineMax = Integer.MIN_VALUE;
        int maxLineIndex = 0;

        for (int i = 0; i < matrix5.length; i++) {
            if (matrixLineSum(matrix5[i]) > matrixLineMax) {
                matrixLineMax = matrixLineSum(matrix5[i]);
                maxLineIndex = i;
            }
            // System.out.println(matrixLineSum(matrix5[i]) + " " + (matrixLineMax) + " " + (maxLineIndex));
        }

        System.out.println("Индекс макс по произведению строки: " + maxLineIndex);
        System.out.println(System.lineSeparator());

        //Sixth task
        /*
        Напишите программу, которая генерирует двумерный массив из 6 строк по 7 столбцов в каждой.
        Массив должен состоять из случайных целых чисел из промежутка [0;9].
        Результат программы выведите в консоль.
        Преобразуйте массив таким образом, чтобы на первом месте (индекс 0)
        в каждой строке стоял самое большое число в строке. Состав массива изменять нельзя,
        но можно  переставлять элементы в рамках одной строки.
        Порядок остальных элементов строки не важен. Результат преобразований выведите в консоль.
        */


        System.out.println("Задание 6:");

        int[][] matrix6 = new int[6][];

        for (int i = 0; i < matrix6.length; i++) {
            matrix6[i] = createRandomArray(7, 0, 9);
        }

        printIntMatrix(matrix6);

        System.out.println(System.lineSeparator());


        for (int[] i : matrix6)
        {
            Arrays.sort(i);
            reverseArray(i);
        }

        printIntMatrix(matrix6);


    }

    public static int[] createRandomArray(int n, int min, int max) {
        Random rd = new Random();
        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt(max - min + 1) + min;
            // System.out.print(array[i] +" ");
        }
        return array;
    }

    public static int find(int i, int[] Array) {
        int result = 0;
        for (int n : Array) {
            if (n == i)
                return result;
            result++;
        }
        return -1;
    }

    public static void printIntMatrix(int[][] matrix) {
        for (int[] line : matrix) {
            System.out.println(Arrays.toString(line));
        }
    }

    public static int matrixLineSum(int[] line) {
        int sum = 1;
        for (int i : line) {
            sum *= i;
        }

        return sum;
    }

    public static void reverseArray(int[] array) {

        int tmp;

        for (int i = 0; i < array.length / 2; i++) {
            tmp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = tmp;
        }
    }
}

