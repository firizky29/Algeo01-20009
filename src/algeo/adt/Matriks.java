package algeo.adt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

// disini tulis adt matriksnya ya guys
public class Matriks {
    public Double[][] elmt;
    protected int nRow, nCol;

    public Matriks(int nRow, int nCol) {
            elmt = new Double[nRow][nCol];
            this.nRow = nRow;
            this.nCol = nCol;
    }
    // versi double
    public Matriks(String filePath) throws FileNotFoundException {
        int i,j;

        Scanner in = new Scanner(new File(filePath));
        nRow = in.nextInt();nCol = in.nextInt();
        elmt = new Double[nRow][nCol];
        for(i=0;i<nRow;i++) {
            for(j=0;j<nCol;j++) {
                elmt[i][j] = in.nextDouble();
            }
        }
        in.close();
    }

    public Matriks(){
        int i,j;

        Scanner in = new Scanner(System.in);
        nRow = in.nextInt();nCol = in.nextInt();
        elmt = new Double[nRow][nCol];
        for(i=0;i<nRow;i++) {
            for(j=0;j<nCol;j++) {
                elmt[i][j] = in.nextDouble();
            }
        }
        in.close();
    }

    public int nCol() {
        return nCol;
    }

    public int nRow() {
        return nRow;
    }

    public void tulisMatriks1(String filePath) {
        // matriks tidak kosong
        int i,j;

        File file = new File(filePath);
        try{
            if(!file.exists()) {
                file.createNewFile();
            }
            Formatter out = new Formatter(file.getAbsoluteFile());
            for(i=0;i<nRow;i++) {
                for(j=0;j<nCol;j++) {
                    if(j==nCol-1) {
                        out.format("%f%n", elmt[i][j]);
                    } else {
                        out.format("%f ", elmt[i][j]);
                    }
                }
            }
            out.close();
        } catch(IOException ex) {
            System.exit(1);
        }
    }

    public void tulisMatriks2(){
        // matriks tidak kosong
        int i,j;

        Formatter out = new Formatter(System.out);
        for(i=0;i<nRow;i++) {
            for(j=0;j<nCol;j++) {
                if(j==nCol-1) {
                    out.format("%f%n", elmt[i][j]);
                } else {
                    out.format("%f ", elmt[i][j]);
                }
            }
        }
        out.close();
    }
}
