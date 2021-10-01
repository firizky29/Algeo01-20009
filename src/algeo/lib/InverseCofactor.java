package algeo.lib;

// Mencari invers dari matriks dengan kofaktor
public class InverseCofactor extends Matriks {
    Matriks res;
    public InverseCofactor(Matriks m){
        super(m);
        DeterminantCofactor detcof = new DeterminantCofactor(m);
        double det = detcof.Determinant();
        if (Eq(det,0.00)) {
            System.out.println("Tidak memliki balikan");
            res = null;
        }
        else if(nRow!=nCol){
            System.out.println("Balikan Tidak Terdefinisi, Jumlah baris dan kolom harus sama");
            res = null;
        }
        else {
            res = new Matriks(nRow, nCol);
            for (int i = 0; i < nRow; i++) {
                for (int j = 0; j < nCol; j++) {
                    res.elmt[i][j] = m.elmt[i][j];
                }
            }
            CofactorMatrix cofmat = new CofactorMatrix(m);
            for (int i = 0; i < m.nRow(); i++) {
                for (int j = 0; j < m.nCol(); j++) {
                    res.elmt[i][j] = cofmat.adjoin().elmt[i][j] / det;
                }
            }
        }
    }
    public Matriks getInverse(){
        return res;
    }
    public boolean hasInverse(){
        return res!=null;
    }
}
