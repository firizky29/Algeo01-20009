package algeo.IO;

import algeo.lib.Matriks;
import algeo.lib.interpolasiPolinom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class FrameInterpol extends JFrame implements ActionListener {
    protected int nData, nInterpolated=0;

    protected JFrame prevFrame;

    protected JPanel panelData;
    protected JPanel panelInter;
    protected JPanel panelGuide;
    
    protected JTextField data;
    protected JButton create;
    protected JPanel gridData;
    protected JButton reset;
    protected JButton calc1;
    protected JButton calc2;
    protected JFileChooser fileIn = new JFileChooser();
    protected JButton open;
    protected JTextField pathIn;

    protected JTextField textPolinom;
    protected JTextField nquery;
    protected JButton createQuery;
    protected JPanel gridInter;
    protected JTextField[][] xyHampiran = new JTextField[4][2];
    protected JTextArea res = new JTextArea();
    protected JButton save;
    protected JTextField pathOut;
    protected JFileChooser fileOut = new JFileChooser();
    protected JTextField[][] points = new JTextField[10][2];
    protected JLabel[] xy = new JLabel[2];
    protected JLabel[] xy2 = new JLabel[2];
    protected JTextArea inputPoints = new JTextArea();
    
    
    public FrameInterpol(JFrame prevFrame) {
        this.prevFrame = prevFrame;
        int i,j;
        this.setLayout(new GridBagLayout());

        panelData = new JPanel();
        panelData.setBackground(Color.RED);
        panelData.setPreferredSize(new Dimension(500,500));
        panelGuide = new JPanel();
        panelGuide.setBackground(Color.white);
        panelGuide.setPreferredSize(new Dimension(500,200));
        panelInter = new JPanel();
        panelInter.setBackground(Color.lightGray);
        panelInter.setPreferredSize(new Dimension(500,300));

        panelData.setLayout(new GridBagLayout());
        GridBagConstraints dataC = new GridBagConstraints();
        JLabel lData = new JLabel("#Titik = ");
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
        create = new JButton("Create");
        create.setPreferredSize(new Dimension(100,25));
        dataC.gridx=2;
        panelData.add(create,dataC);
        reset = new JButton("Reset");
        reset.setPreferredSize(new Dimension(100,25));
        reset.setVisible(false);
        dataC.anchor = GridBagConstraints.SOUTHEAST;
        dataC.gridx=1; dataC.gridy=1;
        panelData.add(reset,dataC);
        calc1 = new JButton("solve (grid)");
        calc1.setPreferredSize(new Dimension(100,25));
        calc1.setVisible(false);
        dataC.gridx=2;
        panelData.add(calc1,dataC);
        dataC.anchor = GridBagConstraints.CENTER;
        gridData = new JPanel();
        gridData.setPreferredSize(new Dimension(500,425));
        xy[0] = new JLabel("x"); xy[1] = new JLabel("y");
        xy2[0] = new JLabel("x"); xy2[1] = new JLabel("y");
        for(i=0;i<10;i++) {
            for(j=0;j<2;j++) {
                points[i][j] = new JTextField();
            }
        }
        dataC.gridx=0; dataC.gridy=2;
        dataC.gridwidth=3; dataC.gridheight=3;
        dataC.fill = GridBagConstraints.HORIZONTAL;
        panelData.add(gridData,dataC);
        open = new JButton("Open");
        open.setPreferredSize(new Dimension(100,25));
        dataC.gridy=5;
        dataC.gridwidth=1; dataC.gridheight=1;
        panelData.add(open,dataC);
        pathIn = new JTextField();
        pathIn.setPreferredSize(new Dimension(100,25));
        pathIn.setEditable(false);
        dataC.gridx =1;
        panelData.add(pathIn,dataC);
        calc2 = new JButton("Solve (file)");
        calc2.setPreferredSize(new Dimension(100,25));
        dataC.gridx =2;
        panelData.add(calc2,dataC);

        panelInter.setLayout(new GridBagLayout());
        GridBagConstraints interC = new GridBagConstraints();
        textPolinom = new JTextField("Persamaan Polinom:");
        textPolinom.setPreferredSize(new Dimension(500,25));
        textPolinom.setEditable(false);
        interC.gridx=0; interC.gridy=0;
        interC.gridheight=1; interC.gridwidth=3;
        interC.weightx=1; interC.weighty=1;
        interC.fill = GridBagConstraints.HORIZONTAL;
        panelInter.add(textPolinom,interC);
        JLabel lnQuery = new JLabel("#Hampiran = ");
        lnQuery.setPreferredSize(new Dimension(100,25));
        interC.gridwidth = 1;
        interC.gridy=1;
        panelInter.add(lnQuery,interC);
        nquery = new JTextField("0");
        nquery.setPreferredSize(new Dimension(100,25));
        interC.gridx=1;
        panelInter.add(nquery,interC);
        createQuery = new JButton("Create");
        createQuery.setPreferredSize(new Dimension(100,25));
        interC.gridx=2;
        panelInter.add(createQuery,interC);
        for(i=0;i<4;i++) {
            for(j=0;j<2;j++) {
                xyHampiran[i][j] = new JTextField();
            }
        }
        gridInter = new JPanel();
        gridInter.setPreferredSize(new Dimension(500,150));
        interC.gridx=0; interC.gridy=2;
        interC.gridwidth=3; interC.gridheight=5;
        panelInter.add(gridInter,interC);
        save = new JButton("Save");
        save.setPreferredSize(new Dimension(100,25));
        interC.gridy=7;
        interC.gridwidth=1; interC.gridheight=1;
        panelInter.add(save,interC);
        pathOut = new JTextField();
        pathOut.setPreferredSize(new Dimension(100,25));
        pathOut.setEditable(false);
        interC.gridx=1;
        panelInter.add(pathOut,interC);

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
        this.add(panelInter,c);

        create.addActionListener(this);
        reset.addActionListener(this);
        calc1.addActionListener(this);
        calc2.addActionListener(this);
        open.addActionListener(this);
        createQuery.addActionListener(this);
        save.addActionListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1100,600);
        this.setTitle("Interpolasi Polinom");

        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==create) {
            int i,j;
            gridData.removeAll();
            nData = Integer.parseInt(data.getText());
            if(nData>0 && nData<=10) {
                gridData.setLayout(new GridLayout(nData+1,2,0,5));
                xy[0].setPreferredSize(new Dimension(100,25));
                xy[1].setPreferredSize(new Dimension(100,25));
                xy[0].setHorizontalAlignment(SwingConstants.CENTER); xy[1].setHorizontalAlignment(SwingConstants.CENTER);
                gridData.add(xy[0]);
                gridData.add(xy[1]);
                for(i=0;i<nData;i++) {
                    for(j=0;j<2;j++) {
                        points[i][j].setText("0");
                        points[i][j].setPreferredSize(new Dimension(100,25));
                        gridData.add(points[i][j]);
                    }
                }
                reset.setVisible(true);
                calc1.setVisible(true);
                this.revalidate();
            } else if(nData>10) {
                gridData.removeAll();
                gridData.setLayout(new GridLayout(1,1,0,0));
                gridData.add(inputPoints);
                reset.setVisible(true);
                calc1.setVisible(true);
                this.revalidate();
            }
        } else if(e.getSource()==reset) {
            if(nData>0 && nData<=10) {
                int i,j;
                for(i=0;i<nData;i++) {
                    for(j=0;j<2;j++) {
                        points[i][j].setText("0");
                    }
                }
            } else if(nData>10) {
                inputPoints.setText("0");
            }
        } else if(e.getSource()==calc1) {
            if(nData<=10) {
                int i,j; double x;
                Matriks p = new Matriks(nData,2);
                for(i=0;i<nData;i++) {
                    for(j=0;j<2;j++) {
                        p.elmt[i][j] = Double.parseDouble(points[i][j].getText());
                    }
                }
                interpolasiPolinom polinom1 = new interpolasiPolinom(p);
                textPolinom.setText("Persamaan Polinom: "+polinom1.getPolinomString());
                if(nInterpolated<=4) {
                    for(i=0;i<nInterpolated;i++) {
                        x = Double.parseDouble(xyHampiran[i][0].getText());
                        xyHampiran[i][1].setText(String.format("%.4f",polinom1.getHampiran(x)));
                    }
                } else {
                    Scanner in2 = new Scanner(res.getText());
                    Matriks interP = new Matriks(nInterpolated,2);
                    for(i=0;i<nInterpolated;i++) {
                        interP.elmt[i][0] = in2.nextDouble();
                        interP.elmt[i][1] = polinom1.getHampiran(interP.elmt[i][0]);
                    }
                    in2.close();
                    StringBuilder sb = new StringBuilder();
                    for(i=0;i<nInterpolated;i++) {
                        sb.append(String.format("%.4f %.4f", interP.elmt[i][0], interP.elmt[i][1]));
                        sb.append((i+1<nInterpolated?"\n":""));
                    }
                    res.setText(sb.toString());
                }
            } else if(nData>10) {
                int i,j; double x;
                Matriks p = new Matriks(nData,2);
                Scanner in = new Scanner(inputPoints.getText());
                for(i=0;i<nData;i++) {
                    for(j=0;j<2;j++) {
                        p.elmt[i][j] = in.nextDouble();
                    }
                }
                in.close();
                interpolasiPolinom polinom1 = new interpolasiPolinom(p);
                textPolinom.setText("Persamaan Polinom: "+polinom1.getPolinomString());
                if(nInterpolated<=4) {
                    for(i=0;i<nInterpolated;i++) {
                        x = Double.parseDouble(xyHampiran[i][0].getText());
                        xyHampiran[i][1].setText(String.format("%.4f",polinom1.getHampiran(x)));
                    }
                } else {
                    Scanner in2 = new Scanner(res.getText());
                    Matriks interP = new Matriks(nInterpolated,2);
                    for(i=0;i<nInterpolated;i++) {
                        interP.elmt[i][0] = in2.nextDouble();
                        interP.elmt[i][1] = polinom1.getHampiran(interP.elmt[i][0]);
                    }
                    in2.close();
                    StringBuilder sb = new StringBuilder();
                    for(i=0;i<nInterpolated;i++) {
                        sb.append(String.format("%.4f %.4f", interP.elmt[i][0], interP.elmt[i][1]));
                        sb.append((i+1<nInterpolated?"\n":""));
                    }
                    res.setText(sb.toString());
                }
            }
        } else if(e.getSource()==calc2) {
            if(fileIn.getSelectedFile()!=null) {
                try{
                    int i; double x;
                    Matriks p = new Matriks(fileIn.getSelectedFile().getAbsolutePath());
                    interpolasiPolinom polinom1 = new interpolasiPolinom(p);
                    textPolinom.setText("Persamaan Polinom: "+polinom1.getPolinomString());
                    if(nInterpolated<=4) {
                        for(i=0;i<nInterpolated;i++) {
                            x = Double.parseDouble(xyHampiran[i][0].getText());
                            xyHampiran[i][1].setText(String.format("%.4f",polinom1.getHampiran(x)));
                        }
                    } else {
                        Scanner in2 = new Scanner(res.getText());
                        Matriks interP = new Matriks(nInterpolated,2);
                        for(i=0;i<nInterpolated;i++) {
                            interP.elmt[i][0] = in2.nextDouble();
                            interP.elmt[i][1] = polinom1.getHampiran(interP.elmt[i][0]);
                        }
                        in2.close();
                        StringBuilder sb = new StringBuilder();
                        for(i=0;i<nInterpolated;i++) {
                            sb.append(String.format("%.4f %.4f", interP.elmt[i][0], interP.elmt[i][1]));
                            sb.append((i+1<nInterpolated?"\n":""));
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
            gridInter.removeAll();
            nInterpolated = Integer.parseInt(nquery.getText());
            if(nInterpolated<=4) {
                gridInter.setLayout(new GridLayout(nInterpolated+1,2,0,5));
                xy2[0].setPreferredSize(new Dimension(100,25));
                xy2[1].setPreferredSize(new Dimension(100,25));
                xy2[0].setHorizontalAlignment(SwingConstants.CENTER); xy2[1].setHorizontalAlignment(SwingConstants.CENTER);
                gridInter.add(xy2[0]);
                gridInter.add(xy2[1]);
                for(i=0;i<nInterpolated;i++) {
                    for(j=0;j<2;j++) {
                        xyHampiran[i][j].setText("0");
                        xyHampiran[i][j].setPreferredSize(new Dimension(100,25));
                        if(j==1){
                            xyHampiran[i][j].setEditable(false);
                            xyHampiran[i][j].setText(null);
                        }
                        gridInter.add(xyHampiran[i][j]);
                    }
                }
                this.revalidate();
            } else if(nInterpolated>4) {
                gridInter.removeAll();
                gridInter.setLayout(new GridLayout(1,1,0,0));
                gridInter.add(res);
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
                    out.format("%s%n",textPolinom.getText());
                    if(nInterpolated<=4) {
                        int i;
                        for(i=0;i<nInterpolated;i++) {
                            out.format("%s %s%n", xyHampiran[i][0].getText(), xyHampiran[i][1].getText());
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
