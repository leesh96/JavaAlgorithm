package datastructure.linkedlist;

class Node<E> {
    E value;
    Node<E> next;

    private Node() {
    }

    Node(E value, Node<E> next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Node(").append(value.toString()).append(")");
        return sb.toString();
    }
}
