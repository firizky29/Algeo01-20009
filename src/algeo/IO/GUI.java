package algeo.IO;

import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;

// yg ini jelas isinya GUI
public class GUI
{
    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Frame1();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}