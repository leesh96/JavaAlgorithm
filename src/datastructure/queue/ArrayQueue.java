package datastructure.queue;

import java.util.Arrays;

public class ArrayQueue<E> implements Queue<E> {

    // 환형 큐를 사용하여 구현 -> front 포인터 한자리는 무조건 비어있음 (공백과 포화의 구분)
    private Object[] arr;
    private int front, rear;
    private int capacity;

    private ArrayQueue() {
    }

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        arr = new Object[this.capacity];
        front = rear = 0;
    }

    @Override
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return rear - front + 1;
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    private boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    @Override
    public void add(E value) {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException("Queue is Full");
        }
        rear = (rear + 1) % capacity;
        arr[rear] = value;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Queue is Empty");
        }
        front = (front + 1) % capacity;
        E element = (E) arr[front];
        arr[front] = null;
        return element;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Queue is Empty");
        }
        return (E) arr[(front + 1) % capacity];
    }

    @Override
    public int indexOf(Object value) {
        if (isEmpty() || value == null) {
            return -1;
        }

        int idx = 0;
        int i = front;
        while (i != rear) {
            i = (i + 1) % capacity;
            if (value.equals(arr[i])) {
                return idx;
            }
            idx++;
        }

        return -1;
    }

    @Override
    public void clear() {
        if (!isEmpty()) {
            Arrays.fill(arr, null);
            front = rear = capacity - 1;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ArrayQueue(");
        int i = front;
        while (i != rear) {
            i = (i + 1) % capacity;
            sb.append(arr[i]).append(" ");
        }
        sb.append(")");
        return sb.toString();
    }

    public void printPtr() {
        System.out.printf("front:%d rear:%d %n", front, rear);
    }
}
