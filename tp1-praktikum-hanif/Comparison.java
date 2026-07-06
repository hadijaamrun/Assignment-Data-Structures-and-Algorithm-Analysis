import java.util.ArrayList;
import java.util.Arrays;

/**
 * Kelas Comparison
 * Bertugas membandingkan kinerja (waktu eksekusi) antara Array dan ArrayList
 * untuk operasi: traversal, pencarian, penyisipan, dan penghapusan.
 *
 * Waktu diukur menggunakan System.nanoTime() lalu dikonversi ke milidetik (ms)
 * agar mudah dibaca: 1 ms = 1_000_000 ns.
 */
public class Comparison {

    // Konversi nanosecond ke millisecond
    private static double toMillis(long nanos) {
        return nanos / 1_000_000.0;
    }

    /**
     * Menjalankan seluruh perbandingan untuk satu ukuran data (n elemen).
     * Data diisi dengan bilangan acak agar mensimulasikan kondisi nyata,
     * lalu operasi yang sama dijalankan pada Array dan ArrayList.
     *
     * @param n jumlah elemen data uji
     */
    public static void runComparison(int n) {
        // Menyiapkan data uji yang identik untuk Array dan ArrayList
        int[] baseArray = new int[n];
        ArrayList<Integer> baseList = new ArrayList<>();
        java.util.Random rand = new java.util.Random(42); // seed tetap agar hasil konsisten
        for (int i = 0; i < n; i++) {
            int value = rand.nextInt(n * 10);
            baseArray[i] = value;
            baseList.add(value);
        }

        int searchTarget = baseArray[n / 2]; // target pencarian: elemen di tengah
        int insertValue = 999999;
        int insertIndex = n / 2;

        System.out.println("\n================ PERBANDINGAN UNTUK n = " + n + " ELEMEN ================");

        // ---------- TRAVERSAL ----------
        ArrayOperations arrOps = new ArrayOperations(Arrays.copyOf(baseArray, baseArray.length));
        ArrayListOperations listOps = new ArrayListOperations(new ArrayList<>(baseList));

        long startArr = System.nanoTime();
        // Traversal tanpa print isi penuh untuk data besar (hanya hitung waktu iterasi)
        int[] arrData = arrOps.getArray();
        long dummySumArr = 0;
        for (int val : arrData) dummySumArr += val;
        long endArr = System.nanoTime();
        double traversalArrTime = toMillis(endArr - startArr);

        long startList = System.nanoTime();
        long dummySumList = 0;
        for (int val : listOps.getList()) dummySumList += val;
        long endList = System.nanoTime();
        double traversalListTime = toMillis(endList - startList);

        // ---------- LINEAR SEARCH (Array) vs SEARCH (ArrayList) ----------
        startArr = System.nanoTime();
        int foundIndexArr = arrOps.linearSearch(searchTarget);
        endArr = System.nanoTime();
        double searchArrTime = toMillis(endArr - startArr);

        startList = System.nanoTime();
        int foundIndexList = listOps.search(searchTarget);
        endList = System.nanoTime();
        double searchListTime = toMillis(endList - startList);

        // ---------- BINARY SEARCH (khusus Array, sebagai info tambahan) ----------
        startArr = System.nanoTime();
        int binaryIndex = arrOps.binarySearch(searchTarget);
        endArr = System.nanoTime();
        double binarySearchTime = toMillis(endArr - startArr);

        // ---------- PENYISIPAN ----------
        startArr = System.nanoTime();
        arrOps.insert(insertIndex, insertValue);
        endArr = System.nanoTime();
        double insertArrTime = toMillis(endArr - startArr);

        startList = System.nanoTime();
        listOps.insertElement(insertIndex, insertValue);
        endList = System.nanoTime();
        double insertListTime = toMillis(endList - startList);

        // ---------- PENGHAPUSAN ----------
        startArr = System.nanoTime();
        arrOps.delete(insertIndex);
        endArr = System.nanoTime();
        double deleteArrTime = toMillis(endArr - startArr);

        startList = System.nanoTime();
        listOps.removeAt(insertIndex);
        endList = System.nanoTime();
        double deleteListTime = toMillis(endList - startList);

        // ---------- PENGURUTAN (khusus ArrayList, sebagai info tambahan) ----------
        startList = System.nanoTime();
        listOps.sort();
        endList = System.nanoTime();
        double sortListTime = toMillis(endList - startList);

        // Tampilkan hasil operasi (untuk n kecil saja agar output tidak terlalu panjang)
        if (n <= 10) {
            arrOps = new ArrayOperations(Arrays.copyOf(baseArray, baseArray.length));
            listOps = new ArrayListOperations(new ArrayList<>(baseList));
            arrOps.traversal();
            listOps.traversal();
            System.out.println("Pencarian " + searchTarget + " dalam Array: Ditemukan di indeks " + arrOps.linearSearch(searchTarget));
            System.out.println("Pencarian " + searchTarget + " dalam ArrayList: Ditemukan di indeks " + listOps.search(searchTarget));
            arrOps.insert(insertIndex, insertValue);
            listOps.insertElement(insertIndex, insertValue);
            System.out.println("Array setelah penyisipan elemen " + insertValue + ": " + Arrays.toString(arrOps.getArray()));
            System.out.println("ArrayList setelah penyisipan elemen " + insertValue + ": " + listOps.getList());
        }

        // Tampilkan tabel perbandingan waktu eksekusi
        printTable(n, traversalArrTime, traversalListTime,
                   searchArrTime, searchListTime, binarySearchTime,
                   insertArrTime, insertListTime,
                   deleteArrTime, deleteListTime, sortListTime);
    }

    /**
     * Menampilkan tabel perbandingan waktu eksekusi dalam format teks sederhana.
     */
    private static void printTable(int n,
                                     double traversalArr, double traversalList,
                                     double searchArr, double searchList, double binarySearch,
                                     double insertArr, double insertList,
                                     double deleteArr, double deleteList,
                                     double sortList) {
        System.out.println("\nTabel Perbandingan Waktu Eksekusi (dalam milidetik) untuk n = " + n);
        System.out.printf("%-25s | %-15s | %-15s%n", "Operasi", "Array (ms)", "ArrayList (ms)");
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-25s | %-15.5f | %-15.5f%n", "Traversal", traversalArr, traversalList);
        System.out.printf("%-25s | %-15.5f | %-15.5f%n", "Pencarian (Linear)", searchArr, searchList);
        System.out.printf("%-25s | %-15.5f | %-15s%n", "Binary Search (Array)", binarySearch, "-");
        System.out.printf("%-25s | %-15.5f | %-15.5f%n", "Penyisipan", insertArr, insertList);
        System.out.printf("%-25s | %-15.5f | %-15.5f%n", "Penghapusan", deleteArr, deleteList);
        System.out.printf("%-25s | %-15s | %-15.5f%n", "Pengurutan (Sort)", "-", sortList);
        System.out.println("---------------------------------------------------------------");
    }
}