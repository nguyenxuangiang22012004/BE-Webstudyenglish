package com.example.app.service.impl;

import com.example.app.dto.request.CreateFlashcardRequest;
import com.example.app.service.ExcelImportService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
public class ExcelImportServiceImpl implements ExcelImportService {

    private static final int MAX_WORDS = 500;

    // Tên cột được chấp nhận (không phân biệt hoa thường)
    private static final String COL_WORD        = "từ vựng";
    private static final String COL_MEANING     = "nghĩa";
    private static final String COL_PHONETIC    = "phiên âm";
    private static final String COL_POS         = "loại từ";
    private static final String COL_EXAMPLE     = "ví dụ";

    @Override
    public List<CreateFlashcardRequest> parseExcelFile(MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename() != null
                ? file.getOriginalFilename().toLowerCase()
                : "";

        if (!filename.endsWith(".xlsx") && !filename.endsWith(".xls")) {
            throw new IllegalArgumentException(
                    "Định dạng không hỗ trợ. Vui lòng upload file .xlsx hoặc .xls");
        }

        try (InputStream is = file.getInputStream();
             Workbook workbook = filename.endsWith(".xlsx")
                     ? new XSSFWorkbook(is)
                     : new HSSFWorkbook(is)) {

            Sheet sheet = workbook.getSheetAt(0);
            if (sheet == null) {
                throw new IllegalArgumentException("File Excel không có sheet nào.");
            }

            // ── Đọc header row (hàng 0) ──────────────────────────────────────
            Row headerRow = sheet.getRow(0);
            if (headerRow == null) {
                throw new IllegalArgumentException("File Excel không có hàng header.");
            }

            Map<String, Integer> colIndex = new HashMap<>();
            for (int c = 0; c <= headerRow.getLastCellNum(); c++) {
                Cell cell = headerRow.getCell(c);
                if (cell == null) continue;
                String name = getCellString(cell).toLowerCase().trim();
                colIndex.put(name, c);
            }

            // Kiểm tra 2 cột bắt buộc
            if (!colIndex.containsKey(COL_WORD) || !colIndex.containsKey(COL_MEANING)) {
                throw new IllegalArgumentException(
                        "File Excel thiếu cột bắt buộc: 'Từ vựng' và/hoặc 'Nghĩa'.");
            }

            int wordCol     = colIndex.get(COL_WORD);
            int meaningCol  = colIndex.get(COL_MEANING);
            int phoneticCol = colIndex.getOrDefault(COL_PHONETIC, -1);
            int posCol      = colIndex.getOrDefault(COL_POS, -1);
            int exampleCol  = colIndex.getOrDefault(COL_EXAMPLE, -1);

            // ── Đọc dữ liệu từ hàng 2 trở đi ───────────────────────────────
            List<CreateFlashcardRequest> result = new ArrayList<>();
            int lastRow = sheet.getLastRowNum();

            for (int r = 1; r <= lastRow; r++) {
                Row row = sheet.getRow(r);
                if (row == null) continue;

                String word    = getCellString(row, wordCol).trim();
                String meaning = getCellString(row, meaningCol).trim();

                // Bỏ qua hàng trống (thiếu word hoặc meaning)
                if (word.isEmpty() || meaning.isEmpty()) continue;

                CreateFlashcardRequest req = new CreateFlashcardRequest();
                req.setWord(truncate(word, 255));
                req.setMeaning(truncate(meaning, 500));

                if (phoneticCol >= 0) {
                    String ph = getCellString(row, phoneticCol).trim();
                    if (!ph.isEmpty()) req.setPronunciation(truncate(ph, 255));
                }
                if (posCol >= 0) {
                    String pos = getCellString(row, posCol).trim();
                    if (!pos.isEmpty()) req.setPartOfSpeech(truncate(pos, 50));
                }
                if (exampleCol >= 0) {
                    String ex = getCellString(row, exampleCol).trim();
                    if (!ex.isEmpty()) req.setExample(ex);
                }

                result.add(req);

                if (result.size() >= MAX_WORDS) break;
            }

            if (result.isEmpty()) {
                throw new IllegalArgumentException(
                        "File Excel không có dữ liệu hợp lệ (thiếu cột Từ vựng hoặc Nghĩa).");
            }

            return result;
        }
    }

    // ─── Helpers ──────────────────────────────────────────────────────────────

    private String getCellString(Row row, int col) {
        if (col < 0) return "";
        Cell cell = row.getCell(col);
        return getCellString(cell);
    }

    private String getCellString(Cell cell) {
        if (cell == null) return "";
        return switch (cell.getCellType()) {
            case STRING  -> cell.getStringCellValue();
            case NUMERIC -> {
                double d = cell.getNumericCellValue();
                // Nếu là số nguyên thì không hiện .0
                yield d == Math.floor(d) && !Double.isInfinite(d)
                        ? String.valueOf((long) d)
                        : String.valueOf(d);
            }
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            case FORMULA -> {
                try { yield cell.getStringCellValue(); }
                catch (Exception e) { yield String.valueOf(cell.getNumericCellValue()); }
            }
            default -> "";
        };
    }

    private String truncate(String value, int maxLen) {
        return value.length() > maxLen ? value.substring(0, maxLen) : value;
    }
}
