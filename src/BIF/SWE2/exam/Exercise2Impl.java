package BIF.SWE2.exam;

import BIF.SWE2.exam.interfaces.*;
import java.util.ArrayList;
import java.util.List;

public class Exercise2Impl implements Exercise2 {

    public class CarDALImpl implements CarDAL {

        List<Car> cars = new ArrayList<>();

        @Override
        public List<Car> GetCars(String brand, String model) {
            List<Car> result = new ArrayList<>();

            for (Car c : cars) {
                boolean ignoreBrand = false;
                boolean ignoreModel = false;
                boolean brandMatched = false;
                boolean modelMatched = false;

                if (brand == null || brand.equals("")) {
                    ignoreBrand = true;
                }

                if (model == null || model.equals("")) {
                    ignoreModel = true;
                }

                if (ignoreBrand || c.getBrand().toLowerCase().contains(brand.toLowerCase())) {
                    brandMatched = true;
                }

                if (ignoreModel || c.getModel().toLowerCase().contains(model.toLowerCase())) {
                    modelMatched = true;
                }

                if (brandMatched && modelMatched) {
                    result.add(c);
                }
            }
            return result;
        }

        @Override
        public void SaveCar(Car c) {
            cars.add(c);
        }

    }

    public class CarBLImpl implements CarBL {

        private CarDAL carDAL;
        private String brand;

        @Override
        public void setDAL(CarDAL dal) {
            this.carDAL = dal;
        }

        @Override
        public void setCurrentBrand(String brand) {
            this.brand = brand;
        }

        @Override
        public List<Car> getCars() {
            if (brand == null) {
                throw new IllegalStateException("No brand is set.");
            }
            List<Car> cars = carDAL.GetCars(brand, null);
            return cars;
        }

        @Override
        public Car getCar(String model) {
            if (brand == null) {
                throw new IllegalStateException("No brand is set.");
            }
            List<Car> cars = carDAL.GetCars(brand, model);
            if (cars.size() == 0) {
                return null;
            } else {
                return cars.get(0);
            }
        }

        @Override
        public void saveCar(Car c) {
            if (brand == null) {
                throw new IllegalStateException("No brand is set.");
            }
            if (!c.getBrand().equalsIgnoreCase(brand)) {
                throw new IllegalStateException("The car does not belong to the current brand.");
            }
            carDAL.SaveCar(c);
        }

    }

    @Override
    public Object method1(int i, String str, Object obj) {
        return new CarDALImpl();
    }

    @Override
    public Object method2(int i, String str, Object obj) {
        return new CarBLImpl();
    }

    // ****************************************************************************************************************
    // Nicht benoetigt!!
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
