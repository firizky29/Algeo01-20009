package algeo.lib;

import algeo.adt.Matriks;

public class interpolasiPolinom {
    private Matriks points;
    private Double[] coefPolinom;
    public interpolasiPolinom(Matriks points) {
        this.points = new Matriks(points);
        int n = points.nRow();
        Matriks matriksAugmented = new Matriks(n,n+1);
        int i,j;

        for(i=0;i<n;i++) {
            for(j=0;j<n+1;j++) {
                if(j==0) {
                    matriksAugmented.elmt[i][j]=1.0;
                } else if(j==n) {
                    matriksAugmented.elmt[i][j]=points.elmt[i][1];
                } else {
                    matriksAugmented.elmt[i][j]=matriksAugmented.elmt[i][j-1]*points.elmt[i][0];
                }
            }
        }
        // interpolasiPolinom dijamin solusinya unik jika koordinat x tiap titik berbeda
        SPLGauss splAugmented = new SPLGauss(matriksAugmented);
        splAugmented.JordanProcess();
        String[] coefPolinomString = splAugmented.getSolution();
        coefPolinom = new Double[n];
        for(i=0;i<n;i++) {
            coefPolinom[i] = Double.valueOf(coefPolinomString[i]);
        }
    }

    public double getHampiran(double x) {
        double xp=1.0, hasil=0.0;
        int i;
        for(i=0;i<coefPolinom.length;i++) {
            hasil += coefPolinom[i]*xp;
            xp *= x;
        }
        return hasil;
    }

    public Double[] getCoefPolinom() {
        return coefPolinom;
    }
}