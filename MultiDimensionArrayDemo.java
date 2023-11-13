public class MultiDimensionArrayDemo {
    public static void main(String[] args) {
        int[][] nums = new int[3][4];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                nums[i][j] = (int) ((i + j) * Math.random() * 10);
            }
        }

        // for (int i = 0; i < nums.length; i++) {
        // for (int j = 0; j < nums[0].length; j++) {
        // System.out.print(nums[i][j] + " ");
        // }
        // System.out.println();
        // }

        // enhanced for loop
        for (int[] arr : nums) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
