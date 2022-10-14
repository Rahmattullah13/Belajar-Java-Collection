# Java Collection

## Pengenalan Collection

- Collection adalah hal umum yang biasa dimiliki di bahasa pemrograman, seperti PHP, Python, Ruby, dll.
- Collection atau biasa disebut container, adalah object yang mengumpulkan atau berisikan data-data mirip seperti
  Array.
- Java telah menyediakan class-class collection yang sudah bisa langsung kita gunakan tanpa tambahan library.
- Semua class-class collection di Java adalah generic class sehingga kita bisa menggunakan java collection dengan data
  apapun.

## Java Collection

Java Collection telah menyediakan semuanya yang berhubungan dengan collection, sehingga kita hanya tinggal
menggunakannya saja.

- Interface, ini adalah contract representasi dari collection. Semua collection di java memiliki kontrak interface,
  sehingga jika kita mau, kita juga bisa membuat implementasinya sendiri(Tidak disarankan).
- Implementations, tidak perlu khawatir kita juga bisa menggunakan implementasi yang sudah dibuat oleh java, semua
  interface collection sudah ada implementasi class nya di Java Collection.
- Algorithm, Java juga sudah menyediakan algoritma-algoritma yang umum digunakan di collection, seperti pencarian,
  pengurutan data di collection.

---

## Iterable Interface

- Iterable adalah parent untuk semua collection di Java, kecuali Map.
- Iterable sendiri sangat sederhana, hanya digunakan agar mendukung for-each loop.
- Karena semua collection pasti implement iterable, secara otomatis maka semua collection di Java
  mendukung perulangan for-each, jadi bukan cuma Array.

**Contoh Iterable**

```java
public class IterableApp {
    public static void main(String[] args) {

        Iterable<String> names = List.of("Rifki", "Hasby", "Agifa");

        for (var name : names) {
            System.out.println(name);
        }

    }
}
```

## Iterator Interface

- Tidak ada magic di Java, sebenarnya for-each di iterable bisa terjadi karena ada method iterator() yang mengembalikan
  object Iterator.
- Iterator adalah interface yang mendefinisikan cara kita melakukan mengakses element di collection secara sequential.
- For-each sendiri muncul sejak Java 5, sebelum Java 5 untuk melakukan iterasi collection, biasanya dilakukan manual
  menggunakan iterator object.

**Contoh Iterator**

```java
public class IterableApp {
    public static void main(String[] args) {

        Iterable<String> names = List.of("Rifki", "Hasby", "Agifa");
        for (var name : names) {
            System.out.println(name);
        }

        System.out.println("ITERATOR");
        Iterator<String> iterator = names.iterator();

        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }

    }
}
```

---

## Collection Interface

- Selain Iterable interface, parent class semua collection di Java adalah Collection.
- Kalo iterable interface digunakan sebagai kontrak untuk meng-iterasi data secara sequential.
- Collection merupakan kontrak untuk memanipulasi data collection, seperti menghapus dan mengecek isi data di
  collection.
- Tidak ada direct implementation untuk Collection, karena collection nanti akan dibagi lagi menjadi List, Set, dan
  Queue.

**Contoh Collection Interface**

```java
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
```

---

## List Interface

- List adalah struktur data collection yang memeiliki sifat sebagai berikut
    - Element di list bisa duplikat, artinya bisa memasukkan data yang sama.

    - Data list berurutan sesuai dengan posisi kita memasukan data.

    - List memiliki index, sehingga kita bisa menggunakan nomor index untuk mendapatkan element di list.
- Di java ada beberapa implementasi List, dan kita bisa memilih sesuai dengan kebutuhan kita.

### Ada dua cara implementasi List

#### 1. ArrayList Class

- ArrayList adalah implementasi dari List menggunakan array.
- Default kapasitas array di ArrayList adalah 10.
- Namun ketika kita memasukan data dan array sudah penuh, maka secara otomatis ArrayList akan membuat
  array baru dengan kapasitas baru dengan ukuran kapasitas lama + data baru.

#### 2. LinkedList Class

- LinkedList adalah implementasi List dengan struktur data Double Linked List.

### ArrayList vs LinkedList

| Operasi | ArrayList                                                       | LinkedList                                                           |
|:--------|:----------------------------------------------------------------|:---------------------------------------------------------------------|
| add     | Cepat jika kapasitas Array masih cukup, lambat jika sudah penuh | Cepat karena hanya menambah node di akhir                            |
| get     | Cepat karena tinggal gunakan index array                        | Lambat karena harus di cek dari nide awal samoai ketemu indexnya     |
| set     | Cepat karena tinggal gunakan index array                        | Lambat karena harus di cek dari awal node sampai ketemu              |
| remove  | Lambat karena harus menggeser data di belakang yang dihapus     | Cepat karena tinggal ubah prev dan next di node sebelah yang dihapus |

**Contoh List Interface**

```java
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
```

## Immutable List

- Secara default, List di Java baik itu ArrayList ataupun LisnkedList datanya bersifat mutable(bisa diubah).
- Di Java mendukung pembuatan immutable list, artinya datanya tidak bisa diubah lagi.
- Sekali List dibuat datanya tidak bisa diubah alias final.
- Tapi ingat, data listnya yang tidak bisa diubah, bukan reference object element nya. Kalo misal kita membuat
  immutabl list berisikan data Person, field data Person tatap bisa diubah, tapi isi element dari immutable list
  tidak bisa diubah lagi.
- Ini cocok ketika kasus-kasus misa, tidak sembarangan code yang boleh diubah elemen di list.

**Contoh Kode: Masalah di Mutable List**

```java
package rifki.rahmattullah.collections.data;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;

    private List<String> hobbies;

    public Person(String name) {
        this.name = name;
        this.hobbies = new ArrayList<>();
    }

    public void addHobby(String hobby) {
        hobbies.add(hobby);
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public String getName() {
        return name;
    }
}

```

```java
package rifki.rahmattullah.collections;

import rifki.rahmattullah.collections.data.Person;

import java.util.List;

public class MutableListApp {
    public static void main(String[] args) {
        /**
         * MASALAH DI MUTABLE LIST
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

```

**Contoh Kode: Immutable List**

```java
package rifki.rahmattullah.collections.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;

    private List<String> hobbies;

    public Person(String name) {
        this.name = name;
        this.hobbies = new ArrayList<>();
    }

    public void addHobby(String hobby) {
        hobbies.add(hobby);
    }

    public List<String> getHobbies() {
        // set menjadi Immutable List
        return Collections.unmodifiableList(hobbies);
    }

    public String getName() {
        return name;
    }
}

```

```java
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
        hobbies.add("Bukan Hobby!"); // Error!
    }
}

```

**Membuat Immutable List**

| Method                             | Keterangan                                  |
|:-----------------------------------|:--------------------------------------------|
| Collections.emptyList()            | Membuat immutable list kosong               |
| Collections.singletonList(e)       | Membuat immutable list berisi satu element  |
| Collections.unmodifiableList(list) | Mengubah metable list menjadi immutable     |
| List.of(e..)                       | Membuat immutable list dari element-element |

**Contoh Immutable List**

```java
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

```

---

## Set Interface

- Set adalah satu collection yang berisikan element-element yang unik, atau tidak boleh duplicate.
- Set tidak memiliki index seperti List, oleh karena itu tidak ada jaminan data yang ada di set itu akan terurut
  sesuai dengan waktu kita memasukan data ke Set.
- Set tidak memiliki method baru, jadi hanya menggunakan method yang ada di interface parent nya,
  yaitu Collection dari iterable.
- Karena tidak memiliki index, untuk mengambil data di Set juga kita harus melakukan iterasi satu persatu.

### HashSet & LinkedHashSet

- Di belakang HashSet dan LinkedHashSet sebenarnya sama-sama ada hash table, dimana data disimpan dalam sebuah
  hash table dengan mengkalkulasi hashCode() function.
- Yang membedakan adalah, HashSet tidak menjamin data terurut sesuai dengan waktu kita menambahkan data tersebut,
  sedangkan LinkedHashSet menjamin data terurut sesuai dengan waktu kita menambahkan data tersebut.
- Urutan data di LinkedHashSet bisa dijaga karena di belakangnya menggunakan double linked list.

**Contoh Kode : HashSet & LinkedHashSet**

```java
package rifki.rahmattullah.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetApp {
    public static void main(String[] args) {

//        Set<String> city = new HashSet<>();
        Set<String> city = new LinkedHashSet<>();

        city.add("Jakarta");
        city.add("Bandung");
        city.add("Cirebon");
        city.add("Jakarta");
        city.add("Bandung");
        city.add("Cirebon");

        for (var name : city) {
            System.out.println(name);
        }
    }
}

```

### EnumSet

- EnumSet adalah Set element yang datanya harus Enum.
- Karena data Enum itu unik, sehingga sangat cocok menggunakan Set dibandingkan List.

**Contoh Kode : EnumSet**

```java
package rifki.rahmattullah.collections;

import java.util.EnumSet;

public class EnumSetApp {

    public static enum Gender {
        MALE, FEMALE, NOT_MENTION
    }

    public static void main(String[] args) {
        EnumSet<Gender> genders = EnumSet.allOf(Gender.class);

        for (var gender : genders) {
            System.out.println(gender);
        }
    }
}

```

---

## Immutable Set

- Sama seperti List, Set pun memiliki tipe data immutable.
- Cara pembuatan immutable Set di Java mirip dengan pembuatan immutable List.

**Membuat Immutable Set**

| Method                           | Keterangan                                 |
|:---------------------------------|:-------------------------------------------|
| Collections.emptySet()           | Membuat immutable Set kosong               |
| Collections.singletonList(e)     | Membuat immutable set berisi satu element  |
| Collections.unmodifiableSet(set) | Mengubah metable set menjadi immutable     |
| Set.of(e..)                      | Membuat immutable set dari element-element |

**Contoh Kode : Immutable Set**

```java
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

```

---

## SortedSet Interface

- SortedSet adalah keturunan dari Set, namun di SortedSet elemen-elemen yang dimasukkan kedalam SortedSet akan
  otomatis di urutkan.
- Jika elemen adalah turunan dari interface Comparable, maka secara otomatis akan diurutkan menggunakan
  comparable tersebut.
- Jika elemen bukan turunan dari interface Comparable, maka kita bisa menggunakan Comparator untuk memberi tahu
  si SortedSet bagaimana cara mengurutkan elemen-elemen nya.

**Contoh Menggunakan SortedSet**

**Membuat Comparator**

```java
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
```

**Contoh SortedSet**

```java
package rifki.rahmattullah.collections;

import rifki.rahmattullah.collections.data.Person;
import rifki.rahmattullah.collections.data.PersonComparator;

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

    }
}

```

### Membuat Immutable SortedSet

| Method                                | Keterangan                                          |
|:--------------------------------------|:----------------------------------------------------|
| Collection.emptySortedSet()           | Membuat immutable sorted set kosong                 |
| Collection.unmodifiableSortedSet(set) | Mengubah mutable sorted set ke immutable sorted set |

**Contoh Immutable SortedSet**

```java
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

```

---

## NavigableSet Interface

- NavigableSet adalah turunan dari SortedSet.
- NavigableSet menambahkan method-method untuk melakukan navigasi pencarian element,
  seperti mencari elemen yang lebih besar dari, kurang dari, membalikan urutan set, dll.

**Contoh NavigableSet**

```java
package rifki.rahmattullah.collections;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class NavigableSetApp {
    public static void main(String[] args) {

        NavigableSet<String> city = new TreeSet<>();
        city.addAll(Set.of("Jakarta", "Cirebon", "Tokyo", "Boston", "New York", "Melbourne"));

        NavigableSet<String> citiesRevers = city.descendingSet(); // untuk descending
        NavigableSet<String> cirebon = city.headSet("Cirebon", true); // untuk Slicing

        for (var cities : cirebon) {
            System.out.println(cities);
        }
    }
}

```

### Membuat Navigable Immutable Set.

| Method                                   | Keterangan                                       |
|:-----------------------------------------|:-------------------------------------------------|
| Collection.emptyNavigableSet()           | Membuat immutable navigable set kosong           |
| Collection.unmodifiableNavigableSet(set) | Mengubah mutable navigable set menjadi immutable |

```java
package rifki.rahmattullah.collections;

import java.util.Collections;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class NavigableSetApp {
    public static void main(String[] args) {

        NavigableSet<String> city = new TreeSet<>();
        city.addAll(Set.of("Jakarta", "Cirebon", "Tokyo", "Boston", "New York", "Melbourne"));

        NavigableSet<String> citiesRevers = city.descendingSet(); // untuk descending
        NavigableSet<String> cirebon = city.headSet("Cirebon", true); // untuk Slicing

        for (var cities : cirebon) {
            System.out.println(cities);
        }

        NavigableSet<String> immutable = Collections.unmodifiableNavigableSet(city);
        // immutable.add("Roma"); // Error
    }
}

```

---

## Queue Interface

- Queue adalah implementasi dari struktur data Antrian atau FIFO(First In First Out).

### ArrayDeque vs LinkedList vs PriorityQueue

- ArrayDeque menggunakan array sebagai implementasi queue nya.
- LinkedList menggunakan double linked list sebagai implementasi queue nya.
- PriorityQueue menggunakan array sebagai implmentasi queue nya, namun diurutkan menggunakan Comparable atau Comparator.

**Contoh Queue Interface**

```java
package rifki.rahmattullah.collections;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueApp {
    public static void main(String[] args) {

        // Queue<String> queue = new ArrayDeque<>();
        // Queue<String> queue = new PriorityQueue<>();
        Queue<String> queue = new LinkedList<>();

        queue.add("Jakarta");
        queue.add("Cirebon");
        queue.add("New York");


        for (String next = queue.poll(); next != null; next = queue.poll()) {
            System.out.println(next);
        }
    }
}

```

---

## Deque Interface

- Deque adalah singkatan dari double ended queue, artinya queue yang bisa di operasikan dari depan ataupun belakang.
- Deque mendukung FIFO dan LIFO(Last In First Out).
- Bisa dibilang deque adalah implementasi struktur data antrian dan stack(tumpukan).

**Contoh Deque Interface**

```java
package rifki.rahmattullah.collections;

import java.util.Deque;
import java.util.LinkedList;

public class DequeApp {
    public static void main(String[] args) {

        Deque<String> stack = new LinkedList<>();

        stack.offerLast("Rifki");
        stack.offerLast("Hasby");
        stack.offerLast("Agifa");

        System.out.println(stack.pollLast());
        System.out.println(stack.pollLast());
        System.out.println(stack.pollLast());

        Deque<String> queue = new LinkedList<>();

        queue.offerLast("Rifki");
        queue.offerLast("Hasby");
        queue.offerLast("Agifa");

        System.out.println(queue.pollFirst());
        System.out.println(queue.pollFirst());
        System.out.println(queue.pollFirst());
    }
}

```

---

## Map Interface

- Map adalah struktur data collection yang berisikan mapping antara key dan value.
- Dimana key di map itu harus unik, tidak boleh duplikat, dan satu key cuma boleh mapping ke satu value.
- Map sebenarnya mirip dengan Array, cuma bedanya kalo di Array itu key adalah index(integer), sedangkan di Map,
  key nya bebas kita tentukan sesuai keinginan kita.

---

## HashMap

- HashMap adalah implementasi Map yang melakukan distribusi key menggunakan hashCode() function.
- Karena HashMap sangat bergantung dengan hashCode() function, jadi pastikan kita harus membuat function hashCode
  seunik mungkin, karena jika terlalu banyak nilai hashCode() yang sama, maka pendistribusian key nya tidak akan optimal
  sehingga proses get data di Map akan semakin lambat.
- Di HashMap pengecekan data duplikat dilakukan dengan menggunakan method equals nya.

**Contoh Kode HashMap**

```java
package rifki.rahmattullah.collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapApp {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        /** method put itu insert dan update
         * jadi misalkan put dengan key yang sama maka itu update
         * tapi jika kita put dengan key yang belum pernah ada maka itu insert.
         *
         */
        map.put("name.first", "Rifki");
        map.put("name.last", "Rahmattullah");

        System.out.println(map.get("name.first"));
        System.out.println(map.get("name.last"));
    }
}

```

---

## WeakHashMap

- WeakHashMap adalah implemetasi Map mirip dengan HashMap.
- Yang membedakan adalah WeakHashMap menggunakan weak key, artinya dimana jika tidak digunakan lagi maka secara
  otomatis data di WeakHashMap akan dihapus.
- Artinya, jika terjadi Garbace Collection di Java, bisa dimungkinkan data di WeakHashMap akan dihapus.
- WeakHashMap cocok digunakan untuk menyimpan Cache di memory secara sementara.

**Contoh Kode WeakHashMap**

```java
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

```

---

## IdentityHashMap

- IdentityHashMap adalah implementasi Map sama seperti HashMap.
- Yang membedakan adalah cara pengecekan kesamaan datanya, tidak menggunakan function equals,
  malainkan menggunakan operator == (reference equality).
- Artinya data dianggap sama, jika memang lokasi di memory tersebut sama.

**Contoh Kode IdentityHashMap**

```java
package rifki.rahmattullah.collections;

import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapApp {
    public static void main(String[] args) {

        Map<String, String> map = new IdentityHashMap<>();

        String key1 = "name.first";

        String name = "name";
        String dot = ".";
        String first = "first";

        String key2 = name + dot + first;

        System.out.println(key1.equals(key2));
        System.out.println(key1 == key2);

        map.put(key1, "Rifki");
        map.put(key2, "Rifki");

        System.out.println(map.size());
    }
}

```

---

## LinkedHashMap

- LinkedHashMap adalah implementasi Map menggunakan double linked list.
- Data di LinkedHashMap akan lebih terprediksi karena datanya akan disimpan berurutan dalam linked list sesuai urutan
  kita menyimpan data.
- Namun perlu diperhatikan, proses get data di LinkedHashMap akan semakin lambat karena harus melakukan iterasi data
  linked list terlebih dahulu.
- Gunakan LinkedHashMap jika memang kita lebih mementingkan iterasi data Map nya.

**Contoh Kode LinkedHashMap**

```java
package rifki.rahmattullah.collections;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapApp {
    public static void main(String[] args) {

        Map<String, String> map = new LinkedHashMap<>();

        map.put("first", "Rifki");
        map.put("last", "Rahmattullah");
        map.put("middle", "Tidak ada");

        // Mengambil data
        Set<String> keys = map.keySet();
        for (var key : keys) {
            System.out.println(key);
        }
    }
}

```

---

## EnumHashMap

- EnumHashMap adalah implementasi Map dimana key nya adalah enum.
- Karena data enum sudah pasti unik, oleh karena itu cocok dijadikan key di Map.
- Algoritma pendistribusian key dioptimalkan untuk enum, sehingga lebih optimal dibandingkan menggunakan hashCode()
  method.

**Contoh Kode EnumHashMap**

```java
package rifki.rahmattullah.collections;

import java.util.EnumMap;
import java.util.Map;

public class EnumHashMapApp {
    public static enum Level {
        FREE, STANDARD, PREMIUM, VIP
    }

    public static void main(String[] args) {

        Map<Level, String> map = new EnumMap<Level, String>(Level.class);
        map.put(Level.FREE, "Rifki");
        map.put(Level.VIP, "Rahmattullah");

        for (var key : map.keySet()) {
            System.out.println(map.get(key));
        }

    }
}

```

---

## Immutable Map

- Sama seperti di List dan Set, Map juga punya tipe data Immutable.

**Membuat Immutable Map**

| Method                               | Keterangan                               |
|:-------------------------------------|:-----------------------------------------|
| Collections.emptyMap()               | Membuat immutable map kosong             |
| Collections.unmodifiableMap(map)     | Mengubah mutable map menjadi immutable   |
| Collections.singletonMap(key, value) | Membuat map dengan satu jumlah key-value |
| Map.of(...)                          | Membuat immutable map dari key-value     |

**Contoh Kode Immutable Map**

```java
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

```

---

## SortedMap Interface

- SortedMap adalah implementasi Map dengan data key yang diurutkan sesuai dengan Comparable key atau bisa menggunakan
  Comparator.
- SortedMap cocok kasus yang posisi key pada Map harus berurut.

**Contoh Kode SortedMap**

```java
package rifki.rahmattullah.collections;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapApp {
    public static void main(String[] args) {

        // Membuat comparator untuk diurutkan secara Descending
        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        };

        SortedMap<String, String> sortedMap = new TreeMap<>(stringComparator);

        sortedMap.put("Rifki", "Rifki");
        sortedMap.put("Agifa", "Agifa");
        sortedMap.put("Hasby", "Hasby");

        for (var key : sortedMap.keySet()) {
            System.out.println(key);
        }
    }
}

```

**Membuat Immutable SortedMap**

| Method                                 | Keterangan                             |
|:---------------------------------------|:---------------------------------------|
| Collections.emptySortedMap()           | Membuat immutable sorted map kosong    |
| Collections.unmodifiableSortedMap(map) | Mengubah mutable map menjadi immutable |

**Contoh Kode Immutable SortedMap**

```java
package rifki.rahmattullah.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapApp {
    public static void main(String[] args) {

        // Membuat comparator untuk diurutkan secara Descending
        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        };

        SortedMap<String, String> sortedMap = new TreeMap<>(stringComparator);

        sortedMap.put("Rifki", "Rifki");
        sortedMap.put("Agifa", "Agifa");
        sortedMap.put("Hasby", "Hasby");

        for (var key : sortedMap.keySet()) {
            System.out.println(key);
        }

        SortedMap<String, String> empty = Collections.emptySortedMap();
        SortedMap<String, String> immutable = Collections.unmodifiableSortedMap(sortedMap);

        // immutable.put("Adhi", "Adhi"); // Error
    }
}

```

---

## NavigableMap Interface

- NavigableMap adalah turunan dari SortedMap.
- Namun NavigableMap memiliki kemampuan navigasi berdasarkan operasi kurang dari, lebih dari, dan sejenisnya.
- Misal, kita ingin mengambil data yang lebih dari key x atau kurang dari key y, ini bisa dilakukuan dangan
  NavigableMap.

**Contoh Kode NavigableMap**

```java
package rifki.rahmattullah.collections;

import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapApp {
    public static void main(String[] args) {

        NavigableMap<String, String> map = new TreeMap<>();

        map.put("Rifki", "Rifki");
        map.put("Agifa", "Agifa");
        map.put("Hasby", "Hasby");

        for (var key : map.keySet()) {
            System.out.println(key);
        }

        System.out.println(map.lowerKey("Hasby"));
        System.out.println(map.higherKey("Hasby"));

        NavigableMap<String, String> mapDesc = map.descendingMap();

        for (var key : mapDesc.keySet()) {
            System.out.println(key);
        }
    }
}

```

**Membuat Immutable NavigableMap**

| Method                                    | Keterangan                                       |
|:------------------------------------------|:-------------------------------------------------|
| Collections.emptyNavigableMap()           | Membuat immutable navigable map kosong           |
| Collections.unmodifiableNavigableMap(map) | Mengubah mutable navigable map menjadi immutable |

**Contoh Kode Immutable NavigableMap**

```java
package rifki.rahmattullah.collections;

import java.util.Collections;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapApp {
    public static void main(String[] args) {

        NavigableMap<String, String> map = new TreeMap<>();

        map.put("Rifki", "Rifki");
        map.put("Agifa", "Agifa");
        map.put("Hasby", "Hasby");

        for (var key : map.keySet()) {
            System.out.println(key);
        }

        System.out.println(map.lowerKey("Hasby"));
        System.out.println(map.higherKey("Hasby"));

        NavigableMap<String, String> mapDesc = map.descendingMap();

        for (var key : mapDesc.keySet()) {
            System.out.println(key);
        }

        NavigableMap<String, String> empty = Collections.emptyNavigableMap();
        NavigableMap<String, String> immutable = Collections.unmodifiableNavigableMap(mapDesc);

        // immutable.put("Adhi", "Adhi"); // Error
    }
}

```

---

## Entry Interface

- Saat kita menyimpan data di Map, data disimpan dalam pair(key-value).
- Di Java collection, implementasi Pair di Map bernama Entry.
- Entry adalah interface sederhana yang berisikan method untuk mengambil key dan value.

**Contoh Kode Entry Interface**

```java
package rifki.rahmattullah.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EntryApp {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();

        map.put("Rifki", "Rifki Value");
        map.put("Agifa", "Agifa Value");
        map.put("Hasby", "Hasby Value");

        Set<Map.Entry<String, String>> entries = map.entrySet();

        for (var entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

```

---

## Legacy Collection

- Collection sudah ada sejak Java versi 1, namun semakin kesini, Java Collection semakin berkembang.
- Sebenarnya ada beberapa legacy collection(collection jadul) yang belum kita bahas, namun jarang sekali digunakan
  sekarang ini.

### Vector Class

- Vector class adalah implementasi dari interface List.
- Cara kerja Vector mirip dengan ArrayList yang membedakan adalah semua method di Vector menggunakan kata kunci
  synchronized yang artinya dia thread safe.
- Namun problemnya adalah, karena semua method menggunakan kata kunci synchronized, secara otomatis impact nya ke
  performa yang menjadi lambat dibandingkan menggunakan ArrayList.
- Lantas bagaimana jika kita ingin membuat List yang bisa digunakan di proses paralel? Di Java baru, sudah disediakan
  yang lebih canggih, oleh karena itu penggunaan Vector sudah jaran sekali ditemui sekarang.

**Contoh Kode Vector Class**

```java
package rifki.rahmattullah.collections;

import java.util.List;
import java.util.Vector;

public class VectorApp {
    public static void main(String[] args) {

        List<String> list = new Vector<>();

        list.add("Rifki");
        list.add("Rahmattulah");

        for (var value : list) {
            System.out.println(value);
        }
    }
}

```

### HashTable Class

- HashTable adalah implemetasi dari Map yang mirip dengan HashMap.
- Sama seperti Vector, semua method di HashTable memiliki kata kunci synchronized, sehingga performanya lebih lambat
  dibandingkan dengan HashMap.
- Dan karena di versi Java baru sudah ada juga ConcurrentHashMap, sehingga penggunaan HashTable sudah jarang sekali
  ditemui.

**Contoh Kode HashTable Class**

```java
package rifki.rahmattullah.collections;

import java.util.Hashtable;
import java.util.Map;

public class HashTableApp {
    public static void main(String[] args) {
        Map<String, String> map = new Hashtable<>();

        map.put("Rifki", "Rifki Value");
        map.put("Agifa", "Agifa Value");
        map.put("Hasby", "Hasby Value");

        for (var key : map.keySet()) {
            System.out.println(key);
        }
    }
}

```

### Stack Class

- Stack adalah implementasi dari struktur data tumpukan LIFO(Last In First Out)
- Namun fitur yang lebih komplit dan konsisten sudah disediakan di Deque, jadi tidak ada alasan lagi menggunakan Stack
  Clas.

**Contoh Kode Stack Class**

```java
package rifki.rahmattullah.collections;

import java.util.Stack;

public class StackApp {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();

        stack.push("Rifki");
        stack.push("Rahmattullah");

        for (var value = stack.pop(); value != null; value = stack.pop()) {
            System.out.println(value);
        }
    }
}

```

---

## Sorting

- Sorting atau pengurutan adalah algoritma yang sudah biasa kita lakukan.
- Di Java Collection juga sudah disediakan cara untuk melakukan pengurutan. Jadi kita tidak perlu melakukan pengurutan
  secara manual.
- Namun perlu diingat, yang bisa di sort hanyalah List, karena Set, Queue, Deque dan Map cara kerjanya sudah khusus,
  jadi pengurutan hanya bisa dilakukan di List.

**Sorting di List**

| Method                             | Keterangan                                        |
|:-----------------------------------|:--------------------------------------------------|
| Collections.sort(list)             | Mengurutkan list dengan comparable bawwan element |
| Collections.sort(list, comparator) | Mengurutkan list dengan comparator                |

**Contoh Kode Sorting List**

```java
package rifki.rahmattullah.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingApp {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.addAll(List.of("Tokyo", "Jakarta", "Melbourne", "Zurich", "Singapore", "Wellington", "Ottawa"));

        Collections.sort(list);

        for (var value : list) {
            System.out.println(value);
        }

        System.out.println("---------------");

        // Membuat Comparator sendiri
        // Untuk Descending
        Comparator<String> reverse = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        };

        Collections.sort(list, reverse);

        for (var value : list) {
            System.out.println(value);
        }

    }
}

```

---

## Binary Search

- Secara default List di Java memiliki fitur search atau get data, namun implementasinya menggunakan sequential search,
  artinya data akan di cek satu per satu dari awal.
- Salah satu algoritma pencarian yang populer adalah binary search, namun binary search hanya bisa dilakukan jika data
  nya sudah berurutan.
- Untungnya di Java Collection sudah ada implementasi binary search, sehingga kita tidak perlu membuatnya secara manual.

**Binary Search di List**

| Method                                           | Keterangan                                                  |
|:-------------------------------------------------|:------------------------------------------------------------|
| Collections.binarySearch(list, value)            | Mencari menggunakan binary search                           |
| Colections.binarySearch(list, value, comparator) | Mencari menggunakan binary search dengan bantuan comparator |

**Contoh Kode Binary Search**

```java
package rifki.rahmattullah.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarySearchApp {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            list.add(i);
        }

        int index = Collections.binarySearch(list, 666);
        System.out.println(index);

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };

        int index2 = Collections.binarySearch(list, 666);
        System.out.println(index2);
    }
}

```

---

## Collections Class

- Collections adalah class yang berisikan utility static method untuk membantu kita menggunakan Java Collection.
- Di materi-materi sebelumnya kita sudah bahas beberapa, seperti membuat immutable collection misalnya.
- Namun sebenarnya masih ada banya static method yang bisa kita gunakan di class Collections.
- [Link Dokumentasi](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Collections.html)

**Static Method di Collections Class**

| Method                                          | Keterangan                                               |
|:------------------------------------------------|:---------------------------------------------------------|
| void copy(listTo, listFrom)                     | Copy semua data dari listFrom ke listTo                  |
| int frequency(collection, object)               | Mengambil beberapa banya element yang sama dengan object |
| max(collection) dan max(collection, comparator) | Mengambil element paling tinggi di list                  |
| min(collection) dan min(collection, comparator) | Mengambil element paling kecil di list                   |
| void reverse(list)                              | Membalikan seluruh element di list                       |
| void shuffle(list)                              | Mengacak posisi element di list                          |
| void swap(list)                                 | Menukar posisi from ke to di list                        |
| dan masih banyak lagi...                        |                                                          |

**Contoh Kode Collections Class**

```java
package rifki.rahmattullah.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsApp {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.addAll(List.of("Tokyo", "Jakarta", "Melbourne", "Zurich", "Singapore", "Wellington", "Ottawa"));

        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);
    }
}

```

---

## Abstract Collection

- Struktur data collection di Java selalu berkembang namun biasanya algoritma dasarnya selalu sama antar jenis
  collection.
- Hampir semua interface collections di Java sudah disediakan abstract class nya sebagai dasar algoritma nya, dan hampir
  semua implementasi class konkrit nya selalu extends abstract class collection.
- Hal ini mempermudah kita, jika ingin membuat collection manual, kita tidak perlu membuat dari awal, kita bisa
  menggunakan abstract class yang sudah disediakan.

**Abstract Class**

| Abstract Class     | Untuk      |
|:-------------------|:-----------|
| AbstractCollection | Collection |
| AbstractList       | List       |
| AbstractMap        | Map        |
| AbstractQueue      | Queue      |
| AbstractSet        | Set        |

**Contoh Kode Abstract Class**

```java
package rifki.rahmattullah.collections.collections;

import java.util.AbstractQueue;
import java.util.Collections;
import java.util.Iterator;

public class SingleQueue<E> extends AbstractQueue<E> {

    private E data;

    @Override
    public Iterator<E> iterator() {
        return Collections.singleton(data).iterator();
    }

    @Override
    public int size() {
        return data == null ? 0 : 1;
    }

    @Override
    public boolean offer(E e) {
        if (data == null) {
            data = e;
            return true;
        }
        return false;
    }

    @Override
    public E poll() {
        E temp = data;
        data = null;
        return temp;
    }

    @Override
    public E peek() {
        return data;
    }
}

```

```java
package rifki.rahmattullah.collections;

import rifki.rahmattullah.collections.collections.SingleQueue;

import java.util.Queue;

public class SingleQueueApp {
    public static void main(String[] args) {

        Queue<String> queue = new SingleQueue<>();
        System.out.println(queue.size());

        System.out.println(queue.offer("Rifki"));
        System.out.println(queue.offer("Hasby"));
        System.out.println(queue.offer("Agifa"));

        System.out.println(queue.size());

        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        System.out.println(queue.size());
    }
}

```

---

## Default Method

- Di Java 8 ada fitur bernama Dafault Method, dimana kita bisa menambahkan konkrit method di Interface.
- Fitur ini banyak sekali dipakai di Java Collection, karena kita tahu semua collection di Java memiliki kontrak
  interface, sehingga dengan mudah di java bisa meng-improve kemampuan semua collection hanya dengan menambahkan default
  method di interface collection nya.

**Default Method di Collection**

| Default Method             | Keterangan                                         |
|:---------------------------|:---------------------------------------------------|
| Iterable.forEach(consumer) | Melakukan iterasi seluruh data collection          |
| List.removeIf(predicate)   | Menghapus data di collection menggunakan predicate |
| List.replaceAll(operator)  | Mengubah seluruh data di collection                |

**Contoh Kode Default Method Collection**

```java
package rifki.rahmattullah.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class CollectionDefaultMethodApp {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            numbers.add(i);
        }

        System.out.println(numbers);

        numbers.replaceAll(new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer) {
                // Semua data yang di integer akan di kalikan 10
                return integer * 10;
            }
        });

        System.out.println(numbers);

        numbers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        numbers.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 500;
            }
        });

        System.out.println(numbers);
    }
}

```

**Default Method di Map**

| Default Method                  | Keterangan                                                         |
|:--------------------------------|:-------------------------------------------------------------------|
| getOrDefault(key, defaultValue) | Mengambil data berdasarkan key, jika tidak ada return defaultValue |
| forEach(consumer)               | Melakukan iterasi seluruh data key-value                           |
| replaceAll(function)            | Mengubah seluruh data value                                        |
| putIfAbsent(key, value)         | Simpan data ke map jika belum ada                                  |
| remove(key, value)              | Hapus jika key-value nya sama                                      |
| replace(key, oldValue, newValue | Ubah key jika value sekarang sama dengan oldValue                  |
| computeIfPresent(key, function) | Ubah key dengan value hasi function jika sudah ada                 |
| computeIfAbsent(key, function)  | Ubah key dengan value hasil function jika belum ada                |

**Contoh Default Method Map**

```java
package rifki.rahmattullah.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class MapDefaultMethodApp {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("Rifki", "Rifki Value");
        map.put("Agifa", "Agifa Value");
        map.put("Hasby", "Hasby Value");

        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String key, String value) {
                System.out.println(key + ":" + value);
            }
        });
    }
}

```

---

## Spliterator Interface

- Spliterator adalah interface yang bisa digunakan untuk melakukan partisi data collection.
- Biasanya ini digunakan ketika kita akan memproses collection dalam jumlah besar, lalu agar lebih cepat di split
  menjadi beberapa dan diproses secara paralel agar lebih cepat.
- Penggunaan Spliterator biasanya erat kaitannya dengan Java Thread atau Java Concurrency.

**Contoh Kode Spliterator**

```java
package rifki.rahmattullah.collections;

import java.util.List;
import java.util.Spliterator;

public class SpliteratorApp {
    public static void main(String[] args) {

        List<String> list = List.of("Tokyo", "Jakarta", "Melbourne", "Zurich", "Wellington", "Ottawa");

        Spliterator<String> spliterator1 = list.spliterator();
        Spliterator<String> spliterator2 = spliterator1.trySplit();

        System.out.println(spliterator1.estimateSize());
        System.out.println(spliterator2.estimateSize());
    }
}

```

---

## Konversi Ke Array

**Collection Interface**

- Interface Collection memiliki method toArray() untuk melakukan konversi collection ke Array.
- Ini sangat cocok jika kita ingin mengubah collection ke Array, misal saja karena mau memanggil method yang memang
  parameternya tipe nya Array, bukan collection.

**toArray Method di Collection**

| Method            | Keterangan                          |
|:------------------|:------------------------------------|
| Object[]toArray() | Mengubah collection menjadi array   |
| T[]toArray()      | Mengubah collection menjadi array T |

**Contoh Kode Konversi Array**

```java
package rifki.rahmattullah.collections;

import java.util.Arrays;
import java.util.List;

public class ArrayApp {
    public static void main(String[] args) {

        List<String> names = List.of("rifki", "rahmattullah");

        Object[] objects = names.toArray();
        String[] strings = names.toArray(new String[]{});

        System.out.println(Arrays.toString(objects));
        System.out.println(Arrays.toString(strings));
    }
}

```

---

# Selesai
























