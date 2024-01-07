package revise.stack;

import java.util.LinkedList;
import java.util.Queue;

public class stackUsingQueue {

//    Queue<Integer> q1 = new LinkedList<>();
//    Queue<Integer> q2 = new LinkedList<>();
//    int curr_size;
//
//    public stackUsingQueue() {
//        curr_size = 0;
//    }
//
//    public void push(int x) {
//        curr_size++;
//
//        q2.add(x);
//
//        while (!q1.isEmpty()){
//            q2.add(q1.peek());
//            q1.remove();
//        }
//
//        Queue<Integer> q = q1;
//        q1 = q2;
//        q2 = q;
//    }
//
//    public int pop() {
//        if (q1.isEmpty()){
//            return -1;
//        }
//        int temp = q1.peek();
//        q1.remove();
//        curr_size--;
//        return temp;
//    }
//
//    public int top() {
//        if (q1.isEmpty()){
//            return -1;
//        }
//        return q1.peek();
//    }
//
//    public boolean empty() {
//        return curr_size==0;
//    }

    //using 1 queues

    Queue<Integer> q = new LinkedList<>();

    public void push(int x){
        q.add(x);
        int count = q.size()-1;
        while (count>0){
            q.add(q.peek());
            q.remove();
            count--;
        }
    }

    public int pop(){
        if (q.size()>0){
            int temp = q.peek();
            q.remove();
            return temp;
        }else {
            return -1;
        }
    }

    public int top(){
        return q.size() > 0? q.peek() : -1;
    }

    public boolean empty(){
        return q.size() ==  0;
    }


}
