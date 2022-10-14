package rifki.rahmattullah.collections;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ImmutableSetApp {
    public static void main(String[] args) {

        Set<String> empty = Collections.emptySet();
        Set<String> one = Collections.singleton("Rifki");

        Set<String> mutable = new HashSet<>();
        mutable.add("Tokyo");
        mutable.add("Nevada");
        Set<String> immutable = Collections.unmodifiableSet(mutable);

        Set<String> set = Set.of("Tokyo", "Nevada");

        // set.add("Canberra"); Error
//        set.remove("Tokyo"); Error
    }
}
