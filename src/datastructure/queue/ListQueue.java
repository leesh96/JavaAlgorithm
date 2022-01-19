package datastructure.queue;

import datastructure.linkedlist.DoubleCircularLinkedList;
import datastructure.linkedlist.LinkedList;

public class ListQueue<E> implements Queue<E> {

    private final LinkedList<E> list;

    public ListQueue() {
        list = new DoubleCircularLinkedList<>();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public void add(E value) {
        list.add(value);
    }

    @Override
    public E remove() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.get(0);
    }

    @Override
    public int indexOf(Object value) {
        return list.indexOf(value);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
