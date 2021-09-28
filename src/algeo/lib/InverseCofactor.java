package algeo.lib;

import algeo.adt.Matriks;

// Mencari invers dari matriks dengan kofaktor
public class InverseCofactor extends Matriks {
    public InverseCofactor(Matriks m){
        super(m);
        CofactorMatrix cofmat = new CofactorMatrix(m);
        for(int i=0; i<m.nRow(); i++){
            for(int j=0; j<m.nCol(); j++){
                DeterminantCofactor detcof = new DeterminantCofactor();
                this.elmt[i][j] = cofmat.adjoin().elmt[i][j] / detcof.determinant(m);
            }
        }
    }
}
