package org.example;

public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"101", "103", "107", "109"},
                {"113", "12", "9", "137"},
                {"139", "149", "151", "157"},
                {"163", "167", "173","12g"}
        };

        try {
            int sum = ArrayProcessor.processArray(array);
            System.out.println("Сумма элементов: " + sum);
        } catch (MyArraySizeException | MyArrayDataException | MyNoSimpleException e) {
            e.printStackTrace();
        }
    }
}