import java.util.Arrays;

/**
 * Kelas ArrayOperations
 * Berisi implementasi operasi dasar pada struktur data Array (fixed-size):
 * - Traversal
 * - Pencarian (Linear Search & Binary Search)
 * - Penyisipan (Insertion)
 * - Penghapusan (Deletion)
 *
 * Catatan kompleksitas (Big-O):
 * - Traversal        : O(n)
 * - Linear Search     : O(n)
 * - Binary Search     : O(log n)  -> syarat: array sudah terurut
 * - Insertion         : O(n)      -> karena butuh shift elemen & pembuatan array baru
 * - Deletion          : O(n)      -> karena butuh shift elemen & pembuatan array baru
 */
public class ArrayOperations {

    private int[] array;

    // Konstruktor: menerima array awal
    public ArrayOperations(int[] initialArray) {
        this.array = initialArray;
    }

    // Getter untuk mengambil array saat ini
    public int[] getArray() {
        return array;
    }

    /**
     * Traversal: menampilkan seluruh isi array.
     * Kompleksitas waktu: O(n), kompleksitas ruang: O(1)
     */
    public void traversal() {
        System.out.println("Array Traversal: " + Arrays.toString(array));
    }

    /**
     * Linear Search: mencari nilai target dengan memeriksa elemen satu per satu.
     * Kompleksitas waktu: O(n) - tidak memerlukan array terurut
     * Kompleksitas ruang: O(1)
     *
     * @param target nilai yang dicari
     * @return 
     */
    public int linearSearch(int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Binary Search: mencari nilai target pada array yang SUDAH TERURUT
     * dengan cara membagi dua ruang pencarian secara berulang.
     * Kompleksitas waktu: O(log n)
     * Kompleksitas ruang: O(1) (iteratif)
     *
     * @param target nilai yang dicari
     * @return indeks elemen jika ditemukan, -1 jika tidak ditemukan
     */
    public int binarySearch(int target) {
        int[] sortedArray = Arrays.copyOf(array, array.length);
        Arrays.sort(sortedArray); // Binary search membutuhkan array terurut

        int low = 0;
        int high = sortedArray.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sortedArray[mid] == target) {
                return mid; // indeks pada array yang sudah diurutkan
            } else if (sortedArray[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Penyisipan (Insertion): menyisipkan nilai baru pada indeks tertentu.
     * Karena array bersifat fixed-size di Java, proses ini membuat array baru
     * berukuran (n+1) lalu menyalin elemen menggunakan System.arraycopy()
     * agar lebih efisien dibanding penyalinan manual dengan loop.
     *
     * @param index posisi penyisipan
     * @param value nilai yang disisipkan
     */
    public void insert(int index, int value) {
        if (index < 0 || index > array.length) {
            throw new IndexOutOfBoundsException("Indeks penyisipan tidak valid: " + index);
        }

        int[] newArray = new int[array.length + 1];

        // Salin elemen sebelum indeks penyisipan
        System.arraycopy(array, 0, newArray, 0, index);
        // Sisipkan nilai baru
        newArray[index] = value;
        // Salin elemen setelah indeks penyisipan (di-shift satu posisi ke kanan)
        System.arraycopy(array, index, newArray, index + 1, array.length - index);

        this.array = newArray;
    }

    /**
     * Penghapusan (Deletion): menghapus elemen pada indeks tertentu.
     * Membuat array baru berukuran (n-1) dan menyalin elemen selain
     * elemen yang dihapus menggunakan System.arraycopy().
     *
     * Kompleksitas waktu: O(n) - karena elemen setelah indeks hapus harus di-shift
     * Kompleksitas ruang: O(n) - karena membuat array baru
     *
     * @param index posisi elemen yang akan dihapus
     */
    public void delete(int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Indeks penghapusan tidak valid: " + index);
        }

        int[] newArray = new int[array.length - 1];

        // Salin elemen sebelum indeks yang dihapus
        System.arraycopy(array, 0, newArray, 0, index);
        // Salin elemen setelah indeks yang dihapus
        System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);

        this.array = newArray;
    }
}