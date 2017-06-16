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
            
            for (Car c : cars){
                boolean brandMatches = false;
                boolean modelMatches = false;
                
                if (c.getBrand().toLowerCase().equals(brand.toLowerCase())){
                    brandMatches = true;
                }
                
                if (c.getModel().toLowerCase().equals(model.toLowerCase())){
                    modelMatches = true;
                }
                
                if (brandMatches && modelMatches) {
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

        @Override
        public void setDAL(CarDAL dal) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void setCurrentBrand(String brand) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public List<Car> getCars() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Car getCar(String model) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void saveCar(Car c) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    @Override
    public Object method1(int paramInt, String paramString, Object paramObject) {
        return null;
    }

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
