package datastructure.bst;

public class Node {
    int value;
    Node left;
    Node right;

    private Node() {}

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
