import java.util.Scanner;

public class RadixSort {

    public static int getMax(int[] arr, int n){
        int max = arr[0];
        for(int i = 1; i < n; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    public static int[] countingSort(int[] arr, int pos, int n){
        int[] count = new int[10];

        for(int i = 0; i < n; i++){
            count[(arr[i] / pos) % 10]++;
        }

        for(int i = 1; i < 10; i++){
            count[i] += count[i - 1];
        }

        int[] sorted = new int[n];

        for(int i = n - 1; i >= 0; i--){
            sorted[count[(arr[i] / pos) % 10] - 1] = arr[i];
            count[(arr[i] / pos) % 10]--;
        }
        return sorted;
    }

    public static int[][] radixSort(int[] arr, int n){
        int maxEle = getMax(arr, n);
        int temp = maxEle;
        int size = 0;
        while(temp > 0){
            size++;
            temp /= 10;
        }

        int[][] sortedArray = new int[size][n];
        int idx = 0;
        // Applying counting sort to sort the elements based on individual digits (from least significant digit to most significant)

        for(int i = 1; (maxEle / i) > 0; i *= 10){
            arr = countingSort(arr, i, n);
            sortedArray[idx++] = arr;
        }
        return sortedArray;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of the array: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " elements of array.");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[][] sortedArray = radixSort(arr, n);
        int pos = 1;
        for(int i = 0; i < sortedArray.length; i++){
            System.out.println("Elements sorted based on " + pos + " position");
            for(int j = 0; j < n; j++){
                System.out.print(sortedArray[i][j] + " ");
            }
            System.out.println();
            pos *= 10;
        }
        sc.close();
    }
}
