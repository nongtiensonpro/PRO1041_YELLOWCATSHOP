/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Meo;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class CustomFontPDFPrinter {

    public static void createAndPrintPDF(String productCode, String fontPath) throws IOException {
        // Tạo tài liệu mới
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        // Tải font từ đường dẫn
        PDType0Font font = PDType0Font.load(document, new File(fontPath));

        // Thêm mã sản phẩm vào tài liệu
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.beginText();
        contentStream.setFont(font, 12);
        contentStream.newLineAtOffset(100, 700);
        contentStream.showText("Mã Sản Phẩm: " + productCode);
        contentStream.endText();
        contentStream.close();

        // Lưu tài liệu
        String filename = "ProductCode_" + productCode + ".pdf";
        document.save(filename);
        document.close();

        // Mở tệp PDF và in
        File file = new File(filename);
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(file);
        }
    }

    public static void main(String[] args) throws IOException {
        String productCode = "123456"; // Mã sản phẩm của bạn
        String fontPath = "image/BeVietnamPro-Thin.ttf"; // Đường dẫn đến font
        createAndPrintPDF(productCode, fontPath);
    }
}
