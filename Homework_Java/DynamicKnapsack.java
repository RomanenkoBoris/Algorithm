import java.util.ArrayList;
import java.util.List;

public class DynamicKnapsack {
    public static void main(String[] args) {
        int[] itemWeights = {3, 4, 5, 8, 9};
        int[] itemPrices =  {1, 6, 4, 7, 6};
        int capacity = 13;

        int [][] array = new int[itemWeights.length + 1][];
        for (int i = 0; i < itemWeights.length+1; i++){
            array[i] = new int[capacity + 1];
        }

        for (int i = 0; i <= itemWeights.length; i++){
            for (int j = 0; j <= capacity; j++){
                if (i == 0 || j == 0){
                    array[i][j] = 0;
                } else {
                    if (j >= itemWeights[i-1]){
                        array[i][j] = Math.max(array[i-1][j], array[i-1][j - itemWeights[i-1]] + itemPrices[i-1]);
                    } else {
                        array[i][j] = array [i-1][j];
                    }
                }
            }
        }
        int maxSum = array[itemWeights.length][capacity];
        ArrayList<Integer> result = new ArrayList<>();
        traceResult(array,itemWeights,itemWeights.length,capacity,result);

        System.out.println("С наибольшей эффективностью мы можем уложить в рюкзак предметы под следующими номерами: ");
        for (Integer i:result) {
            System.out.println(i);
        }
        System.out.println("Общая стоимость уложенных предметов равна: " + maxSum);
    }
    private static void traceResult (int[][] array, int [] weight, int itemQuantity, int capacity, List<Integer>result){
        if (array[itemQuantity][capacity] == 0){
            return;
        }
        if (array[itemQuantity-1][capacity] == array[itemQuantity][capacity]){
            traceResult(array,weight,itemQuantity-1,capacity, result);
        } else {
            traceResult(array,weight,itemQuantity-1,capacity-weight[itemQuantity-1], result);
            result.add(0, itemQuantity);
        }
    }
}
