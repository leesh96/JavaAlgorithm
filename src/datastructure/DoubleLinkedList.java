package datastructure;

import java.util.NoSuchElementException;

public class DoubleLinkedList<E> implements LinkedList<E> {
    private DoubleNode<E> head;
    private DoubleNode<E> tail;
    private int size;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private DoubleNode<E> search(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException();
        }

        DoubleNode<E> ptr;
        if (idx > size / 2) {
            ptr = tail;
            for (int i = size - 1; i > idx; i--) {
                ptr = ptr.prev;
            }
        } else {
            ptr = head;
            for (int i = 0; i < idx; i++) {
                ptr = ptr.next;
            }
        }

        return ptr;
    }

    @Override
    public void addFirst(E value) {
        DoubleNode<E> newNode = new DoubleNode<>(value);
        newNode.next = head;

        if (head != null) {
            head.prev = newNode;
        }

        head = newNode;
        size++;

        if (head.next == null) {
            tail = head;
        }
    }

    @Override
    public void add(E value) {
        DoubleNode<E> newNode = new DoubleNode<>(value);

        if (this.isEmpty()) {
            addFirst(value);
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    @Override
    public void add(E value, int idx) {
        if (idx < 0 || idx > size) {
            throw new IndexOutOfBoundsException();
        }

        if (idx == 0) {
            addFirst(value);
            return;
        }

        if (idx == size) {
            add(value);
            return;
        }

        DoubleNode<E> prev = search(idx - 1);
        DoubleNode<E> next = prev.next;
        DoubleNode<E> newNode = new DoubleNode<>(value);

        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = next;
        next.prev = newNode;
        size++;
    }

    @Override
    public E removeFirst() {
        DoubleNode<E> ptr = head;

        if (ptr == null) {
            throw new NoSuchElementException();
        }

        E data = ptr.value;

        DoubleNode<E> next = head.next;

        head.value = null;
        head.next = null;

        if (next != null) {
            next.prev = null;
        }

        head = next;
        size--;

        if (size == 0) {
            tail = null;
        }

        return data;
    }

    @Override
    public E removeLast() {
        DoubleNode<E> ptr = tail;

        E data = ptr.value;

        ptr = tail.prev;

        ptr.next = null;
        tail.value = null;
        tail.prev = null;
        tail.next = null;
        tail = ptr;
        size--;

        return data;
    }

    @Override
    public boolean remove(Object value) {
        DoubleNode<E> prev = head;
        DoubleNode<E> ptr = head;

        for (; ptr != null; ptr = ptr.next) {
            if (value.equals(ptr.value)) {
                break;
            }
            prev = ptr;
        }

        if (ptr == null) {
            return false;
        }

        if (ptr.equals(head)) {
            removeFirst();
            return true;
        }

        DoubleNode<E> next = ptr.next;

        prev.next = null;
        ptr.value = null;
        ptr.next = null;
        ptr.prev = null;

        if (next != null) {
            next.prev = prev;
            prev.next = next;
        } else {
            tail = prev;
        }

        size--;

        return true;
    }

    @Override
    public E remove(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (idx == 0) {
            return removeFirst();
        }

        DoubleNode<E> prev = search(idx - 1);
        DoubleNode<E> target = prev.next;
        DoubleNode<E> next = target.next;

        E data = target.value;

        prev.next = null;
        target.next = null;
        target.prev = null;
        target.value = null;

        if (next != null) {
            next.prev = prev;
            prev.next = next;
        } else {
            tail = prev;
        }

        size--;

        return data;
    }

    @Override
    public E get(int idx) {
        return search(idx).value;
    }

    @Override
    public void set(E value, int idx) {
        DoubleNode<E> ptr = search(idx);
        ptr.value = value;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) >= 0;
    }

    @Override
    public int indexOf(Object value) {
        int idx = 0;

        for (DoubleNode<E> ptr = head; ptr != null; ptr = ptr.next) {
            if (value.equals(ptr.value)) {
                return idx;
            }
            idx++;
        }

        return -1;
    }

    public int lastIndexOF(Object value) {
        int idx = size;

        for (DoubleNode<E> ptr = tail; ptr != null; ptr = ptr.prev) {
            idx--;
            if (value.equals(ptr.value)) {
                return idx;
            }
        }

        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null || size == 0;
    }

    @Override
    public void clear() {
        for (DoubleNode<E> ptr = head; ptr != null; ) {
            DoubleNode<E> next = ptr.next;
            ptr.value = null;
            ptr.prev = null;
            ptr.next = null;
            ptr = next;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public void print() {
        for (DoubleNode<E> ptr = head; ptr != null; ptr = ptr.next) {
            System.out.print(ptr.value.toString());
            System.out.print(" ");
        }
        System.out.print("\n");
    }

    public void reversePrint() {
        for (DoubleNode<E> ptr = tail; ptr != null; ptr = ptr.prev) {
            System.out.print(ptr.value.toString());
            System.out.print(" ");
        }
        System.out.print("\n");
    }
}
