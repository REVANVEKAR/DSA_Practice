package revise.queue;

import java.util.Stack;

public class queueUsingStack {

    Stack<Integer> first = new Stack<>();
    Stack<Integer> second = new Stack<>();
//    int curr_size;

//    public queueUsingStack() {
//
//    }

    public void push(int x) {
        while (!first.isEmpty()){
            second.push(first.pop());
        }
        first.push(x);
        while (!second.isEmpty()){
            first.push(second.pop());
        }
    }

    public int pop() {
        if (first.isEmpty()){
            return -1;
        }
        return first.pop();
    }

    public int peek() {
        if(first.isEmpty()){
            return -1;
        }
        return first.peek();
    }

    public boolean empty() {
        return first.isEmpty();
    }

}
