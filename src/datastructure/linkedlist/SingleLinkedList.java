package datastructure.linkedlist;

import java.util.NoSuchElementException;

// 단일연결리스트(다음 노드의 링크필드만 가짐)
public class SingleLinkedList<E> implements LinkedList<E> {
    private Node<E> head;
    private Node<E> tail; // 꼬리 노드의 주소를 갖고 있는 포인터는 구현해도 되고 안해도 된다.
    private int size;

    public SingleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
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
        Node<E> ptr = head;
        for (int i = 0; i < idx; i++) {
            ptr = ptr.next;
        }
        return ptr;
    }

    @Override
    public void addFirst(E value) {
        final Node<E> first = head;
        final Node<E> newNode = new Node<>(value, first);
        head = newNode;
        if (first == null) {
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(E value) {
        final Node<E> last = tail;
        final Node<E> newNode = new Node<>(value, null);
        tail = newNode;
        if (last == null) {
            head = newNode;
        } else {
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
        if (next == head) {
            head = newNode;
        } else {
            Node<E> prev;
            for (prev = head; prev.next != next; ) {
                prev = prev.next;
            }
            prev.next = newNode;
        }
        size++;
    }

    @Override
    public E removeFirst() {
        Node<E> first = head;
        if (first == null) {
            throw new NoSuchElementException();
        }

        final E element = first.value;
        final Node<E> next = first.next;
        first.value = null;
        first.next = null;
        head = next;
        if (next == null) {
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
        if (last == head) {
            head = null;
            tail = null;
        } else {
            Node<E> prev;
            for (prev = head; prev.next != last; ) {
                prev = prev.next;
            }
            prev.next = null;
            tail = prev;
        }
        last.value = null;
        size--;

        return element;
    }

    private E unlink(Node<E> n) {
        if (n == head) {
            return removeFirst();
        }

        if (n == tail) {
            return removeLast();
        }

        final E element = n.value;
        final Node<E> next = n.next;
        Node<E> prev;
        for (prev = head; prev.next != n; ) {
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
        if (obj == null) {
            for (Node<E> ptr = head; ptr != null; ptr = ptr.next) {
                if (ptr.value == null) {
                    unlink(ptr);
                    return true;
                }
            }
        } else {
            for (Node<E> ptr = head; ptr != null; ptr = ptr.next) {
                if (obj.equals(ptr.value)) {
                    unlink(ptr);
                    return true;
                }
            }
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
        int idx = 0;
        if (obj == null) {
            for (Node<E> ptr = head; ptr != null; ptr = ptr.next) {
                if (ptr.value == null) {
                    return idx;
                }
                idx++;
            }
        } else {
            for (Node<E> ptr = head; ptr != null; ptr = ptr.next) {
                if (obj.equals(ptr.value)) {
                    return idx;
                }
                idx++;
            }
        }

        return -1;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) >= 0;
    }

    @Override
    public void clear() {
        for (Node<E> ptr = head; ptr != null; ) {
            final Node<E> next = ptr.next;
            ptr.value = null;
            ptr.next = null;
            ptr = next;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SingleLinkedList(");
        for (Node<E> ptr = head; ptr != null; ptr = ptr.next) {
            sb.append(ptr);
        }
        sb.append(")");
        return sb.toString();
    }
}
