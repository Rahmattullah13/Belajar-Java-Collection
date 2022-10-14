package rifki.rahmattullah.collections;

import java.util.Collections;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class NavigableSetApp {
    public static void main(String[] args) {

        NavigableSet<String> city = new TreeSet<>();
        city.addAll(Set.of("Jakarta", "Cirebon", "Tokyo", "Boston", "New York", "Melbourne"));

        NavigableSet<String> citiesRevers = city.descendingSet(); // untuk descending
        NavigableSet<String> cirebon = city.headSet("Cirebon", true); // untuk Slicing

        for (var cities : cirebon) {
            System.out.println(cities);
        }

        NavigableSet<String> immutable = Collections.unmodifiableNavigableSet(city);
        // immutable.add("Roma"); // Error
    }
}
