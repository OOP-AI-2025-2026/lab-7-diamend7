package ua.opnu.Task7;

import java.util.Arrays;
import java.util.function.Function;

// Завдання 7: Stringify метод з Function
public class StringifyNumbers {
    

    public static String[] stringify(int[] numbers, Function<Integer, String> converter) {
        String[] result = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            result[i] = converter.apply(numbers[i]);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // Function для перетворення цифр у слова
        Function<Integer, String> digitToWord = digit -> {
            String[] words = {"нуль", "один", "два", "три", "чотири", 
                            "п'ять", "шість", "сім", "вісім", "дев'ять"};
            
            if (digit >= 0 && digit <= 9) {
                return words[digit];
            } else {
                return "невідоме число";
            }
        };
        
        // Створення array з цифр від 0 до 9
        int[] digits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        System.out.println("Початковий масив: " + Arrays.toString(digits));
        
        String[] words = stringify(digits, digitToWord);
        System.out.println("Цифри словами: " + Arrays.toString(words));
        
        // Додатковий приклад з випадковими цифрами
        int[] randomDigits = {3, 7, 1, 9, 0, 5, 2, 8, 4, 6};
        String[] randomWords = stringify(randomDigits, digitToWord);
        
        System.out.println("\nВипадкові цифри: " + Arrays.toString(randomDigits));
        System.out.println("Випадкові цифри словами: " + Arrays.toString(randomWords));
    }
}