package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
public class ArrayProcessor {
    private final int size;

    public ArrayProcessor(int size) {
        this.size = size;
    }
    public void processSingleThread() {
        float[] arr = new float[size];
        fillArrayWithOnes(arr);

        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = calculateNewValue(arr[i], i);
        }
        long end = System.currentTimeMillis();
        System.out.println("Время выполнения в одном потоке: " + (end - start) + " мс");
        System.out.println("Первый элемент: " + arr[0]);
        System.out.println("Последний элемент: " + arr[arr.length - 1]);
    }

    public void processMultiThread() {
        float[] arr = new float[size];
        fillArrayWithOnes(arr);

        long start = System.currentTimeMillis();

        int actualThreadCount = determineThreadCount();
        int partSize = size / actualThreadCount;
        ExecutorService executor = Executors.newFixedThreadPool(actualThreadCount);

        for (int i = 0; i < actualThreadCount; i++) {
            final int startIdx = i * partSize;
            final int endIdx = (i == actualThreadCount - 1) ? size : (i + 1) * partSize;

            final int threadNumber = i + 1;

            executor.submit(() -> {
                processPart(arr, startIdx, endIdx, threadNumber);
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("Время выполнения в нескольких потоках: " + (end - start) + " мс");
        System.out.println("Первый элемент: " + arr[0]);
        System.out.println("Последний элемент: " + arr[arr.length - 1]);
    }

    private void fillArrayWithOnes(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
    }
    private float calculateNewValue(float value, int index) {
        return (float) (value * Math.sin(0.2f + index / 5.0) * Math.cos(0.2f + index / 5.0) * Math.cos(0.4f + index / 2.0));
    }
    private synchronized void processPart(float[] arr, int startIdx, int endIdx, int threadNumber) {
        for (int j = startIdx; j < endIdx; j++) {
            arr[j] = calculateNewValue(arr[j], j);
        }
        System.out.println("Массив, обработанный потоком " + threadNumber + ": " + java.util.Arrays.toString(java.util.Arrays.copyOfRange(arr, startIdx, endIdx)));
    }
    private int determineThreadCount() {
        if (isPrime(size)) {
            return size;
        }
        if (size % 3 == 0) {
            return 3;
        } else if (size % 4 == 0) {
            return 4;
        } else {
            return 5;
        }
    }
    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
