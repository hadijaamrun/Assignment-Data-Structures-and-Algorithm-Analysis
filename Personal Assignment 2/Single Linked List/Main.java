import java.util.Scanner;

/**
 * Class Main berisi program utama: menu interaktif untuk menguji
 * seluruh operasi pada BookLinkedList (tambah, hapus, cari, tampil).
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookLinkedList daftarBuku = new BookLinkedList();
        int pilihan;

        do {
            // Tampilkan menu
            System.out.println("\n===== SISTEM DATA BUKU =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            // Validasi input harus berupa angka
            while (!scanner.hasNextInt()) {
                System.out.print("Input tidak valid, masukkan angka menu: ");
                scanner.next();
            }
            pilihan = scanner.nextInt();
            scanner.nextLine(); // buang sisa newline setelah nextInt()

            switch (pilihan) {
                case 1: // Tambah Buku (Push)
                    System.out.print("\nMasukkan Kode Buku (maks 5 karakter): ");
                    String kodeBuku = scanner.nextLine();
                    System.out.print("Masukkan Judul: ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan Penulis: ");
                    String penulis = scanner.nextLine();

                    boolean berhasilTambah = daftarBuku.tambahBuku(kodeBuku, judul, penulis);
                    if (berhasilTambah) {
                        System.out.println("Data berhasil ditambahkan!");
                    }
                    break;

                case 2: // Hapus Buku (Pop)
                    System.out.println();
                    daftarBuku.hapusBuku();
                    break;

                case 3: // Cari Buku
                    System.out.print("\nMasukkan Kode Buku yang dicari: ");
                    String kodeDicari = scanner.nextLine();
                    Node hasilCari = daftarBuku.cariBuku(kodeDicari);
                    if (hasilCari != null) {
                        System.out.println("Buku ditemukan!");
                        System.out.println("Kode: " + hasilCari.kodeBuku +
                                " | Judul: " + hasilCari.judul +
                                " | Penulis: " + hasilCari.penulis);
                    } else {
                        System.out.println("Buku tidak ditemukan.");
                    }
                    break;

                case 4: // Tampilkan Semua Buku
                    System.out.println();
                    daftarBuku.tampilkanSemua();
                    break;

                case 5: // Keluar
                    System.out.println("\nTerima kasih telah menggunakan Sistem Data Buku Perpustakaan!");
                    break;

                default:
                    System.out.println("Pilihan menu tidak valid, silakan coba lagi.");
            }

        } while (pilihan != 5);

        scanner.close();
    }
}