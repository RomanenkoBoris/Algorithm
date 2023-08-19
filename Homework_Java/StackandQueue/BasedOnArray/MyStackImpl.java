package StackandQueue.BasedOnArray;

public class MyStackImpl implements MyStack {

    private Object[] source;
    private int size;
    private static final int CAPACITY = 4;

    public MyStackImpl() {
        source = new Object[CAPACITY];
    }

    public int size() {
        return size;
    }

    public void increaseCapacity() {
        Object[] bigSource = new Object[source.length * 2];
        for (int i = 0; i < source.length; i++) {
            bigSource[i] = source[i];
        }
        source = bigSource;
    }

    @Override
    public boolean empty() {
        if (size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Object peek() {
        return source[size() - 1];
    }

    @Override
    public Object pop() {
        Object obj = source[size() - 1];
        size--;
        return obj;
    }

    @Override
    public Object push(Object obj) {
        if (size() == source.length) {
            increaseCapacity();
        }
        source[size()] = obj;
        size++;
        return obj;
    }

    @Override
    public int search(Object obj) {
        for (int i = 0; i < source.length; i++) {
            if (source[i].equals(obj)) {
                return source.length - i;
            }
        }
        return -1;
    }
}
