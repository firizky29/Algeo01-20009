package algeo.lib;

import algeo.adt.Matriks;

import java.util.Arrays;

public class SPLInvers extends AugmentedMatrix {
    public SPLInvers(Matriks m){
        super(m);
        // Kondisi ketika jumlah persamaan melebihi jumlah variabel
        Matriks M;
        if(nRow > nCol-1){
            M = new Matriks(nRow, nRow);
            for(int i=0; i<nRow; i++){
                for(int j=0; j<nRow; j++){
                    if(j<nCol-1) {
                        M.elmt[i][j] = coefficient[i][j];
                    }
                    else{
                        if (i>=nCol-1&&i==j) {
                            M.elmt[i][j] = 1.0;
                        }
                        else M.elmt[i][j] = 0.0;
                    }
                }
            }
            this.coefficient = M.elmt;
            coefRow = nRow;
            coefCol = nRow;
        }
    }
    public Double[] getSolutionVal(){
        Double[] solution = new Double[nCol-1];
        Matriks coef = new Matriks(coefRow,coefCol);    // buat matriks coef sendiri hehe
        coef.elmt = coefficient;                        // semoga bisa
        InverseCofactor invcoef = new InverseCofactor(coef);
        if(!invcoef.hasInverse()){
            Arrays.fill(solution, Double.NaN);
            return solution;
        }
        for(int i=0; i<nCol-1; i++){            // jika Ax = B, maka x = inverse(A) * B
            Double res = 0.0;
            for(int j=0; j<invcoef.nRow(); j++){
                res += invcoef.res.elmt[i][j] * constant[j];
            }
            solution[i] = res;
        }
        return solution;

    }
}
