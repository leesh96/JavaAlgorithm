package datastructure.stack;

public interface Stack<E> {

    int size();
    boolean isEmpty();

    void push(E value);
    E pop();
    E peek();

    int indexOf(Object value);
    void clear();
}
