package algeo.IO;

import algeo.adt.Matriks;
import algeo.lib.RLB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class FrameRegresi extends JFrame implements ActionListener {
    protected int nData=0, nVar=0, nRegresi=0;

    protected JPanel panelData;
    protected JPanel panelRegresi;
    protected JPanel panelGuide;

    protected JTextField data;
    protected JTextField var;
    protected JButton create;
    protected JPanel gridData;
    protected JButton reset;
    protected JButton calc1;
    protected JButton calc2;
    protected JFileChooser fileIn = new JFileChooser();
    protected JButton open;
    protected JTextField pathIn;

    protected JTextField textRegresi;
    protected JTextField nquery;
    protected JButton createQuery;
    protected JPanel gridRegresi;
    protected JTextField[][] xyHampiran = new JTextField[4][10];
    protected JTextArea res = new JTextArea();
    protected JButton save;
    protected JTextField pathOut;
    protected JFileChooser fileOut = new JFileChooser();
    protected JTextField[][] points = new JTextField[10][10];
    protected JLabel[] xy = new JLabel[10];
    protected JLabel[] xy2 = new JLabel[10];
    protected JTextArea inputPoints = new JTextArea();


    public FrameRegresi() {
        int i,j;
        this.setLayout(new GridBagLayout());

        panelData = new JPanel();
        panelData.setBackground(Color.RED);
        panelData.setPreferredSize(new Dimension(500,500));
        panelGuide = new JPanel();
        panelGuide.setBackground(Color.white);
        panelGuide.setPreferredSize(new Dimension(500,200));
        panelRegresi = new JPanel();
        panelRegresi.setBackground(Color.lightGray);
        panelRegresi.setPreferredSize(new Dimension(500,300));

        panelData.setLayout(new GridBagLayout());
        GridBagConstraints dataC = new GridBagConstraints();
        JLabel lData = new JLabel("#Sampel = ");
        lData.setPreferredSize(new Dimension(100,25));
        dataC.gridx=0; dataC.gridy=0;
        dataC.gridwidth=1; dataC.gridheight=1;
        dataC.weightx=1; dataC.weighty=1;
        dataC.fill = GridBagConstraints.HORIZONTAL;
        panelData.add(lData,dataC);
        data = new JTextField("0");
        data.setPreferredSize(new Dimension(100,25));
        dataC.gridx=1;
        panelData.add(data,dataC);
        JLabel lVar = new JLabel("#Variabel = ");
        lVar.setPreferredSize(new Dimension(100,25));
        dataC.gridx=2;
        panelData.add(lVar,dataC);
        var = new JTextField("0");
        var.setPreferredSize(new Dimension(100,25));
        dataC.gridx=3;
        panelData.add(var,dataC);
        create = new JButton("Create");
        create.setPreferredSize(new Dimension(100,25));
        dataC.gridx=4;
        panelData.add(create,dataC);
        reset = new JButton("Reset");
        reset.setPreferredSize(new Dimension(100,25));
        reset.setVisible(false);
        dataC.anchor = GridBagConstraints.SOUTHEAST;
        dataC.gridx=3; dataC.gridy=1;
        panelData.add(reset,dataC);
        calc1 = new JButton("solve (grid)");
        calc1.setPreferredSize(new Dimension(100,25));
        calc1.setVisible(false);
        dataC.gridx=4;
        panelData.add(calc1,dataC);
        dataC.anchor = GridBagConstraints.CENTER;
        gridData = new JPanel();
        gridData.setPreferredSize(new Dimension(500,425));
        for(i=0;i<10;i++) {
            if(i==9) {
                xy[i] = new JLabel("y"); xy2[i] = new JLabel("y");
            } else {
                xy[i] = new JLabel("x"+(i+1)); xy2[i] = new JLabel("x"+(i+1));
            }
            xy[i].setPreferredSize(new Dimension(100,25)); xy2[i].setPreferredSize(new Dimension(100,25));
            xy[i].setHorizontalAlignment(SwingConstants.CENTER); xy2[i].setHorizontalAlignment(SwingConstants.CENTER);
            for(j=0;j<10;j++) {
                points[i][j] = new JTextField();
            }
        }
        dataC.gridx=0; dataC.gridy=2;
        dataC.gridwidth=5; dataC.gridheight=11;
        dataC.fill = GridBagConstraints.HORIZONTAL;
        panelData.add(gridData,dataC);
        open = new JButton("Open");
        open.setPreferredSize(new Dimension(100,25));
        dataC.gridy=13;
        dataC.gridwidth=1; dataC.gridheight=1;
        panelData.add(open,dataC);
        pathIn = new JTextField();
        pathIn.setPreferredSize(new Dimension(100,25));
        pathIn.setEditable(false);
        dataC.gridx =1;
        panelData.add(pathIn,dataC);
        calc2 = new JButton("Solve (file)");
        calc2.setPreferredSize(new Dimension(100,25));
        dataC.gridx =4;
        panelData.add(calc2,dataC);

        panelRegresi.setLayout(new GridBagLayout());
        GridBagConstraints RegresiC = new GridBagConstraints();
        textRegresi = new JTextField("Persamaan Regresi:");
        textRegresi.setPreferredSize(new Dimension(500,25));
        textRegresi.setEditable(false);
        RegresiC.gridx=0; RegresiC.gridy=0;
        RegresiC.gridheight=1; RegresiC.gridwidth=3;
        RegresiC.weightx=1; RegresiC.weighty=1;
        RegresiC.fill = GridBagConstraints.HORIZONTAL;
        panelRegresi.add(textRegresi,RegresiC);
        JLabel lnQuery = new JLabel("#Hampiran = ");
        lnQuery.setPreferredSize(new Dimension(100,25));
        RegresiC.gridwidth = 1;
        RegresiC.gridy=1;
        panelRegresi.add(lnQuery,RegresiC);
        nquery = new JTextField("0");
        nquery.setPreferredSize(new Dimension(100,25));
        RegresiC.gridx=1;
        panelRegresi.add(nquery,RegresiC);
        createQuery = new JButton("Create");
        createQuery.setPreferredSize(new Dimension(100,25));
        RegresiC.gridx=2;
        panelRegresi.add(createQuery,RegresiC);
        for(i=0;i<4;i++) {
            for(j=0;j<10;j++) {
                xyHampiran[i][j] = new JTextField();
            }
        }
        gridRegresi = new JPanel();
        gridRegresi.setPreferredSize(new Dimension(500,150));
        RegresiC.gridx=0; RegresiC.gridy=2;
        RegresiC.gridwidth=3; RegresiC.gridheight=5;
        panelRegresi.add(gridRegresi,RegresiC);
        save = new JButton("Save");
        save.setPreferredSize(new Dimension(100,25));
        RegresiC.gridy=7;
        RegresiC.gridwidth=1; RegresiC.gridheight=1;
        panelRegresi.add(save,RegresiC);
        pathOut = new JTextField();
        pathOut.setPreferredSize(new Dimension(100,25));
        pathOut.setEditable(false);
        RegresiC.gridx=1;
        panelRegresi.add(pathOut,RegresiC);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0; c.gridy = 0;
        c.gridwidth = 1; c.gridheight = 2;
        c.weightx = 1; c.weighty =1;
        c.fill = GridBagConstraints.BOTH;
        this.add(panelData,c);
        c.gridx = 1; c.gridy = 0;
        c.gridwidth = 1; c.gridheight = 1;
        c.weighty = 0.5;
        this.add(panelGuide,c);
        c.gridx = 1; c.gridy = 1;
        c.gridwidth =1; c.gridheight =1;
        c.weighty =1;
        this.add(panelRegresi,c);

        create.addActionListener(this);
        reset.addActionListener(this);
        calc1.addActionListener(this);
        calc2.addActionListener(this);
        open.addActionListener(this);
        createQuery.addActionListener(this);
        save.addActionListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1100,600);
        this.setTitle("Regresi Linier Berganda");

        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==create) {
            int i,j;
            gridData.removeAll();
            nData = Integer.parseInt(data.getText());
            nVar = Integer.parseInt(var.getText());
            if(nData>0 && nData<=10 && nVar>0 && nVar<=9) {
                gridData.setLayout(new GridLayout(nData+1,nVar+1,0,5));
                for(j=0;j<nVar;j++) {
                    gridData.add(xy[j]);
                }
                gridData.add(xy[9]);
                for(i=0;i<nData;i++) {
                    for(j=0;j<nVar+1;j++) {
                        points[i][j].setText("0");
                        points[i][j].setPreferredSize(new Dimension(100,25));
                        gridData.add(points[i][j]);
                    }
                }
                reset.setVisible(true);
                calc1.setVisible(true);
                this.revalidate();
            } else if(nData>10 || nVar>9) {
                gridData.removeAll();
                gridData.setLayout(new GridLayout(1,1,0,0));
                gridData.add(inputPoints);
                reset.setVisible(true);
                calc1.setVisible(true);
                this.revalidate();
            }
        } else if(e.getSource()==reset) {
            if(nData>0 && nData<=10 && nVar>0 && nVar<=9) {
                int i,j;
                for(i=0;i<nData;i++) {
                    for(j=0;j<nVar+1;j++) {
                        points[i][j].setText("0");
                    }
                }
            } else if(nData>10 || nVar>9) {
                inputPoints.setText("0");
            }
        } else if(e.getSource()==calc1) {
            if(nData<=10) {
                int i,j; double[] x=new double[nVar];
                Matriks p = new Matriks(nData,nVar+1);
                for(i=0;i<nData;i++) {
                    for(j=0;j<nVar+1;j++) {
                        p.elmt[i][j] = Double.parseDouble(points[i][j].getText());
                    }
                }
                RLB Regresi1 = new RLB(p);
                Regresi1.getMatriksCoef();
                Regresi1.solveCoefReg();
                textRegresi.setText("Persamaan Regresi: "+Regresi1.getRegEq());
                if(nRegresi<=4) {
                    for(i=0;i<nRegresi;i++) {
                        for(j=0;j<nVar;j++) {
                            x[j] = Double.parseDouble(xyHampiran[i][j].getText());
                        }
                        xyHampiran[i][nVar].setText(String.format("%.4f",Regresi1.getEstimasi(x)));
                    }
                } else {
                    Scanner in2 = new Scanner(res.getText());
                    Matriks RegresiP = new Matriks(nRegresi,nVar+1);
                    double[] xe = new double[nVar];
                    for(i=0;i<nRegresi;i++) {
                        for(j=0;j<nVar;j++) {
                            RegresiP.elmt[i][j] = in2.nextDouble();
                            xe[j] = RegresiP.elmt[i][j];
                        }
                        RegresiP.elmt[i][nVar] = Regresi1.getEstimasi(xe);
                    }
                    in2.close();
                    StringBuilder sb = new StringBuilder();
                    for(i=0;i<nRegresi;i++) {
                        sb.append(String.format("%.4f", RegresiP.elmt[i][0]));
                        for(j=1;j<nVar+1;j++) {
                            sb.append(String.format(" %.4f", RegresiP.elmt[i][j]));
                        }
                        sb.append((i+1<nRegresi?"\n":""));
                    }
                    res.setText(sb.toString());
                }
            } else if(nData>10) {
                int i,j; double[] x=new double[nVar];
                Matriks p = new Matriks(nData,nVar+1);
                Scanner in = new Scanner(inputPoints.getText());
                for(i=0;i<nData;i++) {
                    for(j=0;j<nVar+1;j++) {
                        p.elmt[i][j] = in.nextDouble();
                    }
                }
                in.close();
                RLB Regresi1 = new RLB(p);
                Regresi1.getMatriksCoef();
                Regresi1.solveCoefReg();
                textRegresi.setText("Persamaan Regresi: "+Regresi1.getRegEq());
                if(nRegresi<=4) {
                    for(i=0;i<nRegresi;i++) {
                        for(j=0;j<nVar;j++) {
                            x[j] = Double.parseDouble(xyHampiran[i][j].getText());
                        }
                        xyHampiran[i][nVar].setText(String.format("%.4f",Regresi1.getEstimasi(x)));
                    }
                } else {
                    Scanner in2 = new Scanner(res.getText());
                    Matriks RegresiP = new Matriks(nRegresi,nVar+1);
                    double[] xe = new double[nVar];
                    for(i=0;i<nRegresi;i++) {
                        for(j=0;j<nVar;j++) {
                            RegresiP.elmt[i][j] = in2.nextDouble();
                            xe[j] = RegresiP.elmt[i][j];
                        }
                        RegresiP.elmt[i][nVar] = Regresi1.getEstimasi(xe);
                    }
                    in2.close();
                    StringBuilder sb = new StringBuilder();
                    for(i=0;i<nRegresi;i++) {
                        sb.append(String.format("%.4f", RegresiP.elmt[i][0]));
                        for(j=1;j<nVar+1;j++) {
                            sb.append(String.format(" %.4f", RegresiP.elmt[i][j]));
                        }
                        sb.append((i+1<nRegresi?"\n":""));
                    }
                    res.setText(sb.toString());
                }
            }
        } else if(e.getSource()==calc2) {
            if(fileIn.getSelectedFile()!=null) {
                try{
                    int i,j; double[] x=new double[nVar];
                    Matriks p = new Matriks(fileIn.getSelectedFile().getAbsolutePath());
                    RLB Regresi1 = new RLB(p);
                    Regresi1.getMatriksCoef();
                    Regresi1.solveCoefReg();
                    textRegresi.setText("Persamaan Regresi: "+Regresi1.getRegEq());
                    if(nRegresi<=4) {
                        for(i=0;i<nRegresi;i++) {
                            for(j=0;j<nVar;j++) {
                                x[j] = Double.parseDouble(xyHampiran[i][j].getText());
                            }
                            xyHampiran[i][nVar].setText(String.format("%.4f",Regresi1.getEstimasi(x)));
                        }
                    } else {
                        Scanner in2 = new Scanner(res.getText());
                        Matriks RegresiP = new Matriks(nRegresi,nVar+1);
                        double[] xe = new double[nVar];
                        for(i=0;i<nRegresi;i++) {
                            for(j=0;j<nVar;j++) {
                                RegresiP.elmt[i][j] = in2.nextDouble();
                                xe[j] = RegresiP.elmt[i][j];
                            }
                            RegresiP.elmt[i][nVar] = Regresi1.getEstimasi(xe);
                        }
                        in2.close();
                        StringBuilder sb = new StringBuilder();
                        for(i=0;i<nRegresi;i++) {
                            sb.append(String.format("%.4f", RegresiP.elmt[i][0]));
                            for(j=1;j<nVar+1;j++) {
                                sb.append(String.format(" %.4f", RegresiP.elmt[i][j]));
                            }
                            sb.append((i+1<nRegresi?"\n":""));
                        }
                        res.setText(sb.toString());
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else if(e.getSource()==open) {
            fileIn.setCurrentDirectory(new File("."));
            fileIn.showOpenDialog(null);
            if(fileIn.getSelectedFile()!=null) pathIn.setText(fileIn.getSelectedFile().getAbsolutePath());
        } else if(e.getSource()==createQuery) {
            int i,j;
            gridRegresi.removeAll();
            nRegresi = Integer.parseInt(nquery.getText());
            if(nRegresi<=4) {
                gridRegresi.setLayout(new GridLayout(nRegresi+1,nVar+1,0,5));
                for(j=0;j<nVar;j++) {
                    gridRegresi.add(xy2[j]);
                }
                gridRegresi.add(xy2[9]);
                for(i=0;i<nRegresi;i++) {
                    for(j=0;j<nVar+1;j++) {
                        xyHampiran[i][j].setText("0");
                        xyHampiran[i][j].setPreferredSize(new Dimension(100,25));
                        if(j==nVar){
                            xyHampiran[i][j].setEditable(false);
                            xyHampiran[i][j].setText(null);
                        } else {
                            xyHampiran[i][j].setEditable(true);
                        }
                        gridRegresi.add(xyHampiran[i][j]);
                    }
                }
                this.revalidate();
            } else if(nRegresi>4) {
                gridRegresi.removeAll();
                gridRegresi.setLayout(new GridLayout(1,1,0,0));
                gridRegresi.add(res);
                this.revalidate();
            }
        } else if(e.getSource()==save) {
            fileOut.setCurrentDirectory(new File("."));
            fileOut.showSaveDialog(null);
            if(fileOut.getSelectedFile()!=null) {
                pathOut.setText(fileOut.getSelectedFile().getAbsolutePath());
                File file = new File(fileOut.getSelectedFile().getAbsolutePath());
                try{
                    boolean a = file.createNewFile();
                    Formatter out = new Formatter(file.getAbsoluteFile());
                    out.format("%s%n",textRegresi.getText());
                    if(nRegresi<=4) {
                        int i,j;
                        for(i=0;i<nRegresi;i++) {
                            out.format("%s", xyHampiran[i][0].getText());
                            for(j=1;j<nVar+1;j++) {
                                out.format(" %s", xyHampiran[i][j].getText());
                            }
                            out.format("%n");
                        }
                    } else {
                        out.format("%s", res.getText());
                    }
                    out.close();
                } catch(IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}