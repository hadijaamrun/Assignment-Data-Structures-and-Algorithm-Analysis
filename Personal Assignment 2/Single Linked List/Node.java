/**
 * Class Node merepresentasikan satu simpul (elemen) dalam Single Linked List.
 * Setiap Node menyimpan data satu buku dan referensi (pointer) ke Node berikutnya.
 */
public class Node {
    String kodeBuku;
    String judul;
    String penulis;
    Node next; // referensi ke node berikutnya dalam list

    public Node(String kodeBuku, String judul, String penulis) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.next = null; // node baru selalu menunjuk null di awal
    }
}