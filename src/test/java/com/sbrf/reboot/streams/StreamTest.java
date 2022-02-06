package com.sbrf.reboot.streams;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamTest {

    /*
     * Отсортируйте коллекцию integers по возрастанию. Используйте Stream.
     */
    @Test
    public void sortedListStream() {
        List<Integer> integers = Arrays.asList(6, 9, 8, 3);

        List<Integer> expectedIntegers = Arrays.asList(3, 6, 8, 9);

        List<Integer> actualIntegers = integers.stream().sorted().collect(Collectors.toList());

        assertEquals(expectedIntegers, actualIntegers);
    }

    /*
     * Отфильтруйте коллекцию integers.
     * В коллекции должны остаться только те числа, которые делятся без остатка на 2.  Используйте Stream.
     */
    @Test
    public void filteredListStream() {
        List<Integer> integers = Arrays.asList(6, 9, 8, 3);

        List<Integer> expectedIntegers = Arrays.asList(6, 8);

        List<Integer> actualIntegers = integers.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());

        assertEquals(expectedIntegers, actualIntegers);

    }

    /*
     * Отфильтруйте и отсортируйте коллекцию books.
     * Получите коллекцию, в которой будут только книги от автора "Maria", отсортированные по цене.
     * Используйте Stream.
     */
    @AllArgsConstructor
    @EqualsAndHashCode
    @Getter
    class Book {
        private String name;
        private String author;
        private BigDecimal price;
    }

    @Test
    public void sortedAndFilteredBooks() {
        List<Book> books = Arrays.asList(
                new Book("Trees", "Maria", new BigDecimal(900)),
                new Book("Animals", "Tom", new BigDecimal(500)),
                new Book("Cars", "John", new BigDecimal(200)),
                new Book("Birds", "Maria", new BigDecimal(100)),
                new Book("Flowers", "Tom", new BigDecimal(700))

        );
        List<Book> expectedBooks = Arrays.asList(
                new Book("Birds", "Maria", new BigDecimal(100)),
                new Book("Trees", "Maria", new BigDecimal(900))

        );

        List<Book> actualBooks = books
                .stream().filter(i -> i.getAuthor().equals("Maria"))
                .sorted(Comparator.comparing(Book::getPrice))
                .collect(Collectors.toList());

        assertEquals(expectedBooks, actualBooks);

    }

    /*
     * Получите измененную коллекцию contracts.
     * Получите коллекцию, в которой будет тот же набор строк, только у каждой строки появится префикс "M-".
     * Используйте Stream.
     */
    @Test
    public void modifiedList() {
        List<String> contracts = Arrays.asList("NCC-1-CH", "NCC-2-US", "NCC-3-NH");

        List<String> expectedContracts = Arrays.asList("M-NCC-1-CH", "M-NCC-2-US", "M-NCC-3-NH");

        List<String> actualContracts = contracts.stream().map(s -> "M-" + s).collect(Collectors.toList());
        assertEquals(expectedContracts, actualContracts);

    }

    //Среднее значиние - average()
    //Сумма - sum()
    @Test
    public void integerList() {
        List<Integer> list = Arrays.asList(11, 13, 2, 5, 7, 10);

        int sum = 48;
        double average = 8.0;

        OptionalDouble resultAverage = list.stream().mapToInt((s) -> s).average();
        int resultSum = list.stream().mapToInt((s) -> s).sum();

        assertEquals(sum, resultSum);
        assertEquals(average, resultAverage.orElse(-1));
    }

    // Удаляем повторяюиеся элементы - distinct()
    // Пропускаем первый элемент - skip(1)
    // Берем первые 3 элемента - limit(3)
    @Test
    public void charTest() {
        List<String> list = Arrays.asList("1","2","2","3","3","4","5","6");

        List<String> result = Arrays.asList("2","3","4");

        List<String> newList = list.stream().distinct().skip(1).limit(3).collect(Collectors.toList());


        assertEquals(result,newList);
    }

}
