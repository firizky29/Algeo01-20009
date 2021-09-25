package algeo.lib;

import algeo.adt.Matriks;

import javax.swing.*;

public class InversOBE extends SPLGauss{
    Matriks res;
    public InversOBE(Matriks m){
        super(m);
        res = new Matriks(nRow, nCol);
        if(nRow!=nCol){
            System.out.println("Balikan Tidak Terdefinisi, Jumlah baris dan kolom harus sama");
        }
        else {
            M = new Matriks(nRow, 2*nCol);
            for(int i=0; i<nRow; i++){
                for(int j=0; j<2*nCol; j++){
                    if(j<nCol) {
                        M.elmt[i][j] = m.elmt[i][j];
                        res.elmt[i][j] = m.elmt[i][j];
                    }
                    else{
                        if(j-(nCol)==i){
                            M.elmt[i][j] = 1.0;
                        }
                        else{
                            M.elmt[i][j] = 0.0;
                        }
                    }
                }
            }
        }
    }
    private Matriks InversProcess(){
        SPLGauss inv = new SPLGauss(this.M);
        DeterminantOBE Det = new DeterminantOBE(res);

        if(Eq(Det.Determinant(), 0.0)){
            System.out.println("Tidak memiliki invers");
            return this.res;
        }
        else{
            inv.JordanProcess();
            return inv.M;
        }
    }
    public Matriks getInvers(){
        Matriks inv = InversProcess();
        for(int i=0; i<nRow; i++){
            for(int j=0; j<nCol; j++){
                res.elmt[i][j] = inv.elmt[i][nCol+j];
            }
        }
        return res;
    }
}
