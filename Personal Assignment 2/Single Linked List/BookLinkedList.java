/**
 * Class BookLinkedList mengelola koleksi data buku menggunakan struktur
 * Single Linked List. Operasi yang tersedia: tambahBuku (push di akhir),
 * hapusBuku (pop dari akhir), cariBuku, dan tampilkanSemua.
 */
public class BookLinkedList {
    private Node head;      // penunjuk ke node pertama dalam list
    private int jumlahBuku; // penghitung total buku saat ini

    public BookLinkedList() {
        head = null;
        jumlahBuku = 0;
    }

    /**
     * Menambahkan data buku baru di AKHIR daftar (operasi Push).
     * Validasi: panjang kodeBuku tidak boleh lebih dari 5 karakter.
     *
     * Catatan: syarat "jumlah data minimal 5 buku" pada soal diperlakukan
     * sebagai target pengujian (minimal 5 data dicoba saat demo program),
     * bukan sebagai validasi yang memblokir operasi hapus/cari saat data < 5,
     * karena hal itu akan membuat operasi Pop tidak wajar dipakai.
     */
    public boolean tambahBuku(String kodeBuku, String judul, String penulis) {
        if (kodeBuku.length() > 5) {
            System.out.println("Gagal menambahkan! Kode Buku maksimal 5 karakter.");
            return false;
        }

        Node bukuBaru = new Node(kodeBuku, judul, penulis);

        if (head == null) {
            // Jika list masih kosong, node baru menjadi head
            head = bukuBaru;
        } else {
            // Telusuri sampai node terakhir, lalu sambungkan
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = bukuBaru;
        }
        jumlahBuku++;
        return true;
    }

    /**
     * Menghapus data buku TERAKHIR dari daftar (operasi Pop).
     * Jika daftar kosong, tampilkan pesan sesuai instruksi soal.
     */
    public boolean hapusBuku() {
        if (head == null) {
            System.out.println("Tidak ada data untuk dihapus.");
            return false;
        }

        if (head.next == null) {
            // Hanya ada satu node dalam list
            System.out.println("Buku '" + head.judul + "' (Kode: " + head.kodeBuku + ") berhasil dihapus.");
            head = null;
        } else {
            // Telusuri sampai node kedua-dari-terakhir
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            System.out.println("Buku '" + current.next.judul + "' (Kode: " + current.next.kodeBuku + ") berhasil dihapus.");
            current.next = null;
        }
        jumlahBuku--;
        return true;
    }

    /**
     * Mencari buku berdasarkan kodeBuku.
     * Mengembalikan Node jika ditemukan, atau null jika tidak.
     */
    public Node cariBuku(String kodeBuku) {
        Node current = head;
        while (current != null) {
            if (current.kodeBuku.equalsIgnoreCase(kodeBuku)) {
                return current;
            }
            current = current.next;
        }
        return null; // tidak ditemukan
    }

    /**
     * Menampilkan seluruh data buku sesuai urutan input,
     * beserta total jumlah buku di akhir daftar.
     */
    public void tampilkanSemua() {
        if (head == null) {
            System.out.println("Belum ada data buku.");
            return;
        }

        System.out.println("Daftar Buku:");
        Node current = head;
        while (current != null) {
            System.out.println("Kode: " + current.kodeBuku +
                    " | Judul: " + current.judul +
                    " | Penulis: " + current.penulis);
            current = current.next;
        }
        System.out.println("Total Buku: " + jumlahBuku);
    }

    public int getJumlahBuku() {
        return jumlahBuku;
    }
}