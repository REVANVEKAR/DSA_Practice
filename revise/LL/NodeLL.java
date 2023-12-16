package revise.LL;

public class NodeLL<T> {

    public T data; // T is a generic which means it can be Integer, Character etc
    // not int char though
    public NodeLL<T> next; // reference to next node

    public NodeLL(T data){
        this.data = data;
    }



}
