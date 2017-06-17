package BIF.SWE2.exam.interfaces;

import java.util.List;

public interface CarBL {

    /**
     * Sets the current DAL.
     */
    void setDAL(CarDAL dal);

    /**
     * Sets the current brand. Each operation is only allowed on cars owned by the current brand.
     */
    void setCurrentBrand(String brand);

    /**
     * Returns all cars of the current brand. An Exception is thrown, if no brand is set.
     */
    List<Car> getCars();

    /**
     * Returns the car of the given model of the current brand. Null is returned, if the model is not found. An
     * Exception is thrown, if no brand is set.
     */
    Car getCar(String model);

    /**
     * Saves the car of the current brand. An Exception is thrown, if no brand is set or the car does not belong to the
     * current brand.
     */
    void saveCar(Car c);
}
