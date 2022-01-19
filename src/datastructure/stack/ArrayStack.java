package datastructure.stack;

import java.util.Arrays;

public class ArrayStack<E> implements Stack<E> {

    private Object[] arr;
    private int top;

    private ArrayStack() {
    }

    public ArrayStack(int capacity) {
        arr = new Object[capacity];
        top = -1;
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    private boolean isFull() {
        return top == arr.length - 1;
    }

    @Override
    public void push(E value) {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException("Stack is full");
        }
        arr[++top] = value;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Stack is empty");
        }
        Object element = arr[top];
        arr[top--] = null;

        return (E) element;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Stack is empty");
        }
        return (E) arr[top];
    }

    @Override
    public int indexOf(Object value) {
        if (isEmpty() || value == null) {
            return -1;
        }

        for (int i = top; i >= 0; i--) {
            if (value.equals(arr[i])) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public void clear() {
        if (!isEmpty()) {
            Arrays.fill(arr, null);
            top = -1;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ArrayStack(");
        for (int i = 0; i <= top; i++) {
            sb.append(arr[i]).append(" ");
        }
        sb.append(")");
        return sb.toString();
    }
}
