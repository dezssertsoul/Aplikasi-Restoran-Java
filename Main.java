import java.util.Scanner;

// Kelas Menu untuk merepresentasikan data item
class Menu {
    String nama;
    double harga;
    String kategori;

    public Menu(String nama, double harga, String kategori) {
        this.nama = nama;
        this.harga = harga;
        this.kategori = kategori;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Inisialisasi Menu dalam Array (Minimal 4 per kategori)
        Menu[] daftarMenu = {
            new Menu("Nasi Goreng", 25000, "Makanan"),
            new Menu("Mie Ayam", 15000, "Makanan"),
            new Menu("Ayam Bakar", 30000, "Makanan"),
            new Menu("Sate Kambing", 45000, "Makanan"),
            new Menu("Es Teh Manis", 5000, "Minuman"),
            new Menu("Jus Jeruk", 12000, "Minuman"),
            new Menu("Kopi Hitam", 10000, "Minuman"),
            new Menu("Es Kelapa", 15000, "Minuman")
        };

        // Menampilkan Menu Terkelompok
        System.out.println("=== SELAMAT DATANG DI RESTORAN MAMAH INAH ===");
        System.out.println("\n--- Kategori Makanan ---");
        System.out.println("0. " + daftarMenu[0].nama + " - Rp" + (int)daftarMenu[0].harga);
        System.out.println("1. " + daftarMenu[1].nama + " - Rp" + (int)daftarMenu[1].harga);
        System.out.println("2. " + daftarMenu[2].nama + " - Rp" + (int)daftarMenu[2].harga);
        System.out.println("3. " + daftarMenu[3].nama + " - Rp" + (int)daftarMenu[3].harga);
        
        System.out.println("\n--- Kategori Minuman ---");
        System.out.println("4. " + daftarMenu[4].nama + " - Rp" + (int)daftarMenu[4].harga);
        System.out.println("5. " + daftarMenu[5].nama + " - Rp" + (int)daftarMenu[5].harga);
        System.out.println("6. " + daftarMenu[6].nama + " - Rp" + (int)daftarMenu[6].harga);
        System.out.println("7. " + daftarMenu[7].nama + " - Rp" + (int)daftarMenu[7].harga);

        // Input Pesanan (Maksimal 4 item tanpa looping)
        System.out.println("\n--- INSTRUKSI PEMESANAN ---");
        System.out.println("Format: [Nomor Menu] [Spasi] [Jumlah]");
        System.out.println("Contoh: '0 2' artinya pesan 2 porsi Nasi Goreng.");
        System.out.println("Ketik '-1' jika tidak ingin menambah pesanan lagi.\n");
        
        System.out.print("Pesanan 1: ");
        int id1 = input.nextInt(); 
        int qty1 = (id1 == -1) ? 0 : input.nextInt();
        
        System.out.print("Pesanan 2: ");
        int id2 = input.nextInt(); 
        int qty2 = (id2 == -1) ? 0 : input.nextInt();
        
        System.out.print("Pesanan 3: ");
        int id3 = input.nextInt(); 
        int qty3 = (id3 == -1) ? 0 : input.nextInt();
        
        System.out.print("Pesanan 4: ");
        int id4 = input.nextInt(); 
        int qty4 = (id4 == -1) ? 0 : input.nextInt();

        // Hitung Subtotal per Item
        double sub1 = (id1 != -1) ? daftarMenu[id1].harga * qty1 : 0;
        double sub2 = (id2 != -1) ? daftarMenu[id2].harga * qty2 : 0;
        double sub3 = (id3 != -1) ? daftarMenu[id3].harga * qty3 : 0;
        double sub4 = (id4 != -1) ? daftarMenu[id4].harga * qty4 : 0;

        double totalAwal = sub1 + sub2 + sub3 + sub4;
        
        // Perhitungan Diskon & Promo
        double diskon = 0;
        if (totalAwal > 100000) {
            diskon = totalAwal * 0.10;
        }

        String infoPromoMinum = "Tidak Ada";
        if (totalAwal > 50000) {
            infoPromoMinum = "Beli 1 Gratis 1 Minuman (Aktif)";
        }

        // Biaya Tambahan
        double pajak = totalAwal * 0.10;
        double biayaPelayanan = 20000;
        double totalAkhir = (totalAwal - diskon) + pajak + biayaPelayanan;

        // Cetak Struk Pesanan
        System.out.println("\n======================================");
        System.out.println("           STRUK PEMBAYARAN           ");
        System.out.println("======================================");
        if (id1 != -1) System.out.printf("%-15s x%d : Rp%.0f\n", daftarMenu[id1].nama, qty1, sub1);
        if (id2 != -1) System.out.printf("%-15s x%d : Rp%.0f\n", daftarMenu[id2].nama, qty2, sub2);
        if (id3 != -1) System.out.printf("%-15s x%d : Rp%.0f\n", daftarMenu[id3].nama, qty3, sub3);
        if (id4 != -1) System.out.printf("%-15s x%d : Rp%.0f\n", daftarMenu[id4].nama, qty4, sub4);
        
        System.out.println("--------------------------------------");
        System.out.println("Subtotal Menu    : Rp" + (int)totalAwal);
        if (diskon > 0) System.out.println("Diskon 10%       : -Rp" + (int)diskon);
        System.out.println("Pajak (10%)      : Rp" + (int)pajak);
        System.out.println("Biaya Pelayanan  : Rp" + (int)biayaPelayanan);
        System.out.println("--------------------------------------");
        System.out.println("TOTAL BAYAR      : Rp" + (int)totalAkhir);
        System.out.println("Penawaran Khusus : " + infoPromoMinum);
        System.out.println("======================================");

        input.close();
    }
}