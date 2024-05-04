import java.util.Scanner;

public class HeapConcept {
    static int[] heap = new int[101];
    static int size = 0;

    public static void heapifyMinHeap(int i) {
        int idx = i;
        int leftChildIdx = 2 * idx;
        int rightChildIdx = 2 * idx + 1;
        if (leftChildIdx <= size && heap[idx] > heap[leftChildIdx]) {
            idx = leftChildIdx;
        }
        if (rightChildIdx <= size && heap[idx] > heap[rightChildIdx]) {
            idx = rightChildIdx;
        }
        if (i != idx) {
            int temp = heap[idx];
            heap[idx] = heap[i];
            heap[i] = temp;
            heapifyMinHeap(idx);
        }
    }

    public static void heapSort(){
        int i = size;
        
        while(size > 1){
            int temp = heap[1];
            heap[1] = heap[size];
            heap[size] = temp;
            size--;
            heapifyMaxHeap(1);
        }
        size = i;
    }

    public static void heapifyMaxHeap(int i) {
        int idx = i;
        int leftChildIdx = 2 * idx;
        int rightChildIdx = 2 * idx + 1;
        if (leftChildIdx <= size && heap[idx] < heap[leftChildIdx]) {
            idx = leftChildIdx;
        }
        if (rightChildIdx <= size && heap[idx] < heap[rightChildIdx]) {
            idx = rightChildIdx;
        }
        if (i != idx) {
            int temp = heap[idx];
            heap[idx] = heap[i];
            heap[i] = temp;
            heapifyMaxHeap(idx);
        }
    }

    public static void insertInMaxHeap(int value) {
        size++;
        int idx = size;
        heap[idx] = value;
        while (idx > 1) {
            int parentIdx = idx / 2;
            if (heap[parentIdx] < heap[idx]) {
                int temp = heap[parentIdx];
                heap[parentIdx] = heap[idx];
                heap[idx] = temp;
                idx = parentIdx;
            } else {
                return;
            }
        }
    }

    public static void insertInMinHeap(int value) {
        size++;
        int idx = size;
        heap[idx] = value;
        while (idx > 1) {
            int parentIdx = idx / 2;
            if (heap[parentIdx] > heap[idx]) {
                int temp = heap[parentIdx];
                heap[parentIdx] = heap[idx];
                heap[idx] = temp;
                idx = parentIdx;
            } else {
                return;
            }
        }
    }

    public static void deleteFromMaxHeap() {
        if (size < 1) {
            System.out.println("Heap is Empty!!");
            return;
        }
        // swap the first and last element
        heap[1] = heap[size];
        // remove the last element
        size--;
        // heapify the heap from the root node to the last node
        heapifyMaxHeap(1);
    }

    public static void deleteFromMinHeap() {
        if (size < 1) {
            System.out.println("Heap is Empty!!");
            return;
        }
        // swap the first and last element
        heap[1] = heap[size];
        // remove the last element
        size--;
        // heapify the heap from the root node to the last node
        heapifyMinHeap(1);
    }

    public static void printHeap() {
        if (size <= 0) {
            System.out.println("Heap is Empty");
            return;
        }
        System.out.println("Your Heap is: ");
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static boolean isCorrectChoice(int option) {
        boolean correct = option == 1 || option == 2;
        if (correct) {
            return true;
        } else {
            System.out.println("Choose the valid option!!");
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Which Heap wants to Create:\n1. Min Heap\n2.Max Heap");
        System.out.println("Enter your option: ");
        int option = sc.nextInt();

        if (isCorrectChoice(option)) {
            System.out.println("Enter size of your heap: ");
            int n = sc.nextInt();
            heap = new int[n + 1];

            System.out.println("Enter " + n + " values");
            if (option == 1) {
                for (int i = 0; i < n; i++) {
                    int val = sc.nextInt();
                    insertInMinHeap(val);
                }
            } else {
                for (int i = 0; i < n; i++) {
                    int val = sc.nextInt();
                    insertInMaxHeap(val);
                }
            }
            printHeap();

            System.out.println("Want to delete from heap\n1. Yes\n2. No");
            int option2 = sc.nextInt();
            if (option2 == 1) {
                if (option == 1) {
                    deleteFromMinHeap();
                } else {
                    deleteFromMaxHeap();
                }
                printHeap();
            }

            if(option == 2){
                heapSort();
                System.out.print("After Sorted ");
                printHeap();
            }
        }

        sc.close();
    }
}
