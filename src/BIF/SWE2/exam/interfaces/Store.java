package BIF.SWE2.exam.interfaces;

public interface Store {

    Object load(int d);

    void save(Object obj);
}
