package datastructure.linkedlist;

class DoubleNode<E> {
    E value;
    DoubleNode<E> prev;
    DoubleNode<E> next;

    private DoubleNode() {
    }

    public DoubleNode(DoubleNode<E> prev, E value, DoubleNode<E> next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DoubleNode(").append(value.toString()).append(")");
        return sb.toString();
    }
}
