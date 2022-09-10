package rifki.rahmattullah.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListApp {
    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
//        List<String> strings1 = new LinkedList<>();

        strings.add("Rifki");
        strings.add("Rahmattullah");

        System.out.println(strings.get(1));

        strings.set(1, "Hasby");
        strings.remove(1);

        System.out.println(strings.get(0));

    }
}
