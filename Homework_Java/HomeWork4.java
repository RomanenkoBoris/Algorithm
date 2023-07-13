import java.util.Arrays;

public class HomeWork4 {
    public static void main(String[] args) {

        //    System.out.println(Arrays.toString(fibonacciRecursion1(5)));

        hanoiTowerIterative(4);
        hanoiTowerRecursive(4);


        System.out.println(fibonacci(8));

    }

    public static int[] fibonacciRecursion1(int n) {
        int[] result = new int[n];
        if (n <= 2) {
            result[0] = 0;
            result[1] = 1;
        }
        result[n] = result[n - 1] + result[n - 2];
        fibonacciRecursion1(n - 1);
        return result;
    }
    private static int[] fibonacciRecursion(int n) {
        if (n == 2) { // base case
            return new int[]{0, 1};
        }
        if (n == 1) {
            return new int[]{0};
        }
        int[] result = fibonacciRecursion(n - 1);      // recursive case
        //System.out.println(Arrays.toString(result));
        result = Arrays.copyOf(result, n);             // increase the array size
        result[n - 1] = result[n - 2] + result[n - 3]; // sum of 2 previous elements
        return result;
    }

    public static int fibonacci (int n){
        if (n <= 1){
            return n;
        }
        return (fibonacci(n-1)+fibonacci(n-2));
    }

    public static void hanoiTowerIterative(int n) {
        String pin1 = "жердь 1";
        String pin2 = "жердь 2";
        String pin3 = "жердь 3";
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                System.out.println("Установите диск " + i + " на " + pin2);
            } else if (i % 2 == 1) {
                System.out.println("Установите диск " + i + " на " + pin2 +
                        " и переместите все диски, установленные ранее на " + pin3 + ", на " + pin2 + ", поверх диска" + i);
            } else if (i % 2 == 0) {
                System.out.println("Установите диск " + i + " на " + pin3 +
                        " и переместите все диски, установленные ранее на " + pin2 + ", на " + pin3 + ", поверх диска" + i);
            }
        }
        System.out.println("Поздравляю, вы справились с поставленной задачей и все диски, согласно условию перемещены" +
                "с " + pin1 + " на " + pin2 + " в той же последовательности.");
    }

    public static void hanoiTowerRecursive(int n) {
        String pin1 = "жердь 1";
        String pin2 = "жердь 2";
        String pin3 = "жердь 3";
        if (n == 1) {
            System.out.println("Установите диск " + n + " на " + pin2);
            return;
        } if (n % 2 == 1) {
            System.out.println("Установите диск " + n + " на " + pin2 +
                    " и переместите все диски, установленные ранее на " + pin3 + ", на " + pin2 + ", поверх диска" + n);
        } if (n % 2 == 0) {
            System.out.println("Установите диск " + n + " на " + pin3 +
                    " и переместите все диски, установленные ранее на " + pin2 + ", на " + pin3 + ", поверх диска" + n);

        }
        hanoiTowerRecursive(n - 1);
        System.out.println("Поздравляю, вы справились с поставленной задачей и все диски, согласно условию перемещены" +
                "с " + pin1 + " на " + pin2 + " в той же последовательности.");
    }
}
