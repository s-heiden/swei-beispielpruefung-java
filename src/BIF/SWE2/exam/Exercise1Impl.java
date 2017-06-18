package BIF.SWE2.exam;

import BIF.SWE2.exam.interfaces.Car;
import BIF.SWE2.exam.interfaces.CarPresentationModel;
import BIF.SWE2.exam.interfaces.Exercise1;

/**
 * 2.1.
 */
public class Exercise1Impl implements Exercise1 {

    @Override
    public Object method1(int i, String str, Object obj) {
        return new CarPresentationModelImpl((Car) obj);
    }

    public class CarPresentationModelImpl implements CarPresentationModel {

        private Car car;

        public CarPresentationModelImpl(Car car) {
            this.car = car;
        }

        public String getBrand() {
            return car.getBrand();
        }

        public String getModel() {
            return car.getModel();
        }

        public int getHorsePower() {
            return car.getHorsePower();
        }

        public String getText() {
            return getBrand() + " " + getModel() + " (" + getHorsePower() + " PS)";
        }

        public String getPowerClass() {
            if (getHorsePower() <= 50) {
                return "schwach";
            } else if (getHorsePower() < 100) {
                return "normal";
            } 
            return "stark";
        }

        public boolean isValid() {
            return !(getHorsePower() <= 0
                    || getBrand().isEmpty()
                    || getModel().isEmpty()
                    || getModel() == null
                    || getBrand() == null);
        }
    }

    // ****************************************************************************************************************
    // Nicht benoetigt!!
    @Override
    public Object method2(int paramInt, String paramString, Object paramObject) {
        return null;
    }

    @Override
    public Object method3(int paramInt, String paramString, Object paramObject) {
        return null;
    }

    @Override
    public Object method4(int paramInt, String paramString, Object paramObject) {
        return null;
    }

    @Override
    public Object method5(int paramInt, String paramString, Object paramObject) {
        return null;
    }

}
