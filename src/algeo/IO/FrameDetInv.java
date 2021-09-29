package algeo.IO;

import javax.swing.*;
import java.awt.*;

public class FrameDetInv extends JFrame {
    protected JPanel panelIn;
    protected JPanel panelOut;
    protected JPanel panelGuide;

    protected JTextField col;
//    protected JTextField row;
    protected JButton create;
    protected JPanel gridSpl;
    protected JButton reset;
    protected JButton calc1;
    protected JButton calc2;
    protected JFileChooser fileIn = new JFileChooser();
    protected JButton open;
    protected JTextField pathIn;

    protected JTextArea res;
    protected JButton save;
    protected JTextField pathOut;
    protected JFileChooser fileOut = new JFileChooser();
    protected JTextField[][] koef = new JTextField[10][10];
//    protected JLabel[][] xi = new JLabel[10][9];
    protected JTextArea inputMatriks = new JTextArea();

    public FrameDetInv() {
        int i,j;
        this.setLayout(new GridBagLayout());

        panelIn = new JPanel();
        panelIn.setBackground(Color.RED);
        panelIn.setPreferredSize(new Dimension(600,500));
        panelGuide = new JPanel();
        panelGuide.setBackground(Color.white);
        panelGuide.setPreferredSize(new Dimension(400,200));
        panelOut = new JPanel();
        panelOut.setBackground(Color.lightGray);
        panelOut.setPreferredSize(new Dimension(400,300));

        panelIn.setLayout(new GridBagLayout());
        GridBagConstraints cIn = new GridBagConstraints();
        JLabel var = new JLabel("#Kolom = #Baris = ");
        var.setPreferredSize(new Dimension(100,25));
        cIn.gridx = 0;
        cIn.gridy = 0;
        cIn.gridwidth = 1; cIn.gridheight=1;
        cIn.weightx = 1; cIn.weighty =1;
        cIn.fill = GridBagConstraints.HORIZONTAL;
        panelIn.add(var,cIn);
        col = new JTextField("0");
        col.setPreferredSize(new Dimension(100,25));
        cIn.gridx = 1;
        panelIn.add(col,cIn);
//        JLabel pers = new JLabel("#Baris =");
//        pers.setPreferredSize(new Dimension(100,25));
//        cIn.gridx = 2;
//        panelIn.add(pers,cIn);
//        row = new JTextField("0");
//        row.setPreferredSize(new Dimension(100,25));
//        cIn.gridx = 3;
//        panelIn.add(row,cIn);
        create = new JButton("Create");
        create.setPreferredSize(new Dimension(100,25));
        cIn.gridx = 2;
        panelIn.add(create,cIn);
        reset = new JButton("Reset");
        reset.setPreferredSize(new Dimension(100,25));
        cIn.anchor = GridBagConstraints.SOUTHEAST;
        reset.setVisible(false);
        cIn.gridy = 1; cIn.gridx = 1;
        panelIn.add(reset,cIn);
        calc1 = new JButton("Calculate");
        calc1.setPreferredSize(new Dimension(100,25));
        calc1.setVisible(false);
        cIn.gridx = 2;
        panelIn.add(calc1,cIn);
        cIn.anchor = GridBagConstraints.CENTER;
        gridSpl = new JPanel();
        gridSpl.setPreferredSize(new Dimension(600,425));
//        gridSpl.setBounds(0,0,500,250);
        for(i=0;i<10;i++) {
            for(j=0;j<10;j++) {
                koef[i][j] = new JTextField();
                /* if(j<9) {
                    xi[i][j] = new JLabel();
                }*/
            }
        }
        cIn.gridx = 0;
        cIn.gridy = 2;
        cIn.gridwidth = 3;
        cIn.gridheight = 3;
        cIn.fill = GridBagConstraints.BOTH;
        panelIn.add(gridSpl,cIn);
        open = new JButton("Open");
        open.setPreferredSize(new Dimension(100,25));
        cIn.gridy =5;
        cIn.gridwidth = 1;
        cIn.gridheight = 1;
        cIn.fill = GridBagConstraints.HORIZONTAL;
        panelIn.add(open,cIn);
        pathIn = new JTextField();
        pathIn.setPreferredSize(new Dimension(100,25));
        pathIn.setEditable(false);
        cIn.gridx = 1;
        panelIn.add(pathIn,cIn);
        calc2 = new JButton("Calculate");
        calc2.setPreferredSize(new Dimension(100,25));
        cIn.gridx = 2;
        panelIn.add(calc2,cIn);

        panelOut.setLayout(new GridBagLayout());
        GridBagConstraints cOut = new GridBagConstraints();
        JLabel output = new JLabel("Output:");
        output.setPreferredSize(new Dimension(100,25));
        cOut.gridx = 0; cOut.gridy = 0;
        panelOut.add(output,cOut);
        res = new JTextArea();
        res.setPreferredSize(new Dimension(300,300));
        res.setEditable(false);
        cOut.gridy = 1;
        cOut.gridwidth = 1; cOut.gridheight = 2;
        cOut.fill = GridBagConstraints.BOTH;
        panelOut.add(res,cOut);
        save = new JButton("Save");
        save.setPreferredSize(new Dimension(100,25));
        cOut.gridx = 1;
        cOut.gridheight = 1;
        cOut.fill = GridBagConstraints.NONE;
        panelOut.add(save,cOut);
        pathOut = new JTextField();
        pathOut.setPreferredSize(new Dimension(100,25));
        pathOut.setEditable(false);
        cOut.gridy =2;
        cOut.anchor = GridBagConstraints.NORTH;
        panelOut.add(pathOut,cOut);


        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 2;
        c.weightx = 1;
        c.weighty =1;
        c.fill = GridBagConstraints.BOTH;
        this.add(panelIn,c);
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weighty = 0.5;
        this.add(panelGuide,c);
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth =1;
        c.gridheight =1;
        c.weighty =1;
        this.add(panelOut,c);

        // Debug/
        /*
        for(i=0;i<10;i++) {
            for(j=0;j<10;j++) {
                if(i>5 || j>6) {
                    koef[i][j].setVisible(false);
                    if(j<9) xi[i][j].setVisible(false);
                } else if(j==6) {
                    xi[i][j].setVisible(false);
                } else if(j==5) {
                    xi[i][j].setText("x"+(j+1)+"=");
                }
            }
        }*/

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1100,600);
        this.setTitle("Determinan");

        this.setVisible(true);
    }
    //referensi dari stackoverflow
    public double parse(String frac) {
        if(frac.contains("/")) {
            String[] fracsplit = frac.split("/");
            return Double.parseDouble(fracsplit[0])/Double.parseDouble(fracsplit[1]);
        } else {
            return Double.parseDouble(frac);
        }
    }
}
