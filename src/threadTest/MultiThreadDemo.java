package threadTest;

class ThreeThreads implements Runnable{
    String name;
    Thread t;

    ThreeThreads(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        t.start();
    }

    public void run() {
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println(name +  ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + "is interrupted");
        }
        System.out.println(name + " is comleted");
    }
}

public class MultiThreadDemo {
    public static void main(String args[]) {
        new ThreeThreads("One");
        new ThreeThreads("Two");
        new ThreeThreads("Three");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Main thead is interrupted");
        }
        System.out.println("Main thread is comleted");
    }
}
