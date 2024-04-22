public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        int[] arr = new int[5];

        try {
            // j = 10 / i; // java.lang.ArithmeticException: / by zero
            // System.out.println(arr[5]); java.lang.ArrayIndexOutOfBoundsException: Index 5
            // out of bounds for length 5
            i = 2;
            j = 18 % i;
            if(j == 0){
                throw new ArithmeticException("we don't want zero.");
            }
        } catch (ArithmeticException e) {
            j = 18 / 1;
            System.out.println("that's the default answer " + e );
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array value out of bound " + e);
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
        System.out.println(j + " " + arr[2]);
        System.out.println("BYE");
    }
}


// Exception Hierarchy
// Object --> Throwable(it has two type) - Error, Exception
//  1. Error(we can't handle these): Thread dead, IO Error, Virtual machine error, out of memory
// 2. Exception - Runtime(These are unchecked - Arthmetic, Array out of bound, null pointer) , SQL Exception(Checked Exception), IO Exception(Checked Exception)