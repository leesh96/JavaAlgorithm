package datastructure;

class DoubleNode<E> {
    E value;
    DoubleNode<E> prev;
    DoubleNode<E> next;

    public DoubleNode(E value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}
