package HashMap;

public class MyHashMapTester {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put("Egypt", "Cairo");
        map.put("Sweden", "Stockholm");
        map.put("Norway", "Oslo");
        map.put("Australia", "Canberra");
        map.put("Canada", "Ottawa");
        System.out.println(map.size());
        System.out.println(map.get("Canada"));
        System.out.println(map.get("USA"));
        map.remove("Egypt");
        System.out.println(map.size());
        System.out.println(map.contains("Norway"));
        System.out.println(map.contains("Ireland"));
    }
}
