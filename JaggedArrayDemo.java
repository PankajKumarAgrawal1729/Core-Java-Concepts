public class JaggedArrayDemo {
    public static void main(String[] args) {
        int[][] nums = new int[3][]; // jagged array - array which have different number of columns

        nums[0] = new int[3];
        nums[1] = new int[4];
        nums[2] = new int[5];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                nums[i][j] = (int) (Math.random() * 10);
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }
}
