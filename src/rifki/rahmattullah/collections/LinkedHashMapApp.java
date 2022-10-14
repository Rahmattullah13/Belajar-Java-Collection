package rifki.rahmattullah.collections;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapApp {
    public static void main(String[] args) {

        Map<String, String> map = new LinkedHashMap<>();

        map.put("first", "Rifki");
        map.put("last", "Rahmattullah");
        map.put("middle", "Tidak ada");

        // Mengambil data
        Set<String> keys = map.keySet();
        for (var key : keys) {
            System.out.println(key);
        }
    }
}
