package rifki.rahmattullah.collections;

import java.util.Collections;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapApp {
    public static void main(String[] args) {

        NavigableMap<String, String> map = new TreeMap<>();

        map.put("Rifki", "Rifki");
        map.put("Agifa", "Agifa");
        map.put("Hasby", "Hasby");

        for (var key : map.keySet()) {
            System.out.println(key);
        }

        System.out.println(map.lowerKey("Hasby"));
        System.out.println(map.higherKey("Hasby"));

        NavigableMap<String, String> mapDesc = map.descendingMap();

        for (var key : mapDesc.keySet()) {
            System.out.println(key);
        }

        NavigableMap<String, String> empty = Collections.emptyNavigableMap();
        NavigableMap<String, String> immutable = Collections.unmodifiableNavigableMap(mapDesc);

        // immutable.put("Adhi", "Adhi"); // Error
    }
}
