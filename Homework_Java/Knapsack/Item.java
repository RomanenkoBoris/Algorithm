package Knapsack;

public class Item implements Comparable<Item>{
    private String name;
    private int weight;
    private double prise;

    public Item(String name, int weight, double prise) {
        this.name = name;
        this.weight = weight;
        this.prise = prise;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public double getPrise() {
        return prise;
    }

    @Override
    public String toString() {
        return "Item{" + name + ", " + weight +
                ", " + prise + '}';
    }

    @Override
    public int compareTo(Item o) {
        return Math.round(Double.compare(prise/weight, o.prise/o.weight));
    }
}
