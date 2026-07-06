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

<img width="419" height="167" alt="Screenshot 2026-07-06 083342" src="https://github.com/user-attachments/assets/3d412416-b76c-435e-be30-5b246b96bfeb" />
<img width="503" height="173" alt="Screenshot 2026-07-06 083347" src="https://github.com/user-attachments/assets/069086db-188c-4b6c-aac9-fed3dfc133c8" />
<img width="414" height="143" alt="Screenshot 2026-07-06 083331" src="https://github.com/user-attachments/assets/9e84716a-8c5b-4cf0-bf8f-fc8da8f96966" />
<img width="420" height="182" alt="Screenshot 2026-07-06 083337" src="https://github.com/user-attachments/assets/d41b82aa-452c-4fd8-a416-192303e49c00" />

## Kesimpulan

- **Array** lebih cepat untuk traversal dan pencarian karena menyimpan nilai primitif langsung di memori (tanpa overhead autoboxing).
- **ArrayList** lebih fleksibel karena ukurannya dinamis, dan pada data besar operasi penghapusan/penyisipan bisa lebih efisien karena tidak perlu membuat array baru secara penuh seperti implementasi Array fixed-size.
