/**
 * Class Node merepresentasikan data satu pelanggan.
 * Node ini dipakai bersama oleh Queue (antrian) dan Stack (riwayat transaksi).
 */
public class Node {
    String nomorAntrian;
    String namaPelanggan;
    double totalBelanja;
    Node next; // referensi ke node berikutnya (dipakai Queue maupun Stack)

    public Node(String nomorAntrian, String namaPelanggan, double totalBelanja) {
        this.nomorAntrian = nomorAntrian;
        this.namaPelanggan = namaPelanggan;
        this.totalBelanja = totalBelanja;
        this.next = null;
    }
}