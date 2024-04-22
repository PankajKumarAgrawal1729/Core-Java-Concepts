class Counter {
    int count = 0;

    // synchronized : it's used to make threads safe
    public synchronized void increament() {
        count++;
    }
}

public class ThreadSafe {
    public static void main(String[] args) throws InterruptedException {
        Counter obj = new Counter();

        Runnable obj1 = () -> {
            for (int i = 0; i < 1000; i++) {
                obj.increament();
            }
        };
        Runnable obj2 = () -> {
            for (int i = 0; i < 1000; i++) {
                obj.increament();
            }
        };

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();
        System.out.println(obj.count); // before both threads works complete it's print the value of count, present at
                                       // that instance(value of count)
        // becoz of race condition both are accesing the same variable and try to
        // manupulate that

        // to avoid this condition we need to make our thread's as thread safe, we need
        // to use 'join'

        t1.join();
        t2.join();
        System.out.println(obj.count);
    }
}
