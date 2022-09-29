import net.braniumacademy.customanotations.ClassPreamble;

import javax.swing.*;
import java.awt.*;

@ClassPreamble(
        date = "2022/09/28",
        lastModify = "2022/09/28",
        lastModifyBy = "Branium Academy",
        reviewers = {"Than Trieu", "Branium"}
)
public class MyFrame extends JFrame {
    private final int width;
    private final int height;

    public MyFrame(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.setTitle(title);
        this.setSize(width, height);
        //this.setLocation(100, 150);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.YELLOW);
        this.pack();
    }

    @Override
    public void paint(Graphics g) {
        var g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2));
        drawCircle(g);
        drawRoundRect(g);
    }

    private void drawCircle(Graphics g) {
        int radius = 150;
        g.setColor(Color.green);
        g.drawOval(width / 2 - radius, height / 2 - radius,
                2 * radius, 2 * radius);
    }

    private void drawRoundRect(Graphics g) {
        int width = 200;
        int height = 200;
        g.setColor(Color.red);
        g.fillRoundRect(this.width / 2 - width / 2,
                this.height / 2 - height / 2, width, height,
                20, 20);
    }

    public static void main(String[] args) {
        var title = "My First JFrame Application";
        int width = 400;
        int height = 400;
        MyFrame frame = new MyFrame(width, height, title);
        frame.setVisible(true);

    }
}
