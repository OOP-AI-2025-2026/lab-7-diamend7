package ua.opnu.Task2;

import java.util.Arrays;
import java.util.function.Predicate;

// Завдання 2: Фільтрація студентів
public class StudentFilter {
    
    // Метод фільтрації масиву студентів
    public static Student[] filter(Student[] students, Predicate<Student> predicate) {
        Student[] result = new Student[students.length];
        int count = 0;
        
        for (Student student : students) {
            if (predicate.test(student)) {
                result[count++] = student;
            }
        }
        
        return Arrays.copyOf(result, count);
    }
    
    public static void main(String[] args) {
        // Створення масиву студентів
        Student[] students = {
            new Student("Іванов Іван", "ІП-21", new int[]{85, 90, 78, 92}),
            new Student("Петров Петро", "ІП-21", new int[]{45, 55, 60, 50}),
            new Student("Сидоров Сидір", "ІП-22", new int[]{95, 88, 92, 90}),
            new Student("Коваленко Олена", "ІП-22", new int[]{30, 45, 55, 40})
        };
        
        // Предикат для студентів з заборгованостями (оцінка < 60)
        Predicate<Student> hasDebts = student -> {
            for (int mark : student.getMarks()) {
                if (mark < 60) return true;
            }
            return false;
        };
        
        System.out.println("Всі студенти:");
        for (Student student : students) {
            System.out.println(student);
        }
        
        System.out.println("\nСтуденти з заборгованостями:");
        Student[] studentsWithDebts = filter(students, hasDebts);
        for (Student student : studentsWithDebts) {
            System.out.println(student);
        }
    }
}