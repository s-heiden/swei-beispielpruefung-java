package BIF.SWE2.exam;

import BIF.SWE2.exam.interfaces.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class Exercise3ImplTest {

    public Exercise3ImplTest() {
    }

    @Test
    public void test_4_1() {
        System.out.println("test_4_1");
        boolean thrown;

        Exercise3Impl instance = new Exercise3Impl();

        Factory factory = (Factory) instance.method1(0, null, null);

        // check if an exception is thrown if a value other than 1 or 2 is provided
        thrown = false;
        try {
            factory.create(0);
        } catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);

        thrown = false;
        try {
            factory.create(3);
        } catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);

        // check if classes are created by factory
        assertNotNull(factory.create(1));
        assertNotNull(factory.create(2));

        // check if two distinctive classes are created when 1 and 2 are provided as types
        assertNotEquals(factory.create(1).getClass(), factory.create(2).getClass());

        // check if the factory creates classes that implement Store
        assertTrue(factory.create(1) instanceof Store && factory.create(2) instanceof Store);
    }

}
