import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Database database = new Database();
    boolean inMenu = true;
    while(inMenu) {
      System.out.println(" === Main Menu === ");
      System.out.println("1. Insert data karyawan");
      System.out.println("2. View data karyawan");
      System.out.println("3. Update data karyawan");
      System.out.println("4. Delete data karyawan");
      System.out.println("5. Quit");
      System.out.print(">> ");
      int menu = scan.nextInt();
      scan.nextLine();
      switch(menu) {
        case 1:
        {
          String id = "", nama = "", gender = "", jabatan = ""; 
          System.out.println(" === Insert Menu ===");
          boolean isValid = false;
          // input nama
          while(!isValid) {
            System.out.print("Input nama karyawan [>= 3]: ");
            nama = scan.nextLine();
            if(nama.length() >= 3) isValid = true;
          }
          // input gender
          isValid = false;
          while(!isValid) {
            System.out.print("Input jenis kelamin [Laki-Laki | Perempuan] (Case Sensitive): ");
            gender = scan.nextLine();
            if(gender.compareTo("Laki-Laki") == 0 || gender.compareTo("Perempuan") == 0) isValid = true;
          }
          // input jabatan + gaji
          Integer gaji = 0;
          double persentase = 0;
          isValid = false;
          while(!isValid) {
            System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
            jabatan = scan.nextLine();
            if(jabatan.compareTo("Manager") == 0) {
              gaji = 8000000;
              isValid = true;
              persentase = 0.1;
            }
            else if(jabatan.compareTo("Supervisor") == 0) {
              gaji = 6000000;
              isValid = true;
              persentase = 0.075;
            }
            else if(jabatan.compareTo("Admin") == 0) {
              gaji = 4000000;
              isValid = true;
              persentase = 0.05;
            }
          }
          // membuat id
          Random rand = new Random();
          for(int i = 1; i <= 2; i++) id = id.concat(Character.toString((char)(rand.nextInt(26) + (int)'A')));
          id = id.concat(Character.toString('-'));
          for(int i = 1; i <= 5; i++) id = id.concat(Integer.toString(rand.nextInt(10)));
        
          System.out.println("Berhasil menambahkan karyawan dengan id " + id);

          // validasi gaji karyawan sebelumnya
          if(database.karyawans.size() >= 3) {
            System.out.print("Bonus sebesar " + persentase * 100 + "% telah diberikan kepada karyawan dengan id ");
            for(Karyawan karyawan : database.karyawans) {
              karyawan.tambahGaji(persentase);
              System.out.print(karyawan.getID() + " ");
            }
            System.out.println();
          }
          database.karyawans.add(new Karyawan(id, nama, gender, jabatan, gaji));
        }
        break;
        case 2:
        {
          ArrayList<Karyawan> karyawansTemp = database.karyawans;
          Collections.sort(karyawansTemp, Karyawan.karyawanNameComparator);
          System.out.printf("|----|-----------------|------------------------------|---------------|--------------|-------------|\n");
          System.out.printf("|No  |Kode Karyawan    |Nama Karyawan                 |Jenis Kelamin  |Jabatan       |Gaji Karyawan|\n");
          System.out.printf("|----|-----------------|------------------------------|---------------|--------------|-------------|\n");
          for(Karyawan karyawan : karyawansTemp) {
            System.out.printf("|%4s|%17s|%30s|%15s|%14s|%13s|\n", Integer.toString(karyawansTemp.indexOf(karyawan) + 1), 
              karyawan.getID(), karyawan.getName(), karyawan.getGender(), karyawan.getJabatan(), Integer.toString(karyawan.getGaji()));
          }
          System.out.printf("|----|-----------------|------------------------------|---------------|--------------|-------------|\n");
          System.out.print("Tekan ENTER untuk melanjutkan...."); scan.nextLine();
        }
        break;
        case 3:
        {
          ArrayList<Karyawan> karyawansTemp = database.karyawans;
          Collections.sort(karyawansTemp, Karyawan.karyawanNameComparator);
          System.out.printf("|----|-----------------|------------------------------|---------------|--------------|-------------|\n");
          System.out.printf("|No  |Kode Karyawan    |Nama Karyawan                 |Jenis Kelamin  |Jabatan       |Gaji Karyawan|\n");
          System.out.printf("|----|-----------------|------------------------------|---------------|--------------|-------------|\n");
          for(Karyawan karyawan : karyawansTemp) {
            System.out.printf("|%4s|%17s|%30s|%15s|%14s|%13s|\n", Integer.toString(karyawansTemp.indexOf(karyawan) + 1), 
              karyawan.getID(), karyawan.getName(), karyawan.getGender(), karyawan.getJabatan(), Integer.toString(karyawan.getGaji()));
          }
          System.out.printf("|----|-----------------|------------------------------|---------------|--------------|-------------|\n");
          System.out.print("No. data yang ingin diupdate >> ");
          int idx = scan.nextInt() - 1;
          scan.nextLine();
          
          // new attributes
          String id = "", nama = "", gender = "", jabatan = ""; 
          boolean isValid = false;
          // input nama
          while(!isValid) {
            System.out.print("Input nama karyawan [>= 3]: ");
            nama = scan.nextLine();
            if(nama.length() >= 3) isValid = true;
          }
          // input gender
          isValid = false;
          while(!isValid) {
            System.out.print("Input jenis kelamin [Laki-Laki | Perempuan] (Case Sensitive): ");
            gender = scan.nextLine();
            if(gender.compareTo("Laki-Laki") == 0 || gender.compareTo("Perempuan") == 0) isValid = true;
          }
          // input jabatan + gaji
          Integer gaji = 0;
          isValid = false;
          while(!isValid) {
            System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
            jabatan = scan.nextLine();
            if(jabatan.compareTo("Manager") == 0) {
              gaji = 8000000;
              isValid = true;
            }
            else if(jabatan.compareTo("Supervisor") == 0) {
              gaji = 6000000;
              isValid = true;
            }
            else if(jabatan.compareTo("Admin") == 0) {
              gaji = 4000000;
              isValid = true;
            }
          }
          // membuat id
          Random rand = new Random();
          for(int i = 1; i <= 2; i++) id = id.concat(Character.toString((char)(rand.nextInt(26) + (int)'A')));
          id = id.concat(Character.toString('-'));
          for(int i = 1; i <= 5; i++) id = id.concat(Integer.toString(rand.nextInt(10)));
        
          System.out.println("Berhasil mengupdate karyawan ke-" + (idx + 1));
          database.karyawans.get(idx).setName(nama);
          database.karyawans.get(idx).setGender(gender);
          database.karyawans.get(idx).setID(id);
          database.karyawans.get(idx).setJabatan(jabatan);
          database.karyawans.get(idx).setGaji(gaji);
          System.out.print("Tekan ENTER untuk melanjutkan...."); scan.nextLine();
        }
        break;
        case 4:
        {
          ArrayList<Karyawan> karyawansTemp = database.karyawans;
          Collections.sort(karyawansTemp, Karyawan.karyawanNameComparator);
          System.out.printf("|----|-----------------|------------------------------|---------------|--------------|-------------|\n");
          System.out.printf("|No  |Kode Karyawan    |Nama Karyawan                 |Jenis Kelamin  |Jabatan       |Gaji Karyawan|\n");
          System.out.printf("|----|-----------------|------------------------------|---------------|--------------|-------------|\n");
          for(Karyawan karyawan : karyawansTemp) {
            System.out.printf("|%4s|%17s|%30s|%15s|%14s|%13s|\n", Integer.toString(karyawansTemp.indexOf(karyawan) + 1), 
              karyawan.getID(), karyawan.getName(), karyawan.getGender(), karyawan.getJabatan(), Integer.toString(karyawan.getGaji()));
          }
          System.out.printf("|----|-----------------|------------------------------|---------------|--------------|-------------|\n");
          System.out.print("No. data yang ingin didelete >> ");
          int idx = scan.nextInt() - 1;
          scan.nextLine();
          database.karyawans.remove(idx);
          System.out.println("Berhasil mendelete karyawan ke-" + (idx + 1));
          System.out.print("Tekan ENTER untuk melanjutkan...."); scan.nextLine();
        }
        break;
        case 5:
          inMenu = false;
        break;
      }
    }
    
    scan.close();
  }
}