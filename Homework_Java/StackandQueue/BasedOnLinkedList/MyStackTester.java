package HomeWork5;

import StackandQueue.BasedOnArray.MyStack;
import StackandQueue.BasedOnArray.MyStackImpl;

public class MyStackTester {
    public static void main(String[] args) {
        MyStackImpl myStack = new MyStackImpl();
        System.out.println(myStack.empty());
        myStack.push(5);
        myStack.push(7);
        myStack.push(8);
        myStack.push(4);
        System.out.println(myStack.empty());
        System.out.println(myStack.peek());
        System.out.println(myStack.size());
        System.out.println(myStack.search(7));

        while (!myStack.empty()){
            System.out.print(myStack.pop() + " ");
        }


    }
}
