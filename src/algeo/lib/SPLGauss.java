package algeo.lib;

import algeo.adt.Matriks;

import java.util.*;



public class SPLGauss extends Matriks{
    public Matriks M;
    public SPLGauss(Matriks m){
        super(m);
        // Handle kasus kalau banyak variabel != banyak persamaan
        if(nRow!=nCol-1){
            if(nRow>nCol-1){
                M = new Matriks(nRow, nRow+1);
            }
            else{
                M = new Matriks(nCol-1, nCol);
            }
        }
        else{
            M = new Matriks(nRow, nCol);
        }
        for(int i=0; i<M.nRow(); i++){
            for(int j=0; j<M.nCol(); j++){
                if(nCol-1==nRow) M.elmt[i][j] = m.elmt[i][j];
                else{
                    if(nCol-1>nRow){
                        if(i>=nRow){
                            M.elmt[i][j] = 0.0;
                        }
                        else{
                            M.elmt[i][j] = m.elmt[i][j];
                        }
                    }
                    else{
                        if(j>=nCol-1&&j!=M.nCol()-1){
                            M.elmt[i][j] = 0.0;
                        }
                        else if(j!=M.nCol()-1){
                            M.elmt[i][j] = m.elmt[i][j];
                        }
                        else{
                            M.elmt[i][j] = m.elmt[i][nCol-1];
                        }
                    }
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

    public void GaussProcess(){
        int i, j, k, p;
        i = k = 0;
        while(i<M.nRow() && k<M.nCol()){
            int i_max = firstNonZeroOccurence(i, k);
            if(Eq(M.elmt[i_max][k], 0.0)){
                k++;
            }
            else{
                if(i_max!=i) {
                    M.swaprow(i_max, i);
                }
                double tmp = M.elmt[i][k];

                for(j=0; j<M.nCol(); j++){
                    M.elmt[i][j] /= tmp;
                }
                for(j=i+1; j<M.nRow(); j++){
                    for(p = k+1; p<M.nCol(); p++){
                        M.elmt[j][p] = M.elmt[j][p] - M.elmt[i][p]*M.elmt[j][k];
                    }
                    M.elmt[j][k] = 0.0;
                }
                i++;
                k++;
            }
        }
    }

    public void JordanProcess(){
        int i, j, k, p;
        i = k = 0;
        while(i<M.nRow() && k<M.nCol()){
            int i_max = firstNonZeroOccurence(i, k);
            if(Eq(M.elmt[i_max][k], 0.0)){
                k++;
            }
            else{
                if(i_max!=i) M.swaprow(i_max, i);
                double tmp = M.elmt[i][k];
                for(j=0; j<M.nCol(); j++){
                    M.elmt[i][j] /= tmp;
                }
                for(j=0; j<M.nRow(); j++){
                    if(j==i) continue;
                    for(p = k+1; p<M.nCol(); p++){
                        M.elmt[j][p] = M.elmt[j][p] - M.elmt[i][p]*M.elmt[j][k];
                    }
                    M.elmt[j][k] = 0.0;
                }
                i++;
                k++;
            }
        }
    }
    public String[] getSolution(){
        String[] solution = new String[nCol-1];
        Double[][] Expression = new Double[M.nRow()][M.nCol()];
        boolean inf = false;
        boolean NaN = false;
        for(int i=0; i<M.nRow()&&!NaN; i++){
            boolean curCheckInf = true;
            for(int j=0; j<M.nCol()&&!NaN; j++){
                Expression[i][j] = M.elmt[i][j];
                if(!Eq(M.elmt[i][j], 0.0)&&curCheckInf){
                    curCheckInf = false;
                    if(j==M.nCol()-1){
                        NaN = true;
                    }
                }
            }
            if(!inf && curCheckInf){
                inf = true;
            }
        }
        if(NaN){
            Arrays.fill(solution, "NaN");
            return solution;
        }
        else if(inf){
            boolean[] var = new boolean[M.nRow()];
            List <Integer> idx = new ArrayList<>();
            HashMap<Integer, Integer> ExptoRow = new HashMap<>();
            int[] idxFirst = new int[M.nRow()];
            boolean[] allzeros = new boolean[M.nRow()];
            HashMap<Integer, Integer> pos = new HashMap<>();
            HashMap<Integer, Integer> parameterIdx = new HashMap<>();
            for(int i=0; i<M.nRow(); i++){
                idxFirst[i] = -1;
                allzeros[i] = true;
                for(int j=0; j<M.nCol()-1; j++){
                    if(idxFirst[i]==-1&&!Eq(M.elmt[i][j], 0.0)){
                        idxFirst[i] = j;
                        ExptoRow.put(j, i);
                        var[idxFirst[i]] = true;
                        allzeros[i] = false;
                        //parameterIdx.put(j, j);
                    }
                    else if(idxFirst[i]!=-1){
                        Expression[i][j] = 0.0;
                    }
                }
            }
            for(int i=0; i<M.nRow(); i++){
                //System.out.print(allzeros[i]+" ");
                if(!var[i]){
                    idx.add(i);
                    //System.out.println(i);
                }
            }
            //System.out.println("\n");
            int q = 0;
            for(int i=0; i<M.nRow(); i++){
                if(allzeros[i]){
                    parameterIdx.put(idx.get(0), q++);
                    pos.put(i, idx.get(0));
                    ExptoRow.put(idx.get(0), i);
                    //System.out.print(i + " " + idx.get(0));
                    Expression[i][idx.get(0)] = 1.0;
                    idx.remove(0);
                }
            }
            for(int j=M.nRow()-1; j>=0; j--){
                if(!allzeros[j]){
                    for(int i=idxFirst[j]+1; i<M.nCol()-1; i++){
                        int RealPos = ExptoRow.get(i);
                        if (idxFirst[RealPos]>=0) {
                            for (int k = idxFirst[RealPos]+1; k < M.nCol(); k++) {
                                Expression[j][k] += -1.0 * M.elmt[j][i] * Expression[RealPos][k];
                            }
                        } else {
                            Expression[j][i] += -1.0 * M.elmt[j][i];
                        }
                    }
                }
            }
//            System.out.println("\n");
//            for(int i=0; i<M.nCol()-1; i++){
//                //if(parameterIdx.get(i)!=null) System.out.println(parameterIdx.get(i));
//                for(int k=0; k<M.nCol(); k++){
//                    System.out.print(Expression[i][k] + (" "));
//                }
//                System.out.println("");
//            }
            for(int i=0; i<nCol-1; i++){
                if(allzeros[i]){
                    solution[pos.get(i)] = "c" + (parameterIdx.get(pos.get(i))+1) ;
                }
                else{
                    solution[idxFirst[i]] = "";
                    for(int j=idxFirst[i]+1; j<M.nCol(); j++){
                        boolean firstCome = (solution[idxFirst[i]]=="");
                        if(!Eq(Expression[i][j], 0.0)&&j!=M.nCol()-1){
                            if(Eq(Expression[i][j], 1.0)){
                                if(firstCome) solution[idxFirst[i]] += "c" + (parameterIdx.get(j)+1);
                                else solution[idxFirst[i]] += " + c" + (parameterIdx.get(j)+1);
                            }
                            else if(Eq(Expression[i][j], -1.0)){
                                if(firstCome) solution[idxFirst[i]] += "-c" + (parameterIdx.get(j)+1);
                                else solution[idxFirst[i]] += " - c" + (parameterIdx.get(j)+1);
                            }
                            else{
                                if(Expression[i][j] < 0.0){
                                    if(firstCome) solution[idxFirst[i]] += "-" + Double.toString(Expression[i][j]).substring(1) + "c"  + (parameterIdx.get(j)+1);
                                    else solution[idxFirst[i]] += " - " + Double.toString(Expression[i][j]).substring(1) + "c"  + (parameterIdx.get(j)+1);

                                }
                                else if(Expression[i][j] > 0.0){
                                    if(firstCome) solution[idxFirst[i]] +=  Double.toString(Expression[i][j]).substring(0) + "c"  + (parameterIdx.get(j)+1);
                                    else solution[idxFirst[i]] += " + " + Double.toString(Expression[i][j]).substring(0) + "c"  + (parameterIdx.get(j)+1);
                                }
                            }
                        }
                        else if(j == M.nCol()-1){
                            if(Eq(Expression[i][j], 0.0)){
                                if(firstCome) solution[idxFirst[i]] += Double.toString(0.0);
                            }
                            else if(Expression[i][j] < 0.0){
                                if(firstCome) solution[idxFirst[i]] += "-" + Double.toString(Expression[i][j]).substring(1);
                                else solution[idxFirst[i]] += " - " + Double.toString(Expression[i][j]).substring(1);

                            }
                            else if(Expression[i][j] > 0.0){
                                if(firstCome) solution[idxFirst[i]] +=  Double.toString(Expression[i][j]).substring(0);
                                else solution[idxFirst[i]] += " + " + Double.toString(Expression[i][j]).substring(0);
                            }

                        }
                    }
                }
            }
        }
        else{
            Expression[M.nRow()-1][M.nRow()-1] = M.elmt[M.nRow()-1][M.nCol()-1];
            for(int i=M.nRow()-2; i>=0; i--){
                Expression[i][i] = 0.0;
                for(int j=i+1; j<M.nCol(); j++){
                    if(j==M.nCol()-1){
                        Expression[i][i] += M.elmt[i][j];
                    }
                    else{
                        Expression[i][i] -= M.elmt[i][j]*Expression[j][j];
                    }
                }
            }
            for(int i=0; i<M.nRow(); i++){
                solution[i] = Double.toString(Expression[i][i]);
            }
        }
        return solution;
    }


}
