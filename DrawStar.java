import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class DrawStar extends JPanel {
    private final double starRadius = 10;
    private double starX;
    private double starY;

    public DrawStar() { starX = 0.0; starY = 0.0; setOpaque(false); }
    public DrawStar(double x, double y) { starX = x; starY = y; setOpaque(false); }

    @Override
    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D) gr;
        
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g.setColor(Color.YELLOW);
        g.fill(createDefaultStar(starRadius, starX, starY));

        g.setStroke(new BasicStroke(2));
        g.setPaint(Color.BLACK);
        g.draw(createDefaultStar(starRadius, starX, starY));
        
    }

    public void starSetLocation(double x, double y) { starX = x; starY = y; }

    private static Shape createDefaultStar(double radius, double centerX, double centerY) {
        return createStar(centerX, centerY, radius * 1.4, radius * 2.63, 5, Math.toRadians(-18));
    }

    private static Shape createStar(double centerX, double centerY, double innerRadius, double outerRadius, int numRays, double startAngleRad) {
        Path2D path = new Path2D.Double();
        double deltaAngleRad = Math.PI / numRays;
        for (int i = 0; i < numRays * 2; i++) {
            double angleRad = startAngleRad + i * deltaAngleRad;
            double ca = Math.cos(angleRad);
            double sa = Math.sin(angleRad);
            double relX = ca;
            double relY = sa;
            if ((i & 1) == 0) {
                relX *= outerRadius;
                relY *= outerRadius;
            }
            else {
                relX *= innerRadius;
                relY *= innerRadius;
            }
            if (i == 0) {
                path.moveTo(centerX + relX, centerY + relY);
            }
            else {
                path.lineTo(centerX + relX, centerY + relY);
            }
        }
        path.closePath();
        return path;
    }
}
