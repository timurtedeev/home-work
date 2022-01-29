package com.sbrf.reboot.concurrentmodify;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RemoveElementWithoutErrorsTest {

    @Test
    public void successConcurrentModificationException() {

        List<Integer> list = new ArrayList() {{
            add(1);
            add(2);
            add(3);
        }};

        assertThrows(ConcurrentModificationException.class, () -> {

            for (Integer integer : list) {
                list.remove(1);
            }

        });

    }

    @Test
    public void successRemoveElementWithoutErrors() {

        List<Integer> list = new ArrayList() {{
            add(1);
            add(2);
            add(3);
        }};

        list.removeIf(i -> i == 2);

        assertFalse(list.contains(2));
    }

    @Test
    public void successRemoveElementWithoutErrors2() {

        List<Integer> list = new ArrayList() {{
            add(1);
            add(2);
            add(3);
            add(4);
        }};

        List<Integer> result = new ArrayList<>();

        for (Integer i : list) {
            if (i != 2) {
                result.add(i);
            }
        }

        assertFalse(result.contains(2));
    }


    @Test
    public void successRemoveElementWithoutErrors3() {

        List<Integer> list = new ArrayList() {{
            add(1);
            add(2);
            add(3);
            add(4);
        }};

        List<Integer> listCopy = new ArrayList<>(list);

        for (Integer i : listCopy) {
            if (i == 2) {
                list.remove(i);
            }
        }

        assertFalse(list.contains(2));
    }

    @Test
    public void successRemoveElementWithoutErrors4() {

        List<Integer> list = new ArrayList() {{
            add(1);
            add(2);
            add(3);
            add(4);
        }};

        List<Integer> result = list.stream().filter(i -> i != 2).collect(Collectors.toList());

        assertFalse(result.contains(2));
    }
}
