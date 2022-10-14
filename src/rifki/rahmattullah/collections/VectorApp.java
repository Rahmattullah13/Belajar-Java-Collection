package rifki.rahmattullah.collections;

import java.util.List;
import java.util.Vector;

public class VectorApp {
    public static void main(String[] args) {

        List<String> list = new Vector<>();

        list.add("Rifki");
        list.add("Rahmattulah");

        for (var value : list) {
            System.out.println(value);
        }
    }
}
