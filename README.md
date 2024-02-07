# Pemrograman Lanjut
**Prasetyo Adi Wijonarko** </br>
**2206830246**</br>
**ProLan A / DEE**</br>

## Exercise 1
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
    Atribut productId, productName, dan productQuantity dinyatakan sebagai privat (private), mengikuti prinsip penyembunyian informasi. Hal ini mencegah akses langsung dari luar kelas dan mendorong penggunaan metode (getter dan setter) untuk berinteraksi dengan atribut tersebut.
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