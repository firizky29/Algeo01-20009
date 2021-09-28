package algeo.lib;

import algeo.adt.Matriks;

// mencari determinan dengan kofaktor
public class DeterminantCofactor extends Matriks {
    public Matriks M;
    public DeterminantCofactor(Matriks m){
        super(m);
        if (this.nRow() != this.nCol()) {
            // Keluaran Gagal
            System.out.println("Gagal mencari determinant, jumlah baris dan kolom harus sama");
            M = null;
        }
        else{
            M = new Matriks(nRow, nCol);
            for (int i = 0; i < nRow; i++) {
                for (int j = 0; j < nCol; j++) {
                    M.elmt[i][j] = m.elmt[i][j];
                }
            }
        }
    }
    public Double Determinant(){
        if(!this.hasDeterminant()){
            return Double.NaN;
        }
        Double det = 0.0;
        if (M.nRow() == 1) return M.elmt[0][0];
        else {
            for (int j = 0; j < M.nCol(); j++) {
                Cofactor cof = new Cofactor(M, 0, j);
                DeterminantCofactor Det = new DeterminantCofactor(cof);
                if (j % 2 == 0) det += M.elmt[0][j] * Det.Determinant();
                else det -= M.elmt[0][j] * Det.Determinant();
            }
            return det;
        }
    }

    public boolean hasDeterminant(){
        return M!=null;
    }
}
