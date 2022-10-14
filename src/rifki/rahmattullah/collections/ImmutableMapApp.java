package rifki.rahmattullah.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableMapApp {
    public static void main(String[] args) {

        Map<String, String> empty = Collections.emptyMap();
        Map<String, String> singleton = Collections.singletonMap("city", "Cirebon");

        Map<String, String> mutable = new HashMap<>();
        mutable.put("city", "Cirebon");
        Map<String, String> immutable = Collections.unmodifiableMap(mutable);

        Map<String, String> map = Map.of(
                "city", "Cirebon",
                "national", "Indonesia"
        );

        // Jika kita coba ubah akan error
        // map.put("a", "A"); // Error
    }
}
