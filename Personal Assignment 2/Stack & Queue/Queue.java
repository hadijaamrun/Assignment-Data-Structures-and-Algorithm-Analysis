/**
 * Class Queue mengelola antrian pelanggan dengan prinsip FIFO
 * (First In First Out) menggunakan struktur linked list.
 * front = pelanggan paling depan (dilayani duluan)
 * rear  = pelanggan paling belakang (baru masuk)
 */
public class Queue {
    private Node front;
    private Node rear;
    private int jumlah;

    // Kapasitas maksimal antrian sesuai validasi pada soal (jumlah data <= 5)
    private static final int KAPASITAS_MAKS = 5;

    public Queue() {
        front = null;
        rear = null;
        jumlah = 0;
    }

    /**
     * Enqueue: menambahkan pelanggan baru ke BELAKANG antrian.
     * Validasi: jumlah antrian tidak boleh melebihi kapasitas maksimal (5).
     */
    public boolean enqueue(String nomorAntrian, String namaPelanggan, double totalBelanja) {
        if (jumlah >= KAPASITAS_MAKS) {
            System.out.println("Gagal menambahkan! Antrian sudah penuh (maksimal " + KAPASITAS_MAKS + " pelanggan).");
            return false;
        }

        Node baru = new Node(nomorAntrian, namaPelanggan, totalBelanja);
        if (rear == null) {
            // Antrian masih kosong, node baru jadi front sekaligus rear
            front = baru;
            rear = baru;
        } else {
            rear.next = baru;
            rear = baru;
        }
        jumlah++;
        return true;
    }

    /**
     * Dequeue: mengeluarkan pelanggan paling DEPAN untuk dilayani.
     * Mengembalikan Node pelanggan yang dilayani, atau null jika antrian kosong.
     */
    public Node dequeue() {
        if (front == null) {
            System.out.println("Tidak ada pelanggan dalam antrian untuk dilayani.");
            return null;
        }

        Node dilayani = front;
        front = front.next;
        if (front == null) {
            rear = null; // antrian menjadi kosong setelah node terakhir keluar
        }
        jumlah--;
        return dilayani;
    }

    /**
     * Menampilkan seluruh pelanggan yang sedang mengantre saat ini.
     */
    public void tampilkanAntrian() {
        if (front == null) {
            System.out.println("Antrian kosong, belum ada pelanggan.");
            return;
        }

        System.out.println("Antrian Pelanggan Saat Ini:");
        Node current = front;
        int posisi = 1;
        while (current != null) {
            System.out.println(posisi + ". No: " + current.nomorAntrian +
                    " | Nama: " + current.namaPelanggan +
                    " | Total: Rp" + (long) current.totalBelanja);
            current = current.next;
            posisi++;
        }
        System.out.println("Jumlah Pelanggan dalam Antrian: " + jumlah);
    }
}