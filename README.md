# API-Testing Menggunakan Postman dan Rest Assured
## Description
Pengujian API menggunakan Postman (manual) dan Rest Assured (otomatis) pada Program User Controller pada tautan https://dummyapi.io/docs/user untuk menguji API: Get User by id, Create User, Update User dan Delete User

## Tentang Project API Testing

### Class
- **CreateTest**: Class ini merupakan class pengujian untuk menguji request create data user pada API.
- **GetTest**: Class ini merupakan class pengujian untuk menguji request read data user berdasarkan id pada API.
- **UpdateTest**: Class ini merupakan class pengujian untuk menguji request update data user berdasarkan id pada API.
- **DeleteTest**: Class ini merupakan class pengujian untuk menguji request delete data user berdasarkan id pada API.

## Directory Tree Project
```
.
├── src
│   ├── main/java/com/apitesting
│   │   └── ...
│   └── test
│       └── java
│           └── com
│               └── apitesting
│                   ├── CreateTest.java
│                   ├── DeleteTest.java
│                   ├── GetTest.java
│                   └── UpdateTest.java
├── target
│   ├── classes/com/apitesting
│   │   └── ....
│   ├── generated-sources
│   ├── generated-test-sources
│   ├── maven-status/maven-compiler-plugin
│   │   ├── compile/default-compile
│   │   │   └── ...
│   │   └── testCompile/default-testCompile
│   │       └── ...
│   ├── site
│   │   ├── css
│   │   │   └── ...
│   │   ├── images
│   │   │   └── ...
│   │   ├── surefire-report.html
│   │   └── ...
│   ├── surefire-reports
│   └── test-classes/com/calculator
│       └── ...
└── pom.xml
```
### Penjelasan Directory Root Project
1. **src:** Ini adalah direktori sumber (source) utama yang berisi kode sumber aplikasi.
2. **main\java\com\apitesting:** Ini adalah direktori di mana kode sumber utama (production code) dari aplikasi ditempatkan.
3. **test\java\com\apitesting:** Ini adalah direktori di mana kode sumber pengujian (test code) dari aplikasi ditempatkan.
7. **CreateTest.java:** Ini berisi pengujian untuk method POST.
8. **DeleteTest.java:** Ini berisi pengujian untuk method DELETE.
9. **GetTest.java:** Ini berisi pengujian untuk method GET.
10. **UpdateTest.java:** Ini berisi pengujian untuk method PUT.
11. **target:** Ini adalah direktori yang berisi hasil dari proses kompilasi dan pembuatan (build) lainnya.
12. **classes/com/apitesting:** Direktori tempat hasil kompilasi dari kode sumber utama ditempatkan.
13. **generated-sources:** Direktori untuk sumber yang dihasilkan, mungkin oleh proses generasi kode.
14. **generated-test-sources:** Direktori untuk sumber pengujian yang dihasilkan.
15. **maven-status/maven-compiler-plugin:** Direktori yang berisi informasi status proyek yang dihasilkan oleh Maven.
16. **site:** Direktori yang berisi laporan dan sumber daya lainnya yang dihasilkan oleh plugin Maven yang berorientasi laporan.
17. **surefire-reports:** Direktori yang berisi laporan hasil pengujian yang dihasilkan oleh Surefire plugin.
18. **pom.xml:** Ini adalah berkas POM (Project Object Model) Maven yang berisi konfigurasi proyek, dependensi, dan informasi lainnya yang diperlukan oleh Maven untuk membangun proyek.

## Prerequisites

- Install java
- Install maven
- Install Visual Studio Code
- Install Extension Pack for java

## Menjalankan Aplikasi

Clone project ini

```bash
  git clone https://github.com/suciawalia/API-Testing.git
```

## 
## Menjalankan Tests

Jalankan command ini untuk menjalankan test

```bash
   mvn test
```

## Generate Report by tools

Jalankan command ini untuk generate report dengan maven

```bash
  mvn site
```

## Hasil Tests
### Root file test report
```
..\target\site\surefire-report.html
```
### Hasil Test Report 
**1. Summary**

![reposrt](https://github.com/suciawalia/API-Testing/assets/99374578/229a4d0f-e748-4890-8e36-0325d0d6bcc6)

- Jumlah test case yang dieksekusi (Tests) adalah 21
- Jumlah error pada test case (Errors) adalah 0
- Jumlah test case yang fail (Failures) adalah 3
- Jumlah test case yang dilewati (Skipped) adalah 0
- Success Rate nya adalah 85.7%
- Waktu eksekusi test nya (Time) nya adalah 14.67s

**2. Package List**

![p2](https://github.com/suciawalia/API-Testing/assets/99374578/81803d6d-ecc6-430d-b675-58eec68ca026)

- Package yang di test adalah package "com.apitesting"
- Berdasarkan gambar diatas, test report menampilkan empat class test yang dijalankan pada proses ini, yaitu CreateTest, DeleteTest, GetTest, dan UpdateTest.
- Summary dari masing-masing class test akan ditampilkan. Summary ini mencakup jumlah test case yang dieksekusi, jumlah error, failure, skipped, dan juga success rate serta time.

**3. Test Result CreateTest**

![p3](https://github.com/suciawalia/API-Testing/assets/99374578/62e47d00-b411-4ef0-918f-15f0319fd35e)

- Test report menunjukkan bahwa terdapat enam test case yang dieksekusi pada Class CreateTest, yaitu 'createUserWithInvalidAppId', 'createUserWithFutureDateOfBirth', 'createUserWithoutAppId', 'createUserWithInvalidEmailFormat', 'createUserWithRequiredFieldsAndValidEmailFormat' dan 'createUserWithInvalidGender'.
- Test report menunjukkan bahwa terdapat 1 test case yang fail, yaitu 'createUserWithRequiredFieldsAndValidEmailFormat', ditandai dengan adanya keterangan ' + [Detail] ' di sebelah test case name yang akan menampilkan detail failure dari test case tersebut.

**4. Test Result DeleteTest**

![p4](https://github.com/suciawalia/API-Testing/assets/99374578/f407fccf-a751-45d9-af6c-a2dc1b4d5b12)

- Test report menunjukkan bahwa terdapat lima test case yang dieksekusi pada Class DeleteTest, yaitu 'deleteInvalidUserIdInvalidAppId', 'deleteInvalidUserIdFormatValidAppId', 'deleteInvalidUserIdNoAppId', 'deleteInvalidUserIdValidAppId', dan 'deleteValidUserIdValidAppId'.
- Test report menunjukkan bahwa terdapat 1 test case yang fail, yaitu 'deleteValidUserIdValidAppId', ditandai dengan adanya keterangan ' + [Detail] ' di sebelah test case name yang akan menampilkan detail failure dari test case tersebut.

**5. Test Result GetTest**

![p5](https://github.com/suciawalia/API-Testing/assets/99374578/e979d023-b4db-4539-b411-7081982d3669)

- Test report menunjukkan bahwa terdapat lima test case yang dieksekusi pada Class GetTest, yaitu 'getValidUserIdInvalidAppId', 'getValidUserIdValidAppId', 'getInvalidUserIdValidAppId', 'getInvalidUserIdFormatValidAppId', dan 'getValidUserIdNoAppId'.
- Test report menunjukkan bahwa tidak terdapat test case yang fail

**6. Test Result UpdateTest**

![p6](https://github.com/suciawalia/API-Testing/assets/99374578/f85a4431-e5e4-418d-808a-f5d4a4594c6e)

- Test report menunjukkan bahwa terdapat lima test case yang dieksekusi pada Class UpdateTest, yaitu 'updateTitleMissWithValidUserIdAndAppId', '	updateTitleWithInvalidValue', 'updateTitleMrsWithValidUserIdAndAppId', 'updateTitleMsWithValidUserIdAndAppId', dan 'updateTitleMrWithValidUserIdAndAppId'.
- Test report menunjukkan bahwa terdapat 1 test case yang fail, yaitu 'updateTitleWithInvalidValue', ditandai dengan adanya keterangan ' + [Detail] ' di sebelah test case name yang akan menampilkan detail failure dari test case tersebut.

**7. Failure Details**

![p7](https://github.com/suciawalia/API-Testing/assets/99374578/68b7d59a-bd03-478d-90a4-a13fbdddb772)

- Failure details menunjukkan test case yang fail, mencakup keterangan penyebab fail dan class serta line pada class tersebut yang menyebabkan fail. Failures details ini kumpulan dari test case yang fail dari semua class
  
## Authors
- 211524001 | Adinda Faayza Malika [@adindafaayza](https://github.com/adindafaayza)
- 211524003 | Annisa Dinda Gantini [@annisaadg](https://github.com/annisaadg)
- 211524027 | Suci Awalia Gardara [@suciawalia](https://github.com/suciawalia)
