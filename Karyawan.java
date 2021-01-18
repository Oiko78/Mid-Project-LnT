import java.text.NumberFormat;
import java.util.Comparator;
import java.util.Locale;

public class Karyawan {

  // ID = MM-XXXX, MM = 2 random alphabet, XXXX = 4 random numeric
  private String id;
  // Nama = minimal 3 length character
  private String name;
  // Gender = Laki-Laki / Perempuan (Case Sensitive)
  private String gender;
  // Jabatan = Manager / Supervisor / Admin (Case Sensitive)
  private String jabatan;
  // Gaji = Manager: 8jt / Supervisor 6jt / Admin 4jt
  private Integer gaji;
  // Constructor
  public Karyawan(String id, String name, String gender, String jabatan, Integer gaji) {
    this.id = id;
    this.name = name;
    this.gender = gender;
    this.jabatan = jabatan;
    this.gaji = gaji;
  }
  
  // Getter
  public void getDetails() {
    Locale indoLocale = new Locale("id", "id");
    NumberFormat format = NumberFormat.getCurrencyInstance(indoLocale);
    System.out.println("Name: " + name);
    System.out.println("Gender: " + gender);
    System.out.println("Jabatan:"  + jabatan);
    System.out.println("Gaji: " + format.format(gaji) + " jt");
    System.out.println("ID: " + id);
  }
  public String getID() {
    return id;
  }
  public String getName() {
    return name;
  }
  public String getGender() {
    return gender;
  }
  public String getJabatan() {
    return jabatan;
  }
  public Integer getGaji() {
    return gaji;
  }

  //Setter
  public void setID(String id) {
    this.id = id;
  }
  public void setName(String name) {  
    this.name = name;
  }
  public void setGender(String gender) {
    this.gender = gender;
  }
  public void setJabatan(String jabatan) {
    this.jabatan = jabatan;
  }
  public void setGaji(int gaji) {
    this.gaji = gaji;
  }

  // Methods
  public void tambahGaji(double persentase) {
    gaji = gaji + (int)(gaji * persentase);
  }
  public static Comparator<Karyawan> karyawanNameComparator = new Comparator<Karyawan>(){
    public int compare(Karyawan k1, Karyawan k2) {
      String namaKaryawan1 = k1.name.toUpperCase();
      String namaKaryawan2 = k2.name.toUpperCase();
      return namaKaryawan1.compareTo(namaKaryawan2);
    }
  };
}
