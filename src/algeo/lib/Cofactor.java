package algeo.lib;

// Kelas kofaktor, berupa matriks
public class Cofactor extends Matriks {
    public Cofactor(Matriks matriks, int i, int j){
        super(matriks.nRow()-1, matriks.nCol()-1);
        for(int im = 0; im < matriks.nRow(); im++){
            for(int jm = 0; jm < matriks.nCol(); jm++){
                if (im == i || jm == j) continue;
                int ic = (im < i) ? im : im - 1;
                int jc = (jm < j) ? jm : jm - 1;
                this.elmt[ic][jc] = matriks.elmt[im][jm];
            }
        }
    }
}
