/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Meo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;


public class CustomQRGenerator {

    public static void main(String[] args) {
        String recipientInfo = "your_recipient@example.com"; // Thay đổi thông tin người nhận
        double amountToPay = 100.0; // Thay đổi số tiền

        try {
            String qrCodeFilePath = generateCustomQR(recipientInfo, amountToPay);
            System.out.println("Mã QR tùy chỉnh đã được tạo cho $" + amountToPay + " cho " + recipientInfo);
            System.out.println("Lưu mã QR tại: " + qrCodeFilePath);
        } catch (IOException | WriterException e) {
            e.printStackTrace();
        }
    }

    public static String generateCustomQR(String recipient, double amount) throws IOException, WriterException {
        String qrCodeData = "Người nhận: " + recipient + "\nSố tiền: $" + amount;
        int size = 250; // Thay đổi kích thước mã QR

        // Đặt các thông số cho mã QR
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        // Tạo mã QR
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(qrCodeData, BarcodeFormat.QR_CODE, size, size, hints);

        // Tạo BufferedImage từ BitMatrix
        BufferedImage qrImage = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                qrImage.setRGB(x, y, bitMatrix.get(x, y) ? java.awt.Color.BLACK.getRGB() : java.awt.Color.WHITE.getRGB());
            }
        }

        // Lưu hình ảnh vào tệp
        String qrCodeFilePath = "custom_qr.png"; // Thay đổi đường dẫn tệp đầu ra
        ImageIO.write(qrImage, "png", new File(qrCodeFilePath));

        return qrCodeFilePath;
    }
}