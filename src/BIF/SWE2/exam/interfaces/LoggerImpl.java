package BIF.SWE2.exam.interfaces;

public class LoggerImpl implements Logger {

    @Override
    public void debug(String msg) {
        System.out.println("DEBUG: " + msg);
    }

    @Override
    public void info(String msg) {
        System.out.println("INFO_: " + msg);
    }

    @Override
    public void warn(String msg) {
        System.out.println("WARN_: " + msg);
    }

    @Override
    public void error(String msg) {
        System.out.println("ERROR: " + msg);
    }

}
