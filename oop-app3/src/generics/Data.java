package generics;

import java.util.ArrayList;

public interface Data<T> {
    void add(T t);
    ArrayList<T> getByName(String name);
}
