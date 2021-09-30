package algeo.driver;
// disini isi input/output (semacam drivernya mungkin?) matriksnya (determinan dkk, kalau mau bikin class lgi sabi)
import algeo.adt.Matriks;
import algeo.lib.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.out.println("Wow bisa!");
//        Matriks m,m3;
//        try{
//            m= new Matriks("D:\\Tubes\\koef3b.txt");
//            m.tulisMatriks1("D:\\Tubes\\out.txt");
//        } catch(FileNotFoundException exception) {
//            System.out.println("File tidak ditemukan");
//        }
//        m3 = new Matriks();
//        m3.tulisMatriks2();
//        GaussSPL m = new GaussSPL();
//        m.process();
//        m.M.tulisMatriks2();

//        JordanSPL n = new JordanSPL();
//        n.process();
//        n.M.tulisMatriks2();
        // Misalkan punya matriks m (dibuat pas awal banget)
        //Matriks m = new Matriks();
        // buat nge-Jordan atau nge-Gauss berarti
        Matriks m = new Matriks();
        SPLGauss spl = new SPLGauss(m);
        spl.GaussProcess();
        System.out.println(spl.getSolution().length);
        System.out.println(Arrays.toString(spl.getSolution()));

//        File myObj = new File("test/input/test.txt");
//        Scanner myReader = new Scanner(myObj);
//        while (myReader.hasNextLine()) {
//            String data = myReader.nextLine();
//            System.out.println(data);
//        }
        //SPLGauss childm = new SPLGauss(m);
//        InversOBE childm = new InversOBE(m);
//        if(childm.hasInvers()) childm.getInvers().tulisMatriks2();
//        System.out.println("\n");
//        InverseCofactor childm1 = new InverseCofactor(m);
//        InverseOBE childm2 = new InverseOBE(m);
//        childm1.getInverse();
//        childm2.getInverse();
//        SPLCramer childm1 = new SPLCramer(m);
//        SPLGauss childm2 = new SPLGauss(m);
//        childm2.JordanProcess();
//        SPLInvers childm3 = new SPLInvers(m);
//
//        System.out.println(Arrays.toString(childm1.getSolutionVal()));
//        System.out.println(Arrays.toString(childm2.getSolution()));
//        System.out.println(Arrays.toString(childm3.getSolutionVal()));

//        DeterminantOBE childm = new DeterminantOBE(m);
//        if(childm.hasDeterminant())
//                System.out.println(childm.Determinant());
//        DeterminantCofactor childm1 = new DeterminantCofactor();
//        System.out.println(childm1.determinant(m));
        //childm.M.tulisMatriks2();
        //childm.JordanProcess();
        //childm.M.tulisMatriks2();
        //System.out.println(Arrays.toString(childm.getSolution()));
//        //System.out.println(m.Eq(-0.0, 0.0));
        //SPLCramer mCramer = new SPLCramer(m);
        //System.out.println(Arrays.toString(mCramer.getSolutionString()));
//        Matriks points = new Matriks();
//        interpolasiPolinom polinom1 = new interpolasiPolinom(points);
//        System.out.println((polinom1.getHampiran(0.2))+" "+((polinom1.getHampiran(0.3))));
        //System.out.println(childm.getSolution());
    }
}
