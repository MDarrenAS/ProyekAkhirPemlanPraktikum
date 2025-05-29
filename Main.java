import java.util.ArrayList; // Import ArrayList untuk menyimpan daftar dokter
import java.util.InputMismatchException;
import java.util.List; // Import List interface
import java.util.Scanner;
/*
 * Modul 7 - Stack and Queue
 * Menggunakan Stand and Queue untuk menambah antrian, dan melayani pasien
 * Modul 6 - Single dan Double Linked-List
 * Untuk melist dan memilih dokter dokter apa saja
*/
public class Main {
    public static void main(String[] args) {
        ClinicQueueSystem clinicSystem = new ClinicQueueSystem();
        Scanner scanner = new Scanner(System.in);


        List<Doctor> generalDoctors = new ArrayList<>();
        List<Doctor> specialistDoctors = new ArrayList<>();

        // Dokter Umum
        generalDoctors.add(new GeneralDoctor("Dr. Leslie Thompkins", "DGC001"));
        generalDoctors.add(new GeneralDoctor("Dr. Kureha", "MNG001"));
        generalDoctors.add(new GeneralDoctor("Dr. Leonard Samson", "MVC001"));

        // Dokter Spesialis
        specialistDoctors.add(new SpecialistDoctor("Dr. Bruce Banner", "MVC002", "Radiasi Gamma & Mutasi Seluler"));
        specialistDoctors.add(new SpecialistDoctor("Dr. Pamela Isley", "DGC002", "Botani & Toksikologi"));
        specialistDoctors.add(new SpecialistDoctor("Dr. Tony Tony Chopper", "MNG002", "Penyakit Langka & Anatomi Makhluk Fantasi"));
        specialistDoctors.add(new SpecialistDoctor("Dr. Stephen Strange", "MVC003", "Bedah Saraf (Neurologi)"));
        specialistDoctors.add(new SpecialistDoctor("Dr. Victor Fries", "DGC003", "Kriogenik & Terapi Suhu Ekstrem"));
        specialistDoctors.add(new SpecialistDoctor("Dr. Genus", "MNG003", "Biologi Evolusioner & Rekayasa Genetik"));
        
        int choice;
        String patientName, patientId, sympstoms;
        
        do{
            System.out.println("\n====================================");
            System.out.println("SISTEM PENGELOLAAN ANTRIAN KLINIK");
            System.out.println("====================================");
            System.out.println("1. Tambah Pasien ke Antrian");
            System.out.println("2. Panggil Pasien Berikutnya");
            System.out.println("3. Lihat Antrian Pasien");
            System.out.println("4. Lihat Histori Pasien Selesai Dilayani");
            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            
            try{
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Masukkan Nama Pasien: ");
                    patientName = scanner.nextLine();
                    System.out.println("Masukkan ID Pasien: ");
                    patientId = scanner.nextLine();
                    System.out.println("Masukkan Gejala Pasien: ");
                    sympstoms = scanner.nextLine();
                    Patient newPatient = new Patient(patientName, patientId, sympstoms);
                    clinicSystem.addPatient(newPatient);
                    break;
                case 2:
                    System.out.println("\nPilih Jenis Dokter untuk melayani");
                    System.out.println("1. Dokter Umum");
                    System.out.println("2. Dokter Spesialis");
                     System.out.print("Masukkan pilihan Anda: ");
                    int doctorTypeChoice = scanner.nextInt();
                    scanner.nextLine(); // Konsumsi newline

                    Doctor selectedDoctor = null;
                    if (doctorTypeChoice == 1) {
                        if (generalDoctors.isEmpty()) {
                            System.out.println("Tidak ada Dokter Umum yang tersedia.");
                            break;
                        }
                        System.out.println("\n--- Daftar Dokter Umum ---");
                        for (int i = 0; i < generalDoctors.size(); i++) {
                            System.out.println((i + 1) + ". " + generalDoctors.get(i).getName() + " (ID: "
                                    + generalDoctors.get(i).getId() + ")");
                        }
                        System.out.print("Pilih nomor Dokter Umum: ");
                        int doctorIndex = scanner.nextInt();
                        scanner.nextLine(); // Konsumsi newline

                        if (doctorIndex > 0 && doctorIndex <= generalDoctors.size()) {
                            selectedDoctor = generalDoctors.get(doctorIndex - 1);
                        } else {
                            System.out.println("Pilihan nomor dokter tidak valid.");
                        }
                    } else if (doctorTypeChoice == 2) {
                        if (specialistDoctors.isEmpty()) {
                            System.out.println("Tidak ada Dokter Spesialis yang tersedia.");
                            break;
                        }
                        System.out.println("\n--- Daftar Dokter Spesialis ---");
                        for (int i = 0; i < specialistDoctors.size(); i++) {
                            System.out.println((i + 1) + ". " + specialistDoctors.get(i).getName() + " (ID: "
                                    + specialistDoctors.get(i).getId() + ", Spesialisasi: "
                                    + specialistDoctors.get(i).getSpecialization() + ")");
                        }
                        System.out.print("Pilih nomor Dokter Spesialis: ");
                        int doctorIndex = scanner.nextInt();
                        scanner.nextLine(); // Konsumsi newline

                        if (doctorIndex > 0 && doctorIndex <= specialistDoctors.size()) {
                            selectedDoctor = specialistDoctors.get(doctorIndex - 1);
                        } else {
                            System.out.println("Pilihan nomor dokter tidak valid.");
                        }
                    } else {
                        System.out.println("Pilihan jenis dokter tidak valid.");
                    }

                    if (selectedDoctor != null) {
                        clinicSystem.callNextPatient(selectedDoctor);
                    }
                    break;
                case 3:
                    clinicSystem.viewPatientQueue();
                    break;
                case 4:
                    clinicSystem.viewCompletedPatientsHistory();
                    break;
                case 0:
                    System.out.println("Terima kasih sudah memakai Sistem Antrian Klinik.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Harap masukkan angka untuk pilihan menu.");
                scanner.nextLine(); // Konsumsi input yang salah
                choice = -1; // Set choice ke nilai yang tidak valid agar loop berlanjut
            }

        } while (choice != 0);

        scanner.close();
    }
}