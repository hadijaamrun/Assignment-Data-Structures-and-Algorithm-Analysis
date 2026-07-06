# Personal Assignment Practicum: Data Structures and Algorithm Analysis
## Perbandingan Operasi Dasar pada Array dan ArrayList (Java)

Repository ini berisi implementasi dan analisis perbandingan kinerja antara struktur data **Array** dan **ArrayList** di Java, mencakup operasi traversal, pencarian (linear & binary search), penyisipan, dan penghapusan.

## Ringkasan

| Kelas | Fungsi |
|---|---|
| `ArrayOperations` | Traversal `O(n)`, Linear Search `O(n)`, Binary Search `O(log n)`, Insert `O(n)`, Delete `O(n)` |
| `ArrayListOperations` | Add `O(1)` amortized, Insert `O(n)`, Remove `O(n)`, Search `O(n)`, Sort `O(n log n)` |
| `Comparison` | Mengukur waktu eksekusi tiap operasi menggunakan `System.nanoTime()` dan menampilkannya dalam bentuk tabel |
| `Main` | Menjalankan demonstrasi dan perbandingan untuk berbagai ukuran data (5, 100, 1.000, 10.000 elemen) |

## Contoh Hasil Perbandingan (n = 10.000 elemen)

| Operasi | Array (ms) | ArrayList (ms) | Lebih Cepat |
|---|---|---|---|
| Traversal | 0.16420 | 0.63150 | Array |
| Pencarian (Linear) | 0.07950 | 0.15680 | Array |
| Penyisipan | 0.01970 | 0.04080 | Array |
| Penghapusan | 0.06650 | 0.00580 | ArrayList |


## Kesimpulan

- **Array** lebih cepat untuk traversal dan pencarian karena menyimpan nilai primitif langsung di memori (tanpa overhead autoboxing).
- **ArrayList** lebih fleksibel karena ukurannya dinamis, dan pada data besar operasi penghapusan/penyisipan bisa lebih efisien karena tidak perlu membuat array baru secara penuh seperti implementasi Array fixed-size.
