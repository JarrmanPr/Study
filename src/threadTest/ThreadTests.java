class MyThread implements Runnable {
    
    Thread t;
    String name;
    double x;
    double mas[][];
     
    MyThread(String threadName, double el[][]) {
        name = threadName;
        mas = el;
        t = new Thread(this, name);
        t.setPriority(6);
        t.start();
    }

    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());

        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 2; j++) {
                x += mas[i][j];
            }
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}

class MyThread2 implements Runnable {
    
    Thread t;
    String name;
    double x;
    double mas[][];

     
    MyThread2(String threadName, double el[][]) {
        name = threadName;
        mas = el;
        t = new Thread(this, name);
        t.start();
    }
    
    public void run() {

        
        System.out.printf("%s started... \n", Thread.currentThread().getName());

        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 2; j++) {
                if(x > mas[i][j])
                    x = mas[i][j];
            }
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}

public class ThreadTests {
    public static void main(String[] args) {
        double elements[][] = { {0.6, 18,3},
                {5.4, 14,8},
                {-0.25, 87,4},
                {11.3, 17.9},
                {96.5, 39.7},
                {-12.9, 4.3}};
        
        System.out.println("Main thread started...");
        MyThread myThread = new MyThread("Child", elements);
        MyThread2 myThread2 = new MyThread2("Child2", elements);
        
        try {
            myThread.t.join();
            myThread2.t.join();
            
        } catch(InterruptedException e) {
            System.out.println("Main thread is interupted");
        }
             
        System.out.println("Main thread finished...");
        
        System.out.println(myThread.x);
        System.out.println(myThread2.x);

    }
}
