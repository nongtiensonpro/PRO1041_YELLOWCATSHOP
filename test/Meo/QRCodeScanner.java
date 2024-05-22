///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package Meo;
//
//import com.github.sarxos.webcam.Webcam;
//import com.github.sarxos.webcam.WebcamPanel;
//import com.google.zxing.BinaryBitmap;
//import com.google.zxing.LuminanceSource;
//import com.google.zxing.MultiFormatReader;
//import com.google.zxing.Result;
//import com.google.zxing.common.HybridBinarizer;
//import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
//import com.github.sarxos.webcam.Webcam;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//
//public class QRCodeScanner extends JFrame {
//
//    private Webcam webcam;
//    private WebcamPanel panel;
//    private JTextArea textArea;
//
//    public QRCodeScanner() {
//        super("QR Code Scanner");
//
//        setLayout(new BorderLayout());
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // Tạo và khởi động webcam
//        webcam = Webcam.getDefault();
//        webcam.open();
//
//        // Tạo panel hiển thị hình ảnh từ webcam
//        panel = new WebcamPanel(webcam);
//        add(panel, BorderLayout.CENTER);
//
//        // Tạo text area để hiển thị kết quả quét mã QR
//        textArea = new JTextArea();
//        textArea.setEditable(false);
//        add(new JScrollPane(textArea), BorderLayout.SOUTH);
//
//        // Đặt kích thước cửa sổ
//        setSize(400, 400);
//        setVisible(true);
//
//        // Tạo thread để liên tục quét mã QR
//        new Thread(() -> {
//            while (true) {
//                try {
//                    BufferedImage image = webcam.getImage();
//                    if (image != null) {
//                        LuminanceSource source = new BufferedImageLuminanceSource(image);
//                        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
//                        Result result = new MultiFormatReader().decode(bitmap);
//                        if (result != null) {
//                            textArea.setText("Mã QR: " + result.getText());
//                        }
//                    }
//                    Thread.sleep(100);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }
//
//    public static void main(String[] args) {
//        //        SwingUtilities.invokeLater(QRCodeScanner::new);
//    List<Webcam> webcamsNe = Webcam.getWebcams();
//}
//}
