package algeo.IO;

import javax.swing.*;
import java.awt.*;

public class FrameDetInv extends JFrame {
    protected JFrame prevFrame;
    protected JPanel panelIn;
    protected JPanel panelOut;
    protected JPanel panelNav;
    protected JPanel panelNavBottomLeft;
    protected JPanel panelNavBottomRight;


    protected JTextField col;
    protected JTextField row;
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
    protected JButton home;
    protected JTextField pathOut;
    protected JFileChooser fileOut = new JFileChooser();
    protected JTextField[][] koef = new JTextField[10][10];
//    protected JLabel[][] xi = new JLabel[10][9];
    protected JTextArea inputMatriks = new JTextArea();
    public final Font Bold = new Font("Gill Sans", Font.BOLD, 24);
    public final Font Plain = new Font("Gill Sans", Font.PLAIN, 24);
    public final Color GrandColor = Color.decode("#06061B");
    public final Color FontColor = Color.white;



    public void CreateButton(JButton J){
        J.setFont(Plain);
        J.setBackground(GrandColor);
        J.setForeground(FontColor);
        J.setBorder(BorderFactory.createLineBorder(FontColor));
        J.setBorder(new RoundedBorder(25));
        J.setPreferredSize(new Dimension(200, 35));
        J.setFocusable(false);
    }
    public void CreateLabel(JLabel J){
        J.setFont(Bold);
        J.setBackground(GrandColor);
        J.setForeground(FontColor);
        J.setHorizontalAlignment(SwingConstants.LEFT);
        J.setVerticalAlignment(SwingConstants.BOTTOM);
        J.setPreferredSize(new Dimension(200, 35));
    }
    public void CreateTextField(JTextField J){
        J.setFont(Plain);
        J.setPreferredSize(new Dimension(250, 35));
    }

    public FrameDetInv(JFrame prevFrame) {
        int i,j;

        this.setLayout(new GridBagLayout());

        panelNav = new JPanel();
        panelNav.setBackground(GrandColor);
        panelNav.setPreferredSize(new Dimension(2100, 120));
        panelNav.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));
        panelIn = new JPanel();
        panelIn.setBackground(Color.decode("#3B3838"));
        panelIn.setPreferredSize(new Dimension(1050,500));
        panelOut = new JPanel();
        panelOut.setBackground(Color.lightGray);
        panelOut.setPreferredSize(new Dimension(1050,450));
        panelNavBottomLeft = new JPanel();
        panelNavBottomLeft.setBackground(GrandColor);
        panelNavBottomLeft.setPreferredSize(new Dimension(1050, 50));
        panelNavBottomRight = new JPanel();
        panelNavBottomRight.setBackground(GrandColor);
        panelNavBottomRight.setPreferredSize(new Dimension(1050, 90));
        inputMatriks.setPreferredSize(new Dimension(700, 425));
        inputMatriks.setFont(Plain);

        panelNav.setLayout(new GridBagLayout());
        GridBagConstraints cNav = new GridBagConstraints();

        JLabel rowLabel = new JLabel("Banyak Baris");
        CreateLabel(rowLabel);
        cNav.gridx = 0;
        cNav.gridy = 0;
        cNav.weightx = 1;
        cNav.weighty = 1;
        cNav.gridheight = 0;
        cNav.anchor = GridBagConstraints.NORTH;
        //cNav.fill = GridBagConstraints.VERTICAL;
        panelNav.add(rowLabel, cNav);

        JLabel colLabel = new JLabel("Banyak Kolom");
        CreateLabel(colLabel);
        cNav.gridx = 1;
        cNav.gridy = 0;
        panelNav.add(colLabel, cNav);



        home = new JButton("HOME");
        CreateButton(home);
        cNav.gridx = 4;
        cNav.gridy = 0;
        panelNav.add(home, cNav);

        cNav.anchor = GridBagConstraints.SOUTH;
        cNav.weighty = 0.2;
        cNav.gridheight = 1;
        // Layer ke dua
        row = new JTextField("0");
        CreateTextField(row);
        cNav.gridx = 0;
        cNav.gridy = 1;
        panelNav.add(row, cNav);
        cNav.gridheight=2;
        col = new JTextField("0");
        CreateTextField(col);
        cNav.gridx = 1;
        cNav.gridy = 1;
        panelNav.add(col, cNav);

        create = new JButton("CREATE");
        CreateButton(create);
        cNav.gridx = 2;
        cNav.gridy = 1;
        panelNav.add(create, cNav);

        calc1 = new JButton("CALCULATE");
        CreateButton(calc1);
        cNav.gridx = 3;
        cNav.gridy = 1;
        panelNav.add(calc1, cNav);

        reset = new JButton("RESET");
        CreateButton(reset);
        cNav.gridx = 4;
        cNav.gridy = 1;
        panelNav.add(reset, cNav);

        panelIn.setLayout(new GridBagLayout());
        GridBagConstraints cIn = new GridBagConstraints();
        reset.setVisible(false);
        calc1.setVisible(false);
        cIn.anchor = GridBagConstraints.EAST;
        gridSpl = panelIn;
        gridSpl.setPreferredSize(new Dimension(700,425));
        for(i=0;i<10;i++) {
            for(j=0;j<10;j++) {
                koef[i][j] = new JTextField();
                CreateTextField(koef[i][j]);
                koef[i][j].setHorizontalAlignment(SwingConstants.CENTER);
            }
        }
        panelNavBottomLeft.setLayout(new GridBagLayout());
        GridBagConstraints cNavLeft = new GridBagConstraints();

        cNavLeft.gridx = 0;
        cNavLeft.gridy = 0;
        cNavLeft.weightx = 1;
        cNavLeft.weighty = 0;
        cNavLeft.gridheight = 3;
        cNavLeft.anchor = GridBagConstraints.NORTH;
        open = new JButton("Open");
        CreateButton(open);
        panelNavBottomLeft.add(open, cNavLeft);
        cNavLeft.gridx = 1;
        pathIn = new JTextField();
        CreateTextField(pathIn);
        pathIn.setEditable(false);
        panelNavBottomLeft.add(pathIn, cNavLeft);
        cNavLeft.gridx = 3;
        calc2 = new JButton("Calculate");
        CreateButton(calc2);
        panelNavBottomLeft.add(calc2, cNavLeft);


        panelOut.setLayout(new GridBagLayout());
        GridBagConstraints cOut = new GridBagConstraints();

        JLabel Output = new JLabel("Output:");
        CreateLabel(Output);
        Output.setForeground(Color.black);
        cOut.gridx = 0; cOut.gridy = 0;
        panelOut.add(Output,cOut);
        res = new JTextArea();
        res.setPreferredSize(new Dimension(500,425));
        res.setFont(Plain);
        res.setEditable(false);
        cOut.gridy = 1;
        cOut.gridwidth = 1; cOut.gridheight = 2;
        cOut.fill = GridBagConstraints.BOTH;
        panelOut.add(res,cOut);

        panelNavBottomRight.setLayout(new GridBagLayout());
        GridBagConstraints cNavRight = new GridBagConstraints();
        cNavRight.gridx = 0;
        cNavRight.gridy = 0;
        cNavRight.weightx = 1;
        cNavRight.weighty = 0;
        cNavRight.gridheight = 3;
        save = new JButton("Save");
        CreateButton(save);
        panelNavBottomRight.add(save,cNavRight);
        cNavRight.gridx = 1;
        pathOut = new JTextField();
        CreateTextField(pathOut);
        pathOut.setEditable(false);
        cOut.anchor = GridBagConstraints.NORTH;
        panelNavBottomRight.add(pathOut,cNavRight);



        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        c.weightx = 1;
        c.weighty = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(panelNav,c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
//        c.gridheight = 2;
        c.weightx = 1;
        c.weighty =1;
        c.fill = GridBagConstraints.BOTH;
        this.add(panelIn,c);
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weighty = 0.9;
        this.add(panelOut,c);
        c.gridx = 0;
        c.gridy = 2;
        c.weighty = 0;
        this.add(panelNavBottomLeft, c);
        c.gridx = 1;
        c.gridy = 2;
        this.add(panelNavBottomRight, c);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(2100, 700);
        this.setTitle("SPL - Gauss/Jordan");
        this.prevFrame = prevFrame;
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
