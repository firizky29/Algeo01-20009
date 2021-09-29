package algeo.IO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame1 extends JFrame implements ActionListener {
    private JButton buttonSpl;
    private JButton buttonDet;
    private JButton buttonInv;
    private JButton buttonInterpol;
    private JButton buttonRegresi;

    private JFrame subFrame = new JFrame();
    private JButton buttonSplGauss;
    private JButton buttonSplJordan;
    private JButton buttonSplInvers;
    private JButton buttonSplCramer;
    private JButton buttonDetOBE;
    private JButton buttonDetCofactor;
    private JButton buttonInvOBE;
    private JButton buttonInvCofactor;

    public Frame1() {
        buttonSpl = new JButton("Sistem Persamaan Linier");
        buttonSpl.setFocusable(false);
        buttonDet = new JButton("Determinan");
        buttonDet.setFocusable(false);
        buttonInv = new JButton("Invers Matriks");
        buttonInv.setFocusable(false);
        buttonInterpol = new JButton("Interpolasi Polinom");
        buttonInterpol.setFocusable(false);
        buttonRegresi = new JButton("Regresi Linier");
        buttonRegresi.setFocusable(false);
        buttonSpl.addActionListener(this);
        buttonDet.addActionListener(this);
        buttonInv.addActionListener(this);
        buttonInterpol.addActionListener(this);
        buttonRegresi.addActionListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setTitle("Menu");
        this.setLayout(new GridLayout(5,1,10,10));

        this.add(buttonSpl);
        this.add(buttonDet);
        this.add(buttonInv);
        this.add(buttonInterpol);
        this.add(buttonRegresi);

        this.setVisible(true);

        subFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        subFrame.setSize(500,500);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonSpl) {
            subFrame.setTitle("SPL");
            subFrame.setLayout(new GridLayout(4,1,10,10));

            buttonSplGauss = new JButton("Metode Eliminasi Gauss");
            buttonSplJordan = new JButton("Metode Eliminasi Gauss-Jordan");
            buttonSplInvers = new JButton("Metode Matriks Balikan");
            buttonSplCramer = new JButton("Metode Cramer");
            buttonSplGauss.setFocusable(false);
            buttonSplJordan.setFocusable(false);
            buttonSplInvers.setFocusable(false);
            buttonSplCramer.setFocusable(false);
            buttonSplGauss.addActionListener(this);
            buttonSplJordan.addActionListener(this);
            buttonSplInvers.addActionListener(this);
            buttonSplCramer.addActionListener(this);

            // Tambahin panel informasi batasan metode invers dan cramer
            subFrame.add(buttonSplGauss);
            subFrame.add(buttonSplJordan);
            subFrame.add(buttonSplInvers);
            subFrame.add(buttonSplCramer);

            this.setVisible(false);
            subFrame.setVisible(true);
        } else if(e.getSource()==buttonDet) {
            subFrame.setTitle("Determinan");
            subFrame.setLayout(new GridLayout(2,1,10,10));

            buttonDetOBE = new JButton("Metode Reduksi Baris");
            buttonDetCofactor = new JButton("Metode Ekspansi Kofaktor");
            buttonDetOBE.setFocusable(false);
            buttonDetCofactor.setFocusable(false);
            buttonDetOBE.addActionListener(this);
            buttonDetCofactor.addActionListener(this);

            subFrame.add(buttonDetOBE);
            subFrame.add(buttonDetCofactor);

            this.setVisible(false);
            subFrame.setVisible(true);
        } else if(e.getSource()==buttonInv) {
            subFrame.setTitle("Matriks Balikan");
            subFrame.setLayout(new GridLayout(2,1,10,10));

            buttonInvOBE = new JButton("Metode Reduksi Baris");
            buttonInvCofactor = new JButton("Metode Ekspansi Kofaktor");
            buttonInvOBE.setFocusable(false);
            buttonInvCofactor.setFocusable(false);
            buttonInvOBE.addActionListener(this);
            buttonInvCofactor.addActionListener(this);

            subFrame.add(buttonInvOBE);
            subFrame.add(buttonInvCofactor);

            this.setVisible(false);
            subFrame.setVisible(true);
        } else if(e.getSource()==buttonInterpol) {
            this.setVisible(false);
            new FrameInterpol();
        } else if(e.getSource()==buttonRegresi) {

        } else if(e.getSource()==buttonSplGauss) {
            subFrame.setVisible(false);
            new FrameSplGauss();
        } else if(e.getSource()==buttonSplJordan) {
            subFrame.setVisible(false);
            new FrameSplJordan();
        } else if(e.getSource()==buttonSplInvers) {
            subFrame.setVisible(false);
            new FrameSplInverse();
        } else if(e.getSource()==buttonSplCramer) {
            subFrame.setVisible(false);
            new FrameSplCramer();
        } else if(e.getSource()==buttonDetOBE) {
            subFrame.setVisible(false);
            new FrameDetOBE();
        } else if(e.getSource()==buttonDetCofactor) {
            subFrame.setVisible(false);
            new FrameDetKofaktor();
        } else if(e.getSource()==buttonInvOBE) {
            subFrame.setVisible(false);
            new FrameInvOBE();
        } else if(e.getSource()==buttonInvCofactor) {
            subFrame.setVisible(false);
            new FrameInvKofaktor();
        }
    }
}