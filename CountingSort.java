import java.util.Scanner;

public class CountingSort {
    public static int getMax(int[] arr, int n){
        int max = arr[0];
        for(int i = 1; i < n; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    public static int[] countingSortAlgo(int[] arr, int n){
        int max = getMax(arr, n);
        
        // create  a count array to store the number of elements that have same key values in original array
        int[] count = new int[max + 1];
        for(int i = 0; i < n; i++){
            count[arr[i]]++;
        }

        // Store the cumulative sum or prefix sum of the elements of the count[] by doing count[i] = count[i – 1] + count[i]. This will help in placing the elements of the input array at the correct index in the output array.
        for(int i = 1; i < max + 1; i++){
            count[i] += count[i - 1];
        }
        int[] sortedArray = new int[n];
        
        // add the objects one by one in sorted way using count array

        for(int i = n - 1; i >= 0; i--){
            sortedArray[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
       
        return sortedArray;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array");
        int size = sc.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter " + size + " elements in array");
        for(int i = 0; i < size; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Array Before sort: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("Array after sort: ");
        int[] sortedArray = countingSortAlgo(arr, size);
        for (int i : sortedArray) {
            System.out.print(i + " ");
        }
        System.out.println();

        sc.close();
    }
}
