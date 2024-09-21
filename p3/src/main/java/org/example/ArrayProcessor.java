package org.example;

import java.util.ArrayList;
import java.util.List;

public class ArrayProcessor {

    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException, MyNoSimpleException {
        if (array.length != 4) {
            throw new MyArraySizeException("Массив должен быть размером 4x4");
        }

        for (String[] row : array) {
            if (row.length != 4) {
                throw new MyArraySizeException("Массив должен быть размером 4x4");
            }
        }

        int sum = 0;

// Проверка данных на наличие текста
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    Integer.parseInt(array[i][j]); // Попытка преобразовать строку в число
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("В ячейке [" + i + "][" + j + "] содержится нечисловое значение: " + array[i][j]);
                }
            }
        }

        List<Exception> exceptions = new ArrayList<>(); // Список для хранения исключений

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int number = Integer.parseInt(array[i][j]); // Мы уверены, что это число, т.к. проверили раньше
                if (number < 100 || number > 999 || !isPrime(number)) {
                    exceptions.add(new MyNoSimpleException("Число в ячейке [" + i + "][" + j + "] не является простым трёхзначным числом: " + number));
                } else {
                    sum += number; // Добавляем к сумме только корректные числа
                }
            }
        }

        if (!exceptions.isEmpty()) {
            for (Exception e : exceptions) {
                e.printStackTrace();
            }
            throw new MyNoSimpleException("Найдены неправильные числа.");
        }

        return sum;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}