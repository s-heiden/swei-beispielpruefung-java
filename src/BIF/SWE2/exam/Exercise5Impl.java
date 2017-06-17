package BIF.SWE2.exam;

import BIF.SWE2.exam.interfaces.Car;
import BIF.SWE2.exam.interfaces.Exercise5;
import java.util.ArrayList;
import java.util.List;

public class Exercise5Impl implements Exercise5 {

    @Override
    public Object method1(int i, String str, Object obj) {
        List<Car> input = (List<Car>) obj;
        List<Car> output = new ArrayList<>();
        input.stream().filter((c) -> (c.getBrand().equalsIgnoreCase("BMW"))).forEachOrdered((c) -> {
            output.add(c);
        });
        return output;
    }

    @Override
    public Object method2(int i, String str, Object obj) {
        List<Car> input = (List<Car>) obj;
        List<Car> output = new ArrayList<>();
        input.stream().filter((c) -> (c.getHorsePower() >= 100)).forEachOrdered((c) -> {
            output.add(c);
        });
        return output;
    }

    @Override
    public Object method3(int i, String str, Object obj) {
        List<Car> input = (List<Car>) obj;
        List<Car> countable = new ArrayList<>();
        input.stream().filter((c) -> (c.getHorsePower() <= 50)).forEachOrdered((c) -> {
            countable.add(c);
        });
        return countable.size();
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
