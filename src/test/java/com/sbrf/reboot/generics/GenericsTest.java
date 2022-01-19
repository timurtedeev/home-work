package com.sbrf.reboot.generics;

import com.sbrf.reboot.homework5.City;
import com.sbrf.reboot.homework5.Region;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GenericsTest {

    class MoscowRegion extends Region<City> {
    }

    class TverRegion extends Region<City> {
    }

    @Test
    void testGetCity() {
        ArrayList<City> moscowRegion = new ArrayList<>();
        moscowRegion.add(new City("Балашиха"));
        moscowRegion.add(new City("Дубна"));
        moscowRegion.add(new City("Звенигород"));


        ArrayList<City> tverRegion = new ArrayList<>();
        tverRegion.add(new City("Тверь"));
        tverRegion.add(new City("Ржев"));
        tverRegion.add(new City("Кимры"));
        tverRegion.add(new City("Торжок"));


        Assertions.assertEquals(3, moscowRegion.size());
        Assertions.assertEquals(4, tverRegion.size());
    }
}
