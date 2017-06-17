package BIF.SWE2.exam;

import BIF.SWE2.exam.interfaces.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class Exercise5ImplTest {

    public Exercise5ImplTest() {
    }

    @Test
    public void test_6_1() {
        System.out.println("test_6_1");

        Exercise5Impl instance = new Exercise5Impl();

        Car[] cars = {
            new Car("Mercedes", "SLK", 130),
            new Car("Audi", "R8", 360),
            new Car("Audi", "A3", 120),
            new Car("Opel", "Vectra", 60),
            new Car("Ford", "Ka", 75),
            new Car("Fiat", "Cinquecento", 45),
            new Car("Fiat", "Punto", 40)
        };

        List<Car> result = (List<Car>) instance.method1(0, null, Arrays.asList(cars));

        List<Car> expected = new ArrayList<Car>();
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getBrand().equalsIgnoreCase("BMW")) {
                expected.add(cars[i]);
            }
        }

        assertEquals(expected, result);

        Car[] carsWithBMWs = {
            new Car("Mercedes", "SLK", 130),
            new Car("Audi", "R8", 360),
            new Car("Audi", "A3", 120),
            new Car("Opel", "Vectra", 60),
            new Car("Ford", "Ka", 75),
            new Car("Fiat", "Cinquecento", 45),
            new Car("Fiat", "Punto", 40),
            new Car("BMW", "i8 Spyder", 200),
            new Car("BMW", "M2", 90),
            new Car("BMW", "Z4", 115)
        };

        result = (List<Car>) instance.method1(0, null, Arrays.asList(carsWithBMWs));

        expected = new ArrayList<>();
        for (Car c : carsWithBMWs) {
            if (c.getBrand().equalsIgnoreCase("BMW")) {
                expected.add(c);
            }
        }

        assertEquals(expected, result);
    }

    @Test
    public void test_6_2() {
        System.out.println("test_6_2");

        Exercise5Impl instance = new Exercise5Impl();

        // checking if the correct List<Car> is returned if some matches were found
        Car[] input = {
            new Car("Mercedes", "SLK", 100),
            new Car("Audi", "R8", 360),
            new Car("Opel", "Vectra", 99),
            new Car("Ford", "Ka", 75),
            new Car("Fiat", "Cinquecento", 45),
            new Car("Fiat", "Punto", 40),
            new Car("Audi", "A3", 120)
        };
        Car[] expected = {
            new Car("Mercedes", "SLK", 100),
            new Car("Audi", "R8", 360),
            new Car("Audi", "A3", 120)
        };

        List<Car> result = (List<Car>) instance.method2(0, null, Arrays.asList(input));

        assertEquals(result.size(), 3);

        for (int i = 0; i < result.size(); i++) {
            if (!result.get(i).getBrand().equals(expected[i].getBrand())
                    || !result.get(i).getModel().equals(expected[i].getModel())
                    || result.get(i).getHorsePower() != expected[i].getHorsePower()) {
                Assert.fail();
            }
        }

        // checking if an empty List<Car> is returned if nothing was found
        Car[] input2 = {
            new Car("Mercedes", "SLK", 99),
            new Car("Audi", "R8", 99),
            new Car("Opel", "Vectra", 99),
            new Car("Ford", "Ka", 75),
            new Car("Fiat", "Cinquecento", 45),
            new Car("Fiat", "Punto", 40),
            new Car("Audi", "A3", 99)
        };

        List<Car> result2 = (List<Car>) instance.method2(0, null, Arrays.asList(input2));

        assertEquals(result2.size(), 0);

    }

    @Test
    public void test_6_3() {
        System.out.println("test_6_3");

        Exercise5Impl instance = new Exercise5Impl();

        // checking if the correct number is returned
        Car[] input = {
            new Car("Mercedes", "SLK", 99),
            new Car("Audi", "R8", 50),
            new Car("Opel", "Vectra", 99),
            new Car("Ford", "Ka", 75),
            new Car("Fiat", "Cinquecento", 49),
            new Car("Fiat", "Punto", 47),
            new Car("Audi", "A3", 100)
        };
        Integer count = (Integer) instance.method3(0, null, Arrays.asList(input));
        assertEquals(count.intValue(), 3);
    }

}
