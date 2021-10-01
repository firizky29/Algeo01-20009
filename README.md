# TUBES 1 IF2123 Aljabar Linier dan Geometri

## Kelompok 30 - mengtubes hehe
* Ahmad Romy Zahran (13520009)
* Firizky Ardiansyah (13520095)
* Muhammad Fahmi Irfan (13520152)

## Deskripsi Tubes
Projek untuk membuat _library_ aljabar linier dalam bahasa Java dan menggunakannya untuk menyelesaikan persoalan dalam bentuk SPL, interpolasi polinom dan regresi linier berganda.   

## Struktur Direktori
- Folder _bin_ : berisi _java bytecode_
- Folder src : berisi folder algeo yang berisi 5 folder:
  * IO : berisi source code untuk _GUI_(antarmuka pengguna)
  * adt : berisi kelas Matriks umum
  * driver : berisi kelas Main untuk pengujian di terminal
  * lib : berisi 12 objek kelas yang bersama membentuk _library_ aljabar linier.
  * resource : berisi logo program.  
- Folder test : berisi data uji
- Folder doc : berisi laporan

## Cara Penggunaan Program
- compile blabla sampe kebuka programnya
- Ketika program dibuka, akan muncul jendela `Menu` sebagai berikut.
- Anda dapat memilih satu dari lima persoalan yang dapat diselesaikan. Perlu diketahui bahwa Anda dapat memilih persoalan lain jika Anda memilih `Sistem Persamaan Linier`, `Determinan`, atau `Invers Matriks`. Sedangkan jika anda memilih `Interpolasi Polinom` atau `Regresi Linier` anda perlu membuka program lagi untuk memilih persoalan lain.
- Pada submenu `Sistem Persamaan Linier` terdapat 4 pilihan metode sebagai berikut dan ada tombol `Kembali` untuk kembali ke menu utama. Perlu diketahui bahwa `Metode Matriks Balikan` dan `Metode Cramer` tidak mengeluarkan output untuk Sistem Persamaan Linier yang tidak memiliki solusi atau memiliki solusi banyak.
- Antarmuka untuk persoalan `Sistem Persamaan Linier` adalah sebagai berikut.
  * Kotak dialog Banyak Baris akan diisi banyak baris pada matriks augmented
  * Kotak dialog Banyak Kolom akan diisi banyak kolom pada matriks augmented
  * Tombol Create digunakan untuk membuat matriks berukuran baris dan kolom sesuai input yang komponennya 0 semua. Matriks dapat diinput jika baris dan kolom sudah sesuai dan tombol create sudah dklik.
  * Tombol Calculate di atas digunakan untuk mencari solusi dari matriks augmented yang sudah diinput
  * Tombol Home digunakan untuk kembali ke menu utama
  * Tombol Reset digunakan untuk mereset matriks yang akan diinput menjadi matriks nol
  * Tombol Open digunakan untuk membuka file berisi matriks augmented
  * Tombol Calculate di bawah digunakan untuk mencari solusi dari matriks augmented pada file yang telah diinput
  * Tombol Save di bawah digunakan untuk menyimpan solusi dalam file txt
- Antarmuka untuk persoalan `Determinan` dan `Invers Matriks` juga mirip dengan `Sistem Persamaan Linier`. Persoalan `Determinan` dan `Invers Matriks` memiliki 2 metode yang dapat dipilih, yaitu `Metode Reduksi Baris` dan `Metode Ekspansi Kofaktor`.
- Antarmuka `Interpolasi Polinom` dan `Regresi Linier` adalah sebagai berikut. Terdapat tambahan kotak persamaan polinom/regresi dan panel untuk mencari nilai yang ingin diestimasi. Untuk persamaan dan nilai estimasi dicari dengan tombol `Calculate`.
- Perlu dipastikan bahwa setiap masukan dari GUI sudah dengan menekan tombol `Create` dan `Calculate`. 
