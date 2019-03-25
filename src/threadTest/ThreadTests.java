class MyThread implements Runnable {
    
    Thread t;
    String name;
    boolean isActive;
    int counter = 0;
     
    MyThread(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        t.setPriority(6);
        isActive = true;
        t.start();
    }
    
    void disable(){
        isActive = false;
    }
    
    public void run() {
        int i = 0;
        System.out.printf("%s started... \n", Thread.currentThread().getName());
      
        while(i < 10) {
            counter++;
            i++;
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}

class MyThread2 implements Runnable {
    
    Thread t;
    String name;
    int x = 0;
     
    MyThread2(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        t.start();
    }
    
    public void run() {
        int i = 0;
        
        System.out.printf("%s started... \n", Thread.currentThread().getName());
      
        while(i < 10) {
            x += 1;
            i++;
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}

public class ThreadTests {
    public static void main(String[] args) {
        
        System.out.println("Main thread started...");
        MyThread myThread = new MyThread("Child");
        MyThread2 myThread2 = new MyThread2("Child2");
        
        try {
            myThread.t.join();
            myThread2.t.join();
            
        } catch(InterruptedException e) {
            System.out.println("Main thread is interupted");
        }
             
        System.out.println("Main thread finished...");
        
        System.out.println(myThread.counter);
        System.out.println(myThread2.x);
        int a = myThread.counter + myThread2.x;
        System.out.println(a);
    }
}
