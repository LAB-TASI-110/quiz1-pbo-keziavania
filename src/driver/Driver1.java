import java.util.*;

public class Driver1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        HashMap<String, String> nama = new HashMap<>();
        HashMap<String, Integer> hargaMenu = new HashMap<>();

        nama.put("NGS", "Nasi Goreng Spesial");
        nama.put("AP", "Ayam Penyet");
        nama.put("SA", "Sate Ayam");
        nama.put("BU", "Bakso Urat");
        nama.put("MAP", "Mie Ayam Pangsit");
        nama.put("GG", "Gado-Gado");
        nama.put("SAM", "Soto Ayam");
        nama.put("RD", "Rendang Daging");
        nama.put("IB", "Ikan Bakar");
        nama.put("NUK", "Nasi Uduk Komplit");

        hargaMenu.put("NGS",15000);
        hargaMenu.put("AP",20000);
        hargaMenu.put("SA",25000);
        hargaMenu.put("BU",18000);
        hargaMenu.put("MAP",15000);
        hargaMenu.put("GG",15000);
        hargaMenu.put("SAM",17000);
        hargaMenu.put("RD",25000);
        hargaMenu.put("IB",35000);
        hargaMenu.put("NUK",20000);

        ArrayList<String> listMenu = new ArrayList<>();
        ArrayList<Integer> listPorsi = new ArrayList<>();
        ArrayList<Integer> listHarga = new ArrayList<>();
        ArrayList<Integer> listTotal = new ArrayList<>();

        int totalBelanja = 0;

        while(true){

            System.out.print("Masukkan kode menu : ");
            String kode = input.nextLine().toUpperCase();

            if(kode.equals("END")){
                break;
            }

            if(!nama.containsKey(kode)){
                System.out.println("Kode salah!");
                continue;
            }

            System.out.print("Masukkan porsi Butet : ");
            int butet = input.nextInt();
            input.nextLine();

            int totalPorsi = 3 * butet;
            int harga = hargaMenu.get(kode);
            int subtotal = harga * totalPorsi;

            listMenu.add(nama.get(kode));
            listPorsi.add(totalPorsi);
            listHarga.add(harga);
            listTotal.add(subtotal);

            totalBelanja += subtotal;
        }


        System.out.println("\nMenu\t\t\tPorsi\tHarga\tTotal");
        System.out.println("========================================================");

        for(int i=0;i<listMenu.size();i++){
            System.out.printf("%-20s\t%d\t%d\t%d\n",
            listMenu.get(i),
            listPorsi.get(i),
            listHarga.get(i),
            listTotal.get(i));
        }

        System.out.println("========================================================");
        System.out.println("Total Pembayaran\t\t\t\t"+totalBelanja);
    }
}
