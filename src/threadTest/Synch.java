package threadTest;

class Callme1 {
    void call(String msg) {  // 1й вариант синхронизации
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}

class Caller1 implements Runnable {
    String msg;
    Callme1 target;
    Thread t;

    public Caller1(Callme1 targ, String s) {
        target = targ;
        msg = s;
        t = new Thread(this);
        t.start();
    }

    public void run() {
       // target.call(msg);

        synchronized(target) {  // 2й вариант синхронизации
            target.call(msg);
        }
    }
}

public class Synch {
    public static void main(String args[]) {
        Callme1 target = new Callme1();
        Caller1 ob1 = new Caller1(target, "Welcome1");
        Caller1 ob2 = new Caller1(target, "to synchronized1");
        Caller1 ob3 = new Caller1(target, "world !1");

        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch(InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}
