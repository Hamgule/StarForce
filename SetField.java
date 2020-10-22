import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class SetField extends JPanel {
    private double x;
    private double y;
    private double width;
    private double height;

    public SetField(double x, double y, double w, double h) {
        this.x = x; this.y = y; width = w; height = h;
    }

    @Override
    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D) gr;
        Rectangle2D rectangle = new Rectangle2D.Double(x, y, width, height);

        g.setPaint(Color.WHITE);
        g.fill(rectangle);
        g.setPaint(Color.BLACK);
        g.draw(rectangle);
    }
}