import java.util.InputMismatchException;
import java.util.Scanner;

public class UasC2 {
    public Scanner sc = new Scanner(System.in);
    String[] namaPesewa = new String[1];
    String[] jnsKendaraan = new String[1];
    int jmlhSewa;
    String[] status = new String[1];
    boolean sudahIsi = false;

    public void Menu() {
        System.out.println("Silakan pilih menu");
        System.out.println("1. Input Nama");
        System.out.println("2. Jenis Kendaraan");
        System.out.println("3. Jumlah Hari sewa");
        System.out.println("4. Out");
    }

    public void InputData() {
        System.out.println("=======input data pesewa=======");
        for (int x = 0; x < 3; x++) {
            try {
                System.out.print("\nNama Pesewa : ");
                namaPesewa[x] = sc.nextLine();
                sc.nextLine();
                System.out.print("Masukkan jenis kendaraan (motor, mobil, minibus) :" );
                jnsKendaraan[x] = sc.nextLine();
                System.out.print("Sewa Berapa Hari? :" );
                jmlhSewa = sc.nextInt();

                double motor = 75000;
                double mobil = 250000;
                double minibus = 400000;
                
                motor *= jmlhSewa;
                mobil *= jmlhSewa;
                minibus *= jmlhSewa;
                
                int pilihann = 0;

                switch (pilihann) {
                    case 1:
                    System.out.println(motor);
                    if (jmlhSewa >= 3) {
                    System.out.println("Dapat diskon 15%");
                    double diskon = 0.15 * jmlhSewa;
                    jmlhSewa -= diskon;
                    } else {
                    System.out.println("gak dapet diskon");
                }
                break;
                    case 2:
                    System.out.println(mobil);
                    if (jmlhSewa >= 3) {
                    System.out.println("Dapat diskon 15%");
                    double diskon = 0.15 * jmlhSewa;
                    jmlhSewa -= diskon;
                    } else {
                    System.out.println("gak dapet diskon");
                }
                break;
                    case 3:
                    System.out.println(minibus);
                    if (jmlhSewa >= 3) {
                    System.out.println("Dapat diskon 15%");
                    double diskon = 0.15 * jmlhSewa;
                    jmlhSewa -= diskon;
                    } else {
                    System.out.println("gak dapet diskon");
                }
                break;
            }
        }
            catch (InputMismatchException e) {
                System.out.println("Error: masukkan input yang benar!");
                x--;
            }
        }

        sudahIsi = true;
        System.out.println("Perubahan telah tersimpan");
    }

    public void TampilData() {
        if (sudahIsi == false) {
            System.out.println("Silakan isi data terlebih dahulu");
        } else {
            System.out.println("Data Pesewa");
            for (int x = 0; x < 3; x = x + 1) {
                System.out.println((x + 1) + "." + namaPesewa[x] + " = " + jnsKendaraan[x] + "| Status = " + status[x]);
            }
        }
    }

    public void HitungJumlahPesewa() {
        int lanjut = 0;
        int rampok = 0;

        for (String a : status) {

            if (a != null && a.equalsIgnoreCase("next")) {
                lanjut++;
            } else if (a != null && a.equalsIgnoreCase("penipu lu")) {
                rampok++;
            }
        }

        System.out.println("next: " + lanjut);
        System.out.println("scam: " + rampok);
    }

    public static void main(String[] args) {
        UasC2 obj = new UasC2();
        String ulangi;
        int pilihan;

        do {
            obj.Menu();
            System.out.print("Pilih menu (1-4): ");

            try {

                pilihan = obj.sc.nextInt();

                switch (pilihan) {
                    case 1:
                        obj.InputData();
                        break;
                    case 2:
                        obj.TampilData();
                        break;
                    case 3:
                        obj.HitungJumlahPesewa();
                        break;
                    case 4:
                        System.exit(pilihan);
                        break;
                    default:
                        System.out.println("Pilihan tidak valid! Masukkan angka 1-4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: masukkan input yang benar!");
                obj.sc.nextLine();
                pilihan = 0;
            }
            obj.sc.nextLine();
            System.out.print("Apakah looping? (ya/ nah) ");
            ulangi = obj.sc.nextLine();
        } while (ulangi.equals("ya"));

    }

}
