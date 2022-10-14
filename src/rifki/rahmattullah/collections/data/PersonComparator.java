package rifki.rahmattullah.collections.data;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        // ini di urutkan secara Asc.
        return o1.getName().compareTo(o2.getName());
        // jika pengen Desc maka tinggal dibalik saja Person2 dan Person1.
        // return o2.getName().compareTo(o1.getName());
    }
}
