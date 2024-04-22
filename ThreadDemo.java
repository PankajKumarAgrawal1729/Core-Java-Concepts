class A extends Thread {
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println("Hi");
        }
    }
}

class B extends Thread{
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println("Hello");
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        A obj1 = new A();
        B obj2 = new B();
        // obj1.show();
        // obj2.show();
        obj1.start();
        obj2.start();
    }
}


// threads have 5 step: new , runnable, running, waiting, dead
//      start()            notify()
// new -------> Runnable ---> waiting
//                 | |       /|\
//                 | |        |
//                 | | run() / notify()
//              ___| |      /
//              |   \|/    /  stop()
//              |  Running ------------>  dead
//              |                          /|\
//              |___________________________|
//                     stop() (deprecated)