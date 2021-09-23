package algeo.adt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

// disini tulis adt matriksnya ya guys
public class Matriks {
    public static int[][] bacaMatriks1(String filePath) throws FileNotFoundException {
        int baris,kolom;
        int i,j;

        Scanner in = new Scanner(new File(filePath));
        baris = in.nextInt();kolom = in.nextInt();
        int[][] m = new int[baris][kolom];
        for(i=0;i<baris;i++) {
            for(j=0;j<kolom;j++) {
                m[i][j] = in.nextInt();
            }
        }
        in.close();
        return m;
    }

    public static int[][] bacaMatriks2(){
        int baris,kolom;
        int i,j;

        Scanner in = new Scanner(System.in);
        baris = in.nextInt();kolom = in.nextInt();
        int[][] m = new int[baris][kolom];
        for(i=0;i<baris;i++) {
            for(j=0;j<kolom;j++) {
                m[i][j] = in.nextInt();
            }
        }
        in.close();
        return m;
    }
    public static void tulisMatriks1(int[][] m, String filePath) {
        // matriks tidak kosong
        int baris=m.length, kolom=m[0].length;
        int i,j;

        File file = new File(filePath);
        try{
            if(!file.exists()) {
                file.createNewFile();
            }
            Formatter out = new Formatter(file.getAbsoluteFile());
            for(i=0;i<baris;i++) {
                for(j=0;j<kolom;j++) {
                    if(j==kolom-1) {
                        out.format("%d%n", m[i][j]);
                    } else {
                        out.format("%d ", m[i][j]);
                    }
                }
            }
            out.close();
        } catch(IOException ex) {
            System.exit(1);
        }
    }

    public static void tulisMatriks2(int[][] m){
        // matriks tidak kosong
        int baris=m.length, kolom=m[0].length;
        int i,j;

        Formatter out = new Formatter(System.out);
        for(i=0;i<baris;i++) {
            for(j=0;j<kolom;j++) {
                if(j==kolom-1) {
                    out.format("%d%n", m[i][j]);
                } else {
                    out.format("%d ", m[i][j]);
                }
            }
        }
        out.close();
    }

    // versi double
    public static Double[][] bacaMatriksD1(String filePath) throws FileNotFoundException {
        int baris,kolom;
        int i,j;

        Scanner in = new Scanner(new File(filePath));
        baris = in.nextInt();kolom = in.nextInt();
        Double[][] m = new Double[baris][kolom];
        for(i=0;i<baris;i++) {
            for(j=0;j<kolom;j++) {
                m[i][j] = in.nextDouble();
            }
        }
        in.close();
        return m;
    }

    public static Double[][] bacaMatriksD2(){
        int baris,kolom;
        int i,j;

        Scanner in = new Scanner(System.in);
        baris = in.nextInt();kolom = in.nextInt();
        Double[][] m = new Double[baris][kolom];
        for(i=0;i<baris;i++) {
            for(j=0;j<kolom;j++) {
                m[i][j] = in.nextDouble();
            }
        }
        in.close();
        return m;
    }
    public static void tulisMatriks1(Double[][] m, String filePath) {
        // matriks tidak kosong
        int baris=m.length, kolom=m[0].length;
        int i,j;

        File file = new File(filePath);
        try{
            if(!file.exists()) {
                file.createNewFile();
            }
            Formatter out = new Formatter(file.getAbsoluteFile());
            for(i=0;i<baris;i++) {
                for(j=0;j<kolom;j++) {
                    if(j==kolom-1) {
                        out.format("%f%n", m[i][j]);
                    } else {
                        out.format("%f ", m[i][j]);
                    }
                }
            }
            out.close();
        } catch(IOException ex) {
            System.exit(1);
        }
    }

    public static void tulisMatriks2(Double[][] m){
        // matriks tidak kosong
        int baris=m.length, kolom=m[0].length;
        int i,j;

        Formatter out = new Formatter(System.out);
        for(i=0;i<baris;i++) {
            for(j=0;j<kolom;j++) {
                if(j==kolom-1) {
                    out.format("%f%n", m[i][j]);
                } else {
                    out.format("%f ", m[i][j]);
                }
            }
        }
        out.close();
    }
}
