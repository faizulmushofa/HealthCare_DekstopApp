# EMUY HealthCare 🏥

Aplikasi desktop kesehatan pribadi berbasis JavaFX. Pengguna dapat memantau kondisi kesehatan harian, melacak target olahraga, dan berkonsultasi dengan chatbot berbasis NLP sederhana.

---

## Fitur Utama

| Fitur | Keterangan |
|---|---|
| **Login & Registrasi** | Autentikasi dengan animasi slide, password di-hash BCrypt, validasi input |
| **Dashboard Kesehatan** | Tampilkan BMI, gula darah, tekanan darah dengan indikator warna real-time |
| **Grafik Target Lari** | LineChart history target lari per tanggal dengan animasi per-titik |
| **Chatbot EMUY** | Chatbot berbasis tokenisasi NLP lokal untuk konsultasi gejala penyakit |
| **Update Data** | Input/update gula darah, tekanan darah, berat badan, tinggi badan, target olahraga |
| **Indikator BMI** | Visual indikator + gambar kategori (kurus / normal / kelebihan / obesitas 1-3) |

---

## Teknologi

| Layer | Library/Tool |
|---|---|
| UI Framework | JavaFX 21 + FXML |
| Material Design | JFoenix 9.0.10 |
| Database | SQLite (via `sqlite-jdbc`) |
| SQL Logger | P6Spy |
| Dependency Injection | Google Guice 7 |
| Password Hashing | jBCrypt |
| Logging | SLF4J Simple |
| Build Tool | Maven |
| Boilerplate Reduction | Lombok |

---

## Struktur Project

```
src/main/java/
├── app/                    # Entry point (Launcher, MainApplication)
├── model/                  # Model data (User, dst.)
└── _legacy/                # Kode lama (referensi, belum direfactor)
    ├── Controller/         # LoginController, DashBoardController, ChatBotController, UpdateDataController
    ├── DataBaseController/ # Koneksi & query SQLite
    ├── API/                # Layer service (LoginApiV2, SignUpAPI, PenyakitAPI)
    ├── chatBotEngine/      # Tokenisasi NLP lokal (CakapEmuyService)
    └── Utils/              # Alert, Logger, DbTimer

src/main/resources/
├── com/example/emuyhealthcare/   # File FXML (loginPage, dashBoard1, chatBot, UpdateData)
├── images/                       # Asset gambar & ikon
└── css/                          # Stylesheet custom
```

---

## Cara Menjalankan

### Prasyarat
- Java 21+
- Maven 3.8+

### Run via Maven
```bash
mvn javafx:run
```

### Run via IDE (IntelliJ IDEA)
1. Buka project sebagai Maven project
2. Jalankan class `Launcher`

### Build fat JAR
```bash
mvn package
java -jar target/EMUYHealthCare-1.0-SNAPSHOT.jar
```

---

## Database

SQLite lokal, file ada di:
```
Database/User/Users.db
```

Tabel utama:
- `users` — data akun pengguna (username, password, berat badan, tinggi badan, tanggal lahir)
- `riwayat` — target lari per tanggal
- `riwayat_gula_tekanan` — riwayat gula darah & tekanan darah

---

## Alur Aplikasi

```
Login / Register
     │
     ▼
Dashboard
  ├── Lihat BMI, Gula Darah, Tekanan Darah (indikator warna)
  ├── Grafik history target lari
  └── Input data harian (jika belum ada)
     │
     ├── Chatbot EMUY → konsultasi gejala
     └── Update Data  → ubah data kesehatan & target olahraga
```

---

## Status Project

> ⚠️ Sedang dalam proses refactor.  
> Kode di `_legacy/` adalah implementasi lama yang masih berfungsi.  
> `app/` dan `model/` adalah struktur baru yang sedang dikerjakan dengan arsitektur Guice DI.
