package algeo.lib;

import algeo.adt.Matriks;
import java.util.*;

// Regresi Linier Berganda
public class RLB {
    Matriks m;      // Matriks koefisien b
    Double[] b,B;   // b[i] yang mau dicari, B ruas kanan SPL
    Double[][] x;   // x variabel bebas (yang bentuknya x[i][j]
    Double[] y;     // y variabel terikat (yang bentuknya y[i]
    int n,k;
    public RLB(int k, int n){      // k banyak variabel bebas, n banyak data
        b = new Double[k+1];
        B = new Double[k+1];
        m = new Matriks(k + 1,k+1);
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

            B[i] = 0d;
            for(int j=0; j<n; j++){
                Double xi;
                if(i==0) xi = 1d;
                else xi = x[i][j];
                B[i] += xi*y[j];
            }
        }
    }
}
