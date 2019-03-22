package threadTest;

public class NewThread implements Runnable{
    Thread t;

    NewThread() {
        t = new Thread(this, "Demo thread");
        System.out.println("Child thread is created: " + t);
        t.start();
    }

    public void run() {
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println("Child thread: " + i);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            System.out.println("Child thead is interrupted");
        }
        System.out.println("Child thread is comleted");
    }
}

class ThreadDemo {
    public static void main(String args[]) {
        new NewThread();

        try {
            for(int i = 5; i > 0; i--) {
                System.out.println("Main thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thead is interrupted");
        }
        System.out.println("Main thread is comleted");
    }
}
