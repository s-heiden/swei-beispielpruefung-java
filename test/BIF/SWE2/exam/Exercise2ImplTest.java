
package BIF.SWE2.exam;

import BIF.SWE2.exam.interfaces.Car;
import BIF.SWE2.exam.interfaces.CarBL;
import BIF.SWE2.exam.interfaces.CarDAL;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Exercise2ImplTest {
    
    public Exercise2ImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
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
        for (Car c : cars) { carDAL.SaveCar(c); }
        
        List<Car> ret1 = carDAL.GetCars("Audi", null);
        assertEquals(ret1.size(), 2);
        
        List<Car> ret2 = carDAL.GetCars("Opel", "");
        assertEquals(ret2.size(), 1);
        
        List<Car> ret3 = carDAL.GetCars(null, "A3");
        assertEquals(ret3.size(), 1);
        
        List<Car> ret4 = carDAL.GetCars("", "A3");
        assertEquals(ret4.size(), 1);
        
        List<Car> ret5 = carDAL.GetCars("Fiat", "Ka");
        assertEquals(ret5.size(), 0);
        
        List<Car> ret6 = carDAL.GetCars("Opel", "Vectra");
        assertEquals(ret6.size(), 1);
    }

    @Test
    public void test_3_2() {
        System.out.println("test_3_2");
        Exercise2Impl instance = new Exercise2Impl();

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
        for (Car c : cars) { carDAL.SaveCar(c); }
        
        
        CarBL carBL = (CarBL) instance.method2(0, null, null);
        carBL.setDAL(carDAL);
        
        // test if an exception is thrown by getCars, getCar, and saveCar if no brand is set
        boolean thrown = false;

        try {
          carBL.getCars();
        } catch (Exception e) {
          thrown = true;
        }
        assertTrue(thrown);
        
        try {
          carBL.getCar("Vectra");
        } catch (Exception e) {
          thrown = true;
        }
        assertTrue(thrown);
        
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
        assertEquals(carBL.getCars().size(), 2);
        assertEquals(carBL.getCar("R8").getHorsePower(), 360);
        
        // test if an empty List<Car> is returned if we search for a non existing brand in getCars()
        carBL.setCurrentBrand("Peugeot");
        assertEquals(carBL.getCars().size(), 0);
        
        // test if null is returned by getCar(String model) if no such model is saved for current brand
        carBL.setCurrentBrand("Peugeot");
        assertNull(carBL.getCar("206"));
        
        // test if cars can be saved and found again
        carBL.setCurrentBrand("VW");
        carBL.saveCar(new Car("VW", "Golf 2", 65));
        assertEquals(carBL.getCar("Golf 2").getBrand(), "VW");
        assertEquals(carBL.getCar("Golf 2").getModel(), "Golf 2");
        assertEquals(carBL.getCar("Golf 2").getHorsePower(), 65);
        
    }
    
}
