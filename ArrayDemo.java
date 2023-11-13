public class ArrayDemo {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 4, 54 };
        System.out.println(nums[3]);

        // update value in array
        nums[3] = 34;

        System.out.println(nums[3]);

        // int[] arr = new int[size_of_array];
        int[] arr = new int[4];
        System.out.println(arr[3]); // default value is 0
        arr[0] = 2;
        arr[1] = 5;
        arr[2] = 7;
        arr[3] = 27;

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
