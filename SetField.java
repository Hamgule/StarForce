import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class SetField extends JPanel {
    private double fieldX;
    private double fieldY;
    private double fieldWidth;
    private double fieldHeight;

    private double centerX;
    private double centerY;
    private double centerWidth;
    private double centerHeight;

    public SetField(double x, double y, double w, double h, double centerWidth) {
        fieldX = x; fieldY = y; fieldWidth = w; fieldHeight = h;
        centerX = (x + w - centerWidth) / 2;
        centerY = y;
        this.centerWidth = centerWidth;
        this.centerHeight = h;
        setOpaque(false);
    }

    @Override
    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D) gr;

        g.setStroke(new BasicStroke(2));

        g.setColor(Color.BLACK);
        g.drawRect((int) fieldX, (int) fieldY, (int) fieldWidth, (int) fieldHeight);
        g.setColor(Color.WHITE);
        g.fillRect((int) fieldX, (int) fieldY, (int) fieldWidth, (int) fieldHeight);

        g.setColor(Color.BLACK);
        g.drawRect((int) centerX, (int) centerY, (int) centerWidth, (int) centerHeight);
        g.setColor(Color.ORANGE);
        g.fillRect((int) centerX, (int) centerY, (int) centerWidth, (int) centerHeight);
        
    }
}