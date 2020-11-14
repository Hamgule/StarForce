import javax.swing.*;
import java.awt.*;
import java.awt.Shape.*;
import java.awt.event.*;
import java.awt.geom.*;

public class DrawCircle extends JPanel {
    private double radius;
    private double circleX;
    private double circleY;

    public DrawCircle() { circleX = 0.0; circleY = 0.0; setOpaque(false); }
    public DrawCircle(double r, double x, double y) { radius = r; circleX = x; circleY = y; setOpaque(false); }

    @Override
    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D) gr;
        
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g.setStroke(new BasicStroke(2));
        g.setPaint(Color.GRAY);
        g.draw(createCircle(radius, circleX, circleY));
        
    }

    public Shape createCircle(double r, double x, double y) {
        Path2D path = new Path2D.Double();
        path.append(new Ellipse2D.Double(x, y, r, r), false);

        path.closePath();
        return path;
    }

    public void setCircleLocation(double x, double y) { circleX = x; circleY = y; }
    public void removeCircle() { setVisible(false); }

}