import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {654, 51, 23, 4, 2, 4, 6, 14, 62, 46, 2, 45, 2, 46, 3, 456, 6, 5};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void quickSort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = array[pivotIndex];

        swap(array, pivotIndex, highIndex);

        int leftPointer = lowIndex;
        int rightPoiner = highIndex;

        while (leftPointer < rightPoiner) {
            while (array[leftPointer] <= pivot && leftPointer < rightPoiner) {
                leftPointer++;
            }
            while (array[rightPoiner] >= pivot && leftPointer < rightPoiner) {
                rightPoiner--;
            }

            swap(array, leftPointer, rightPoiner);
        }
        swap(array, leftPointer, highIndex);

        quickSort(array, lowIndex, leftPointer - 1);
        quickSort(array, leftPointer + 1, highIndex);
    }

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }
}
