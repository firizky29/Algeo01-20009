package algeo.IO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameInterpol extends JFrame implements ActionListener {
    protected int nData, nInterpolated;
    
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
//    protected JTextField
    protected JPanel gridInter;
    protected JTextField[][] xyHampiran = new JTextField[4][2];
    protected JTextArea res;
    protected JButton save;
    protected JTextField pathOut;
    protected JFileChooser fileOut = new JFileChooser();
    protected JTextField[][] points = new JTextField[10][2];
    protected JLabel[] xy = new JLabel[2];
    protected JTextArea inputPoints = new JTextArea();
    
    
    public FrameInterpol() {
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
        textPolinom.setEditable(false);
        interC.gridx=0; interC.gridy=0;
        interC.gridheight=1; interC.gridwidth=1;
        interC.weightx=1; interC.weighty=1;
        interC.fill = GridBagConstraints.HORIZONTAL;
        panelInter.add(textPolinom,interC);


        this.setTitle("Interpolasi Polinom");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
