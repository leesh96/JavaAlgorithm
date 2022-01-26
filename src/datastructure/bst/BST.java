package datastructure.bst;

public class BST {
    public Node root;

    public BST() {
        root = null;
    }

    public Node search(Node root, int value) {
        if (root == null || value == root.value) return root;

        if (value < root.value) {
            return search(root.left, value);
        } else {
            return search(root.right, value);
        }
    }

    public void insert(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return;
        }

        Node parent = null;
        Node cur = root;
        while (cur != null) {
            if (value == cur.value) return;
            parent = cur;
            if (value < cur.value) cur = cur.left;
            else cur = cur.right;
        }

        if (value < parent.value) parent.left = newNode;
        else parent.right = newNode;
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.value + " ");
            inOrder(root.right);
        }
    }
}
