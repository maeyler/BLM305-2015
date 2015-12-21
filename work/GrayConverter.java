import java.io.File;
import java.net.URL;
import javax.swing.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import javax.imageio.ImageIO;

public class GrayConverter {

    final JFrame frm = new JFrame();
    final ImageIcon icn = new ImageIcon();
    final JLabel lab = new JLabel(icn);
    BufferedImage img;
    
    public GrayConverter() {
        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frm.getContentPane().add(lab);
    }
    public BufferedImage fileToImage(String n) throws Exception {
        return fileToImage(new File(n)); 
    }
    public BufferedImage fileToImage(File f) throws Exception {
        return urlToImage(f.toURI().toURL()); 
    }
    public BufferedImage urlToImage(String u) throws Exception {
        return urlToImage(new URL(u)); 
    }
    final static int MAX = 640;
    public BufferedImage urlToImage(URL u) throws Exception {
        //Image i = new ImageIcon(u).getImage();
        BufferedImage i = ImageIO.read(u);
        BufferedImage i2 = i; //make sure i2 has correct type
        if (i.getType() != BufferedImage.TYPE_INT_RGB) {
            int w = i.getWidth(null), h = i.getHeight(null);
            i2 = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            i2.getGraphics().drawImage(i, 0, 0, null);
        }
        setImage(i2, u.toString());
        return i2;
    }
    public void setImage(BufferedImage i, String t) {
        img = i; icn.setImage(i); lab.repaint();
        if (t==null || t.length()==0) t = "Some image";
        frm.setTitle(t); frm.pack(); frm.setVisible(true);
    }
    public void convert() {
        convert(img); lab.repaint();
    }
    
    public static void convert(BufferedImage i) {
        if (i == null) 
            throw new RuntimeException("No image loaded yet");
        WritableRaster R = i.getRaster();
        int[] rgb = { 0, 0, 0 };
        for (int x=0; x<i.getWidth(); x++) 
            for (int y=0; y<i.getHeight(); y++) {
                R.getPixel(x, y, rgb); 
                int m = (rgb[0]+rgb[1]+rgb[2])/3;
                rgb[0] = m; rgb[1] = m; rgb[2] = m;
                R.setPixel(x, y, rgb); 
            }
        i.setData(R);  //modified copy of the data
    }
    static GrayConverter G = new GrayConverter();;
    public static void main(String[] args) throws Exception {
        G.fileToImage(new File("images", "Kedi.png"));
    }
}
