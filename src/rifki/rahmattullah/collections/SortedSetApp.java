package rifki.rahmattullah.collections;

import rifki.rahmattullah.collections.data.Person;
import rifki.rahmattullah.collections.data.PersonComparator;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetApp {
    public static void main(String[] args) {

        SortedSet<Person> people = new TreeSet<>(new PersonComparator()); // Jika ingin Descending tambahkan method reversed()

        people.add(new Person("Agifa"));
        people.add(new Person("Rifki"));
        people.add(new Person("Hasby"));

        for (var person : people) {
            System.out.println(person.getName());
        }

        SortedSet<Person> sortedSet = Collections.unmodifiableSortedSet(people);
//        sortedSet.add(new Person("Joko")); //Error

    }
}
