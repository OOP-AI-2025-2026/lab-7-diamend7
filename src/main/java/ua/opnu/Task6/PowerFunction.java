package ua.opnu.Task6;

import java.util.Arrays;
import java.util.function.Function;

// Завдання 6: Function для обчислення 2^n
public class PowerFunction {
    
    // Метод для обробки масиву за допомогою Function
    public static int[] processArray(int[] input, Function<Integer, Integer> function) {
        int[] result = new int[input.length];
        
        for (int i = 0; i < input.length; i++) {
            result[i] = function.apply(input[i]);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // Function для обчислення 2^n
        Function<Integer, Integer> powerOf2 = n -> (int) Math.pow(2, n);
        
        // Створення масиву з 10 цілих чисел
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        System.out.println("Початковий масив: " + Arrays.toString(numbers));
        
        int[] powers = processArray(numbers, powerOf2);
        System.out.println("Степені двійки (2^n): " + Arrays.toString(powers));
        
        // Додатковий приклад з іншою функцією
        Function<Integer, Integer> cube = n -> n * n * n;
        int[] cubes = processArray(numbers, cube);
        System.out.println("Куби чисел (n³): " + Arrays.toString(cubes));
    }
}