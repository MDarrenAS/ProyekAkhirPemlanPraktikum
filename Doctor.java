
/**
 * Modul 5: Class Abstract dan Interface
 * Abstract class dari Person untuk merepresentasikan seorang dokter.
 * Akan diwarisi oleh GeneralDoctor dan SpecialistDoctor.
 * Modul 7: Class Relationship - Doctor melayani banyak Patient
 */
public abstract class Doctor extends Person {
    protected String specialization;

    public Doctor(String name, String id, String specialization) {
        super(name, id);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    /**
     * Mengimplementasikan metode abstrak displayInfo dari kelas Person.
     * Menampilkan informasi spesifik dokter.
     */
    @Override
    public void displayInfo() {
        System.out.println("------------------------------------");
        System.out.println("Informasi Dokter:");
        System.out.println("Nama: " + name);
        System.out.println("ID: " + id);
        System.out.println("Spesialisasi: " + specialization);
        System.out.println("------------------------------------");
    }

    /**
     * Modul 6: Overload, Override, Polimorfisme
     * Metode abstrak untuk melayani pasien.
     * Akan di-override oleh subclass Doctor (GeneralDoctor, SpecialistDoctor)
     * untuk menyesuaikan metode pelayanan.
     */
    public abstract void servePatient(Patient patient);
}
