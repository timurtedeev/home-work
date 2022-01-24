package com.sbrf.reboot.equalshashcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class EqualsHashCodeTest {

    class Car {
        String model;
        String color;
        Calendar releaseDate;
        int maxSpeed;

        @Override
        public boolean equals(Object o) {
            //В первую проверяем ссылки сравниваемых объектов и если они равны, то сразу возвращаем true
            if (o == this) {
                return true;
            }
            //Проверим не является ли ссылка null
            if (o == null) {
                return false;
            }
            //Сравниваем типы объектов
            if (o.getClass() != getClass()) {
                return false;
            }
            //Преобразуем тип параметра к нашему классу (Car)
            Car car = (Car) o;
            //В этом выражении мы сравниваем все значимые поля объектов и если хоть одно поле не равно, вернется false
            return Objects.equals(model, car.model) &&
                    Objects.equals(color, car.color) &&
                    Objects.equals(releaseDate, car.releaseDate) &&
                    maxSpeed == car.maxSpeed;
        }

        @Override
        public int hashCode() {
            return model.hashCode() *
                    color.hashCode() *
                    releaseDate.hashCode() *
                    maxSpeed;
        }
    }

    @Test
    public void assertTrueEquals() {
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, 0, 25);
        car1.maxSpeed = 10;

        Car car2 = new Car();
        car2.model = "Mercedes";
        car2.color = "black";
        car2.releaseDate = new GregorianCalendar(2020, 0, 25);
        car2.maxSpeed = 10;


        Assertions.assertTrue(car1.equals(car2));
    }

    @Test
    public void assertFalseEquals() {
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, 0, 25);
        car1.maxSpeed = 10;

        Car car2 = new Car();
        car2.model = "Audi";
        car2.color = "white";
        car2.releaseDate = new GregorianCalendar(2017, 0, 25);
        car2.maxSpeed = 10;

        Assertions.assertFalse(car1.equals(car2));
    }

    @Test
    public void successEqualsHashCode() {
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, 0, 25);
        car1.maxSpeed = 10;

        Car car2 = new Car();
        car2.model = "Mercedes";
        car2.color = "black";
        car2.releaseDate = new GregorianCalendar(2020, 0, 25);
        car2.maxSpeed = 10;

        Assertions.assertEquals(car1.hashCode(), car2.hashCode());

    }

    @Test
    public void failEqualsHashCode() {
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, 0, 25);
        car1.maxSpeed = 10;

        Car car2 = new Car();
        car2.model = "Audi";
        car2.color = "white";
        car2.releaseDate = new GregorianCalendar(2017, 0, 25);
        car2.maxSpeed = 10;

        Assertions.assertNotEquals(car1.hashCode(), car2.hashCode());

    }

    class Sportsman {
        int age;
        int weight;
        String name;
        String sportName;

        public Sportsman(String name, int age, int weight, String sportName) {
            this.age = age;
            this.weight = weight;
            this.name = name;
            this.sportName = sportName;
        }

        /* Мой пример
         *
         * В этом примере я переопределил метод equals таким орбразом, что бы сравнивать только по полям:
         * age, weight
         * У нас проходят соревнования и надо подобрать пары для схваток по: весу и возрасту.
         * Необходимо проверять кто подходит по возрасту и весовой категории
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Sportsman sportsman = (Sportsman) o;
            return age == sportsman.age &&
                    Objects.equals(weight, sportsman.weight);
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, weight);
        }
    }

    @Test
    public void successEqualsHashCodeSportsmens() {
        Sportsman sportsman1 = new Sportsman("Григорий", 18, 50, "Вольная Борьба");
        Sportsman sportsman2 = new Sportsman("Олег", 18, 50, "Вольная Борьба");

        Assertions.assertTrue(sportsman1.equals(sportsman2));
    }

    @Test
    public void failEqualsHashCodeSportsmens() {
        Sportsman sportsman1 = new Sportsman("Александр", 21, 50, "Вольная Борьба");
        Sportsman sportsman2 = new Sportsman("Юрий", 30, 84, "Вольная Борьба");

        Assertions.assertFalse(sportsman1.equals(sportsman2));
    }

    @Test
    public void successEqualsSportsmens() {
        Sportsman sportsman1 = new Sportsman("Григорий", 18, 50, "Вольная Борьба");
        Sportsman sportsman2 = new Sportsman("Олег", 18, 50, "Вольная Борьба");

        Assertions.assertEquals(sportsman1.hashCode(), sportsman2.hashCode());
    }

    @Test
    public void failEqualsSportsmens() {
        Sportsman sportsman1 = new Sportsman("Александр", 21, 50, "Вольная Борьба");
        Sportsman sportsman2 = new Sportsman("Юрий", 30, 84, "Вольная Борьба");

        Assertions.assertNotEquals(sportsman1.hashCode(), sportsman2.hashCode());
    }
}
