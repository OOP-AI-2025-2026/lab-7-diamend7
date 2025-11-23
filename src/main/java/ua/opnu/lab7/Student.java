package ua.opnu.list;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Comparator;

public class SortingList extends Application {

    // ... (поля та методи start, populateList) ...
    private ObservableList<Student> students;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // ... (код методу start) ...
    }

    private ObservableList<Student> populateList() {
        // ... (код методу populateList) ...
        Student student1 = new Student("Борис", "Іванов", 75);
        Student student2 = new Student("Петро", "Петренко", 92);
        Student student3 = new Student("Сергій", "Сергієнко", 61);
        Student student4 = new Student("Григорій", "Сковорода", 88);

        return FXCollections.observableArrayList(
                student1, student2, student3, student4);
    }


    /*
     * Налаштовуємо кнопки. ТУТ ВАШ КОД
     */
    private HBox setButtons() {
        // Кнопка JavaFX має клас Button
        final Button sortByNameButton = new Button("Сортувати за ім'ям");
        final Button sortByLastNameButton = new Button("Сортувати за прізвищем");
        final Button sortByMarkButton = new Button("Сортувати за оцінкою");

        // Блок коду нижче дозволяє кнопкам розтягуватися завширшки...
        HBox.setHgrow(sortByNameButton, Priority.ALWAYS);
        HBox.setHgrow(sortByLastNameButton, Priority.ALWAYS);
        HBox.setHgrow(sortByMarkButton, Priority.ALWAYS);
        sortByNameButton.setMaxWidth(Double.MAX_VALUE);
        sortByLastNameButton.setMaxWidth(Double.MAX_VALUE);
        sortByMarkButton.setMaxWidth(Double.MAX_VALUE);

        // --- Реалізація бонусного завдання: окремий стан для кожної кнопки ---

        final boolean[] nameOrder = {true}; // Пряме сортування за замовчуванням
        final boolean[] lastNameOrder = {true};
        final boolean[] markOrder = {true};


        // Обробка натискання кнопки "Сортувати за ім'ям" (Оновлено для nameOrder)
        sortByNameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                students.sort(new NameSorter(nameOrder[0]));
                nameOrder[0] = !nameOrder[0]; // Змінюємо порядок для наступного кліка
            }
        });

        // ✅ Обробка натискання на кнопку "Сортувати за прізвищем"
        sortByLastNameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                students.sort(new LastNameSorter(lastNameOrder[0]));
                lastNameOrder[0] = !lastNameOrder[0]; // Змінюємо порядок
            }
        });

        // ✅ Обробка натискання на кнопку "Сортувати за оцінкою"
        sortByMarkButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                students.sort(new AvgMarkSorter(markOrder[0]));
                markOrder[0] = !markOrder[0]; // Змінюємо порядок
            }
        });

        // Створюємо горизонтальний ряд
        HBox hb = new HBox();
        // Відстань між елементами ряду
        hb.setSpacing(5);
        // Додаємо до ряду елементи. У нашому випадку – кнопки
        hb.getChildren().addAll(sortByNameButton, sortByLastNameButton, sortByMarkButton);
        // Говоримо, що елементи в ряді мають бути вирівняні по центру
        hb.setAlignment(Pos.CENTER);

        return hb;
    }

    public static void main(String[] args) {
        // Метод запускає додаток
        launch(args);
    }
}