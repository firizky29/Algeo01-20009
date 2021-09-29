package algeo.IO;

import algeo.adt.Matriks;
import algeo.lib.DeterminantOBE;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class FrameDetOBE extends FrameDetInv implements ActionListener {
    protected int nrow, ncol;

    public FrameDetOBE() {
        super();
        this.setTitle("Determinan - Metode Reduksi Baris");
        open.addActionListener(this);
        save.addActionListener(this);
        create.addActionListener(this);
        reset.addActionListener(this);
        calc2.addActionListener(this);
        calc1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
            nrow = ncol;
            if(ncol>0 && ncol<=10 && nrow>0 && nrow<=10) {
                gridSpl.setLayout(new GridLayout(nrow,ncol,5,5));
                for(i=0;i<nrow;i++) {
                    for(j=0;j<ncol;j++) {
                        koef[i][j].setText("0");
                        koef[i][j].setPreferredSize(new Dimension(50,25));
                        gridSpl.add(koef[i][j]);
                    }
                }
                reset.setVisible(true);
                calc1.setVisible(true);
                this.revalidate();
            } else if(ncol>10 || nrow>10) {
                gridSpl.removeAll();
                gridSpl.setLayout(new GridLayout(1,1,0,0));
                gridSpl.add(inputMatriks);
                reset.setVisible(true);
                calc1.setVisible(true);
                this.revalidate();
            }
        } else if(e.getSource()==reset) {
            if(nrow>0 && nrow<=10 && ncol>0 && ncol<=10) {
                int i,j;
                for(i=0;i<nrow;i++) {
                    for(j=0;j<ncol;j++) {
                        koef[i][j].setText("0");
                    }
                }
            } else if(nrow>10 || ncol>10) {
                inputMatriks.setText("");
            }
        } else if(e.getSource()==calc1) {
            if(nrow>0 && nrow<=10 && ncol>0 && ncol<=10) {
                int i,j;
                Matriks m = new Matriks(nrow,ncol);
                for(i=0;i<nrow;i++) {
                    for(j=0;j<ncol;j++) {
                        m.elmt[i][j] = parse(koef[i][j].getText());
                    }
                }
                DeterminantOBE mat = new DeterminantOBE(m);
                if(mat.hasDeterminant()) {
                    res.setText(Double.toString(mat.Determinant()));
                }
            } else if(nrow>10 || ncol>10) {
                int i,j;
                Matriks m = new Matriks(nrow,ncol);
                Scanner in = new Scanner(inputMatriks.getText());
                for(i=0;i<nrow;i++) {
                    for(j=0;j<ncol;j++) {
                        m.elmt[i][j] = in.nextDouble();
                    }
                }
                in.close();
                DeterminantOBE mat = new DeterminantOBE(m);
                if(mat.hasDeterminant()) {
                    res.setText(Double.toString(mat.Determinant()));
                }
            }
        } else if(e.getSource()==calc2) {
            if(fileIn.getSelectedFile()!=null) {
                try {
                    int j;
                    DeterminantOBE mat = new DeterminantOBE(new Matriks(fileIn.getSelectedFile().getAbsolutePath()));
                    if(mat.hasDeterminant()) {
                        res.setText(Double.toString(mat.Determinant()));
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}