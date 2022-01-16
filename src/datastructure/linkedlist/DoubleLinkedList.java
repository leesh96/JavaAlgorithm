package datastructure.linkedlist;

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

    private DoubleNode<E> search(int idx) {
        if (!checkIndex(idx)) {
            throw new IndexOutOfBoundsException();
        }

        DoubleNode<E> ptr;
        if (idx < (size >> 1)) {
            ptr = head;
            for (int i = 0; i < idx; i++) {
                ptr = ptr.next;
            }
        } else {
            ptr = tail;
            for (int i = size - 1; i > idx; i--) {
                ptr = ptr.prev;
            }
        }
        return ptr;
    }

    @Override
    public void addFirst(E value) {
        final DoubleNode<E> first = head;
        final DoubleNode<E> newNode = new DoubleNode<>(null, value, first);
        head = newNode;
        if (first == null) { // addFirst to empty list
            tail = newNode;
        } else {
            first.prev = newNode;
        }
        size++;
    }

    @Override
    public void add(E value) {
        final DoubleNode<E> last = tail;
        final DoubleNode<E> newNode = new DoubleNode<>(last, value, null);
        tail = newNode;
        if (last == null) { // addLast to empty list
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

        final DoubleNode<E> next = search(idx);
        final DoubleNode<E> prev = next.prev;
        final DoubleNode<E> newNode = new DoubleNode<>(prev, value, next);
        next.prev = newNode;
        if (prev == null) {
            head = newNode;
        } else {
            prev.next = newNode;
        }
        size++;
    }

    @Override
    public E removeFirst() {
        DoubleNode<E> first = head;
        if (first == null) {
            throw new NoSuchElementException();
        }

        final E element = first.value;
        final DoubleNode<E> next = first.next;
        first.value = null;
        first.next = null;
        head = next;
        if (next == null) {
            tail = null;
        } else {
            next.prev = null;
        }
        size--;

        return element;
    }

    @Override
    public E removeLast() {
        DoubleNode<E> last = tail;
        if (last == null) {
            throw new NoSuchElementException();
        }

        final E element = last.value;
        final DoubleNode<E> prev = last.prev;
        last.value = null;
        last.prev = null;
        tail = prev;
        if (prev == null) {
            head = null;
        } else {
            prev.next = null;
        }
        size--;

        return element;
    }

    private E unlink(DoubleNode<E> n) {
        final E element = n.value;
        final DoubleNode<E> prev = n.prev;
        final DoubleNode<E> next = n.next;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            n.prev = null;
        }
        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            n.next = null;
        }
        n.value = null;
        size--;

        return element;
    }

    @Override
    public boolean remove(Object obj) {
        if (obj == null) {
            for (DoubleNode<E> ptr = head; ptr != null; ptr = ptr.next) {
                if (ptr.value == null) {
                    unlink(ptr);
                    return true;
                }
            }
        } else {
            for (DoubleNode<E> ptr = head; ptr != null; ptr = ptr.next) {
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
        DoubleNode<E> ptr = search(idx);
        ptr.value = value;
    }

    @Override
    public int indexOf(Object obj) {
        int idx = 0;
        if (obj == null) {
            for (DoubleNode<E> ptr = head; ptr != null; ptr = ptr.next) {
                if (ptr.value == null) {
                    return idx;
                }
                idx++;
            }
        } else {
            for (DoubleNode<E> ptr = head; ptr != null; ptr = ptr.next) {
                if (obj.equals(ptr.value)) {
                    return idx;
                }
                idx++;
            }
        }

        return -1;
    }

    public int lastIndexOf(Object obj) {
        int idx = size;
        if (obj == null) {
            for (DoubleNode<E> ptr = tail; ptr != null; ptr = ptr.prev) {
                idx--;
                if (ptr.value == null) {
                    return idx;
                }
            }
        } else {
            for (DoubleNode<E> ptr = tail; ptr != null; ptr = ptr.prev) {
                idx--;
                if (obj.equals(ptr.value)) {
                    return idx;
                }
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
        for (DoubleNode<E> ptr = head; ptr != null; ) {
            final DoubleNode<E> next = ptr.next;
            ptr.value = null;
            ptr.prev = null;
            ptr.next = null;
            ptr = next;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DoubleLinkedList(");
        for (DoubleNode<E> ptr = head; ptr != null; ptr = ptr.next) {
            sb.append(ptr);
        }
        sb.append(")");
        return sb.toString();
    }
}
