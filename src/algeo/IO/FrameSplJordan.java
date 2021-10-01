package algeo.IO;

import algeo.lib.Matriks;
import algeo.lib.SPLGauss;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class FrameSplJordan extends FrameSpl implements ActionListener {
    protected int nrow, ncol;

    public FrameSplJordan(JFrame J) {
        super(J);
        this.setTitle("SPL - Metode Eliminasi Gauss-Jordan");
        open.addActionListener(this);
        save.addActionListener(this);
        reset.addActionListener(this);
        calc2.addActionListener(this);
        calc1.addActionListener(this);
        create.addActionListener(this);
        home.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int maxSize = 6;
        if(e.getSource()==open) {
            fileIn.setCurrentDirectory(new File("."));
            fileIn.showOpenDialog(null);
            if(fileIn.getSelectedFile()!=null) pathIn.setText(fileIn.getSelectedFile().getAbsolutePath());
        } else if(e.getSource()==save) {
            fileOut.setCurrentDirectory(new File("."));
            fileOut.showSaveDialog(null);
            if(fileOut.getSelectedFile()!=null) {
                pathOut.setText(fileOut.getSelectedFile().getAbsolutePath());
                File file = new File(fileOut.getSelectedFile().getAbsolutePath());
                try {
                    boolean a = file.createNewFile();
                    Formatter out = new Formatter(file.getAbsoluteFile());
                    out.format("%s",res.getText());
                    out.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else if(e.getSource()==create) {
            int i,j;
            gridSpl.removeAll();
            ncol = Integer.parseInt(col.getText());
            nrow = Integer.parseInt(row.getText());
            if(ncol>0 && ncol<=maxSize && nrow>0 && nrow<=maxSize) {
                gridSpl.setLayout(new GridLayout(nrow,2*ncol-1,0,2));
                for(i=0;i<nrow;i++) {
                    for(j=0;j<ncol;j++) {
                        koef[i][j].setText("0");
                        koef[i][j].setPreferredSize(new Dimension(50,25));
                        gridSpl.add(koef[i][j]);
                        if(j<ncol-2) {
                            xi[i][j].setText("x"+(j+1)+" +");
                            xi[i][j].setPreferredSize(new Dimension(30,25));
                            gridSpl.add(xi[i][j]);
                        } else if(j==ncol-2) {
                            xi[i][j].setText("x"+(j+1)+" =");
                            xi[i][j].setPreferredSize(new Dimension(30,25));
                            gridSpl.add(xi[i][j]);
                        }
                    }
                }
                reset.setVisible(true);
                calc1.setVisible(true);
                this.revalidate();
            } else if(ncol>maxSize || nrow>maxSize) {
                gridSpl.removeAll();
                gridSpl.setLayout(new GridLayout(1,1,0,0));
                gridSpl.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
                gridSpl.add(inputMatriks);
                reset.setVisible(true);
                calc1.setVisible(true);
                this.revalidate();
            }
        } else if(e.getSource()==reset) {
            if(nrow>0 && nrow<=maxSize && ncol>0 && ncol<=maxSize) {
                int i,j;
                for(i=0;i<nrow;i++) {
                    for(j=0;j<ncol;j++) {
                        koef[i][j].setText("0");
                    }
                }
            } else if(nrow>maxSize || ncol>maxSize) {
                inputMatriks.setText("");
            }
        } else if(e.getSource()==calc1) {
            if(nrow>0 && nrow<=maxSize && ncol>0 && ncol<=maxSize) {
                int i,j;
                Matriks m = new Matriks(nrow,ncol);
                for(i=0;i<nrow;i++) {
                    for(j=0;j<ncol;j++) {
                        m.elmt[i][j] = parse(koef[i][j].getText());
                    }
                }
                SPLGauss spl = new SPLGauss(m);
                spl.JordanProcess();
                String[] solusi = spl.getSolution();
                StringBuilder solusijoined = new StringBuilder();
                if(solusi[0].equals("NaN")) {
                    solusijoined.append("SPL tidak memiliki solusi");
                } else {
                    for(j=0;j<solusi.length;j++) {
                        solusijoined.append("x"+(j+1)+"= "+solusi[j]+"\n");
                    }
                }
                res.setText(solusijoined.toString());
            } else if(nrow>maxSize || ncol>maxSize) {
                int i,j;
                Matriks m = new Matriks(nrow,ncol);
                Scanner in = new Scanner(inputMatriks.getText());
                for(i=0;i<nrow;i++) {
                    for(j=0;j<ncol;j++) {
                        m.elmt[i][j] = in.nextDouble();
                    }
                }
                in.close();
                SPLGauss spl = new SPLGauss(m);
                spl.JordanProcess();
                String[] solusi = spl.getSolution();
                StringBuilder solusijoined = new StringBuilder();
                if(solusi[0].equals("NaN")) {
                    solusijoined.append("SPL tidak memiliki solusi");
                } else {
                    for(j=0;j<solusi.length;j++) {
                        solusijoined.append("x"+(j+1)+"= "+solusi[j]+"\n");
                    }
                }
                res.setText(solusijoined.toString());
            }
        } else if(e.getSource()==calc2) {
            if(fileIn.getSelectedFile()!=null) {
                try {
                    int j;
                    SPLGauss m = new SPLGauss(new Matriks(fileIn.getSelectedFile().getAbsolutePath()));
                    m.JordanProcess();
                    String[] solusi = m.getSolution();
                    StringBuilder solusijoined = new StringBuilder();
                    if(solusi[0].equals("NaN")) {
                        solusijoined.append("SPL tidak memiliki solusi");
                    } else {
                        for(j=0;j<solusi.length;j++) {
                            solusijoined.append("x"+(j+1)+"= "+solusi[j]+"\n");
                        }
                    }
                    res.setText(solusijoined.toString());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else if(e.getSource()==home){
            this.setVisible(false);
            this.prevFrame.setVisible(true);
            this.dispose();
        }
    }
}