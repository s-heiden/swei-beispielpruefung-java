package BIF.SWE2.exam;

import BIF.SWE2.exam.interfaces.*;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class Exercise2ImplTest {

    public Exercise2ImplTest() {
    }

    @Test
    public void test_3_1() {
        System.out.println("test_3_1");

        Exercise2Impl instance = new Exercise2Impl();
        CarDAL carDAL = (CarDAL) instance.method1(0, "", null);
        assertNotNull(carDAL);

        Car[] cars = {
            new Car("Mercedes", "SLK", 130),
            new Car("Audi", "R8", 360),
            new Car("Audi", "A3", 120),
            new Car("Opel", "Vectra", 60),
            new Car("Ford", "Ka", 75),
            new Car("Fiat", "Cinquecento", 45)
        };
        for (Car c : cars) {
            carDAL.saveCar(c);
        }

        List<Car> ret1 = carDAL.getCars("Audi", null);
        assertEquals(2, ret1.size());

        List<Car> ret2 = carDAL.getCars("Opel", "");
        assertEquals(1, ret2.size());

        List<Car> ret3 = carDAL.getCars(null, "A3");
        assertEquals(1, ret3.size());

        List<Car> ret4 = carDAL.getCars("", "A3");
        assertEquals(1, ret4.size());

        List<Car> ret5 = carDAL.getCars("Fiat", "Ka");
        assertEquals(0, ret5.size());

        List<Car> ret6 = carDAL.getCars("Opel", "Vectra");
        assertEquals(1, ret6.size());
    }

    @Test
    public void test_3_2() {
        System.out.println("test_3_2");
        Exercise2Impl instance = new Exercise2Impl();
        boolean thrown;

        CarDAL carDAL = (CarDAL) instance.method1(0, null, null);
        Car[] cars = {
            new Car("Mercedes", "SLK", 130),
            new Car("Audi", "R8", 360),
            new Car("Audi", "A3", 120),
            new Car("Opel", "Vectra", 60),
            new Car("Ford", "Ka", 75),
            new Car("Fiat", "Cinquecento", 45),
            new Car("Fiat", "Punto", 40)

        };
        for (Car c : cars) {
            carDAL.saveCar(c);
        }

        CarBL carBL = (CarBL) instance.method2(0, null, null);
        carBL.setDAL(carDAL);

        // test if an exception is thrown by getCars, getCar, and saveCar if no brand is set
        thrown = false;
        try {
            carBL.getCars();
        } catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);

        thrown = false;
        try {
            carBL.getCar("Vectra");
        } catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);

        thrown = false;
        try {
            carBL.saveCar(new Car("Audi", "A1", 100));
        } catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);

        // test if an exception is thrown by saveCar if the car does not belong to the current brand
        carBL.setCurrentBrand("Audi");
        try {
            carBL.saveCar(new Car("VW", "Polo", 60));
        } catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);

        // test if correct car/cars is returned by getCars() and getCar(String model)
        carBL.setCurrentBrand("Audi");
        assertEquals(2, carBL.getCars().size());
        assertEquals(360, carBL.getCar("R8").getHorsePower());

        // test if an empty List<Car> is returned if we search for a non existing brand in getCars()
        carBL.setCurrentBrand("Peugeot");
        assertEquals(0, carBL.getCars().size());

        // test if null is returned by getCar(String model) if no such model is saved for current brand
        carBL.setCurrentBrand("Peugeot");
        assertNull(carBL.getCar("206"));

        // test if cars can be saved and found again
        carBL.setCurrentBrand("VW");
        carBL.saveCar(new Car("VW", "Golf 2", 65));
        assertEquals("VW", carBL.getCar("Golf 2").getBrand());
        assertEquals("Golf 2", carBL.getCar("Golf 2").getModel());
        assertEquals(65, carBL.getCar("Golf 2").getHorsePower());

    }

}
