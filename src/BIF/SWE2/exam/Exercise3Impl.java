package BIF.SWE2.exam;

import BIF.SWE2.exam.interfaces.*;

public class Exercise3Impl implements Exercise3 {

    public class FactoryImpl implements Factory {

        @Override
        public Object create(int type) {
            switch (type) {
                case 1:
                    return new FileStore();
                case 2:
                    return new MemoryStore();
                default:
                    throw new IllegalArgumentException("An invalid type integer was provided");
            }
        }

    }

    public class FileStore implements Store {

        @Override
        public Object Load(int d) {
            System.out.println("Performing Load");
            return null;
        }

        @Override
        public void Save(Object obj) {
            System.out.println("Performing Save");
        }
    }

    public class MemoryStore implements Store {

        @Override
        public Object Load(int d) {
            System.out.println("Performing Load");
            return null;
        }

        @Override
        public void Save(Object obj) {
            System.out.println("Performing Save");
        }
    }

    @Override
    public Object method1(int i, String str, Object obj) {
        return new FactoryImpl();
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
