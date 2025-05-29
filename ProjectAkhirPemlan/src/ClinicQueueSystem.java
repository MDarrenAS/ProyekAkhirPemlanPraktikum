/*
* Modul 7 : Stack and Queue 


*/
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class ClinicQueueSystem {
    // Menggunakan queue untuk antrian pasien
    private Queue<Patient> patientQueue;
    // Menggunnakan stack untuk menyimpan riwayat pasien yang telah selesai
    private Stack<Patient> completePatientsHistory;

    public ClinicQueueSystem() {
        this.patientQueue = new LinkedList<>();
        this.completePatientsHistory = new Stack<>();
    }

    // Method menambah pasien
    public void addPatient(Patient patient) {
        patientQueue.offer(patient);
        System.out.println("Pasien " + patient.getName() + " telah ditambahkan ke antrian.");
        System.out.println("Nomor antrian saat ini: " + patientQueue.size());
    }

    // Method memanggil pasien
    public void callNextPatient(Doctor doctor){
        if(patientQueue.isEmpty()){
            System.out.println("\nAntrian pasien kosong, Tidak ada pasien yang bisa dipanggil");
            return;
        }
        Patient nextPatient = patientQueue.poll();
        if(nextPatient != null){
             nextPatient.setServedByDoctor(doctor);
            System.out.println("\nMemanggil pasien berikutnya...");
            doctor.servePatient(nextPatient);
            completePatientsHistory.push(nextPatient);
            System.out.println("Pasien " + nextPatient.getName() + " telah dilayani dan ditambah ke histori pasien. ");
        }
    }

    //memanggil daftar pasien yang ada di antrien
    public void viewPatientQueue(){
        System.out.println("Antrien Pasien saat ini");
        if(patientQueue.isEmpty()){
            System.out.println("\nAntrian Pasien kosong");
            return;
        }
        int i = 1;
        for(Patient patient : patientQueue){
            System.out.println(i + ". Nama: " + patient.getName() + ", Gejala: " + patient.getSymptoms());
            i++;
        }
        System.out.println("Total Pasien dalam antrian adalah : " + patientQueue.size());
    }

    // Melihat histori 
    public void viewCompletedPatientsHistory(){
        System.out.println("\nHistori Pasien");
        if(completePatientsHistory.isEmpty()){
            System.out.println("Histori Pasien Kosong, Belum ada pasien yang di layani");
            return;
        }

        Stack<Patient> tempStack = (Stack<Patient>) completePatientsHistory.clone();
        int i = 1;
        while (!tempStack.isEmpty()){
            Patient patient = tempStack.pop();
            String doctorInfo = (patient.getServedByDoctor() != null) ?
                                "Dilayani oleh: " + patient.getServedByDoctor().getName() + " (" + patient.getServedByDoctor().getSpecialization() + ")" :
                                "Dokter tidak tercatat";
            System.out.println(i + ". Nama: " + patient.getName() + ", Gejala: " + patient.getSymptoms() + ", Dilayani pada: " + patient.getRegistrationTime() + ", " + doctorInfo);
            i++;
        }
        System.out.println("Total pasien dalam histori: " + completePatientsHistory.size());
    }
}