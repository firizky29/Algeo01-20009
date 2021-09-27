package algeo.lib;

import algeo.adt.Matriks;

// mencari determinan dengan kofaktor
public class DeterminantCofactor {
    public double determinant(Matriks m){
        double det = 0;
        if (m.nRow() == 1) return m.elmt[0][0];
        else {
            for (int j = 0; j < m.nCol(); j++) {
                Cofactor cof = new Cofactor(m, 0, j);
                if (j % 2 == 0) det += m.elmt[0][j] * determinant(cof);
                else det -= m.elmt[0][j] * determinant(cof);
            }
            return det;
        }
    }
}
