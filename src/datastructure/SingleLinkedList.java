package datastructure;

import java.util.NoSuchElementException;

public class SingleLinkedList<E> implements LinkedList<E> {
    private Node<E> head;
    // 꼬리 노드의 주소를 갖고 있는 포인터는 구현해도 되고 안해도 된다.
    private Node<E> tail;
    private int size;

    public SingleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private Node<E> search(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> ptr = head;

        for (int i = 0; i < idx; i++) {
            ptr = ptr.next;
        }

        return ptr;
    }

    @Override
    public void addFirst(E value) {
        Node<E> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
        size++;

        if (head.next == null) {
            tail = head;
        }
    }

    @Override
    public void add(E value) {
        Node<E> newNode = new Node<>(value);

        if (this.isEmpty()) {
            addFirst(value);
            return;
        }

        tail.next = newNode;
        tail = newNode;
        size++;
    }

    @Override
    public void add(E value, int idx) {
        if (idx < 0 || idx > size) {
            throw new IndexOutOfBoundsException();
        }

        if (isEmpty()) {
            addFirst(value);
            return;
        }

        if (idx == size) {
            add(value);
            return;
        }

        Node<E> prev = search(idx - 1);
        Node<E> next = prev.next;
        Node<E> newNode = new Node<>(value);

        prev.next = newNode;
        newNode.next = next;
        size++;
    }

    @Override
    public E removeFirst() {
        Node<E> ptr = head;

        if (ptr == null) {
            throw new NoSuchElementException();
        }

        E data = head.value;

        Node<E> next = head.next;

        head.value = null;
        head.next = null;
        head = next;
        size--;

        if (isEmpty()) {
            tail = null;
        }

        return data;
    }

    @Override
    public E removeLast() {
        Node<E> ptr = tail;

        E data = ptr.value;

        ptr = search(size - 2);

        ptr.next = null;
        tail.value = null;
        tail.next = null;
        tail = ptr;
        size--;

        return data;
    }

    @Override
    public boolean remove(Object value) {
        Node<E> prev = head;
        Node<E> ptr = head;

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

        prev.next = ptr.next;
        ptr.value = null;
        ptr.next = null;
        size--;

        return true;
    }

    @Override
    public E remove(int idx) {
        if (idx == 0) {
            return removeFirst();
        }

        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> prev = search(idx - 1);
        Node<E> target = prev.next;
        Node<E> next = target.next;

        E data = target.value;

        prev.next = next;

        target.value = null;
        target.next = null;
        size--;

        return data;
    }

    @Override
    public E get(int idx) {
        return search(idx).value;
    }

    @Override
    public void set(E value, int idx) {
        Node<E> ptr = search(idx);
        ptr.value = value;
    }

    @Override
    public int indexOf(Object value) {
        int idx = 0;

        for (Node<E> ptr = head; ptr != null; ptr = ptr.next) {
            if (value.equals(ptr.value)) {
                return idx;
            }
            idx++;
        }

        return -1;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) >= 0;
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
        for (Node<E> ptr = head; ptr != null; ) {
            Node<E> next = ptr.next;
            ptr.value = null;
            ptr.next = null;
            ptr = next;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public void print() {
        for (Node<E> ptr = head; ptr != null; ptr = ptr.next) {
            System.out.print(ptr.value.toString());
            System.out.print(" ");
        }
        System.out.print("\n");
    }
}
