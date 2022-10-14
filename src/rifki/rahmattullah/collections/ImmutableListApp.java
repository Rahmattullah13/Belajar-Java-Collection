package rifki.rahmattullah.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableListApp {
    public static void main(String[] args) {

        List<String> one = Collections.singletonList("Satu");
        List<String> empty = Collections.emptyList();

        List<String> mutable = new ArrayList<>();
        mutable.add("Rifki");
        mutable.add("Rahmmattullah");
        List<String> immutable = Collections.unmodifiableList(mutable);

        List<String> element = List.of("Rifki", "Hasby", "Agifa", "Adhi", "Agus");
    }
}
