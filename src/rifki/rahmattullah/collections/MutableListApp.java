package rifki.rahmattullah.collections;

import rifki.rahmattullah.collections.data.Person;

import java.util.List;

public class MutableListApp {
    public static void main(String[] args) {
        /**
         * PROBLEM IN MUTABLE LIST
         *
         * Ketika kita me-return kan data list nya orang lain nanti bisa mengubah data list nya. Harusnya tidak bisa.
         */

        Person person = new Person("Rifki");

        person.addHobby("Nonton");
        person.addHobby("Coding");

        doSomethingWithHobbies(person.getHobbies());

        for (var hobby : person.getHobbies()) {
            System.out.println(hobby);
        }
    }

    public static void doSomethingWithHobbies(List<String> hobbies) {
        hobbies.add("Bukan Hobby!");
    }
}
