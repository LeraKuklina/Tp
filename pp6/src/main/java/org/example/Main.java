package org.example;

public class Main {
    public static void main(String[] args) {
        int arraySize = 31;

        ArrayProcessor processor = new ArrayProcessor(arraySize);

        System.out.println("Обработка в одном потоке:");
        processor.processSingleThread();

        System.out.println("\nОбработка в нескольких потоках:");
        processor.processMultiThread();
    }
}
