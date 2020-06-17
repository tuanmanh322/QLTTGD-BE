package com.da.common;

import com.da.dto.DiemToExcelDTO;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelFileUtil {

    public static ByteArrayInputStream objectToExcel(List<DiemToExcelDTO> objects) throws IOException {
        String[] COLUMNS = {
                "MÃ HỌC SINH", "HỌ VÀ TÊN", "NGÀY SINH",
                "ĐIỂM 15'", "ĐIỂM 45'", "ĐIỂM 90'", "ĐIỂM TB",
                "KÍP DẠY", "TÊN LỚP", "MÔN HỌC","NOTE"};

        try (
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream();
        ) {
            CreationHelper creationHelper = workbook.getCreationHelper();

            Sheet sheet = workbook.createSheet("Points");

            Font headFont = workbook.createFont();
            headFont.setBold(true);
            headFont.setColor(IndexedColors.BLUE.getIndex());

            CellStyle headerCellStyle = workbook.createCellStyle();

            headerCellStyle.setFont(headFont);

            // Row for header
            Row headerRow = sheet.createRow(0);

            // print header title

            for (int col = 0; col < COLUMNS.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(COLUMNS[col]);
                cell.setCellStyle(headerCellStyle);
            }

            int rowIdx = 1;
            for (DiemToExcelDTO diem : objects) {
                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(diem.getMaThe());
                row.createCell(1).setCellValue(diem.getUserName());
                row.createCell(2).setCellValue(diem.getNgaySinh());
                row.createCell(3).setCellValue(diem.getDiemMieng());
                row.createCell(4).setCellValue(diem.getDiem15p());
                row.createCell(5).setCellValue(diem.getDiem90p());
                row.createCell(6).setCellValue(diem.getDiemTB());
                row.createCell(7).setCellValue(diem.getKipDay());
                row.createCell(8).setCellValue(diem.getTenLop());
                row.createCell(9).setCellValue(diem.getTenMonHoc());
                row.createCell(10).setCellValue("1-Kíp 1(7h - 9h)" +
                        "2-Kíp 2(9h30- 12h)" +
                        "3-Kíp 3(13h-15h)" +
                        "4-Kíp 4(15h-18h)" +
                        "5-Kíp 5(18h30-21h30)");
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
}
