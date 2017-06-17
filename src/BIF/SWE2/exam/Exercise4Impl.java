package BIF.SWE2.exam;

import BIF.SWE2.exam.interfaces.Exercise4;
import BIF.SWE2.exam.interfaces.Logger;

public class Exercise4Impl implements Exercise4 {

    @Override
    public Object method1(int i, String str, Object obj) {
        int amount = 0;
        Logger log = (Logger) obj;
        log.info("Creating a new Invoice");
        try {
            log.debug("amount = " + amount);
            if (amount == 0) {
                log.warn("Creating a Invoice with amount of 0");
            }
            throw new Exception("Test");
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return null;
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
