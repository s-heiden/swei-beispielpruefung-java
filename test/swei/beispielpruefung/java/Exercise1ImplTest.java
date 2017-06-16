package swei.beispielpruefung.java;

import BIF.SWE2.exam.Exercise1Impl;
import BIF.SWE2.exam.interfaces.Car;
import BIF.SWE2.exam.interfaces.CarPresentationModel;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Exercise1ImplTest {
    
    
    public Exercise1ImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void test_2_1() {
        System.out.println("test_2_1");
        int i = 0;
        String str = "";
        Car obj = new Car("Peugeot", "207 SW", 90);
        Exercise1Impl instance = new Exercise1Impl();
        
        CarPresentationModel result = (CarPresentationModel) instance.method1(i, str, obj);
        
        assertEquals(90, result.getHorsePower());
        assertEquals("Peugeot", result.getBrand());
        assertEquals("207 SW", result.getModel());
        
        assertEquals("Peugeot 207 SW (90 PS)", result.getText());
        assertEquals("normal", result.getPowerClass());
        
        obj.setHorsePower(120);
        assertEquals("stark", result.getPowerClass());
        
        obj.setHorsePower(33);
        assertEquals("schwach", result.getPowerClass());
        
        obj.setBrand("Opel");
        obj.setModel("Corsa");
        obj.setHorsePower(50);
        assertEquals("Opel Corsa (50 PS)", result.getText());
                
    }
    
    
}
