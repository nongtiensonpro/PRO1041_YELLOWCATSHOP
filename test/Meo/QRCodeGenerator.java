/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Meo;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
//import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.ByteMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.ByteArrayOutputStream;

public class QRCodeGenerator {

//    public static void main(String[] args) {
//        String data = "SP001"; // Chuỗi cần mã hóa thành mã QR
//
//        try {
//            QRCodeWriter qrCodeWriter = new QRCodeWriter();
//            ByteMatrix matrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 200, 200);
//
//            // Lưu mã QR vào mảng byte
//            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//            MatrixToImageWriter.writeToStream(matrix, "PNG", outputStream);
//            byte[] qrByteArray = outputStream.toByteArray();
//
//            // Bây giờ bạn có thể sử dụng qrByteArray cho mục đích lưu trữ hoặc truyền đi.
//        } catch (WriterException e) {
//            e.printStackTrace();
//        }
//    }
}



