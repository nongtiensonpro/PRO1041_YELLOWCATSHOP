/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Meo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.HashMap;

public class CustomQRGenerator {

    public static void main(String[] args) {
        String recipientInfo = "your_recipient@example.com"; // Change the recipient information
        double amountToPay = 100.0; // Change the amount to pay

        try {
            String qrCodeFilePath = generateCustomQR(recipientInfo, amountToPay);
            System.out.println("The custom QR code has been generated for $" + amountToPay + " for " + recipientInfo);
            System.out.println("The custom QR code is saved as: " + qrCodeFilePath);
        } catch (IOException | WriterException e) {
            e.printStackTrace();
        }
    }

    public static String generateCustomQR(String recipient, double amount) throws IOException, WriterException {
        String qrCodeData = "Recipient: " + recipient + "\nAmount: $" + amount;
        int size = 250; // Change the QR code size

        // Set the QR code parameters
        HashMap<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        // Create the QR code
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(qrCodeData, BarcodeFormat.QR_CODE, size, size, hints);

        // Convert the BitMatrix to a BufferedImage
        BufferedImage qrImage = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                qrImage.setRGB(x, y, bitMatrix.get(x, y) ? java.awt.Color.BLACK.getRGB() : java.awt.Color.WHITE.getRGB());
            }
        }

        // Save the QR code image to a file
        String qrCodeFilePath = "custom_qr.png"; // Change the output file path
        ImageIO.write(qrImage, "png", new File(qrCodeFilePath));

        return qrCodeFilePath;
    }
}