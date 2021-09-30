package algeo.lib;

import algeo.adt.Matriks;
import java.util.*;

// Regresi Linier Berganda
public class RLB {
    Matriks m;      // Matriks Augmented
    Double[] b;     // b[i] yang mau dicari
    Double[][] x;   // x variabel bebas (yang bentuknya x[i][j]
    Double[] y;     // y variabel terikat (yang bentuknya y[i]
    int n,k;
    public RLB(int k, int n){      // k banyak variabel bebas, n banyak data
        b = new Double[k+1];
        m = new Matriks(k+1,k+2);
        x = new Double[k][n];
        y = new Double[n];
        this.n = n;
        this.k = k;
        Scanner input = new Scanner(System.in);
        for(int j=0; j<n; j++){
            for(int i=0; i<k; i++){
                x[i][j] = input.nextDouble();
            }
            y[j] = input.nextDouble();
        }
    }

    public RLB(Matriks m) {         // m matriks dengan n baris dan k + 1 kolom
        this.n = m.nRow();
        this.k = m.nCol() - 1;
        b = new Double[k+1];
        this.m = new Matriks(k + 1,k+2);
        x = new Double[k][n];
        y = new Double[n];
        for(int j=0; j<n; j++){
            for(int i=0; i<k; i++){
                x[i][j] = m.elmt[j][i];
            }
            y[j] = m.elmt[j][k];
        }
    }

    public void getMatriksCoef(){
        for(int i=0; i<=k; i++){
            for(int j=0; j<=k; j++){
                Double xim, xjm;
                double coef = 0d;
                for(int l=0; l<n; l++){
                    if(i==0) xim = 1d;
                    else xim = x[i-1][l];
                    if(j==0) xjm = 1d;
                    else xjm = x[j-1][l];
                    coef += xim*xjm;
                }
                m.elmt[i][j] = coef;
            }

            m.elmt[i][k+1] = 0d;
            for(int j=0; j<n; j++){
                Double xi;
                if(i==0) xi = 1d;
                else xi = x[i-1][j];
                m.elmt[i][k+1] += xi*y[j];
            }
        }
    }

    public void solveCoefReg(){
        SPLInvers splinv = new SPLInvers(this.m);
        b = splinv.getSolutionVal();
    }

    public String getRegEq(){
        String eq = "y = ";
        for(int i=0; i<=k; i++){
            eq += b[i];
            if(i!=0) eq += " x[" + i + "] + ";
        }
        eq += "e";
        return eq;
    }

    public double getEstimasi(double[] xe) {
        double estimasi=0.0;
        int j;
        for(j=0;j<k+1;j++) {
            estimasi += b[j]*(j>0?xe[j-1]:1.0);
        }
        return estimasi;
    }

    public int getK() {
        return k;
    }
}
