package rifki.rahmattullah.collections;

import java.util.Hashtable;
import java.util.Map;

public class HashTableApp {
    public static void main(String[] args) {
        Map<String, String> map = new Hashtable<>();

        map.put("Rifki", "Rifki Value");
        map.put("Agifa", "Agifa Value");
        map.put("Hasby", "Hasby Value");

        for (var key : map.keySet()) {
            System.out.println(key);
        }
    }
}
