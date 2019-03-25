package threadTest;

class MyQueue {
    int n;
    boolean valueSet = false;

    synchronized int get() { // Consumer
        while(!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }

        System.out.println("Recieved: " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n) { // Producer
        while(valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }

        this.n = n;
        System.out.println("Sent: " + n);
        valueSet = true;
        notify();
    }
}

class Producer implements Runnable {
    MyQueue queue;

    Producer(MyQueue q) {
        this.queue = q;
        new Thread(this, "Producer").start();
    }

    public void run() {
        int i = 0;

        while(true) {
            queue.put(i++);
        }
    }
}

class Consumer implements Runnable {
    MyQueue queue;

    Consumer(MyQueue q) {
        this.queue = q;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        int i = 0;

        while(true) {
            queue.get();
        }
    }
}

public class WaitNotifyTest {
    public static void main(String args[]) {
        MyQueue q = new MyQueue();
        new Producer(q);
        new Consumer(q);
    }

}
