import java.util.Scanner;

public class Driver2 {

    static class Siswa {
        String nama;
        int nilai;
        char jk;

        Siswa(String nama, int nilai, char jk) {
            this.nama = nama;
            this.nilai = nilai;
            this.jk = jk;
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jumlah siswa (N): ");
        int N = input.nextInt();
        input.nextLine();

        Siswa[] data = new Siswa[N];

        // Input data siswa
        for (int i = 0; i < N; i++) {
            System.out.println("\nData siswa ke-" + (i+1));

            System.out.print("Nama            : ");
            String nama = input.nextLine();

            System.out.print("Nilai           : ");
            int nilai = input.nextInt();

            System.out.print("Jenis Kelamin (L/P): ");
            char jk = input.next().charAt(0);
            input.nextLine();

            data[i] = new Siswa(nama, nilai, jk);
        }

        System.out.print("\nTampilkan data berdasarkan jenis kelamin (L/P): ");
        char pilih = input.next().charAt(0);

        int total = 0;

        System.out.println("\nDaftar siswa dengan jenis kelamin " + pilih + ":");

        for (int i = 0; i < N; i++) {
            if (Character.toUpperCase(data[i].jk) == Character.toUpperCase(pilih)) {
                System.out.println(data[i].nama + " - " + data[i].nilai);
                total += data[i].nilai;
            }
        }

        System.out.println("Total Nilai = " + total);

        input.close();
    }
}
