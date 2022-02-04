package datastructure.heap;

public class MaxHeap {
    private int[] arr;
    private int last;
    private final int maxSize;

    public MaxHeap(int n) {
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

        if (arr[index/2] >= arr[index]) return;

        int temp = arr[index / 2];
        arr[index / 2] = arr[index];
        arr[index] = temp;
        upHeapify(index / 2);
    }

    private void downHeapify(int index) {
        if (index * 2 > last) return;

        if (arr[index] >= arr[index * 2] && arr[index] >= arr[index * 2 + 1]) return;

        if (arr[index * 2] >= arr[index * 2 + 1]) {
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
