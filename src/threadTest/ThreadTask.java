package threadTest;

class MinSearchThread implements Runnable {

    double elementsArr[][];
    Thread t;
    double minVal;
    String name;

    MinSearchThread(String threadName, double elements[][]) {
        name = threadName;
        elementsArr = elements;
        t = new Thread(this, threadName);
        t.start();
    }

    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 2; j++) {
                if(elementsArr[i][j] < minVal) {
                    minVal = elementsArr[i][j];
                }
            }
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }

    public double getMinValue() {
        return minVal;
    }
}

class MaxSearchThread implements Runnable {

    Thread t;
    double elementsArr[][];
    double maxVal;
    String name;

    MaxSearchThread(String threadName, double elements[][]) {
        name = threadName;
        elementsArr = elements;
        t = new Thread(this, threadName);
        t.setPriority(6);
        t.start();
    }

    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 2; j++) {
                if(elementsArr[i][j] > maxVal) {
                    maxVal = elementsArr[i][j];
                }
            }
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }

    public double getMaxValue() {
        return maxVal;
    }
}

public class ThreadTask {
    public static void main(String args[]) {

       /*17.	Дан массив размера 6 x 2 с элементами вещественного типа.
       Написать программу для вычисления max^2-min^2 ,
       где max-максимальный !!!! по модулю элемент массива, а min -минимальный
       по модулю элемент массива.*/
        System.out.println("Main thread started...");
        double elements[][] = { {0.6, 18,3},
                                {5.4, 14,8},
                                {-0.25, 87,4},
                                {11.3, 17.9},
                                {96.5, 39.7},
                                {-12.9, 4.3}};

        MaxSearchThread maxObj = new MaxSearchThread("Max", elements);
        MinSearchThread minObj = new MinSearchThread("Min", elements);

        try {
            maxObj.t.join();
            minObj.t.join();
        } catch(InterruptedException e) {
            System.out.println("Main thread is interrupted");
        }

        double result = Math.pow(maxObj.getMaxValue(), 2.0) -
                Math.pow(minObj.getMinValue(), 2.0);

        System.out.println("Max: " + maxObj.maxVal);
        System.out.println("Min: " + minObj.minVal);
        System.out.println("Max^2 - Min^2: " + result);
        System.out.println("Main thread finished...");
    }
}
