package algeo.lib;

import java.util.Arrays;

public class SPLCramer extends AugmentedMatrix {
    public SPLCramer(Matriks m) {
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
            //M.tulisMatriks2();
            this.coefficient = M.elmt;
            coefRow = nRow;
            coefCol = nRow;
        }
    }
    public Double[] getSolutionVal() {
        int n = nCol-1;
        Double[] solution = new Double[n];
        Matriks matrixj = new Matriks(coefRow,coefCol);
        int i,j;
        for(i=0;i<coefRow;i++) {
            for(j=0;j<coefCol;j++) {
                matrixj.elmt[i][j] = coefficient[i][j];
            }
        }
        DeterminantOBE detClass = new DeterminantOBE(matrixj);
        if(!detClass.hasDeterminant()){
            Arrays.fill(solution, Double.NaN);
            return solution;
        }
        else{
            Double detCoef = detClass.Determinant();
            if(Eq(detCoef, 0.0)){
                Arrays.fill(solution, Double.NaN);
                return solution;
            }
            for(j=0;j<nCol-1;j++) {
                for(i=0;i<coefRow;i++) {
                    matrixj.elmt[i][j] = constant[i];
                }
                Double detj = new DeterminantOBE(matrixj).Determinant();
                solution[j] = detj/detCoef;
                for(i=0;i<coefRow;i++) {
                    matrixj.elmt[i][j] = coefficient[i][j];
                }
            }
        }
        return solution;
    }

    public String[] getSolutionString() {
        Double[] solutionVal = getSolutionVal();
        String[] solution = new String[solutionVal.length];
        int i;
        for(i=0;i< solutionVal.length;i++) {
            solution[i] = Double.toString(solutionVal[i]);
        }
        return solution;
    }

}