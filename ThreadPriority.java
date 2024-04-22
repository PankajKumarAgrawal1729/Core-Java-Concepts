class A extends Thread {
    public void run() {
        for (int i = 0; i < 40; i++) {
            System.out.println("Hi");
            try {
                Thread.sleep(10);  // here we assign the time for that much time we want to execute this thread
            } catch (InterruptedException e) {
                e.printStackTrace();
            }   
        }
    }
}

class B extends Thread{
    public void run() {
        for (int i = 0; i < 40; i++) {
            System.out.println("Hello");
            try {
                Thread.sleep(10);  // here we assign the time for that much time we want to execute this thread
            } catch (InterruptedException e) {
                e.printStackTrace();
            }   
        }
    }
}

public class ThreadPriority {
    public static void main(String[] args) {
        A obj1 = new A();
        B obj2 = new B();

        // priority range b/w 1-10 where
        // 1 - least priority
        // 5 - normal(default)
        // 10 - high priority
        // System.out.println(obj1.getPriority() + " " + obj2.getPriority()); // 5 5
        // obj2.setPriority(Thread.MAX_PRIORITY);

        obj1.start();
        obj2.start();
    }
}
