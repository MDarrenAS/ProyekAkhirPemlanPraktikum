import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Subclass dari Person untuk merepresentasikan seorang pasien.
 */
public class Patient extends Person {
    private String symptoms;
    private LocalDateTime registrationTime;
    private Doctor servedByDoctor;

    public Patient(String name, String id, String symptoms) {
        super(name, id);
        this.symptoms = symptoms;
        this.registrationTime = LocalDateTime.now(); // Waktu pendaftaran pasien
    }

    public String getSymptoms() {
        return symptoms;
    }

    public LocalDateTime getRegistrationTime() {
        return registrationTime;
    }

     public Doctor getServedByDoctor() {
        return servedByDoctor;
    }
    
    public void setServedByDoctor(Doctor servedByDoctor) {
        this.servedByDoctor = servedByDoctor;
    }

    /**
     * Mengimplementasikan metode abstrak displayInfo dari kelas Person.
     * Menampilkan informasi spesifik pasien.
     */
    @Override
    public void displayInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("------------------------------------");
        System.out.println("Informasi Pasien:");
        System.out.println("Nama: " + name);
        System.out.println("ID: " + id);
        System.out.println("Gejala: " + symptoms);
        System.out.println("Waktu Pendaftaran: " + registrationTime.format(formatter));
        System.out.println("------------------------------------");
    }
}
