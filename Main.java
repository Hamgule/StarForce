import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class Main {
    private static int canvasWidth = 500;
    private static int canvasHeight = 500;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame f = new JFrame();

        DrawStar star = new DrawStar(10, 20);
        SetField field = new SetField(0, canvasHeight * 0.6, canvasWidth, canvasHeight * 0.08);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(star);
        f.getContentPane().add(field);
        f.setSize(canvasWidth, canvasHeight);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}