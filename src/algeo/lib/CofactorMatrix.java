package algeo.lib;

import algeo.adt.Matriks;

public class CofactorMatrix extends Matriks{
    public CofactorMatrix(Matriks matriks){
        super(matriks.nRow(), matriks.nCol());
        for(int i=0; i<matriks.nRow(); i++){
            for(int j=0; j<matriks.nCol(); j++){
                Cofactor cof = new Cofactor(matriks, i, j);
                DeterminantCofactor detcof = new DeterminantCofactor(cof);
                this.elmt[i][j] = ((i+j)%2 == 0) ? detcof.Determinant() : (-1)*(detcof.Determinant());
            }
        }
    }

    public Matriks adjoin(){
        Matriks adj = new Matriks(this.nCol(),this.nRow());
        for(int i=0; i<adj.nRow(); i++){
            for(int j=0; j<adj.nCol(); j++){
                adj.elmt[i][j] = this.elmt[j][i];
            }
        }
        return adj;
    }
}
