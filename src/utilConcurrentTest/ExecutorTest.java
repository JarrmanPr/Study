package utilConcurrentTest;
import java.util.*;
import java.util.concurrent.*;

interface MinMaxSearch<T extends Comparable<T>> {
    T call();
}

class MinValueSearch<T extends Comparable<T>> implements Callable, MinMaxSearch<T> {

    private T elementsArr[];
    T minVal;

    public MinValueSearch(T elements[]) {
        elementsArr = elements;
    }

    public T call() {
        minVal = elementsArr[0];

        for(int i = 1; i < elementsArr.length; i++) {
            if(elementsArr[i].compareTo(minVal) < 0) {
                minVal = elementsArr[i];
            }
        }

        return minVal;
    }
}

class MaxValueSearch<T extends Comparable<T>> implements Callable, MinMaxSearch<T> {

    private T elementsArr[];
    T maxVal;

    public MaxValueSearch(T elements[]) {
        elementsArr = elements;
    }

    public T call() {
        maxVal = elementsArr[0];

        for(int i = 1; i < elementsArr.length; i++) {
            if(elementsArr[i].compareTo(maxVal) > 0) {
                maxVal = elementsArr[i];
            }
        }

        return maxVal;
    }
}

public class ExecutorTest {
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

        System.out.println("Вычисление минимума");
        ExecutorService poolMin = Executors.newFixedThreadPool(6);
        List<Future<Object>> minValList = new ArrayList<Future<Object>>();

        for(int i = 0; i < 3; i++) {
            Callable<Object> callableInt = new MinValueSearch(dataArr[i]);
            Callable<Object> callableDouble = new MinValueSearch(dataArr2[i]);
            Future<Object> futureInt = poolMin.submit(callableInt);
            Future<Object> futureDouble = poolMin.submit(callableDouble);
            minValList.add(futureInt);
            minValList.add(futureDouble);
        }

        poolMin.shutdown();

        for (Future<Object> future : minValList) {
            System.out.println(future.get());
        }

        System.out.println("Вычисление максимума");
        ExecutorService poolMax = Executors.newFixedThreadPool(6);
        List<Future<Object>> maxValList = new ArrayList<Future<Object>>();

        for(int i = 0; i < 3; i++) {
            Callable<Object> callableInt2 = new MaxValueSearch(dataArr[i]);
            Callable<Object> callableDouble2 = new MaxValueSearch(dataArr2[i]);
            Future<Object> futureInt2 = poolMax.submit(callableInt2);
            Future<Object> futureDouble2 = poolMax.submit(callableDouble2);
            maxValList.add(futureInt2);
            maxValList.add(futureDouble2);
        }

        poolMax.shutdown();

        for (Future<Object> future2 : maxValList) {
            System.out.println(future2.get());
        }

    }
}

