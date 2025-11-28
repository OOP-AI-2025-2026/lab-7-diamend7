package ua.opnu.Task4;

import ua.opnu.Task2.Student;
import java.util.function.Consumer;

// Завдання 4: Consumer для студентів
public class StudentConsumer {
    
    // Метод forEach для масиву студентів
    public static void forEach(Student[] students, Consumer<Student> action) {
        for (Student student : students) {
            action.accept(student);
        } 
    }
    
    public static void main(String[] args) {
        // Створення масиву студентів
        Student[] students = {
            new Student("Іванов Іван", "ІП-21", new int[]{85, 90, 78}),
            new Student("Петрова Марія", "ІП-22", new int[]{92, 88, 95}),
            new Student("Сидоренко Олег", "ІП-21", new int[]{76, 82, 79})
        };
        
        // Consumer для виводу прізвища та імені
        Consumer<Student> printFullName = student -> {
            String[] nameParts = student.getName().split(" ");
            if (nameParts.length >= 2) {
                System.out.println(nameParts[0] + " " + nameParts[1]);
            } else {
                System.out.println(student.getName());
            }
        };
        
        System.out.println("Прізвища та імена студентів:");
        forEach(students, printFullName);
        
        // Додатковий Consumer для виводу повної інформації
        Consumer<Student> printFullInfo = student -> 
            System.out.println("Студент: " + student.getName() + ", група: " + student.getGroup());
        
        System.out.println("\nПовна інформація про студентів:");
        forEach(students, printFullInfo);
    }
}