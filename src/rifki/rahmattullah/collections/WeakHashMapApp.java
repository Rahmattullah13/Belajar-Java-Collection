package rifki.rahmattullah.collections;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapApp {
    public static void main(String[] args) {

        Map<Integer, Integer> map = new WeakHashMap<>();

        for (int i = 0; i < 1_000_000; i++) {
            map.put(i, i);
        }

        // Running Garbage Collection
        System.gc();

        // Untuk melihat hasil looping
        System.out.println(map.size());
    }
}
