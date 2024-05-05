# API-Testing Menggunakan Postman dan Rest Assured
## Description
Pengujian API menggunakan Postman (manual) dan Rest Assured (otomatis) pada Program User Controller pada tautan https://dummyapi.io/docs/user untuk menguji API: Get User by id, Create User, Update User dan Delete User

## Tentang Project API Testing

### Class
- **DeleteTest**: Class ini merupakan class pengujian untuk menguji request DELETE user pada API.
- **GetTest**: Class ini merupakan class pengujian untuk menguji request GET user pada API.

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
│                   ├── DeleteTest.java
│                   └── GetTest.java
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
7. **DeleteTest.java:** Ini berisi pengujian untuk method DELETE.
8. **GetTest.java:** Ini berisi pengujian untuk method GET.
10. **target:** Ini adalah direktori yang berisi hasil dari proses kompilasi dan pembuatan (build) lainnya.
11. **classes/com/apitesting:** Direktori tempat hasil kompilasi dari kode sumber utama ditempatkan.
12. **generated-sources:** Direktori untuk sumber yang dihasilkan, mungkin oleh proses generasi kode.
13. **generated-test-sources:** Direktori untuk sumber pengujian yang dihasilkan.
14. **maven-status/maven-compiler-plugin:** Direktori yang berisi informasi status proyek yang dihasilkan oleh Maven.
15. **site:** Direktori yang berisi laporan dan sumber daya lainnya yang dihasilkan oleh plugin Maven yang berorientasi laporan.
16. **surefire-reports:** Direktori yang berisi laporan hasil pengujian yang dihasilkan oleh Surefire plugin.
17. **pom.xml:** Ini adalah berkas POM (Project Object Model) Maven yang berisi konfigurasi proyek, dependensi, dan informasi lainnya yang diperlukan oleh Maven untuk membangun proyek.

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

## Authors
- 211524001 | Adinda Faayza Malika [@adindafaayza](https://github.com/adindafaayza)
- 211524003 | Annisa Dinda Gantini [@annisaadg](https://github.com/annisaadg)
- 211524027 | Suci Awalia Gardara [@suciawalia](https://github.com/suciawalia)
