package controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.Desktop;
import java.io.File;
import model.ChiTietHoaDonModel;
import model.HoaDonModel;

import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

public class PdfPrinter {

    public static void createInvoicePdf(List<ChiTietHoaDonModel> chiTietHoaDonList, HoaDonModel hoaDonModel, int giamGia) {
        Document document = new Document();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDate = now.format(formatter);
        try {
            PdfWriter.getInstance(document, new FileOutputStream(hoaDonModel.getMaHoaDon().trim() + ".pdf"));
            document.open();
            // Định nghĩa màu sắc
            BaseColor lightGray = new BaseColor(230, 230, 230);
            BaseColor darkGray = new BaseColor(100, 100, 100);
            String fontPath = PdfPrinter.class.getClassLoader().getResource("image/BeVietnamPro-Thin.ttf").getPath();
            BaseFont baseFont = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font vietnameseFont = new Font(baseFont, 14, Font.BOLD);
            // Thêm hình ảnh chất lượng cao
            String imagePath = PdfPrinter.class.getClassLoader().getResource("image/Logo4.jpg").getPath();
            Image logo = Image.getInstance(imagePath);
            logo.scaleToFit(100, 100); // Tùy chỉnh kích thước hình ảnh

            // Thêm logo và thông tin công ty
            Paragraph companyInfo = new Paragraph();
            companyInfo.add(logo);
            companyInfo.add(new Paragraph("Yellow Cat Company", vietnameseFont));
            companyInfo.add(new Paragraph("Bắc Từ Liêm, Hà Nội", vietnameseFont));
            companyInfo.setAlignment(Element.ALIGN_CENTER); // Canh giữa
            document.add(companyInfo);
            document.add(new Paragraph(" "));

            // Tiêu đề
            String fontPath2 = PdfPrinter.class.getClassLoader().getResource("image/BeVietnamPro-Bold.ttf").getPath();
            BaseFont baseFont2 = BaseFont.createFont(fontPath2, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font vietnameseFont2 = new Font(baseFont2, 18, Font.BOLD);
            Paragraph title = new Paragraph("HÓA ĐƠN BÁN HÀNG", vietnameseFont2);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph(" "));

            // Thông tin hóa đơn
            Paragraph invoiceInfo = new Paragraph();
            invoiceInfo.add(new Paragraph("Mã hóa đơn: " + hoaDonModel.getMaHoaDon(), vietnameseFont));
            invoiceInfo.add(new Paragraph("Ngày tạo: " + formattedDate, vietnameseFont));
            invoiceInfo.add(new Paragraph("Khách hàng: " + hoaDonModel.getSoDienThoaiKH(), vietnameseFont));
            invoiceInfo.add(new Paragraph("Nhân viên: " + hoaDonModel.getSoDienThoaiNV(), vietnameseFont));
            invoiceInfo.setAlignment(Element.ALIGN_CENTER); // Canh giữa
            document.add(invoiceInfo);

            // Bảng chi tiết hóa đơn
            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            table.setHeaderRows(1);
            document.add(new Paragraph(" "));
            // Tiêu đề bảng
            Font headerFont = new Font(baseFont, 14, Font.BOLD, darkGray);
            Stream.of("Tên sản phẩm", "Mã sản phẩm", "Số lượng", "Đơn giá", "Tổng tiền")
                    .forEach(headerTitle -> {
                        PdfPCell header = new PdfPCell();
                        header.setBackgroundColor(lightGray);
                        header.setBorderWidth(0.5f);
                        header.setPhrase(new Phrase(headerTitle, headerFont));
                        table.addCell(header);
                    });

            // Dữ liệu bảng
            Font dataFont = new Font(baseFont, 10);
            DecimalFormat decimalFormat = new DecimalFormat("#,##0");
            for (ChiTietHoaDonModel chiTietHoaDon : chiTietHoaDonList) {
                table.addCell(new Phrase(chiTietHoaDon.getTenSanPham(), dataFont));
                table.addCell(new Phrase(chiTietHoaDon.getMaSanPhamChiTiet(), dataFont));
                table.addCell(new Phrase(String.valueOf(chiTietHoaDon.getSoLuong()), dataFont));

                PdfPCell priceCell = new PdfPCell(new Phrase(String.valueOf(decimalFormat.format(chiTietHoaDon.getDonGia())), dataFont));
                priceCell.setHorizontalAlignment(Element.ALIGN_RIGHT); // Canh phải
                table.addCell(priceCell);

                table.addCell(new Phrase(String.valueOf(decimalFormat.format(chiTietHoaDon.getTongTien())), dataFont));
            }
            document.add(table);

            // Giảm giá và Tổng tiền
            Paragraph discountTotal = new Paragraph();
            if (0==giamGia) {
             
            }else{
                   discountTotal.add(new Paragraph("Giảm giá : "+decimalFormat.format(giamGia) + " đồng", vietnameseFont));
            }
            discountTotal.add(new Paragraph("Tổng tiền: " + decimalFormat.format(hoaDonModel.getTongTien()) + " đồng", vietnameseFont));
            discountTotal.setAlignment(Element.ALIGN_CENTER); // Canh giữa
            document.add(discountTotal);
            document.add(new Paragraph(" "));

            // Chân trang
            Paragraph footer = new Paragraph();
            footer.add(new Paragraph("Cảm ơn quý khách và hẹn gặp lại!", vietnameseFont));
            footer.add(new Paragraph("Zalo: 0944214116", vietnameseFont));
            footer.setAlignment(Element.ALIGN_CENTER); // Canh giữa
            document.add(footer);

            document.close();

            System.out.println("Hóa đơn đã được tạo thành công tại " + hoaDonModel.getMaHoaDon().trim() + ".pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
         try {
            // Phần code để tạo và lưu hóa đơn đã được bạn viết ở trên

            // Mở hóa đơn PDF sau khi đã được tạo và lưu
            File file = new File(hoaDonModel.getMaHoaDon().trim() + ".pdf");
            if (file.exists()) {
                Desktop.getDesktop().open(file);
            } else {
                System.out.println("Không thể tìm thấy tập tin hóa đơn.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
