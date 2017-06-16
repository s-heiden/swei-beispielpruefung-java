
import BIF.SWE2.exam.interfaces.Car;
import java.util.List;

public interface CarDAL {
    /**
     * Returns all cars that match the given filter criteria. The filter of each
     * criteria is not applied if the given criteria is empty or null
     */
    List<Car> GetCars(String brand, String model);
    
    /**
     * Saves the car. Always adds the car to the collection.
     */
    void SaveCar(Car c);
}