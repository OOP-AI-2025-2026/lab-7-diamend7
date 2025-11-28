package ua.opnu;

import ua.opnu.Task1.PrimeNumberPredicate;
import ua.opnu.Task2.StudentFilter;
import ua.opnu.Task3.DoubleFilter;
import ua.opnu.Task4.StudentConsumer;
import ua.opnu.Task5.ConditionalConsumer;
import ua.opnu.Task6.PowerFunction;
import ua.opnu.Task7.StringifyNumbers;

// Головний клас для демонстрації всіх завдань
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Лабораторна робота 7: Лямбда-вирази ===\n");
        
        System.out.println("--- Завдання 1: Предикат для простих чисел ---");
        PrimeNumberPredicate.main(args);
        
        System.out.println("\n--- Завдання 2: Фільтрація студентів ---");
        StudentFilter.main(args);
        
        System.out.println("\n--- Завдання 3: Фільтрація за двома умовами ---");
        DoubleFilter.main(args);
        
        System.out.println("\n--- Завдання 4: Consumer для студентів ---");
        StudentConsumer.main(args);
        
        System.out.println("\n--- Завдання 5: Predicate + Consumer ---");
        ConditionalConsumer.main(args);
        
        System.out.println("\n--- Завдання 6: Function для степеня 2 ---");
        PowerFunction.main(args);
        
        System.out.println("\n--- Завдання 7: Stringify функція ---");
        StringifyNumbers.main(args);
    }
}