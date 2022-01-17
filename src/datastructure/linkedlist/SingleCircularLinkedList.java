package datastructure.linkedlist;

import java.util.NoSuchElementException;

public class SingleCircularLinkedList<E> implements LinkedList<E> {

    // 포인터가 항상 마지막 노드를 가리키고 마지막 노드의 링크 필드가 항상 첫번째 노드를 가리키는 구조
    private Node<E> tail;
    private int size;

    public SingleCircularLinkedList() {
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean checkIndex(int index) {
        return 0 <= index && index < size;
    }

    private boolean checkPosition(int pos) {
        return 0 <= pos && pos <= size;
    }

    private Node<E> search(int idx) {
        Node<E> ptr = tail;
        for (int i = 0; i <= idx; i++) {
            ptr = ptr.next;
        }
        return ptr;
    }

    @Override
    public void addFirst(E value) {
        final Node<E> last = tail;
        final Node<E> newNode = new Node<>(value, null);
        if (last == null) {
            newNode.next = newNode;
            tail = newNode;
        } else {
            newNode.next = last.next;
            last.next = newNode;
        }
        size++;
    }

    @Override
    public void add(E value) {
        final Node<E> last = tail;
        final Node<E> newNode = new Node<>(value, null);
        tail = newNode;
        if (last == null) {
            newNode.next = newNode;
        } else {
            newNode.next = last.next;
            last.next = newNode;
        }
        size++;
    }

    @Override
    public void add(int idx, E value) {
        if (!checkPosition(idx)) {
            throw new IndexOutOfBoundsException();
        }

        if (idx == size) {
            add(value);
            return;
        }

        final Node<E> next = search(idx);
        final Node<E> newNode = new Node<>(value, next);
        Node<E> prev;
        for (prev = tail; prev.next != next; ) {
            prev = prev.next;
        }
        prev.next = newNode;
        size++;
    }

    @Override
    public E removeFirst() {
        Node<E> last = tail;
        if (last == null) {
            throw new NoSuchElementException();
        }

        final Node<E> first = last.next;
        final E element = first.value;
        final Node<E> next = first.next;
        first.value = null;
        first.next = null;
        last.next = next;
        if (first == tail) {
            tail = null;
        }
        size--;

        return element;
    }

    @Override
    public E removeLast() {
        Node<E> last = tail;
        if (last == null) {
            throw new NoSuchElementException();
        }

        final E element = last.value;
        final Node<E> next = last.next;
        if (next == tail) {
            tail = null;
        } else {
            Node<E> prev;
            for (prev = tail; prev.next != last; ) {
                prev = prev.next;
            }
            prev.next = next;
            tail = prev;
        }
        last.value = null;
        last.next = null;
        size--;

        return element;
    }

    private E unlink(Node<E> n) {
        if (n == tail) {
            return removeLast();
        }

        final E element = n.value;
        final Node<E> next = n.next;
        Node<E> prev;
        for (prev = tail; prev.next != n; ) {
            prev = prev.next;
        }
        prev.next = next;
        n.value = null;
        n.next = null;
        size--;

        return element;
    }

    @Override
    public boolean remove(Object obj) {
        Node<E> ptr = tail;
        if (ptr == null) {
            return false;
        }

        if (obj == null) {
            do {
                if (ptr.value == null) {
                    unlink(ptr);
                    return true;
                }
                ptr = ptr.next;
            } while (ptr != tail);
        } else {
            do {
                if (obj.equals(ptr.value)) {
                    unlink(ptr);
                    return true;
                }
                ptr = ptr.next;
            } while (ptr != tail);
        }

        return false;
    }

    @Override
    public E remove(int idx) {
        if (!checkIndex(idx)) {
            throw new IndexOutOfBoundsException();
        }
        return unlink(search(idx));
    }

    @Override
    public E get(int idx) {
        if (!checkIndex(idx)) {
            throw new IndexOutOfBoundsException();
        }
        return search(idx).value;
    }

    @Override
    public void set(int idx, E value) {
        if (!checkIndex(idx)) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> ptr = search(idx);
        ptr.value = value;
    }

    @Override
    public int indexOf(Object obj) {
        Node<E> ptr = tail;
        if (ptr == null) {
            return -1;
        }

        int idx = 0;
        if (obj == null) {
            do {
                ptr = ptr.next;
                if (ptr.value == null) {
                    return idx;
                }
                idx++;
            } while (ptr != tail);
        } else {
            do {
                ptr = ptr.next;
                if (obj.equals(ptr.value)) {
                    return idx;
                }
                idx++;
            } while (ptr != tail);
        }

        return -1;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) >= 0;
    }

    @Override
    public void clear() {
        Node<E> ptr = tail;
        if (ptr != null) {
            do {
                final Node<E> next = ptr.next;
                ptr.value = null;
                ptr.next = null;
                ptr = next;
            } while (ptr != tail);
        }
        tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SingleCircularLinkedList(");
        Node<E> ptr = tail;
        if (ptr != null) {
            do {
                ptr = ptr.next;
                sb.append(ptr);
            } while (ptr != tail);
        }
        sb.append(")");
        return sb.toString();
    }
}
