package algeo.IO;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Frame1 extends JFrame implements ActionListener {
    // FRAME-FRAME DIINIT SEKALI SAJA
    private JFrame SPLGauss = new JFrame();
    private JFrame SPLJordan = new JFrame();
    private JFrame SPLInvers = new JFrame();
    private JFrame SPLCramer = new JFrame();
    private JFrame DetOBE = new JFrame();
    private JFrame DetCofactor = new JFrame();
    private JFrame InvOBE = new JFrame();
    private JFrame InvCofactor =  new JFrame();
    private JFrame Interpol = new JFrame();
    private JFrame Regresi = new JFrame();
    private JFrame[] subFrame = new JFrame[3];


    private JButton buttonSpl;
    private JButton buttonDet;
    private JButton buttonInv;
    private JButton buttonInterpol;
    private JButton buttonRegresi;

    private JButton buttonSplGauss;
    private JButton buttonSplJordan;
    private JButton buttonSplInvers;
    private JButton buttonSplCramer;
    private JButton buttonDetOBE;
    private JButton buttonDetCofactor;
    private JButton buttonInvOBE;
    private JButton buttonInvCofactor;
    private JButton[] buttonBack = new JButton[3];
    private JPanel mainPanel;
    // enumerasi subframe
    // 0: subframe SPL, 1: subframe Det, 2: subframe inv
    private int enumSubframe;

    public final Image icon = Toolkit.getDefaultToolkit().getImage("src/algeo/resource/favicon.png");
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
        J.setPreferredSize(new Dimension(600, 35));
    }
    public void CreateTextField(JTextField J){
        J.setFont(Plain);
        J.setPreferredSize(new Dimension(250, 35));
    }


    public Frame1() throws IOException {
        //init subframe
        enumSubframe = -1;
        this.setIconImage(icon);
        buttonSpl = new JButton("Sistem Persamaan Linier");
        CreateButton(buttonSpl);
        buttonDet = new JButton("Determinan");
        CreateButton(buttonDet);
        buttonInv = new JButton("Invers Matriks");
        CreateButton(buttonInv);
        buttonInterpol = new JButton("Interpolasi Polinom");
        CreateButton(buttonInterpol);
        buttonRegresi = new JButton("Regresi Linier");
        CreateButton(buttonRegresi);
        buttonSpl.addActionListener(this);
        buttonDet.addActionListener(this);
        buttonInv.addActionListener(this);
        buttonInterpol.addActionListener(this);
        buttonRegresi.addActionListener(this);
        mainPanel = new JPanel();
        mainPanel.setBackground(GrandColor);
        mainPanel.setPreferredSize(new Dimension(0, 400));
        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints cc = new GridBagConstraints();
        BufferedImage myPicture = ImageIO.read(new File("src/algeo/resource/logokecil.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        picLabel.setPreferredSize(new Dimension(60, 60));
        cc.gridx = 0;
        cc.gridy = 0;
        JLabel Judul = new JLabel("ALJABAR LINEAR KALKULATOR");
        CreateLabel(Judul);
        mainPanel.add(picLabel);
        mainPanel.add(Judul);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setTitle("Menu");
        this.setLayout(new GridLayout(6,1,10,10));

        this.add(mainPanel);
        this.add(buttonSpl);
        this.add(buttonDet);
        this.add(buttonInv);
        this.add(buttonInterpol);
        this.add(buttonRegresi);

        this.setBackground(GrandColor);

        this.setVisible(true);
        for(int l=0; l<3; l++) {
            subFrame[l] = new JFrame();
            subFrame[l].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            subFrame[l].setSize(500, 500);
            subFrame[l].setIconImage(icon);
        }

        subFrame[0].setTitle("SPL");
        subFrame[0].setLayout(new GridLayout(5, 1, 10, 10));
        subFrame[0].setBackground(GrandColor);
        buttonSplGauss = new JButton("Metode Eliminasi Gauss");
        buttonSplJordan = new JButton("Metode Eliminasi Gauss-Jordan");
        buttonSplInvers = new JButton("Metode Matriks Balikan");
        buttonSplCramer = new JButton("Metode Cramer");

        for(int l=0; l<3; l++){
            buttonBack[l] = new JButton("Kembali");
            CreateButton(buttonBack[l]);
            buttonBack[l].addActionListener(this);
        }
        CreateButton(buttonSplJordan);
        CreateButton(buttonSplInvers);
        CreateButton(buttonSplCramer);
        CreateButton(buttonSplGauss);
        buttonSplGauss.addActionListener(this);
        buttonSplJordan.addActionListener(this);
        buttonSplInvers.addActionListener(this);
        buttonSplCramer.addActionListener(this);
        // Tambahin panel informasi batasan metode invers dan cramer
        subFrame[0].add(buttonSplGauss);
        subFrame[0].add(buttonSplJordan);
        subFrame[0].add(buttonSplInvers);
        subFrame[0].add(buttonSplCramer);
        subFrame[0].add(buttonBack[0]);


        subFrame[1].setTitle("Determinan");
        subFrame[1].setLayout(new GridLayout(3,1,10,10));
        subFrame[1].setBackground(GrandColor);
        buttonDetOBE = new JButton("Metode Reduksi Baris");
        buttonDetCofactor = new JButton("Metode Ekspansi Kofaktor");
        CreateButton(buttonDetOBE);
        CreateButton(buttonDetCofactor);
        buttonDetOBE.addActionListener(this);
        buttonDetCofactor.addActionListener(this);

        subFrame[1].add(buttonDetOBE);
        subFrame[1].add(buttonDetCofactor);
        subFrame[1].add(buttonBack[1]);

        subFrame[2].setTitle("Matriks Balikan");
        subFrame[2].setLayout(new GridLayout(3,1,10,10));
        subFrame[2].setBackground(GrandColor);
        buttonInvOBE = new JButton("Metode Reduksi Baris");
        buttonInvCofactor = new JButton("Metode Ekspansi Kofaktor");
        CreateButton(buttonInvOBE);
        CreateButton(buttonInvCofactor);
        buttonInvOBE.addActionListener(this);
        buttonInvCofactor.addActionListener(this);

        subFrame[2].add(buttonInvOBE);
        subFrame[2].add(buttonInvCofactor);
        subFrame[2].add(buttonBack[2]);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonSpl) {
            this.setVisible(false);
            subFrame[0].setVisible(true);
            enumSubframe = 0;
//            subFrame.setVisible(true);
        } else if(e.getSource()==buttonDet) {
            this.setVisible(false);
            subFrame[1].setVisible(true);
            enumSubframe = 1;
            //subFrame.setVisible(true);
        } else if(e.getSource()==buttonInv) {
            this.setVisible(false);
            subFrame[2].setVisible(true);
            enumSubframe = 2;

            //[enumSubframesubFrame.setVisible(true);
        } else if(e.getSource()==buttonInterpol) {
            this.setVisible(false);
            if(!Interpol.isDisplayable()) Interpol = new FrameInterpol(this);
            else Interpol.setVisible(true);
        } else if(e.getSource()==buttonRegresi) {
            this.setVisible(false);
            if(!Regresi.isDisplayable()) Regresi = new FrameRegresi(this);
            else Regresi.setVisible(true);
        } else if(e.getSource()==buttonSplGauss) {
            subFrame[enumSubframe].setVisible(false);
            if(!SPLGauss.isDisplayable()) SPLGauss = new FrameSplGauss(this);
            else SPLGauss.setVisible(true);
        } else if(e.getSource()==buttonSplJordan) {
            subFrame[enumSubframe].setVisible(false);
            if(!SPLJordan.isDisplayable()) SPLJordan = new FrameSplJordan(this);
            else SPLJordan.setVisible(true);
        } else if(e.getSource()==buttonSplInvers) {
            subFrame[enumSubframe].setVisible(false);
            if(!SPLInvers.isDisplayable()) SPLInvers = new FrameSplInverse(this);
            else SPLInvers.setVisible(true);
        } else if(e.getSource()==buttonSplCramer) {
            subFrame[enumSubframe].setVisible(false);
            if(!SPLCramer.isDisplayable()) SPLCramer = new FrameSplCramer(this);
            else SPLCramer.setVisible(true);
        } else if(e.getSource()==buttonDetOBE) {
            subFrame[enumSubframe].setVisible(false);
            if(!DetOBE.isDisplayable()) DetOBE = new FrameDetOBE(this);
            else DetOBE.setVisible(true);
        } else if(e.getSource()==buttonDetCofactor) {
            subFrame[enumSubframe].setVisible(false);
            if(!DetCofactor.isDisplayable()) DetCofactor = new FrameDetKofaktor(this);
            else DetCofactor.setVisible(true);
        } else if(e.getSource()==buttonInvOBE) {
            subFrame[enumSubframe].setVisible(false);
            if(!InvOBE.isDisplayable()) InvOBE = new FrameInvOBE(this);
            else InvOBE.setVisible(true);
        } else if(e.getSource()==buttonInvCofactor) {
            subFrame[enumSubframe].setVisible(false);
            if(!InvCofactor.isDisplayable()) InvCofactor = new FrameInvKofaktor(this);
            else InvCofactor.setVisible(true);
        } else if(e.getSource() == buttonBack[0]){
            subFrame[0].setVisible(false);
            this.setVisible(true);
        } else if(e.getSource() == buttonBack[1]){
            subFrame[1].setVisible(false);
            this.setVisible(true);
        } else if(e.getSource() == buttonBack[2]){
            subFrame[2].setVisible(false);
            this.setVisible(true);
        }
    }
}