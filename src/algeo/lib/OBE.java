package algeo.lib;

import algeo.adt.Matriks;

import java.util.Arrays;

public class OBE extends Matriks{
    public Matriks M;
    public OBE(){
        M = new Matriks(nRow, nCol);
        M.elmt = Arrays.stream(this.elmt).map(Double[]::clone).toArray(Double[][]::new);
    }
    int idxOfLargestAbs(int startIdx, int pivot){
        int i;
        for(i=startIdx; i<M.nRow()&&Eq(M.elmt[i][pivot], 0.0); i++);
        if(i==M.nRow()) i--;
        return i;
    }
}
