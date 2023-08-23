package Knapsack;

import java.util.*;

public class KnapSack {
    public static void main(String[] args) {
        TreeSet<Item> items = new TreeSet<>(Arrays.asList(
                new Item("A", 10, 60),
                new Item("A", 20, 100),
                new Item("A", 30, 120)
        ));

        System.out.println(fillSack(items, 50));

    }

    public static List<Item> fillSack(TreeSet<Item> items, int sackCapacity) {
        int restCapacity = sackCapacity;
        List<Item> result = new ArrayList<>();
        int totalPrise = 0;
        for (Item i : items) {
            while (restCapacity >= i.getWeight()) {
                result.add(i);
                restCapacity -= i.getWeight();
                totalPrise += i.getPrise();
            }
        }
        System.out.println("The total prise of items is " + totalPrise);
        System.out.println("Your sack is filled with:");
        return result;
    }
}
