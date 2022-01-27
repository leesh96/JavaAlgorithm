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

    public boolean remove(int value) {
        Node parent = root;
        Node target = root;
        boolean isLeft = false;

        while (target.value != value) {
            parent = target;
            if (value < target.value) {
                isLeft = true;
                target = target.left;
            } else {
                isLeft = false;
                target = target.right;
            }
            if (target == null) {
                return false;
            }
        }

        if (target == root) root = delete(target);
        else if (isLeft) parent.left = delete(target);
        else parent.right = delete(target);
        return true;
    }

    private Node delete(Node target) {
        if (target.left == null && target.right == null) return null;
        else if (target.left == null) return target.right;
        else if (target.right == null) return target.left;
        else {
            Node parent = target;
            Node next = target.right;
            while (next.left != null) {
                parent = next;
                next = next.left;
            }
            target.value = next.value;
            if (next == target.right) target.right = next.right;
            else parent.left = next.right;
            return target;
        }
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.value + " ");
            inOrder(root.right);
        }
    }
}
