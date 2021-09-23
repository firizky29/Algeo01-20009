package algeo.driver;
// disini isi input/output (semacam drivernya mungkin?) matriksnya (determinan dkk, kalau mau bikin class lgi sabi)
import algeo.adt.Matriks;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Wow bisa!");
        int[][] m, m2,m3;
        try{
            m = Matriks.bacaMatriks1("D:\\Tubes\\in.txt");
            Matriks.tulisMatriks1(m,"D:\\Tubes\\out.txt");
        } catch(FileNotFoundException exception) {
            System.out.println("File tidak ditemukan");
        }
        try{
            m2 = Matriks.bacaMatriks1("D:\\Tubes\\in2.txt");
            Matriks.tulisMatriks1(m2,"D:\\Tubes\\out2.txt");
        } catch(FileNotFoundException exception) {
            System.out.println("File tidak ditemukan");
        }
        m3 = Matriks.bacaMatriks2();
        Matriks.tulisMatriks2(m3);
    }
}
