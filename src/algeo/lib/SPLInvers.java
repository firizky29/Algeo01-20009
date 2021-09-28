package algeo.lib;

import algeo.adt.Matriks;

public class SPLInvers extends AugmentedMatrix {
    public SPLInvers(){
        super();
    }
    public Double[] getSolutionVal(){
        Double[] solution = new Double[coefCol];
        Matriks coef = new Matriks(coefRow,coefCol);    // buat matriks coef sendiri hehe
        coef.elmt = coefficient;                        // semoga bisa
        Matriks invcoef = new InverseCofactor(coef);    // buat matriks inversnya
        for(int i=0; i<invcoef.nRow(); i++){            // jika Ax = B, maka x = inverse(A) * B
            double res = 0;
            for(int j=0; j<invcoef.nCol(); j++){
                res += invcoef.elmt[i][j] * constant[j];
            }
            solution[i] = res;
        }
        return solution;

    }
}
