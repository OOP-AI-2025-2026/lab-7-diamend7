package ua.opnu.list;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SortingList extends Application {

    private ObservableList<Student> students;

    @Override
    public void start(Stage primaryStage) throws Exception {
        students = populateList();

        ListView<Student> list = new ListView<>(students);
        HBox buttons = setButtons();

        VBox root = new VBox();
        root.getChildren().addAll(list, buttons);
        
        // Дозволяємо списку займати весь вільний простір
        VBox.setVgrow(list, Priority.ALWAYS);

        Scene scene = new Scene(root, 450, 300);
        primaryStage.setTitle("Student Sorting (Lambda)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private ObservableList<Student> populateList() {
        // Створюємо студентів згідно з вашим конструктором (Name, LastName, AvgMark)
        return FXCollections.observableArrayList(
                new Student("Борис", "Іванов", 75.5),
                new Student("Петро", "Петренко", 92.0),
                new Student("Сергій", "Сергієнко", 61.3),
                new Student("Григорій", "Сковорода", 88.8),
                new Student("Андрій", "Андрієнко", 75.0)
        );
    }

    /*
     * РЕФАКТОРИНГ: Використання лямбда-виразів з вашим класом Student
     */
    private HBox setButtons() {
        final Button sortByNameButton = new Button("Сортувати за ім'ям");
        final Button sortByLastNameButton = new Button("Сортувати за прізвищем");
        final Button sortByMarkButton = new Button("Сортувати за балом");

        // Налаштування вигляду кнопок
        HBox.setHgrow(sortByNameButton, Priority.ALWAYS);
        HBox.setHgrow(sortByLastNameButton, Priority.ALWAYS);
        HBox.setHgrow(sortByMarkButton, Priority.ALWAYS);
        sortByNameButton.setMaxWidth(Double.MAX_VALUE);
        sortByLastNameButton.setMaxWidth(Double.MAX_VALUE);
        sortByMarkButton.setMaxWidth(Double.MAX_VALUE);

        // Прапорці для відстеження напрямку сортування (true - зростання, false - спадання)
        final boolean[] nameOrder = {true};
        final boolean[] lastNameOrder = {true};
        final boolean[] markOrder = {true};

        // 1. Сортування за Ім'ям (getName)
        sortByNameButton.setOnAction(event -> {
            students.sort((s1, s2) -> {
                if (nameOrder[0]) {
                    return s1.getName().compareTo(s2.getName());
                } else {
                    return s2.getName().compareTo(s1.getName());
                }
            });
            nameOrder[0] = !nameOrder[0]; // змінюємо напрямок наступного сортування
        });

        // 2. Сортування за Прізвищем (getLastName)
        sortByLastNameButton.setOnAction(event -> {
            students.sort((s1, s2) -> {
                if (lastNameOrder[0]) {
                    return s1.getLastName().compareTo(s2.getLastName());
                } else {
                    return s2.getLastName().compareTo(s1.getLastName());
                }
            });
            lastNameOrder[0] = !lastNameOrder[0];
        });

        // 3. Сортування за Середнім балом (getAvgMark - double)
        sortByMarkButton.setOnAction(event -> {
            students.sort((s1, s2) -> {
                // Використовуємо Double.compare для коректного порівняння дробових чисел
                if (markOrder[0]) {
                    return Double.compare(s1.getAvgMark(), s2.getAvgMark());
                } else {
                    return Double.compare(s2.getAvgMark(), s1.getAvgMark());
                }
            });
            markOrder[0] = !markOrder[0];
        });

        HBox hb = new HBox();
        hb.setSpacing(5);
        hb.getChildren().addAll(sortByNameButton, sortByLastNameButton, sortByMarkButton);
        hb.setAlignment(Pos.CENTER);

        return hb;
    }

    public static void main(String[] args) {
        launch(args);
    }
}