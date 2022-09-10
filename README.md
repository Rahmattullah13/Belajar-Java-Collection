# Java Collection

## Pengenalan Collection

- Collection adalah hal umum yang biasa dimiliki di bahasa pemrograman, seperti PHP, Python, Ruby, dll.
- Collection atau biasa disebut conatainer, adalah object yang mengumpulkan atau berisikan data-data mirip seperti
  Array.
- Java telah menyediakan class-class collection yang sudah bisa langsung kita gunakan tanpa tamabahan library.
- Semua class-class collection di Java adalah generic class sehingga kita bisa menggunakan java collection dengan data
  apapun.

## Java Collection

Java Collection telah menyediakan semuanya yang berhubungan dengan collection, sehingga kita hanya tinggal
menggunakannya saja.

- Interface, ini adalah contract representasi dari collection. Semua collection di java memiliki kontrak interface,
  sehingga jika kita mua, kita juga bisa membuat implementasinya sendiri(Tidak disarankan).
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

