/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;

import java.io.FileOutputStream;
import java.awt.Desktop;
import java.io.File;
import model.SanPhamModel;

public class PDFCreatorWithQR {

    public static void createPDF(SanPhamModel sp, String fontPath) {
        Document document = new Document();
        HangController hangController = new HangController();
        MauSacController mauSacController = new MauSacController();
        NhaSanXuatController nhaSanXuatController = new NhaSanXuatController();
        ChatLieuController chatLieuController = new ChatLieuController();
        SizeController sizeController = new SizeController();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(sp.getMa_SanPhamChiTiet()+".pdf"));
            document.open();

            document.addAuthor("Yellow Cat");
            document.addCreationDate();
            document.addCreator("Yellow Cat Company");
            document.addTitle(sp.getMa_SanPhamChiTiet());
            document.addKeywords(sp.getMoTa());
            document.addSubject("Yellow Cat Company");
            document.addHeader("Content-Type", "application/pdf");
            document.addHeader("Content-Disposition", "inline; filename="+sp.getMa_SanPhamChiTiet()+".pdf\"");
            document.addHeader("Content-Transfer-Encoding", "binary");

            // Tạo mã QR
            BarcodeQRCode barcodeQRCode = new BarcodeQRCode(sp.getMa_SanPhamChiTiet(), 1000, 1000, null);
            Image codeQrImage = barcodeQRCode.getImage();
            codeQrImage.scaleToFit(100, 100);

            // Thêm logo và mã QR vào cùng một hàng
            PdfPTable logoTable = new PdfPTable(2);
            logoTable.setWidthPercentage(100);
            logoTable.setWidths(new float[]{1, 3});
            logoTable.setHorizontalAlignment(Element.ALIGN_CENTER);
            BaseFont baseFont = BaseFont.createFont("image/BeVietnamPro-Thin.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font companyFont = new Font(baseFont, 16, Font.BOLD);
            // Thêm logo
            String imagePath = PdfPrinter.class.getClassLoader().getResource("image/Logo4.jpg").getPath();
            Image logo = Image.getInstance(imagePath);
            logo.scaleToFit(100, 100); // Điều chỉnh kích thước của logo
            PdfPCell logoCell = new PdfPCell(logo);
            logoCell.setBorder(Rectangle.NO_BORDER);
            logoTable.addCell(logoCell);

            // Thêm mã QR
            PdfPCell qrCell = new PdfPCell(codeQrImage);
            qrCell.setBorder(Rectangle.NO_BORDER);
            qrCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            logoTable.addCell(qrCell);

            document.add(logoTable);

            // Thêm tên công ty
            document.add(new Paragraph(" "));
            Paragraph companyParagraph = new Paragraph("Yellow Cat Company", companyFont);
            companyParagraph.add(new Paragraph("Bắc Từ Liêm, Hà Nội", companyFont));
            companyParagraph.add(new Paragraph("Tel +84 44214116, Gmail : nongtiensonpro@gmail.com", companyFont));
            document.add(companyParagraph);
            
            BaseFont baseFont1 = BaseFont.createFont("image/BeVietnamPro-Bold.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font companyFont1 = new Font(baseFont1, 25, Font.BOLD);
            
            
            Paragraph paragraph = new Paragraph(sp.getTen(), companyFont1); // Tạo đoạn văn bản với Font in đậm
            paragraph.setAlignment(Element.ALIGN_CENTER); // Căn giữa đoạn văn bản

            document.add(paragraph); // Thêm đoạn văn bản vào tài liệu

            // Thêm thông tin sản phẩm vào tài liệu
            PdfPTable table = new PdfPTable(2); // Tạo bảng với 2 cột
            table.setWidthPercentage(80); // Phần trăm chiều rộng của bảng
            table.setSpacingBefore(10f); // Khoảng cách trước bảng

            // Thêm các dòng thông tin sản phẩm vào bảng
            addTableCell(table, "Mã sản phẩm : ", sp.getMa_SanPhamChiTiet(), companyFont);
//            addTableCell(table, "Tên sản phẩm : ", sp.getTen(), companyFont);
            addTableCell(table, "Tên hãng : ", hangController.timKiemHangTheoMa(sp.getMaHang()).get(0).getTenHang() + "\n" + hangController.timKiemHangTheoMa(sp.getMaHang()).get(0).getMoTa(), companyFont);
            addTableCell(table, "Tên nhà sản xuất : ", nhaSanXuatController.timKiemNSXTheoMa(sp.getMaSanXuat()).get(0).getTenNSX() + "\n" + nhaSanXuatController.timKiemNSXTheoMa(sp.getMaSanXuat()).get(0).getMoTa(), companyFont);
             addTableCell(table, "Quốc gia : ", nhaSanXuatController.timKiemNSXTheoMa(sp.getMaSanXuat()).get(0).getQuocGia() + "\n", companyFont);
            addTableCell(table, "Tên màu sắc : ", mauSacController.timKiemMauSacTheoMa(sp.getMaMauSac()).get(0).getTenMauSac() + "\n" + mauSacController.timKiemMauSacTheoMa(sp.getMaMauSac()).get(0).getMoTa(), companyFont);
            addTableCell(table, "Tên chất liệu : ", chatLieuController.timKiemChatLieuTheoMa(sp.getMaChatLieu()).get(0).getTen() + "\n" + chatLieuController.timKiemChatLieuTheoMa(sp.getMaChatLieu()).get(0).getMoTa(), companyFont);
            addTableCell(table, "Size : ", String.valueOf(sizeController.timSizeGanDung(sp.getMaSize()).get(0).getSoSize()) + "\n" + String.valueOf(sizeController.timSizeGanDung(sp.getMaSize()).get(0).getMoTa()), companyFont);

            // Thêm bảng vào tài liệu
            document.add(table);

            document.add(new Paragraph("Mô tả : " + sp.getMoTa(), companyFont));
            document.add(new Paragraph("Giá sản phẩm: " + sp.getGiaBan() + " VND", companyFont));
            
            document.close();
            writer.close();

            // Mở tệp PDF để in
            File file = new File(sp.getMa_SanPhamChiTiet()+".pdf");
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Hàm hỗ trợ thêm ô vào bảng với nội dung, font và màu cụ thể
    private static void addTableCell(PdfPTable table, String header, String content, Font font) {
        PdfPCell headerCell = new PdfPCell(new Phrase(header, font));
        headerCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        headerCell.setBackgroundColor(new BaseColor(240, 240, 240)); // Màu nền của ô header
        headerCell.setBorder(Rectangle.NO_BORDER);

        PdfPCell contentCell = new PdfPCell(new Phrase(content, font));
        contentCell.setBackgroundColor(new BaseColor(255, 255, 255)); // Màu nền của ô content
        contentCell.setBorder(Rectangle.NO_BORDER);

        table.addCell(headerCell);
        table.addCell(contentCell);
    }
}
