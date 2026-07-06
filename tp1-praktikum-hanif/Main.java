/**
 * Kelas Main
 * Titik masuk program (entry point). Menjalankan demonstrasi operasi dasar
 * pada Array dan ArrayList, kemudian menjalankan perbandingan kinerja
 * untuk beberapa ukuran data (kecil, sedang, besar).
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" TUGAS: PERBANDINGAN OPERASI ARRAY vs ARRAYLIST");
        System.out.println("==================================================");

        // ---- Bagian 1: Demonstrasi sederhana dengan data kecil (sesuai contoh output) ----
        System.out.println("\n--- DEMONSTRASI DENGAN DATA KECIL ---");
        Comparison.runComparison(5);

        // ---- Bagian 2: Perbandingan kinerja dengan data berukuran lebih besar ----
        System.out.println("\n\n--- PERBANDINGAN KINERJA DENGAN DATA BERUKURAN BESAR ---");
        int[] testSizes = {100, 1000, 10000};
        for (int size : testSizes) {
            Comparison.runComparison(size);
        }

        System.out.println("\n==================================================");
        System.out.println(" PROGRAM SELESAI DIJALANKAN");
        System.out.println("==================================================");
    }
}