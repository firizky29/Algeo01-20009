package algeo.lib;

import algeo.adt.Matriks;

public class SPLCramer extends AugmentedMatrix {
    public SPLCramer(Matriks m) {
        super(m);
    }
    public Double[] getSolutionVal() {
        int n = coefCol;
        Double[] solution = new Double[n];
        Matriks matrixj = new Matriks(coefRow,coefCol);
        int i,j;
        for(i=0;i<coefRow;i++) {
            for(j=0;j<coefCol;j++) {
                matrixj.elmt[i][j] = coefficient[i][j];
            }
        }
        double detCoef = new DeterminantOBE(matrixj).Determinant();
        for(j=0;j<coefCol;j++) {
            for(i=0;i<coefRow;i++) {
                matrixj.elmt[i][j] = constant[i];
            }
            Double detj = new DeterminantOBE(matrixj).Determinant();
            solution[j] = detj/detCoef;
            for(i=0;i<coefRow;i++) {
                matrixj.elmt[i][j] = coefficient[i][j];
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