package algeo.lib;

import algeo.adt.Matriks;

// Mencari invers dari matriks dengan kofaktor
public class InverseCofactor extends Matriks {
    public InverseCofactor(Matriks m){
        super(m);
        DeterminantCofactor detcof = new DeterminantCofactor();
        double det = detcof.determinant(m);
        if (Eq(det,0.00)) System.out.println("Tidak ada Inverse.");
        else {
            CofactorMatrix cofmat = new CofactorMatrix(m);
            for (int i = 0; i < m.nRow(); i++) {
                for (int j = 0; j < m.nCol(); j++) {
                    this.elmt[i][j] = cofmat.adjoin().elmt[i][j] / det;

                }
            }
        }
    }
}
