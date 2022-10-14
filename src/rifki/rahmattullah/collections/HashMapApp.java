package rifki.rahmattullah.collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapApp {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        /** method put itu insert dan update
         * jadi misalkan put dengan key yang sama maka itu update
         * tapi jika kita put dengan key yang belum pernah ada maka itu insert.
         *
         */
        map.put("name.first", "Rifki");
        map.put("name.last", "Rahmattullah");

        System.out.println(map.get("name.first"));
        System.out.println(map.get("name.last"));
    }
}
