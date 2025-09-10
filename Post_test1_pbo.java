package com.mycompany.post_test1_pbo;
 

import java.util.ArrayList;
import java.util.Scanner;

public class Post_test1_pbo { 

    // Kelas untuk menyimpan data ruangan
    static class Ruangan {
        String nomor;
        String tipe;
        String status;

        Ruangan(String nomor, String tipe, String status) {
            this.nomor = nomor;
            this.tipe = tipe;
            this.status = status;
        }

        @Override
        public String toString() {
            return "Nomor: " + nomor + " | Tipe: " + tipe + " | Status: " + status;
        }
    }

    public static void main(String[] args) {
        ArrayList<Ruangan> daftarRuangan = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== SISTEM CRUD RUANGAN RAWAT RUMAH SAKIT ===");
            System.out.println("1. Tambah Ruangan");
            System.out.println("2. Lihat Semua Ruangan");
            System.out.println("3. Ubah Data Ruangan");
            System.out.println("4. Hapus Ruangan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine(); // bersihkan buffer enter

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nomor Ruangan: ");
                    String nomor = input.nextLine();
                    System.out.print("Masukkan Tipe Ruangan (VIP/Kelas 1/2/3): ");
                    String tipe = input.nextLine();
                    System.out.print("Masukkan Status (Kosong/Terisi): ");
                    String status = input.nextLine();

                    daftarRuangan.add(new Ruangan(nomor, tipe, status));
                    System.out.println("Ruangan berhasil ditambahkan!");
                    break;

                case 2:
                    if (daftarRuangan.isEmpty()) {
                        System.out.println("Belum ada data ruangan.");
                    } else {
                        System.out.println("=== DAFTAR RUANGAN ===");
                        for (int i = 0; i < daftarRuangan.size(); i++) {
                            System.out.println((i + 1) + ". " + daftarRuangan.get(i));
                        }
                    }
                    break;

                case 3:
                    if (daftarRuangan.isEmpty()) {
                        System.out.println("Belum ada data ruangan.");
                    } else {
                        System.out.print("Masukkan nomor urut ruangan yang ingin diubah: ");
                        int idxUbah = input.nextInt();
                        input.nextLine();

                        if (idxUbah > 0 && idxUbah <= daftarRuangan.size()) {
                            Ruangan r = daftarRuangan.get(idxUbah - 1);
                            System.out.print("Nomor baru (lama: " + r.nomor + "): ");
                            r.nomor = input.nextLine();
                            System.out.print("Tipe baru (lama: " + r.tipe + "): ");
                            r.tipe = input.nextLine();
                            System.out.print("Status baru (lama: " + r.status + "): ");
                            r.status = input.nextLine();

                            System.out.println("Data ruangan berhasil diubah!");
                        } else {
                            System.out.println("Nomor ruangan tidak valid.");
                        }
                    }
                    break;

                case 4:
                    if (daftarRuangan.isEmpty()) {
                        System.out.println("Belum ada data ruangan.");
                    } else {
                        System.out.print("Masukkan nomor urut ruangan yang ingin dihapus: ");
                        int idxHapus = input.nextInt();
                        input.nextLine();

                        if (idxHapus > 0 && idxHapus <= daftarRuangan.size()) {
                            daftarRuangan.remove(idxHapus - 1);
                            System.out.println("Data ruangan berhasil dihapus!");
                        } else {
                            System.out.println("Nomor ruangan tidak valid.");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Terima kasih, program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);

        input.close();
    }
}

