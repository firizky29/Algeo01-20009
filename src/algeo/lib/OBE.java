package algeo.lib;

import algeo.adt.Matriks;

import java.util.Arrays;

public class OBE extends Matriks{
    public Matriks M;
    public OBE(Matriks m){
        super(m);
        M = new Matriks(nRow, nCol);
        M.elmt = Arrays.stream(this.elmt).map(Double[]::clone).toArray(Double[][]::new);
    }
    int idxOfLargestAbs(int startIdx, int pivot){
        int i;
        for(i=startIdx; i<M.nRow()&&Eq(M.elmt[i][pivot], 0.0); i++);
        if(i==M.nRow()) i--;
        return i;
    }
    public void GaussProcess(){
        int i, j, k, p;
        i = k = 0;
        while(i<M.nCol() && k<M.nRow()){
            int i_max = idxOfLargestAbs(i, k);
            if(Eq(M.elmt[i_max][k], 0.0)){
                k++;
            }
            else{
                if(i_max!=i) M.swaprow(i_max, i);
                double tmp = M.elmt[i][k];
                for(j=0; j<M.nCol(); j++){
                    M.elmt[i][j] /= tmp;
                }
                //M.tulisMatriks2();
                for(j=i+1; j<M.nRow(); j++){
                    //System.out.println(M.elmt[i][k] + "\n");
                    for(p = k+1; p<M.nCol(); p++){
                        M.elmt[j][p] = M.elmt[j][p] - M.elmt[i][p]*M.elmt[j][k];
                    }
                    M.elmt[j][k] = 0.0;
                }
                i++;
                k++;
            }//M.tulisMatriks2();
        }
    }

    public void JordanProcess(){
        int i, j, k, p;
        i = k = 0;
        while(i<M.nCol() && k<M.nRow()){
            int i_max = idxOfLargestAbs(i, k);
            if(Eq(M.elmt[i_max][k], 0.0)){
                k++;
            }
            else{
                if(i_max!=i) M.swaprow(i_max, i);
                double tmp = M.elmt[i][k];
                for(j=0; j<M.nCol(); j++){
                    M.elmt[i][j] /= tmp;
                }
                //M.tulisMatriks2();
                for(j=0; j<M.nRow(); j++){
                    if(j==i) continue;
                    //System.out.println(M.elmt[i][k] + "\n");
                    for(p = k+1; p<M.nCol(); p++){
                        M.elmt[j][p] = M.elmt[j][p] - M.elmt[i][p]*M.elmt[j][k];
                    }
                    M.elmt[j][k] = 0.0;
                }
                i++;
                k++;
            }//M.tulisMatriks2();
        }
    }
}
