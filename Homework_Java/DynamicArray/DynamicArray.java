package DynamicArray;

import java.util.NoSuchElementException;

public class DynamicArray {
    private Object[] array;
    private int size;
    private int capacity;

    public DynamicArray() {
        array = new Object[10];
        size = 0;
        capacity = 10;
    }

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
        size = 0;
    }

    @Override
    public String toString() {
        StringBuffer current = new StringBuffer("[");
        for (int i = 0; i < size(); i++) {
            current.append(array[i]);
            if (i < size() - 1) {
                current.append(", ");
            }
        }
        current.append("]");
        return current.toString();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void clean() {
        Object[] array2 = new Object[capacity];
        array = array2;
        size = 0;
    }

    public int contains(Object obj) {
        for (int i = 0; i < size(); i++) {
            if (array[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    public void set(int index, Object obj) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = obj;
    }

    public void increseCapacity() {
        Object[] array2 = new Object[capacity * 2];
        for (int i = 0; i < capacity; i++) {
            array2[i] = array[i];
        }
        array = array2;
        capacity *= 2;
    }
    public void add (Object obj){
        if(size() == capacity){
            increseCapacity();
        }
        array[size()]= obj;
        size++;
    }
    public void remove() throws NoSuchElementException {
        if (size()==0){
            throw new NoSuchElementException();
        } else {
            size--;
        }
    }
    public void removeAt(int index) throws IndexOutOfBoundsException{
        if (index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size(); i++){
            array[i] = array[i+1];
        }
        size--;
    }

}
