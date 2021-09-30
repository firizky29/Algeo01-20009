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
    private JFrame subFrame = new JFrame();


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
    private JButton buttonBack;
    private JPanel mainPanel;

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

        subFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        subFrame.setSize(500,500);
        subFrame.setIconImage(icon);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonSpl) {
            if(!subFrame.isDisplayable()) {
                subFrame.setTitle("SPL");
                subFrame.setLayout(new GridLayout(5, 1, 10, 10));
                subFrame.setBackground(GrandColor);
                buttonSplGauss = new JButton("Metode Eliminasi Gauss");
                buttonSplJordan = new JButton("Metode Eliminasi Gauss-Jordan");
                buttonSplInvers = new JButton("Metode Matriks Balikan");
                buttonSplCramer = new JButton("Metode Cramer");
                buttonBack = new JButton("Kembali");
                CreateButton(buttonSplJordan);
                CreateButton(buttonSplInvers);
                CreateButton(buttonSplCramer);
                CreateButton(buttonBack);
                CreateButton(buttonSplGauss);
                buttonSplGauss.addActionListener(this);
                buttonSplJordan.addActionListener(this);
                buttonSplInvers.addActionListener(this);
                buttonSplCramer.addActionListener(this);
                buttonBack.addActionListener(this);
                // Tambahin panel informasi batasan metode invers dan cramer
                subFrame.add(buttonSplGauss);
                subFrame.add(buttonSplJordan);
                subFrame.add(buttonSplInvers);
                subFrame.add(buttonSplCramer);
                subFrame.add(buttonBack);
            }

            this.setVisible(false);
            subFrame.setVisible(true);
        } else if(e.getSource()==buttonDet) {
            if(!subFrame.isDisplayable()){
                subFrame.setTitle("Determinan");
                subFrame.setLayout(new GridLayout(3,1,10,10));
                subFrame.setBackground(GrandColor);
                buttonDetOBE = new JButton("Metode Reduksi Baris");
                buttonDetCofactor = new JButton("Metode Ekspansi Kofaktor");
                buttonBack = new JButton("Kembali");
                buttonDetOBE.setFocusable(false);
                buttonDetCofactor.setFocusable(false);
                buttonBack.setFocusable(false);
                buttonDetOBE.addActionListener(this);
                buttonDetCofactor.addActionListener(this);
                buttonBack.addActionListener(this);

                subFrame.add(buttonDetOBE);
                subFrame.add(buttonDetCofactor);
                subFrame.add(buttonBack);
            }

            this.setVisible(false);
            subFrame.setVisible(true);
        } else if(e.getSource()==buttonInv) {
            if(!subFrame.isDisplayable()){
                subFrame.setTitle("Matriks Balikan");
                subFrame.setLayout(new GridLayout(3,1,10,10));
                subFrame.setBackground(GrandColor);
                buttonInvOBE = new JButton("Metode Reduksi Baris");
                buttonInvCofactor = new JButton("Metode Ekspansi Kofaktor");
                buttonBack = new JButton("Kembali");
                buttonInvOBE.setFocusable(false);
                buttonInvCofactor.setFocusable(false);
                buttonBack.setFocusable(false);
                buttonInvOBE.addActionListener(this);
                buttonInvCofactor.addActionListener(this);
                buttonBack.addActionListener(this);

                subFrame.add(buttonInvOBE);
                subFrame.add(buttonInvCofactor);
                subFrame.add(buttonBack);
            }

            this.setVisible(false);
            subFrame.setVisible(true);
        } else if(e.getSource()==buttonInterpol) {
            this.setVisible(false);
            if(!Interpol.isDisplayable()) Interpol = new FrameInterpol(this);
            else Interpol.setVisible(true);
        } else if(e.getSource()==buttonRegresi) {
            this.setVisible(false);
            if(!Regresi.isDisplayable()) Regresi = new FrameRegresi(this);
            else Regresi.setVisible(true);
        } else if(e.getSource()==buttonSplGauss) {
            subFrame.setVisible(false);
            if(!SPLGauss.isDisplayable()) SPLGauss = new FrameSplGauss(this);
            else SPLGauss.setVisible(true);
        } else if(e.getSource()==buttonSplJordan) {
            subFrame.setVisible(false);
            if(!SPLJordan.isDisplayable()) SPLJordan = new FrameSplJordan(this);
            else SPLJordan.setVisible(true);
        } else if(e.getSource()==buttonSplInvers) {
            subFrame.setVisible(false);
            if(!SPLInvers.isDisplayable()) SPLInvers = new FrameSplInverse(this);
            else SPLInvers.setVisible(true);
        } else if(e.getSource()==buttonSplCramer) {
            subFrame.setVisible(false);
            if(!SPLCramer.isDisplayable()) SPLCramer = new FrameSplCramer(this);
            else SPLCramer.setVisible(true);
        } else if(e.getSource()==buttonDetOBE) {
            subFrame.setVisible(false);
            if(!DetOBE.isDisplayable()) DetOBE = new FrameDetOBE(this);
            else DetOBE.setVisible(true);
        } else if(e.getSource()==buttonDetCofactor) {
            subFrame.setVisible(false);
            if(!DetCofactor.isDisplayable()) DetCofactor = new FrameDetKofaktor(this);
            else DetCofactor.setVisible(true);
        } else if(e.getSource()==buttonInvOBE) {
            subFrame.setVisible(false);
            if(!InvOBE.isDisplayable()) InvOBE = new FrameInvOBE(this);
            else InvOBE.setVisible(true);
        } else if(e.getSource()==buttonInvCofactor) {
            subFrame.setVisible(false);
            if(!InvCofactor.isDisplayable()) InvCofactor = new FrameInvKofaktor(this);
            else InvCofactor.setVisible(true);
        } else if(e.getSource() == buttonBack){
            subFrame.setVisible(false);
            this.setVisible(true);
        }
    }
}