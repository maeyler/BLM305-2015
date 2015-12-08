import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class XORMode extends JPanel {
    Point oldP, newP; 
    public XORMode() {        
        Ear ma = new Ear();
        addMouseListener(ma);
        addMouseMotionListener(ma);
        setPreferredSize(new Dimension(400, 400));
    }
    public void paint(Graphics g) {
        g.setColor(Color.blue);
        g.drawLine(40, 25, 250, 180);
        g.drawLine(75, 90, 400, 400);
        cross(g, oldP); cross(g, newP);
    }
    public void cross(Graphics g, Point p) {
        if (p == null) return;
        // xor cross hairs
        g.setXORMode(Color.gray);
        g.drawLine(p.x - 10, p.y, p.x + 10, p.y);
        g.drawLine(p.x, p.y - 10, p.x, p.y + 10);
        g.drawLine(p.x - 10, p.y-1, p.x + 10, p.y-1);
        g.drawLine(p.x-1, p.y - 10, p.x-1, p.y + 10);
        g.setPaintMode();
    }

    class Ear extends MouseAdapter {
            public void mouseMoved(MouseEvent e) {
                oldP = newP; newP = e.getPoint(); repaint();
            }
            public void mouseExited(MouseEvent e) {
                //System.out.println("MouseEvent");
                oldP = newP; newP = null; repaint();
            }
    }
    public static void main(String[] a) {
        JFrame f = new JFrame("XORMode");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setContentPane(new XORMode());
        f.setResizable(false); f.pack(); 
        f.setVisible(true);
    }
}
