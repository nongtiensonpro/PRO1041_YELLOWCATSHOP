package controller;

import java.awt.Desktop;
import java.io.File;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import model.SanPhamModel;

public class ExcelExporter {

    public static void xuatFileExcelDanhSachSanPham(List<SanPhamModel> listSanPham) {
        // Tạo một Workbook mới (đại diện cho file Excel .xls)
        Workbook workbook = new HSSFWorkbook();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
        String formattedDate = now.format(formatter);
        // Tạo một bảng tính mới
        Sheet sheet = workbook.createSheet("Danh sách sản phẩm " + formattedDate);

        // Tạo tiêu đề cho các cột
        String[] columnNames = {"Mã sản phẩm", "Tên sản phẩm", "Loại hãng",
                                "Nhà sản xuất", "Màu sắc", "Mã chất liệu", 
                                "Giá nhập", "Giá bán", "Mã Size", 
                                "Ngày tạo", "Mô tả", "Trạng thái"};
        
        // Tạo hàng đầu tiên (dòng tiêu đề)
        Row headerRow = sheet.createRow(0);
        CellStyle headerCellStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerCellStyle.setFont(headerFont);
        
        for (int i = 0; i < columnNames.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columnNames[i]);
            cell.setCellStyle(headerCellStyle);
        }
        
        // Định dạng cột cho dữ liệu
        for (int i = 0; i < columnNames.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Tạo dữ liệu từ danh sách sản phẩm
        for (int i = 0; i < listSanPham.size(); i++) {
            SanPhamModel sanPham = listSanPham.get(i);
            Row row = sheet.createRow(i + 1); // +1 vì hàng đầu tiên đã được sử dụng cho tiêu đề
            row.createCell(0).setCellValue(sanPham.getMa_SanPhamChiTiet());
            row.createCell(1).setCellValue(sanPham.getTen());
            row.createCell(2).setCellValue(listSanPham.get(i).getMaHang());
            row.createCell(3).setCellValue(listSanPham.get(i).getMaSanXuat());
            row.createCell(4).setCellValue(listSanPham.get(i).getMaMauSac());
            row.createCell(5).setCellValue(listSanPham.get(i).getMaChatLieu());
            row.createCell(6).setCellValue(listSanPham.get(i).getGiaNhap());
            row.createCell(7).setCellValue(listSanPham.get(i).getGiaBan());
            row.createCell(8).setCellValue(listSanPham.get(i).getMaSize());
            row.createCell(9).setCellValue(listSanPham.get(i).getNgayTao());
            row.createCell(10).setCellValue(listSanPham.get(i).getMoTa());
            row.createCell(11).setCellValue(listSanPham.get(i).isTrangThai()?"Hoạt động":"Không hoạt động");
        }

        // Lưu file Excel
        try (FileOutputStream fileOut = new FileOutputStream("Danh sách sản phẩm " + formattedDate + ".xls")) {
            workbook.write(fileOut);
            System.out.println("File Excel đã được tạo và lưu thành công!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            // Mở file Excel sau khi đã được tạo và lưu
            File file = new File("Danh sách sản phẩm " + formattedDate + ".xls");
            if (file.exists()) {
                Desktop.getDesktop().open(file);
            } else {
                System.out.println("Không thể tìm thấy tập tin Excel.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
