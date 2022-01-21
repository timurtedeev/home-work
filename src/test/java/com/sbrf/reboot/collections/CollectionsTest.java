package com.sbrf.reboot.collections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionsTest {


    /*
     * Задача.
     * Имеется список лучших студентов вуза.
     *
     * 1. Иванов
     * 2. Петров
     * 3. Сидоров
     *
     * В новом семестре по результатам подсчетов оценок в рейтинг на 1 место добавился новый студент - Козлов.
     * Теперь в рейтинге участвуют 4 студента.
     * (Предполагаем что в рейтинг можно попасть только получив достаточное количество балов, что бы занять 1 место).
     *
     * Вопрос.
     * Какую коллекцию из Collections framework вы предпочтете для текущего хранения и использования списка студентов?
     *
     * Проинициализируйте students, добавьте в нее 4 фамилии студентов что бы тест завершился успешно.
     */
    @Test
    public void addStudentToRating() {

        List<String> students = new LinkedList<>();
        students.add("Козлов");
        students.add("Иванов");
        students.add("Петров");
        students.add("Сидоров");

        assertEquals(4, students.size());
    }

    /*
     * Задача.
     * Вы коллекционируете уникальные монеты.
     * У вас имеется специальный бокс с секциями, куда вы складываете монеты в хаотичном порядке.
     *
     * Вопрос.
     * Какую коллекцию из Collections framework вы предпочтете использовать для хранения монет в боксе.
     *
     * Проинициализируйте moneyBox, добавьте в нее 10 монет что бы тест завершился успешно.
     */
    @Test
    public void addMoneyToBox() {

        Set<Integer> moneyBox = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            moneyBox.add(i);
        }

        assertEquals(10, moneyBox.size());
    }

    /*
     * Задача.
     * Имеется книжная полка.
     * Периодически вы берете книгу для чтения, затем кладете ее на свое место.
     *
     * Вопрос.
     * Какую коллекцию из Collections framework вы предпочтете использовать для хранения книг.
     *
     * Проинициализируйте bookshelf, добавьте в нее 3 книги что бы тест завершился успешно.
     */
    @Test
    public void addBookToShelf() {
        class Book {
        }

        List<Book> bookshelf = new ArrayList<>();
        bookshelf.add(new Book());
        bookshelf.add(new Book());
        bookshelf.add(new Book());

        assertEquals(3, bookshelf.size());
    }

    /*
     * Задача.
     * В отделении Банка скапливается очередь к Окнам сотрудников.
     * Для решения проблемы поставили терминал,который выдает талоны к определенному Окну и экран, на котором указан порядок талонов.
     *
     * Какую коллекцию из Collections framework вы предпочтете использовать для правильного формирования очереди ?
     */

    @Test
    public void addBankQueue() {
        class People {
            String name;

            public People(String name) {
                this.name = name;
            }
        }
        Queue<People> bankQueue = new LinkedList<>();
        bankQueue.add(new People("Первый"));
        bankQueue.add(new People("Второй"));
        bankQueue.add(new People("Третий"));

        assertEquals(3, bankQueue.size());
    }


}
