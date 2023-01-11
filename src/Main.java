import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args)
    {
    //First task
        /*
        Создайте массив из 12 случайных целых чисел из отрезка [-15;15].
        Определите какой элемент является в этом массиве максимальным и сообщите
        индекс его последнего вхождения в массив.
        */

        System.out.println("Задание 1:");

        int [] arr1 = createRandom(12,-15,15);
        System.out.println("Массив: " + Arrays.toString(arr1));

        int [] arrS = new int[12];
        System.arraycopy(arr1, 0, arrS, 0, 12);
        Arrays.sort(arrS);

        int toFind = arrS[arrS.length-1];

        int pos = find(toFind,arr1);

        if (pos==-1)
            System.out.println("Error");
        else
            System.out.println("Позиция наибольшего числа в массиве: " + (pos+1) + "\nСамо число: " + arr1[pos]);

        System.out.println(System.lineSeparator());



    }

    public static int[] createRandom(int n, int min, int max)
    {
        Random rd = new Random();
        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt(max - min + 1) + min;
            // System.out.print(array[i] +" ");
        }
        return array;
    }

    public static int find(int i, int [] Array)
    {
        int c = 0;
        for (int n : Array)
        {
            if (n == i)
                return c;
            c++;
        }
        return -1;
    }
}