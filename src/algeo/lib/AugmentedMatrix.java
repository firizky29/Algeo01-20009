package algeo.lib;

import algeo.adt.Matriks;

import java.io.FileNotFoundException;
import java.util.*;

// disini diisi pemrosesan matriksnya (semacam bikin implementasi .h di c)
public class AugmentedMatrix extends Matriks {
    protected Double[] constant;
    public Double[][] coefficient;
    protected int coefRow, coefCol;
    private int[] zeros;
    public AugmentedMatrix(int nRow, int nCol){
        super(nRow, nCol);
        this.constant = new Double[nRow];
        this.coefficient = new Double[nRow][nCol-1];
        this.coefRow = nRow;
        this.coefCol = nCol-1;
        this.zeros = new int[nRow];
    }
    public AugmentedMatrix(String filePath) throws FileNotFoundException{
        super(filePath);
        this.constant = new Double[nRow];
        this.coefficient = new Double[nRow][nCol-1];
        this.zeros = new int[nRow];
        int i, j;
        for(i=0; i<nRow; i++){
            for(j=0; j<nCol-1; j++){
                coefficient[i][j] = this.elmt[i][j];
            }
        }
        for(i=0; i<nRow; i++){
            constant[i] = this.elmt[i][nCol-1];
        }
        coefRow = this.nRow();
        coefCol = this.nCol()-1;

    }
    public AugmentedMatrix(){
        super();
        this.constant = new Double[nRow];
        this.coefficient = new Double[nRow][nCol-1];
        this.zeros = new int[nRow];
        int i, j;
        for(i=0; i<nRow; i++){
            for(j=0; j<nCol-1; j++){
                coefficient[i][j] = this.elmt[i][j];
            }
        }
        for(i=0; i<nRow; i++){
            constant[i] = this.elmt[i][nCol-1];
        }
        coefRow = this.nRow();
        coefCol = this.nCol()-1;
    }
    public AugmentedMatrix(Matriks m) {
        super(m);
        this.constant = new Double[nRow];
        this.coefficient = new Double[nRow][nCol-1];
        zeros = new int[nRow];
        int i,j;
        for(i=0; i<nRow; i++){
            for(j=0; j<nCol-1; j++){
                coefficient[i][j] = this.elmt[i][j];
            }
        }
        for(i=0; i<nRow; i++){
            constant[i] = this.elmt[i][nCol-1];
        }
        coefRow = nRow;
        coefCol = nCol-1;
    }
    // read-only attributes
    public int getCoefCol() {
        return coefCol;
    }
    public int getCoefRow() {
        return coefRow;
    }
    public Double constElmt(int i){
        return constant[i];
    }
}
