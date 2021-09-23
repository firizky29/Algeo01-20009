package algeo.driver;
// disini isi input/output (semacam drivernya mungkin?) matriksnya (determinan dkk, kalau mau bikin class lgi sabi)
import algeo.adt.Matriks;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Wow bisa!");
        Matriks m,m3;
        try{
            m= new Matriks("D:\\Tubes\\koef3b.txt");
            m.tulisMatriks1("D:\\Tubes\\out.txt");
        } catch(FileNotFoundException exception) {
            System.out.println("File tidak ditemukan");
        }
        m3 = new Matriks();
        m3.tulisMatriks2();
    }
}
