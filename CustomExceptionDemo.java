class PankajException extends Exception {
    public PankajException(String str) {
        super(str);
    }
}

public class CustomExceptionDemo {
    public static void main(String[] args) {
        try {
            int p = 22 % 2;
            if (p == 0)
                throw new PankajException("This is custom exception");
        } catch (PankajException e) {
            System.out.println(e);
        }
    }
}
