

/**
 * Subclass dari Doctor untuk merepresentasikan dokter spesialis.
 * Modul 6: Overload, Override, Polimorfisme
 */
public class SpecialistDoctor extends Doctor {

    public SpecialistDoctor(String name, String id, String specialization) {
        super(name, id, specialization);
    }

    /**
     * Meng-override metode servePatient untuk pelayanan dokter spesialis.
     */
    @Override
    public void servePatient(Patient patient) {
        System.out.println("\n--- Pelayanan Dokter Spesialis ---");
        System.out.println("Dokter " + getName() + " (" + getSpecialization() + ") sedang melayani pasien:");
        patient.displayInfo();
        System.out.println("Dokter Spesialis memberikan penanganan mendalam sesuai bidangnya.");
        System.out.println("Pelayanan selesai untuk pasien " + patient.getName() + ".");
    }
}
