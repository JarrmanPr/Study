import java.util.*;
import java.util.concurrent.*;

interface MinMaxSearch<T extends Comparable<T>> {
    T call();
}

class MinValueSearch<T extends Comparable<T>> implements Callable, MinMaxSearch<T> {

    private T elementsArr[];
    T minVal;
    int threadNum;

    public MinValueSearch(T elements[], int num) {
        elementsArr = elements;
        threadNum = num;
    }

    public T call() {
        System.out.println("Thread " + threadNum + " start");
        minVal = elementsArr[0];

        for(int i = 1; i < elementsArr.length; i++) {
            if(elementsArr[i].compareTo(minVal) < 0) {
                minVal = elementsArr[i];
            }
        }
        System.out.println("Thread " + threadNum + " end");

        return minVal;
    }
}

class MaxValueSearch<T extends Comparable<T>> implements Callable, MinMaxSearch<T> {

    private T elementsArr[];
    T maxVal;
    int threadNum;

    public MaxValueSearch(T elements[], int num) {
        elementsArr = elements;
        threadNum = num;
    }

    public T call() {
        System.out.println("Thread " + threadNum + " start");
        maxVal = elementsArr[0];

        for(int i = 1; i < elementsArr.length; i++) {
            if(elementsArr[i].compareTo(maxVal) > 0) {
                maxVal = elementsArr[i];
            }
        }
        System.out.println("Thread " + threadNum + " end");

        return maxVal;
    }
}

public class SimplifiedExecutorTest {
    public static void main(String args[]) throws Exception {

        Integer dataArr[][] = {
                {7, 8, 9},
                {4, 5, 6},
                {1, 2, 3}
        };

        Double dataArr2[][] = {
                {7.1, 8.1, 9.1},
                {4.1, 5.1, 6.1},
                {1.1, 2.1, 3.1}
        };
        Callable<Object> callableInt;
        Callable<Object> callableDouble;
        Future<Object> futureInt;
        Future<Object> futureDouble;

        System.out.println("Вычисление минимума");
        ExecutorService pool = Executors.newFixedThreadPool(3);
        List<Future<Object>> valList = new ArrayList<Future<Object>>();

        for(int i = 0; i < 3; i++) {
            callableInt = new MinValueSearch(dataArr[i], i + 10);
            callableDouble = new MinValueSearch(dataArr2[i], i + 20);
            futureInt = pool.submit(callableInt);
            futureDouble = pool.submit(callableDouble);
            valList.add(futureInt);
            valList.add(futureDouble);
        }

        System.out.println("Вычисление максимума");
       
        for(int i = 0; i < 3; i++) {
            callableInt = new MaxValueSearch(dataArr[i], i + 30);
            callableDouble = new MaxValueSearch(dataArr2[i], i + 40);
            futureInt = pool.submit(callableInt);
            futureDouble = pool.submit(callableDouble);
            valList.add(futureInt);
            valList.add(futureDouble);
        }

        pool.shutdown();

        for (Future<Object> future2 : valList) {
            System.out.println(future2.get());
        }
    }
}
