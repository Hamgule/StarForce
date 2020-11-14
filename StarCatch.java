import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class StarCatch extends JFrame implements ActionListener {
    // default position of Objects
    private static double canvasWidth = 500.0;
    private static double canvasHeight = 500.0;

    private double fieldWidth = canvasWidth * 0.94; // 470
    private double fieldHeight = canvasHeight * 0.1; // 50
    private double fieldX = canvasWidth * 0.03; // 15
    private double fieldMidY = canvasHeight * 0.75; // 375
    private double fieldY = fieldMidY - fieldHeight / 2; // 375
    
    private double starRadius = 10.0;
    private double starX = canvasWidth * 0.1;
    private double starY = fieldMidY;

    private double buttonWidth = canvasWidth / 3;
    private double buttonHeight = canvasHeight - (fieldY + fieldHeight + canvasHeight * 0.06);
    private double buttonX = (canvasWidth - buttonWidth) / 2;
    private double buttonY = fieldY + fieldHeight + canvasHeight * 0.03; 

    private SetField field;
    private DrawStar star;
    private JButton stopButton;
    private JLabel countLabel;
    private int countdown = 5;

    // ActionListener related Variables
    private Timer t;
    private double starSpeed = 3;
    private int starDirection = 1;

    public StarCatch() {
        setFocusable(true);
        
        field = new SetField(fieldX, fieldY, fieldWidth, fieldHeight, 100.0);
        star = new DrawStar(starX, starY);
        stopButton = new JButton("STOP!");
        countLabel = new JLabel("" + countdown);

        t = new Timer(5, this);

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize((int) (canvasWidth + 15), (int) (canvasHeight + 40));
        getContentPane().setBackground(Color.GRAY);

        star.setLocation(0, 0);
        star.setSize((int) canvasWidth, (int) canvasHeight);
        add(star);
        
        field.setLocation(0, 0);
        field.setSize((int) canvasWidth, (int) canvasHeight);
        add(field);

        stopButton.setBounds((int) buttonX, (int) buttonY, (int) buttonWidth, (int) buttonHeight);
        add(stopButton);
        stopButton.addActionListener(this);

        countLabel.setLocation((int) buttonWidth, (int) ((fieldY - buttonWidth) / 2)); // (167, 94)
        countLabel.setSize((int) buttonWidth, (int) buttonWidth); // (167, 167)
        countLabel.setHorizontalAlignment(JLabel.CENTER);
        countLabel.setFont(new Font("Arial", Font.PLAIN, 50));

        add(countLabel);

        setLocationRelativeTo(null);
        setVisible(true);

        t.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        
        if (countdown < 0) {
            stopStar();
            star.removeStar();
        }

        if (starX < starRadius * 2.5 || starX > canvasWidth - starRadius * 2.5) {
            starDirection *= -1;
            countdown -= 1;
            countLabel.setText("" + countdown);
        }
        starX += starSpeed * starDirection;
        star.setStarLocation(starX, starY);
        
        if (e.getSource().equals(stopButton)) { 
            stopStar();
            star.removeStar();
        }
    }

    public void stopStar() { starSpeed = 0; }

    public static double getCanvasWidth() { return canvasWidth; }
    public static double getCanvasHeight() { return canvasHeight; }
}