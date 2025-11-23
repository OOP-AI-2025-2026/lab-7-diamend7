package ua.opnu.lab7;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lab7 {

    public static void main(String[] args) {
        // --- Завдання 1: Предикат на просте число ---
        System.out.println("--- Task 1: Prime Number ---");
        Predicate<Integer> isPrime = n -> {
            if (n <= 1) return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        };
        System.out.println("Is 5 prime? " + isPrime.test(5)); // true
        System.out.println("Is 4 prime? " + isPrime.test(4)); // false

        // --- Підготовка даних для Завдань 2-4 ---
        Student[] students = {
                new Student("Ivanov", "IPZ-21", new int[]{90, 80, 100}),
                new Student("Petrov", "IPZ-21", new int[]{60, 55, 70}), // Є борг (<60)
                new Student("Sidorov", "KN-21", new int[]{100, 95, 99}),
                new Student("Kovalenko", "KN-21", new int[]{50, 30, 40}) // Є борги
        };

        // --- Завдання 2: Фільтрація студентів (боржники) ---
        System.out.println("\n--- Task 2: Filter Debtors ---");
        // Предикат: true, якщо хоча б одна оцінка < 60
        Predicate<Student> hasDebt = s -> {
            for (int mark : s.getMarks()) {
                if (mark < 60) return true;
            }
            return false;
        };
        
        Student[] debtors = filterStudents(students, hasDebt);
        for (Student s : debtors) {
            System.out.println(s);
        }

        // --- Завдання 3: Фільтрація за двома умовами ---
        System.out.println("\n--- Task 3: Two Predicates (Debt AND Group 'KN-21') ---");
        Predicate<Student> isKnGroup = s -> s.getGroup().equals("KN-21");
        
        // Використовуємо метод з двома предикатами
        Student[] knDebtors = filterStudentsTwoConditions(students, hasDebt, isKnGroup);
        for (Student s : knDebtors) {
            System.out.println(s);
        }

        // --- Завдання 4: Consumer ---
        System.out.println("\n--- Task 4: Consumer (Print Name) ---");
        Consumer<Student> printName = s -> System.out.println("Student: " + s.getName());
        forEachStudent(students, printName);

        // --- Завдання 5: Predicate + Consumer ---
        System.out.println("\n--- Task 5: Predicate + Consumer ---");
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // Вивести число, якщо воно парне
        processIf(numbers, 
                i -> i % 2 == 0,            // Predicate
                i -> System.out.print(i + " ") // Consumer
        );
        System.out.println();

        // --- Завдання 6: Function (2^n) ---
        System.out.println("\n--- Task 6: Function 2^n ---");
        Function<Integer, Integer> powerOfTwo = n -> (int) Math.pow(2, n);
        int[] powersInput = {1, 2, 3, 4};
        int[] powersResult = processArray(powersInput, powerOfTwo);
        System.out.println(Arrays.toString(powersResult));

        // --- Завдання 7: Stringify ---
        System.out.println("\n--- Task 7: Stringify ---");
        Function<Integer, String> numberToString = n -> {
            switch (n) {
                case 0: return "нуль";
                case 1: return "один";
                case 2: return "два";
                case 3: return "три";
                case 4: return "чотири";
                case 5: return "п'ять";
                case 6: return "шість";
                case 7: return "сім";
                case 8: return "вісім";
                case 9: return "дев'ять";
                default: return "невідомо";
            }
        };
        int[] digits = {1, 5, 9, 0};
        String[] stringified = stringify(digits, numberToString);
        System.out.println(Arrays.toString(stringified));
    }

    // --- Методи для завдань ---

    // Метод для Завдання 2
    public static Student[] filterStudents(Student[] input, Predicate<Student> p) {
        Student[] temp = new Student[input.length];
        int count = 0;
        for (Student s : input) {
            if (p.test(s)) {
                temp[count++] = s;
            }
        }
        return Arrays.copyOf(temp, count);
    }

    // Метод для Завдання 3
    public static Student[] filterStudentsTwoConditions(Student[] input, Predicate<Student> p1, Predicate<Student> p2) {
        // Об'єднуємо два предикати через and()
        return filterStudents(input, p1.and(p2));
    }

    // Метод для Завдання 4
    public static void forEachStudent(Student[] input, Consumer<Student> action) {
        for (Student s : input) {
            action.accept(s);
        }
    }

    // Метод для Завдання 5
    public static void processIf(int[] input, Predicate<Integer> p, Consumer<Integer> c) {
        for (int i : input) {
            if (p.test(i)) {
                c.accept(i);
            }
        }
    }

    // Метод для Завдання 6
    public static int[] processArray(int[] input, Function<Integer, Integer> function) {
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = function.apply(input[i]);
        }
        return result;
    }

    // Метод для Завдання 7
    public static String[] stringify(int[] input, Function<Integer, String> function) {
        String[] result = new String[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = function.apply(input[i]);
        }
        return result;
    }
}