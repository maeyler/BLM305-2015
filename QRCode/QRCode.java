//package com.javapapers.java;
//Reference:  javapapers.com/core-java/java-qr-code/

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;

public class QRCode {

    final static String charset = "UTF-8"; // or "ISO-8859-1"
    final static int qrCodeheight = 200; 
    final static int qrCodewidth = 200;

    public static void createQRCode(String data, String path)
            throws WriterException, IOException {
        BitMatrix bm = new MultiFormatWriter().encode(data,
            BarcodeFormat.QR_CODE, qrCodewidth, qrCodeheight);
        String ext = path.substring(path.lastIndexOf('.') + 1);
        MatrixToImageWriter.writeToFile(bm, ext, new File(path));
    }
    public static String readQRCode(String path)
            throws NotFoundException, IOException  {
        BinaryBitmap bb = new BinaryBitmap(new HybridBinarizer(
            new BufferedImageLuminanceSource(ImageIO.read(new File(path)))));
        return new MultiFormatReader().decode(bb).getText();
    }
    public static void main(String[] args) {
        final String file = "easy.png";
        try {
            createQRCode("Sample text: QR Code is easy", file);
            System.out.println("QR Code "+file+" written");
            System.out.println(readQRCode(file));
        } catch (Exception x) {
            System.out.println(x);
        }
    }
}
