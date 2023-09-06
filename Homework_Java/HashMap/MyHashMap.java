package HashMap;

import java.util.Arrays;

public class MyHashMap implements MyMap {
    private static class Pair {
        String key;
        String value;
        Pair next;

        public Pair(String key, String value, Pair next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "{" + key + value + '}';
        }


    }

    private int size = 0;
    private static final int INITIAL_CAPACITY = 4;
    private Pair[] source = new Pair[INITIAL_CAPACITY];
    private static final double LOAD_FACTOR = 0.75;

    // вычисление номера вебра по ключу
    private int findBucket(String key) {
        return Math.abs(key.hashCode() % source.length);
    }

    // нахождение пары по ключу
    private Pair findPair(String key) {
        int bucket = findBucket(key);
        if (source[bucket] == null) {
            return null;
        }
        Pair temp = source[bucket];
        while (temp != null) {
            if (temp.key.equals(key)) {
                return temp;
            } else {
                temp = temp.next;
            }
        }
        return null;
    }

    private void rebalance() {
        Pair[] bigSource = new Pair[source.length * 2];
        for (int i = 0; i < size(); i++) {
            if (source[i] != null) {
                Pair temp = source[i];
                while (temp != null) {
                    int bucket = Math.abs(temp.key.hashCode() % bigSource.length);
                    if (bigSource[bucket] == null) {
                        bigSource[bucket] = temp;
                    } else {
                        Pair current = bigSource[bucket];
                        bigSource[bucket] = temp;
                        bigSource[bucket].next = current;
                    }
                    temp = temp.next;
                }
            }
        }
        source = bigSource;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(String key) {
        return findPair(key) != null;
    }

    @Override
    public void put(String key, String value) {
        if (size() / source.length >= LOAD_FACTOR) {
            rebalance();
        }
        Pair temp = findPair(key);
        if (temp != null) {
            temp.value = value;
        } else {
            int bucket = findBucket(key);
            source[bucket] = new Pair(key, value, source[bucket]);
        }
        size++;
    }

    @Override
    public String get(String key) {
        if (findPair(key) != null) {
            return findPair(key).value;
        }
        return null;
    }

    @Override
    public String remove(String key) {
        if(findPair(key) == null){
            return null;
        }
        Pair temp = findPair(key);
        int bucket = findBucket(key);
        if (temp.next == null && source[bucket].key.equals(temp.key)){
            source[bucket] = null;
        } else {
            Pair current = source[bucket];
            while (current.next != temp){
                current = current.next;
            }
            current.next = temp.next;
        }
        size--;
        return temp.value;
    }

    @Override
    public String toString() {
        String r = "[";
        int s = size() - 1;
        for (Pair p : source) {
            Pair current = p;
            while (current != null) {
                r += p;
                if (--s >= 0)
                    r += ", ";
                current = current.next;
            }
        }
        return r;
    }
}
