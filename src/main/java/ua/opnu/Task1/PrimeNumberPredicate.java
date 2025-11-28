package ua.opnu.Task1;

import java.util.function.Predicate;

// Завдання 1: Предикат для перевірки простих чисел
public class PrimeNumberPredicate {
    
    public static void main(String[] args) {
        // Предикат для перевірки простих чисел
        Predicate<Integer> isPrime = n -> {
            if (n <= 1) return false;
            if (n <= 3) return true;
            if (n % 2 == 0 || n % 3 == 0) return false;
            
            for (int i = 5; i * i <= n; i += 6) {
                if (n % i == 0 || n % (i + 2) == 0) {
                    return false;
                }
            }
            return true;
        };
        
        // Тестування
        int[] numbers = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 17, 19, 20};
        
        System.out.println("Перевірка простих чисел:");
        for (int num : numbers) {
            System.out.println(num + " є простим: " + isPrime.test(num));
        }
    }
}