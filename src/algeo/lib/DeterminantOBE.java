package algeo.lib;

import algeo.adt.Matriks;

public class DeterminantOBE extends Matriks{
    public Matriks M;
    public DeterminantOBE(Matriks m){
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

    int firstNonZeroOccurence(int startIdx, int pivot){
        int i = startIdx;
        for(;i<M.nRow();i++){
            if(!Eq(M.elmt[i][pivot], 0.0)){
                return i;
            }
        }
        return startIdx;
    }

    public Double Determinant() {
        if(!this.hasDeterminant()){
            return Double.NaN;
        }
        Double res = 1.0;
        int numOfSwaps = 0;
        int i, j, k, p;
        i = k = 0;
        while (i < M.nRow() && k < M.nCol()) {
            int i_max = firstNonZeroOccurence(i, k);
            if (Eq(M.elmt[i_max][k], 0.0)) {
                k++;
            } else {
                if (i_max != i) {
                    M.swaprow(i_max, i);
                    numOfSwaps++;
                }
                for (j = i + 1; j < M.nRow(); j++) {
                    for (p = k + 1; p < M.nCol(); p++) {
                        if(!Eq(M.elmt[i][k], 0.0)){
                            M.elmt[j][p] = M.elmt[j][p] - M.elmt[i][p] * M.elmt[j][k] / M.elmt[i][k];
                        }

                    }
                    M.elmt[j][k] = 0.0;
                }
                i++;
                k++;
            }
        }
        res *= Math.pow(-1, numOfSwaps);
        for(int l=0; l<M.nRow(); l++){
            res *= M.elmt[l][l];
        }
        return res;
    }

    public boolean hasDeterminant(){
        return M!=null;
    }
}
