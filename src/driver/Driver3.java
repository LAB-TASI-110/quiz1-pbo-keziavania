import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

class Mahasiswa {
    private String nama;
    private String nim;
    private String asrama;

    public Mahasiswa(String nama, String nim, String asrama) {
        this.nama = nama;
        this.nim = nim;
        this.asrama = asrama;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getAsrama() {
        return asrama;
    }

    @Override
    public String toString() {
        return nama + " (" + nim + ") - " + asrama;
    }
}

class Laundry {
    public static final String MENUNGGU = "MENUNGGU PENJEMPUTAN";
    public static final String SIAP = "SIAP DIJEMPUT";
    public static final String PROSES = "DALAM PROSES CUCI";
    public static final String SELESAI = "SELESAI DICUCI";
    public static final String KEMBALI = "SUDAH DIKEMBALIKAN";

    private Mahasiswa mahasiswa;
    private Map<String, Integer> daftarPakaian;
    private LocalDate tanggal;
    private String status;

    public Laundry(Mahasiswa mahasiswa, Map<String, Integer> daftarPakaian) {
        this.mahasiswa = mahasiswa;
        this.daftarPakaian = daftarPakaian;
        this.tanggal = LocalDate.now();
        this.status = MENUNGGU;
    }

    public void tampilkanDetail() {
        System.out.println("\n=== DETAIL LAUNDRY ===");
        System.out.println("Mahasiswa : " + mahasiswa);
        System.out.println("Tanggal   : " + tanggal);
        System.out.println("Status    : " + status);
        System.out.println("Daftar pakaian:");

        for (Map.Entry<String, Integer> entry : daftarPakaian.entrySet()) {
            System.out.printf("  - %-10s : %d%n",
                    entry.getKey(), entry.getValue());
        }
    }

    public void updateStatus(String statusBaru) {
        this.status = statusBaru;
        System.out.println("[UPDATE] Status → " + status);
    }
}

public class LaundryDelApp {

    public static void prosesLaundry(Laundry laundry) {
        laundry.updateStatus(Laundry.SIAP);
        laundry.updateStatus(Laundry.PROSES);

        System.out.println("[MESIN CUCI] Proses pencucian ±1 hari...");

        laundry.updateStatus(Laundry.SELESAI);
        laundry.updateStatus(Laundry.KEMBALI);
    }

    public static void main(String[] args) {
        System.out.println("=== SISTEM LAUNDRY DEL ===");

        Mahasiswa mhs = new Mahasiswa(
                "Kejia",
                "123456",
                "Asrama A"
        );

        Map<String, Integer> daftarPakaian = new HashMap<>();
        daftarPakaian.put("Kaos", 5);
        daftarPakaian.put("Celana", 2);
        daftarPakaian.put("Jaket", 1);

        Laundry laundry = new Laundry(mhs, daftarPakaian);
        laundry.tampilkanDetail();

        prosesLaundry(laundry);

        System.out.println("\n=== PROSES SELESAI ===");
    }
}
