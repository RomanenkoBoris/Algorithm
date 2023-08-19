package StackandQueue.BasedOnArray;

public class MyQueueImpl implements MyQueue{
    private Object[] source;
    private int startPointer = -1;
    private int endtPointer = -1;
    private static final int CAPACITY  = 4;

    public MyQueueImpl() {
        source = new Object[CAPACITY];
    }
    private void increaseCapacity (){
        Object[] bigSource = new Object[source.length * 2];
        int current = 0;
        for(int i = startPointer; i<endtPointer; i++){
            bigSource[current] = source[i];
            current++;
        }
        startPointer =0;
        endtPointer = current;
    }


    @Override
    public Object offer(Object obj) {
        if(startPointer==-1 || endtPointer == -1){
            source[0]=obj;
            startPointer = 0;
            endtPointer = 0;
            return obj;
        }
        if (endtPointer == source.length-1){
            increaseCapacity();
        }
        ++endtPointer;
        source[endtPointer]= obj;
        return obj;
    }

    @Override
    public Object poll() {
        if (startPointer==-1 || endtPointer == -1){
            return null;
        }
        Object obj = source[startPointer];
        ++startPointer;
        if (startPointer>endtPointer){
            startPointer=-1;
            endtPointer=-1;
        }
        return obj;
    }

    @Override
    public Object peek() {
        if (startPointer==-1 || endtPointer == -1){
            return null;
        }
        return source[startPointer];
    }
}
