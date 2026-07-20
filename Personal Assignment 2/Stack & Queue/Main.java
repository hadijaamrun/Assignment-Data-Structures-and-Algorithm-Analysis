import java.util.Scanner;

/**
 * Class Main berisi program utama Sistem Kasir Toko.
 * Menggabungkan Queue (antrian pelanggan) dan Stack (riwayat transaksi)
 * lewat menu interaktif menggunakan Scanner.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue antrian = new Queue();
        Stack riwayat = new Stack();
        int pilihan;

        do {
            // Tampilkan menu
            System.out.println("\n=== SISTEM KASIR TOKO ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Lihat Riwayat Transaksi");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            // Validasi input harus berupa angka
            while (!scanner.hasNextInt()) {
                System.out.print("Input tidak valid, masukkan angka menu: ");
                scanner.next();
            }
            pilihan = scanner.nextInt();
            scanner.nextLine(); // buang sisa newline

            switch (pilihan) {
                case 1: // Tambah Antrian (Enqueue)
                    System.out.print("\nMasukkan Nomor Antrian: ");
                    String nomorAntrian = scanner.nextLine();
                    System.out.print("Masukkan Nama Pelanggan: ");
                    String namaPelanggan = scanner.nextLine();
                    System.out.print("Masukkan Total Belanja: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.print("Input tidak valid, masukkan angka: ");
                        scanner.next();
                    }
                    double totalBelanja = scanner.nextDouble();
                    scanner.nextLine();

                    boolean berhasilEnqueue = antrian.enqueue(nomorAntrian, namaPelanggan, totalBelanja);
                    if (berhasilEnqueue) {
                        System.out.println("Data pelanggan ditambahkan ke antrian!");
                    }
                    break;

                case 2: // Layani Pelanggan (Dequeue + Push ke Stack)
                    System.out.println();
                    Node dilayani = antrian.dequeue();
                    if (dilayani != null) {
                        System.out.println("Melayani pelanggan " + dilayani.nomorAntrian +
                                " (" + dilayani.namaPelanggan + ")");
                        riwayat.push(dilayani);
                        System.out.println("Transaksi disimpan ke riwayat.");
                    }
                    break;

                case 3: // Tampilkan Antrian
                    System.out.println();
                    antrian.tampilkanAntrian();
                    break;

                case 4: // Lihat Riwayat Transaksi
                    System.out.println();
                    riwayat.tampilkanRiwayat();
                    break;

                case 5: // Keluar
                    System.out.println("\nTerima kasih telah menggunakan Sistem Kasir Toko!");
                    break;

                default:
                    System.out.println("Pilihan menu tidak valid, silakan coba lagi.");
            }

        } while (pilihan != 5);

        scanner.close();
    }
}