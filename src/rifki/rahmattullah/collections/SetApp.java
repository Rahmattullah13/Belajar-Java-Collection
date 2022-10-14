package rifki.rahmattullah.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetApp {
    public static void main(String[] args) {

//        Set<String> city = new HashSet<>();
        Set<String> city = new LinkedHashSet<>();

        city.add("Jakarta");
        city.add("Bandung");
        city.add("Cirebon");
        city.add("Jakarta");
        city.add("Bandung");
        city.add("Cirebon");

        for (var name : city) {
            System.out.println(name);
        }
    }
}
