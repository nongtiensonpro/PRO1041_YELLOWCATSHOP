///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package Meo;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.List;
//import static org.apache.poi.hemf.record.emfplus.HemfPlusDraw.EmfPlusUnitType.Document;
//
//public class QRCodeToWord {
//
//    public static void insertQRCodeToDocx(List<SanPham> sanPhamList, String docxPath) throws IOException, InvalidFormatException {
//        XWPFDocument document = new XWPFDocument();
//        FileOutputStream out = new FileOutputStream(new File(docxPath));
//
//        for (SanPham sp : sanPhamList) {
//            String qrCodeImagePath = "path/to/qr/" + sp.getMa() + ".png"; // Đường dẫn đến hình ảnh mã QR
//
//            XWPFParagraph paragraph = document.createParagraph();
//            XWPFRun run = paragraph.createRun();
//            run.setText(sp.getTen() + " - " + sp.getGia());
//            run.addBreak();
//            run.addPicture(new FileInputStream(qrCodeImagePath),
//                    Document.PICTURE_TYPE_PNG, qrCodeImagePath,
//                    Units.toEMU(200), Units.toEMU(200)); // Chèn hình ảnh mã QR
//            run.addBreak(BreakType.PAGE);
//        }
//
//        document.write(out);
//        out.close();
//        document.close();
//        System.out.println("Tài liệu Word đã được tạo!");
//    }
//
//    public static void main(String[] args) throws IOException, InvalidFormatException {
//        // Giả sử bạn có một danh sách sản phẩm
////        List<SanPham> sanPhamList = ...; // Khởi tạo danh sách sản phẩm của bạn ở đây
//        String docxPath = "office/QRCodeDocument.docx"; // Đường dẫn lưu tài liệu Word
//
//        insertQRCodeToDocx(sanPhamList, docxPath);
//    }
//}
//
//// Lớp SanPham mẫu
//class SanPham {
//    private String ma; // Mã sản phẩm
//    private String ten; // Tên sản phẩm
//    private String gia; // Giá sản phẩm
//
//    // Các phương thức getter và constructor
//}
