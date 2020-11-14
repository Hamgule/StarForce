import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class CatchEffect extends JLabel implements ActionListener {
    private double circleRadius = 30.0;
    private double circleX;
    private double circleY;

    private DrawCircle circle;

    public CatchEffect(double x, double y, boolean success) {
        circleX = x;
        circleY = y;

        circle = new DrawCircle(circleRadius, circleX, circleY);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        circleRadius += 1;
    }

}