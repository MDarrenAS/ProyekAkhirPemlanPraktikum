

/**
 * Subclass dari Doctor untuk merepresentasikan dokter umum.
 * Modul 6: Overload, Override, Polimorfisme
 */
public class GeneralDoctor extends Doctor {

    public GeneralDoctor(String name, String id) {
        super(name, id, "Umum");
    }

    /**
     * Meng-override metode servePatient untuk pelayanan dokter umum.
     */
    @Override
    public void servePatient(Patient patient) {
        System.out.println("\n--- Pelayanan Dokter Umum ---");
        System.out.println("Dokter " + getName() + " (" + getSpecialization() + ") sedang melayani pasien:");
        patient.displayInfo();
        System.out.println("Dokter Umum memberikan penanganan awal dan resep umum.");
        System.out.println("Pelayanan selesai untuk pasien " + patient.getName() + ".");
    }
}
