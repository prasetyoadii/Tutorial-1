# Pemrograman Lanjut
**Prasetyo Adi Wijonarko** </br>
**2206830246**</br>
**ProLan A / DEE**</br>

<details>
<summary> Tutorial 1</summary>

### Exercise 1
- **Implementasi Clean Code Principles**
  * Meaningfull Name </br>
    Setiap penamaan variabel dan fungsi dalam kode jelas dan ringkas sehingga mudah dipahami. Contoh:
    ```
    public class Product {
        private String productId;
        private String productName;
        private int productQuantity;

        public Product() {
            this.productId = UUID.randomUUID().toString();
        }
    }
    ```
  * Function </br>
    Setiap function yang dibuat hanya mengerjakan satu tugas saja dan function tidak memiliki lebih dari 80 baris (ukuran function kecil). fungsi create, edit, findproductid, dan delete yang masing masing fungsinya hanya melakukan satu tujuan saja. Contoh: 
    ```
    public Product delete(String productId){
        Product existingProduct = findProductId(productId);
        productData.remove(existingProduct);
        return existingProduct;
        
    }
    ```
  * Comment<br>
    Dalam kode saya, belum terdapat implementasi komen karena penamaan pada variabel dan function sudah deskriptif.
  * Objects and Data Structures </br>
    Contoh:
    ```
    public class Product {
        private String productId;
        private String productName;
        private int productQuantity;

        public Product() {
            this.productId = UUID.randomUUID().toString();
        }
    }
    ```
    Atribut productId, productName, dan productQuantity dinyatakan sebagai private. Hal ini mencegah akses langsung dari luar kelas dan dapat diubah dengan menggunakan setter dan getter untuk berinteraksi dengan atribut tersebut.
  * Error Handling<br>
    Error handling dalam clean code digunakan untuk memastikan bahwa program dapat mengatasi kesalahan atau situasi tidak terduga. Contoh:
    ```
    @Test
    void productListPage_isCorrect(ChromeDriver driver) throws Exception {
        driver.get(baseUrl);
        WebElement checkInput = driver.findElement(By.className("btn"));
        checkInput.click();

        String titleProductList = driver.getTitle();
        assertEquals("Product List", titleProductList);
    }
    ```
  * Version Control</br>
    Dalam pengerjaan tutorial ini, saya telah mengaitkannya dengan `Git` dan menghubungkannya dengan repositori `Git` di akun `GitHub` pribadi saya. Saya membuat enam cabang dalam pengerjaan tutorial ini , yang mencakup `main`, `list-product`, `edit-product`, `delete-product`, `unit-test`, dan`functional-test`,
  * Unit Test</br>
    Saya membuat beberapa unit test untuk menguji fitur-fitur yang saya buat. Saya membuat unit test yang menguji fitur edit,delete, create poduct, dan lain-lain yang terdapat pada direktori `test`.
    

- **Hal yang Perlu Ditingkatkan**
  * Validasi </br>
   Belum terdapat validasi input saat create product dan edit product sehingga user bisa saja menginput kuantitas yang besarnya kurang dari 1 dan menginput string kosong
   * Secure Coding </br>
    Belum mengimplementasikan secure coding sehingga masih ada potensi serangan eksternal dan keamanan data belum baik    

## Exercise 2
- Kegunaan Unit Test<br>
  Dengan melakukan unit test, saya dapat memastikan bahwa setiap fitur seperti edit, delete, dan create berperilaku sesuai dengan yang diharapkan dan tidak mengalami kerusakan. Unit test juga harus melibatkan berbagai skenario yang berbeda termasuk uji positif dan negatif. Selain itu, unit test membantu dalam mendeteksi bug atau kesalahan lebih awal. 
- Code Coverage<br>
  Meskipun suatu program mencapai 100% code coverage, masih mungkin terdapat kondisi yang belum diuji oleh test suite, yang berarti beberapa bug atau kesalahan mungkin tetap tidak terdeteksi. Code coverage tinggi menunjukkan bahwa sebagian besar kode telah diuji, namun belum tentu mencakup semua situasi penggunaan.
- Another Number of Items Functional Test<br>
  Ketika kita menambahkan `functional test` yang baru yang, terdapat beberapa masalah yang berkaitan dengan kebersihan kode, berikut adalah beberapa masalahnya:
    * Redundancy (pengulangan): <br>
    Membuat functional test yang mirip dengan kode sebelumnya menimbulkan redundansi dalam kode. Ini dapat menyulitkan pemeliharaan dan meningkatkan potensi untuk duplikasi atau perubahan yang tidak sinkron.
    * Code Duplication (duplikasi kode): <br>
    Duplikasi kode menyebabkan kesulitan dalam pemeliharaan karena setiap perubahan pada fungsionalitas harus diperbarui di setiap tempat duplikasi, meningkatkan risiko kelupaan pembaruan.
    * Maintainability(pemeliharaan): <br>
    Kode yang redundan dan memiliki banyak duplikasi dapat mempersulit pemeliharaan. Setiap perubahan pada satu tempat mungkin perlu diterapkan secara manual di tempat lain.

  Solusi:
    * Inheritance or Composition: <br>
    Inheritance berguna untuk mengatasi duplikasi kode karena memungkinkan kelas anak untuk mewarisi sifat kelas induk. Dengan menggunakan inheritance, kode yang sama atau serupa dapat ditempatkan di kelas induk, dan kelas anak dapat mewarisi fungsionalitas tersebut tanpa perlu menduplikasi kode.
    * Review and Refactoring: <br>
    Dalam proses review kode, tim pengembang mengidentifikasi dan mengatasi redundansi serta duplikasi kode fungsional test melalui diskusi dan pengamatan bersama. Review membantu mengenali potensi duplikasi. Selain itu, refactoring digunakan untuk membuat abstraksi yang lebih baik, mengurangi duplikasi tanpa mengorbankan fungsionalitas, dan memfasilitasi penempatan kode terduplikasi di lokasi yang sesuai, meningkatkan kebersihan dan konsistensi dalam pemeliharaan kode.
</details>

<details>
<summary> Tutorial 2</summary>

## Tutorial 2
[Link Website](https://eshop-prasetyoadii.koyeb.app/)

[![SonarCloud](https://sonarcloud.io/images/project_badges/sonarcloud-orange.svg)](https://sonarcloud.io/summary/new_code?id=prasetyoadii_Tutorial-1)

#### Reflection

1. Saya melihat isu isu berikut pada sonarcloud (code smell) dan memperbaikinya. Berikut adalah list isu tersebut:
   - Isu tabel tidak memiliki deskripsi<br>
    Strategi : Menambahkan elemen ```<caption>``` ke dalam HTML
   - Field Injection<br>
   Strategi :  Pada kelas ProductCotroller dan Product service ubah field injection menjadi constructor injection
   - Public modifier kelas test<br>
   Strategi :  Menghilangkan modifier public pada semua kelas test
   - Setidaknya menambahkan assertion pada testcse<br>
    Strategi : Menambahkan assertion untuk method ```mainMethodDoesNotThrowException() ``` dan ```void contextLoads()``` pada `EshopApplicationTest.java`


2. Untuk saat ini, implementasi berhasil memenuhi konsep CI/CD dengan menggunakan GitHub Workflows. Setiap kali ada perubahan di-push atau di-pull request ke repository GitHub, alur kerja otomatis diaktifkan. Proses ini mencakup uji kode menggunakan test case dalam `ci.yml`, analisis kode oleh OSSF Scorecard menggunakan scorecard.yml, dan code scanning dengan SonarCloud melalui `sonarcloud.yml`. setelah semua tahap berhasil, perubahan kode akan digabungkan ke branch utama. Selanjutnya, melakukan deployment ke platform as a service (PaaS) Koyeb secara otomatis. Setiap deployment, terdapat pemeriksaan keamanan kode dengan menggunakan `scorecard.yml`. Dengan demikian, implementasi ini membentuk alur kerja otomatis yang menyelaraskan siklus pengembangan perangkat lunak (Software Development Life Cycle) secara lengkap, termasuk CI/CD.

</details>

<details>
<summary> Tutorial 3 </summary>

## Tutorial 3
1. **Explain what principles you apply to your project!** <br>
     * SRP: Melakukan pemisahan file `CarController.java` yang tadinya terdapat pada `ProductController.java` karena setiap kelas memiliki fungsi yang berbeda. Sehingga setiap kelas dapat fokus pada tanggung jawabnya sendiri tanpa terjebak dalam keberagaman tanggung jawab yang tidak terkait.
     * ISP: Memisahkan interface `CarService` dan `ProductService` karena kedua interface tersebut memiliki dua tanggung jawab yang berbeda. Sehingga `CarService` dapat berfokus pada operasi yang terkait dengan car, sementara `ProductService` dapat berfokus pada operasi yang terkait dengan produk. interface yang lebih kecil dan lebih spesifik memberikan fleksibilitas lebih besar. Misalnya, jika ada kelas yang hanya memerlukan fungsi dari `CarService`, kelas tersebut tidak perlu tahu tentang `ProductService`.
     * DIP: Saya menggunakan antarmuka `CarService` daripada `CarServiceImpl` pada `CarController.java` untuk menghindari potensi kerusakan jika terjadi perubahan pada `CarServiceImpl`

2.   **Explain the advantages of applying SOLID principles to your project with examples.** <br>
   Dengan mengimplementasikan SOLID principle, Kode yang saya buat menjadi lebih modular, terstruktur, maintainable, bersih, dan readable. Prinsip-prinsip seperti Single Responsibility Principle (SRP) membantu memfokuskan setiap komponen pada satu tanggung jawab, meningkatkan keterbacaan dan pemeliharaan. Interface Segregation Principle (ISP) membantu dalam memisahkan antarmuka menjadi lebih spesifik sesuai dengan fungsionalitas yang diperlukan dan Dependency Inversion Principle (DIP) membantu mengelola ketergantungan dengan baik dan memastikan setiap komponen hanya bergantung pada fungsionalitas yang diperlukan. Hasilnya adalah kode yang tidak hanya efisien dalam implementasi fitur, tetapi juga mudah dipahami dan dikelola. Contohnya sudah saya berikan diatas. 
3.   **Explain the disadvantages of not applying SOLID principles to your project with examples.** <br>
   Jika saya tidak menerapkan prinsip SOLID kode menjadi rumit dan sulit dipahami. Bisa jadi suatu kelas dapat melakukan terlalu banyak tugas dan memiliki banyak tanggung jawab. Ini juga dapat menyebabkan kesulitan dalam pemeliharaan dan perubahan. Selain itu, kode tersebut bisa menjadi sulit untuk diuji dan kurang fleksibel untuk menangani perubahan atau penambahan fitur baru. Akhirnya, kode yang tidak mengikuti prinsip SOLID sering kali sulit untuk digunakan kembali dalam konteks lain. Secara keseluruhan, menerapkan prinsip SOLID dapat membantu Anda menghindari banyak masalah ini dan membuat kode Anda lebih bersih, lebih mudah dipahami, dan lebih mudah dipelihara. Salah satu contohnya, pelanggaran Single Responsibility Principle (SRP): SRP menyatakan bahwa setiap kelas harus memiliki satu dan hanya satu alasan untuk berubah. Jika CarController dan ProductController berada dalam satu kelas, kelas tersebut memiliki lebih dari satu alasan untuk berubah, yang melanggar SRP. Perubahan pada Car dapat mempengaruhi Product, dan sebaliknya. Ini dapat membuat pemeliharaan kode menjadi lebih sulit. Pengujian menjadi lebih sulit karena Anda harus menguji Car dan Product bersama-sama. Jika ada bug, akan lebih sulit untuk menentukan apakah itu berasal dari Car atau Product.
</details>

## Tutorial 4
1. **Reflect based on Percival (2017) proposed self-reflective questions (in “Principles and Best Practice of Testing” submodule, chapter “Evaluating Your Testing Objectives”), whether this TDD flow is useful enough for you or not. If not, explain things that you need to do next time you make more tests** <br>
Pentingnya pengembangan Test-Driven Development (TDD) ke depan adalah untuk memperluas cakupan pengujian guna memantau interaksi antar fitur. Ini berarti menambahkan pengujian yang mencakup pembuatan, pembaruan, dan penghapusan 100 produk sekaligus, sehingga memastikan integrasi yang benar di antara ketiga fitur tersebut. Pendekatan ini akan meningkatkan kepastian terhadap kebenaran kode. Bagi saya pribadi, TDD sangat berguna karena memberikan alur kerja yang terstruktur, terdiri dari tiga langkah utama: [RED], [GREEN], dan [REFACTOR]. Dengan membagi proses pengembangan menjadi tahapan-tahapan ini, TDD memudahkan implementasi kelas dengan menangani segala kemungkinan kasus, baik yang bersifat positif maupun negatif. Hasilnya adalah kode yang lebih aman dan mempermudah proses refaktor.

2. **You have created unit tests in Tutorial. Now reflect whether your tests have successfully followed F.I.R.S.T. principle or not. If not, explain things that you need to do the next time you create more tests.** <br>
Tes yang telah disusun memenuhi prinsip F.I.R.S.T., di mana algoritma pengujian dirancang secara minimalis untuk menguji keseluruhan kode. Unit test diisolasi satu sama lain, sehingga tidak ada saling mempengaruhi. Setiap tes dilengkapi dengan asersi untuk memastikan kebenaran output, dan dapat dijalankan berulang kali setiap kali terjadi perubahan kode yang perlu diuji. Dalam tutorial ini, unit test yang telah dibuat sudah sepenuhnya memenuhi prinsip F.I.R.S.T., dengan algoritma yang dikhususkan untuk suatu metode tanpa campur tangan pada metode lain. Penggunaan mock pada service test juga dilakukan untuk memastikan bahwa pengujian tidak mempengaruhi kode asli. Hasil dari setiap tes dilengkapi dengan asersi, mencakup semua kemungkinan kasus "happy" dan "unhappy" dari metode yang sedang diperiksa.
