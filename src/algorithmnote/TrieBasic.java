package algorithmnote;

public class TrieBasic {
    static final int ALPHA = 26;

    Node root;

    class Node {
        Node[] child = new Node[ALPHA];
        boolean isLast = false;
        int childCnt = 0;
        char value;
    }

    public TrieBasic() {
        this.root = new Node();
        root.value = ' ';
    }

    public void insert(String s) {
        int length = s.length();
        Node cur = this.root;

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            if (cur.child[idx] == null) {
                cur.child[idx] = new Node();
                cur.child[idx].value = c;
                cur.childCnt++;
            }
            cur = cur.child[idx];
        }

        cur.isLast = true;
    }

    public boolean find(String s) {
        int length = s.length();
        Node cur = this.root;

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            if (cur.child[idx] == null) {
                return false;
            }
            cur = cur.child[idx];
        }

        return cur != null && cur.isLast;
    }

    public void delete(String s) {
        delete(this.root, s, 0);
    }

    private void delete(Node cur, String s, int idx) {
        int length = s.length();
        if ((cur.childCnt == 0 && idx != length) || (idx == length && !cur.isLast)) {
            return;
        }

        if (idx == length) {
            cur.isLast = false;

            if (cur.childCnt== 0) {
                cur = null;
            }
        } else {
            char c = s.charAt(idx);
            int i = c - 'a';

            delete(cur.child[i], s, idx + 1);

            if (cur.child[i] == null) {
                cur.childCnt--;
            }

            if (cur.childCnt == 0 && !cur.isLast) {
                cur = null;
            }
        }
    }

    public void print() {
        print(this.root, 0, new StringBuilder());
    }

    private void print(Node node, int idx, StringBuilder sb) {
        Node cur = node;
        Node[] child = cur.child;
        StringBuilder builder = new StringBuilder(sb);

        if (!cur.equals(this.root)) {
            builder.append((char)(idx + 'a'));
        }

        if (cur.isLast) {
            System.out.println(builder);
        }

        for (int i = 0; i < ALPHA; i++) {
            if (cur.child[i] == null) {
                continue;
            }
            print(child[i], i, builder);
        }
    }
}
