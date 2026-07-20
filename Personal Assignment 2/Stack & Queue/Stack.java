/**
 * Class Stack menyimpan riwayat transaksi pelanggan yang sudah dilayani,
 * dengan prinsip LIFO (Last In First Out) menggunakan struktur linked list.
 * top = transaksi paling baru (ditampilkan paling atas).
 */
public class Stack {
    private Node top;
    private int jumlah;

    public Stack() {
        top = null;
        jumlah = 0;
    }

    /**
     * Push: menyimpan data transaksi pelanggan yang baru selesai dilayani
     * ke posisi paling atas stack.
     */
    public void push(Node transaksi) {
        transaksi.next = top; // node baru menunjuk ke transaksi lama
        top = transaksi;      // top diperbarui ke transaksi baru
        jumlah++;
    }

    /**
     * Menampilkan seluruh riwayat transaksi dari yang TERBARU ke yang TERLAMA.
     */
    public void tampilkanRiwayat() {
        if (top == null) {
            System.out.println("Belum ada riwayat transaksi.");
            return;
        }

        System.out.println("Riwayat Transaksi (Terbaru -> Terlama):");
        Node current = top;
        int urutan = 1;
        while (current != null) {
            System.out.println(urutan + ". No: " + current.nomorAntrian +
                    " | Nama: " + current.namaPelanggan +
                    " | Total: Rp" + (long) current.totalBelanja);
            current = current.next;
            urutan++;
        }
        System.out.println("Total Transaksi Selesai: " + jumlah);
    }
}