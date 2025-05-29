// File: Person.java
/**
 * Modul 5: Class Abstract dan Interface
 * Abstract class dasar untuk merepresentasikan seseorang di klinik.
 * Akan diwarisi oleh Patient dan Doctor.
 */
public abstract class Person {
    protected String name;
    protected String id;

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    /**
     * Metode abstrak untuk menampilkan informasi detail dari seseorang.
     * Akan diimplementasikan oleh subclass.
     */
    public abstract void displayInfo();
}
