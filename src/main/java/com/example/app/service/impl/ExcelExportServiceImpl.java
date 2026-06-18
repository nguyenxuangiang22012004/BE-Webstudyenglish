package com.example.app.service.impl;

import com.example.app.dto.response.FlashcardResponse;
import com.example.app.dto.response.FlashcardSetResponse;
import com.example.app.service.ExcelExportService;
import com.example.app.service.FlashcardService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class ExcelExportServiceImpl implements ExcelExportService {

    private final FlashcardService flashcardService;

    public ExcelExportServiceImpl(FlashcardService flashcardService) {
        this.flashcardService = flashcardService;
    }

    @Override
    public byte[] exportFlashcardSetToExcel(UUID setId, String ownerEmail) throws IOException {
        FlashcardSetResponse set = flashcardService.getSetById(setId, ownerEmail, null);
        List<FlashcardResponse> cards = set.getCards();

        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            XSSFSheet sheet = workbook.createSheet("Từ vựng");

            // Column widths
            sheet.setColumnWidth(0, 5 * 256);    // STT
            sheet.setColumnWidth(1, 22 * 256);   // Từ vựng
            sheet.setColumnWidth(2, 22 * 256);   // Nghĩa
            sheet.setColumnWidth(3, 18 * 256);   // Phiên âm
            sheet.setColumnWidth(4, 14 * 256);   // Loại từ
            sheet.setColumnWidth(5, 40 * 256);   // Ví dụ
            sheet.setColumnWidth(6, 14 * 256);   // Trạng thái

            // ===== TITLE ROW =====
            XSSFCellStyle titleStyle = createTitleStyle(workbook);
            Row titleRow = sheet.createRow(0);
            titleRow.setHeightInPoints(36);
            Cell titleCell = titleRow.createCell(0);
            String titleText = (set.getEmoji() != null ? set.getEmoji() + " " : "") + set.getName();
            titleCell.setCellValue(titleText);
            titleCell.setCellStyle(titleStyle);
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 6));

            // ===== META ROW =====
            XSSFCellStyle metaStyle = createMetaStyle(workbook);
            Row metaRow = sheet.createRow(1);
            metaRow.setHeightInPoints(20);
            Cell metaCell = metaRow.createCell(0);
            metaCell.setCellValue("Tổng số từ: " + cards.size() +
                    (set.getDescription() != null && !set.getDescription().isBlank()
                            ? "   |   " + set.getDescription()
                            : ""));
            metaCell.setCellStyle(metaStyle);
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 6));

            // ===== SPACER ROW =====
            sheet.createRow(2).setHeightInPoints(8);

            // ===== HEADER ROW =====
            XSSFCellStyle headerStyle = createHeaderStyle(workbook);
            Row headerRow = sheet.createRow(3);
            headerRow.setHeightInPoints(28);
            String[] headers = {"#", "Từ vựng", "Nghĩa", "Phiên âm", "Loại từ", "Ví dụ", "Trạng thái"};
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
                cell.setCellStyle(headerStyle);
            }

            // ===== DATA ROWS =====
            XSSFCellStyle evenRowStyle = createDataStyle(workbook, false);
            XSSFCellStyle oddRowStyle = createDataStyle(workbook, true);
            XSSFCellStyle statusMasteredStyle = createStatusStyle(workbook, "MASTERED");
            XSSFCellStyle statusLearningStyle = createStatusStyle(workbook, "LEARNING");
            XSSFCellStyle statusUnknownStyle = createStatusStyle(workbook, "UNKNOWN");

            for (int i = 0; i < cards.size(); i++) {
                FlashcardResponse card = cards.get(i);
                Row row = sheet.createRow(4 + i);
                row.setHeightInPoints(22);

                XSSFCellStyle rowStyle = (i % 2 == 0) ? evenRowStyle : oddRowStyle;

                createCell(row, 0, String.valueOf(i + 1), rowStyle);
                createCell(row, 1, card.getWord(), rowStyle);
                createCell(row, 2, card.getMeaning(), rowStyle);
                createCell(row, 3, orEmpty(card.getPronunciation()), rowStyle);
                createCell(row, 4, orEmpty(card.getPartOfSpeech()), rowStyle);
                createCell(row, 5, orEmpty(card.getExample()), rowStyle);

                String status = card.getStatus();
                XSSFCellStyle statusStyle = switch (status) {
                    case "MASTERED" -> statusMasteredStyle;
                    case "LEARNING" -> statusLearningStyle;
                    default -> statusUnknownStyle;
                };
                String statusLabel = switch (status) {
                    case "MASTERED" -> "✓ Đã thuộc";
                    case "LEARNING" -> "⟳ Đang học";
                    default -> "✗ Chưa biết";
                };
                createCell(row, 6, statusLabel, statusStyle);
            }

            // ===== OUTPUT =====
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            return out.toByteArray();
        }
    }

    // ===== STYLE HELPERS =====

    private XSSFCellStyle createTitleStyle(XSSFWorkbook wb) {
        XSSFCellStyle style = wb.createCellStyle();
        XSSFFont font = wb.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 18);
        font.setColor(new XSSFColor(new byte[]{(byte) 255, (byte) 255, (byte) 255}, null));
        style.setFont(font);
        style.setFillForegroundColor(new XSSFColor(new byte[]{(byte) 67, (byte) 97, (byte) 238}, null));
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        return style;
    }

    private XSSFCellStyle createMetaStyle(XSSFWorkbook wb) {
        XSSFCellStyle style = wb.createCellStyle();
        XSSFFont font = wb.createFont();
        font.setFontHeightInPoints((short) 11);
        font.setItalic(true);
        font.setColor(new XSSFColor(new byte[]{(byte) 100, (byte) 100, (byte) 120}, null));
        style.setFont(font);
        style.setFillForegroundColor(new XSSFColor(new byte[]{(byte) 240, (byte) 242, (byte) 255}, null));
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setAlignment(HorizontalAlignment.LEFT);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setIndention((short) 1);
        return style;
    }

    private XSSFCellStyle createHeaderStyle(XSSFWorkbook wb) {
        XSSFCellStyle style = wb.createCellStyle();
        XSSFFont font = wb.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 11);
        font.setColor(new XSSFColor(new byte[]{(byte) 255, (byte) 255, (byte) 255}, null));
        style.setFont(font);
        style.setFillForegroundColor(new XSSFColor(new byte[]{(byte) 58, (byte) 90, (byte) 200}, null));
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(new XSSFColor(new byte[]{(byte) 200, (byte) 210, (byte) 255}, null));
        return style;
    }

    private XSSFCellStyle createDataStyle(XSSFWorkbook wb, boolean alternate) {
        XSSFCellStyle style = wb.createCellStyle();
        XSSFFont font = wb.createFont();
        font.setFontHeightInPoints((short) 11);
        style.setFont(font);
        if (alternate) {
            style.setFillForegroundColor(new XSSFColor(new byte[]{(byte) 245, (byte) 247, (byte) 255}, null));
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(new XSSFColor(new byte[]{(byte) 220, (byte) 225, (byte) 240}, null));
        style.setWrapText(true);
        return style;
    }

    private XSSFCellStyle createStatusStyle(XSSFWorkbook wb, String status) {
        XSSFCellStyle style = wb.createCellStyle();
        XSSFFont font = wb.createFont();
        font.setFontHeightInPoints((short) 10);
        font.setBold(true);

        byte[] color = switch (status) {
            case "MASTERED" -> new byte[]{(byte) 22, (byte) 163, (byte) 74};    // green-600
            case "LEARNING" -> new byte[]{(byte) 234, (byte) 88, (byte) 12};    // orange-600
            default -> new byte[]{(byte) 107, (byte) 114, (byte) 128};           // gray-500
        };
        font.setColor(new XSSFColor(color, null));
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(new XSSFColor(new byte[]{(byte) 220, (byte) 225, (byte) 240}, null));
        return style;
    }

    private void createCell(Row row, int col, String value, CellStyle style) {
        Cell cell = row.createCell(col);
        cell.setCellValue(value != null ? value : "");
        cell.setCellStyle(style);
    }

    private String orEmpty(String value) {
        return value != null ? value : "";
    }
}
