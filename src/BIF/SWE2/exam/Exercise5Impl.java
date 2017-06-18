package BIF.SWE2.exam;

import BIF.SWE2.exam.interfaces.Car;
import BIF.SWE2.exam.interfaces.Exercise5;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise5Impl implements Exercise5 {

    @Override
    public Object method1(int i, String str, Object obj) {
        List<Car> input = (List<Car>) obj;

        return input.stream()
            .filter(car -> "BMW".equalsIgnoreCase(car.getBrand()))
            .collect(Collectors.toList());
    }

    @Override
    public Object method2(int i, String str, Object obj) {
        List<Car> input = (List<Car>) obj;

        return input.stream()
            .filter(car -> car.getHorsePower() >= 100)
            .collect(Collectors.toList());
    }

    @Override
    public Object method3(int i, String str, Object obj) {
        List<Car> input = (List<Car>) obj;

        return input.stream()
            .filter(car -> car.getHorsePower() <= 50)
            .collect(Collectors.counting()).intValue();
    }

    // ****************************************************************************************************************
    // Nicht benoetigt!!
    @Override
    public Object method4(int paramInt, String paramString, Object paramObject) {
        return null;
    }

    @Override
    public Object method5(int paramInt, String paramString, Object paramObject) {
        return null;
    }

}
