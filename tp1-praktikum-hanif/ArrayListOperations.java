import java.util.ArrayList;
import java.util.Collections;

/**
 * Kelas ArrayListOperations
 * Berisi implementasi operasi dasar pada struktur data ArrayList (dynamic array):
 * - Menambahkan elemen
 * - Menghapus elemen
 * - Pencarian elemen
 * - Pengurutan elemen
 *
 * Catatan kompleksitas (Big-O):
 * - add(value) di akhir       : O(1) amortized (kadang O(n) saat resize internal)
 * - remove(index)             : O(n)  -> elemen setelahnya di-shift oleh JVM
 * - search (indexOf/contains) : O(n)  -> linear search di balik layar
 * - sort (Collections.sort)   : O(n log n) -> menggunakan TimSort
 */
public class ArrayListOperations {

    private ArrayList<Integer> list;

    // Konstruktor: menerima ArrayList awal
    public ArrayListOperations(ArrayList<Integer> initialList) {
        this.list = initialList;
    }

    // Getter untuk mengambil ArrayList saat ini
    public ArrayList<Integer> getList() {
        return list;
    }

    /**
     * Traversal: menampilkan seluruh isi ArrayList.
     * Kompleksitas waktu: O(n)
     */
    public void traversal() {
        System.out.println("ArrayList Traversal: " + list.toString());
    }

    /**
     * Menambahkan elemen ke akhir ArrayList.
     * Kompleksitas waktu: O(1) amortized
     *
     * @param value nilai yang ditambahkan
     */
    public void addElement(int value) {
        list.add(value);
    }

    /**
     * Menambahkan elemen pada indeks tertentu (operasi penyisipan).
     * Kompleksitas waktu: O(n) -> elemen setelah indeks harus di-shift
     *
     * @param index posisi penyisipan
     * @param value nilai yang disisipkan
     */
    public void insertElement(int index, int value) {
        list.add(index, value);
    }

    /**
     * Menghapus elemen berdasarkan nilai (bukan indeks).
     * Kompleksitas waktu: O(n) -> harus mencari dulu (linear) lalu shift elemen
     *
     * @param value nilai yang ingin dihapus
     * @return true jika berhasil dihapus, false jika tidak ditemukan
     */
    public boolean removeElement(int value) {
        // Perlu di-cast ke Integer object agar method remove(Object) dipanggil,
        // bukan remove(int index)
        return list.remove(Integer.valueOf(value));
    }

    /**
     * Menghapus elemen berdasarkan indeks.
     * Kompleksitas waktu: O(n)
     *
     * @param index posisi elemen yang dihapus
     */
    public void removeAt(int index) {
        list.remove(index);
    }

    /**
     * Pencarian elemen dalam ArrayList menggunakan indexOf (linear search di balik layar).
     * Kompleksitas waktu: O(n)
     *
     * @param target nilai yang dicari
     * @return indeks elemen jika ditemukan, -1 jika tidak ditemukan
     */
    public int search(int target) {
        return list.indexOf(target);
    }

    /**
     * Mengurutkan elemen dalam ArrayList secara ascending menggunakan Collections.sort().
     * Kompleksitas waktu: O(n log n) -> menggunakan algoritma TimSort
     */
    public void sort() {
        Collections.sort(list);
    }
}