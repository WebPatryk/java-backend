package test;

public class Exercise {

    public static int searchIndex(int[] array, int value) {
        int index = 0;
        int limit = array.length - 1;
        while (index <= limit) {
            double point = Math.ceil((index + limit) / 2);
            double entry = array[(int) point];

            if (value > entry) {
                index = (int) (point + 1);
                continue;
            }
            if (value < entry) {
                limit = (int) (point - 1);
                continue;
            }
            return (int)point;
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arrayOfNumbers = {4, 5, 7, 11, 12, 15, 15, 21, 40, 45};
        int index = searchIndex(arrayOfNumbers, 11);

        System.out.println(index);
    }
    }

