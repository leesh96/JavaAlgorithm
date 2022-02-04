package datastructure.heap;

public class MinHeap {
    private int[] arr;
    private int last;
    private final int maxSize;

    public MinHeap(int n) {
        this.arr = new int[n+1];
        this.maxSize = n;
        last = 0;
    }

    public void insert(int value) {
        if (last == maxSize) { throw new IndexOutOfBoundsException(); }
        arr[++last] = value;
        upHeapify(last);
    }

    public int remove() {
        if (last == 0) { throw new IndexOutOfBoundsException(); }
        int value = arr[1];
        arr[1] = arr[last];
        arr[last--] = 0;
        downHeapify(1);

        return value;
    }

    private void upHeapify(int index) {
        if (index <= 1) return;

        if (arr[index/2] <= arr[index]) return;

        int temp = arr[index / 2];
        arr[index / 2] = arr[index];
        arr[index] = temp;
        upHeapify(index / 2);
    }

    private void downHeapify(int index) {
        if (index * 2 > last) return;

        // 왼쪽 자식 하나만 존재 하는데 최소힙 성질 만족
        if (arr[index] <= arr[index * 2] && index * 2 + 1 > last) return;

        // 자식이 둘 다 있는데 최소힙 성질 만족
        if (arr[index] <= arr[index * 2] && arr[index] <= arr[index * 2 + 1]) return;

        // 최소힙 성질 만족 x
        // 왼쪽 자식이 오른쪽 자식보다 작거나 같고, 자식이 하나만 있으면 왼쪽으로
        if (arr[index * 2] <= arr[index * 2 + 1] || index * 2 + 1 > last) {
            int temp = arr[index];
            arr[index] = arr[index * 2];
            arr[index * 2] = temp;
            downHeapify(index * 2);
        } else {
            int temp = arr[index];
            arr[index] = arr[index * 2 + 1];
            arr[index * 2 + 1] = temp;
            downHeapify(index * 2 + 1);
        }
    }

    public void print() {
        for (int i = 1; i <= last; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();
    }
}
