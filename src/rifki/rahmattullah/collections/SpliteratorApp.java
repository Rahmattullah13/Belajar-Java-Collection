package rifki.rahmattullah.collections;

import java.util.List;
import java.util.Spliterator;

public class SpliteratorApp {
    public static void main(String[] args) {

        List<String> list = List.of("Tokyo", "Jakarta", "Melbourne", "Zurich", "Wellington", "Ottawa");

        Spliterator<String> spliterator1 = list.spliterator();
        Spliterator<String> spliterator2 = spliterator1.trySplit();
        Spliterator<String> spliterator3 = spliterator2.trySplit();

        System.out.println(spliterator1.estimateSize());
        System.out.println(spliterator2.estimateSize());
        System.out.println(spliterator3.estimateSize());
    }
}
