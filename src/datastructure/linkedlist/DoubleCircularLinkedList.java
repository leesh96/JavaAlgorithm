package datastructure.linkedlist;

import java.util.NoSuchElementException;

public class DoubleCircularLinkedList<E> implements LinkedList<E> {

    // 이중 원형 연결리스트는 head 포인터가 첫 번째 노드를 항상 가리키며 마지막 노드의 다음 링크 필드가 첫 번째 노드를 가리킴
    // tail 포인터가 필요 없음

    private DoubleNode<E> head;
    private int size;

    public DoubleCircularLinkedList() {
        head = null;
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

    private DoubleNode<E> search(int idx) {
        DoubleNode<E> ptr = head;
        if (idx <= (size >> 1)) {
            for (int i = 0; i < idx; i++) {
                ptr = ptr.next;
            }
        } else {
            for (int i = size - 1; i >= idx; i--) {
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
        if (first == null) {
            newNode.prev = newNode;
            newNode.next = newNode;
        } else {
            newNode.prev = first.prev;
            first.prev.next = newNode;
            first.prev = newNode;
        }
        size++;
    }

    @Override
    public void add(E value) {
        final DoubleNode<E> last = head;
        final DoubleNode<E> newNode = new DoubleNode<>(null, value, last);
        if (last == null) {
            head = newNode;
            newNode.prev = newNode;
            newNode.next = newNode;
        } else {
            newNode.prev = last.prev;
            last.prev.next = newNode;
            last.prev = newNode;
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
        prev.next = newNode;
        size++;
    }

    @Override
    public E removeFirst() {
        DoubleNode<E> first = head;
        if (first == null) {
            throw new NoSuchElementException();
        }

        final E element = first.value;
        final DoubleNode<E> prev = first.prev;
        final DoubleNode<E> next = first.next;
        if (next == first && prev == first) {
            head = null;
        } else {
            head = next;
            next.prev = prev;
            prev.next = next;
        }
        first.value = null;
        first.prev = null;
        first.next = null;
        size--;

        return element;
    }

    @Override
    public E removeLast() {
        DoubleNode<E> last = head;
        if (last == null) {
            throw new NoSuchElementException();
        }

        last = last.prev;
        final E element = last.value;
        final DoubleNode<E> prev = last.prev;
        final DoubleNode<E> next = last.next;
        if (prev == last && next == last) {
            head = null;
        } else {
            next.prev = prev;
            prev.next = next;
        }
        last.value = null;
        last.prev = null;
        last.next = null;
        size--;

        return element;
    }

    private E unlink(DoubleNode<E> n) {
        if (n == head) {
            return removeFirst();
        }

        final E element = n.value;
        final DoubleNode<E> prev = n.prev;
        final DoubleNode<E> next = n.next;
        if (prev == next) {
            head = null;
        } else {
            prev.next = next;
            next.prev = prev;
        }
        n.value = null;
        n.prev = null;
        n.next = null;
        size--;

        return element;
    }

    @Override
    public boolean remove(Object obj) {
        DoubleNode<E> ptr = head;
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
            } while (ptr != head);
        } else {
            do {
                if (obj.equals(ptr.value)) {
                    unlink(ptr);
                    return true;
                }
                ptr = ptr.next;
            } while (ptr != head);
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
        DoubleNode<E> ptr = head;
        if (ptr != null) {
            if (obj == null) {
                do {
                    if (ptr.value == null) {
                        return idx;
                    }
                    idx++;
                    ptr = ptr.next;
                } while (ptr != head);
            } else {
                do {
                    if (obj.equals(ptr.value)) {
                        return idx;
                    }
                    idx++;
                    ptr = ptr.next;
                } while (ptr != head);
            }
        }

        return -1;
    }

    public int lastIndexOf(Object obj) {
        int idx = size;
        DoubleNode<E> ptr = head;
        if (ptr != null) {
            if (obj == null) {
                do {
                    idx--;
                    if (ptr.value == null) {
                        return idx;
                    }
                    ptr = ptr.next;
                } while (ptr != head);
            } else {
                do {
                    idx--;
                    if (obj.equals(ptr.value)) {
                        return idx;
                    }
                    ptr = ptr.next;
                } while (ptr != head);
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
        DoubleNode<E> ptr = head;
        if (ptr != null) {
            do {
                final DoubleNode<E> next = ptr.next;
                ptr.value = null;
                ptr.prev = null;
                ptr.next = null;
                ptr = next;
            } while (ptr != head);
        }
        head = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DoubleCircularLinkedList(");
        DoubleNode<E> ptr = head;
        if (ptr != null) {
            do {
                sb.append(ptr);
                ptr = ptr.next;
            } while (ptr != head);
        }
        sb.append(")");
        return sb.toString();
    }
}
