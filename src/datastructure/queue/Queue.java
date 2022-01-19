package datastructure.queue;

public interface Queue<E> {

    int size();
    boolean isEmpty();

    void add(E value);
    E remove();
    E peek();

    int indexOf(Object value);
    void clear();
}
