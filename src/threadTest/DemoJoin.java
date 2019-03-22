package threadTest;

class MyThread implements Runnable{
    String name;
    Thread t;

    MyThread(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        t.start();
    }

    public void run() {
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + "is interrupted");
        }
        System.out.println(name + " is comleted");
    }
}

public class DemoJoin {
    public static void main(String args[]) {
        MyThread obj1 = new MyThread("One");
        obj1.t.setPriority(10);
        MyThread obj2 = new MyThread("Two");
        obj2.t.setPriority(7);
        MyThread obj3 = new MyThread("Three");

        System.out.println("Thread 1 isAlive(): " + obj1.t.isAlive());
        System.out.println("Thread 2 isAlive(): " + obj2.t.isAlive());
        System.out.println("Thread 3 isAlive(): " + obj3.t.isAlive());

        try {
            System.out.println("Waiting for threads to complete ...");
            obj1.t.join();
            obj2.t.join();
            obj3.t.join();
        } catch(InterruptedException e) {
            System.out.println("Main thead is interupted");
        }

        System.out.println("Thread 1 isAlive(): " + obj1.t.isAlive());
        System.out.println("Thread 2 isAlive(): " + obj2.t.isAlive());
        System.out.println("Thread 3 isAlive(): " + obj3.t.isAlive());

        System.out.println("Main thead is completed");
    }



}
