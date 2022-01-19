package datastructure.stack;

import datastructure.linkedlist.DoubleLinkedList;
import datastructure.linkedlist.LinkedList;

public class ListStack<E> implements Stack<E> {

    private final LinkedList<E> list;

    public ListStack() {
        list = new DoubleLinkedList<>();
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
    public void push(E value) {
        list.addFirst(value);
    }

    @Override
    public E pop() {
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
