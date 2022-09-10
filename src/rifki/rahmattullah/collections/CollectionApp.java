package rifki.rahmattullah.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionApp {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();

        collection.add("Rifki");
        collection.add("Hardlan");
        collection.add("Fikri");
        collection.addAll(List.of("Hasby", "Agifa", "Adhi"));

        for (var value : collection) {
            System.out.println(value);
        }

        System.out.println("REMOVE");

        // Menghapus data di collection
        collection.remove("Adhi");
        collection.removeAll(List.of("Agifa", "Hardlan"));

        for (var value : collection) {
            System.out.println(value);
        }

        // Untuk mengecek data kita pakai keyword contains
        System.out.println(
                collection.contains("Agifa")
        );

        System.out.println(
                collection.containsAll(List.of("Rifki", "Fikri", "Hasby"))
        );

    }
}
