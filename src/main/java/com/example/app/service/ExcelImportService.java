package com.example.app.service;

import com.example.app.dto.request.CreateFlashcardRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ExcelImportService {
    /**
     * Parse file Excel do người dùng upload.
     * Đọc từ hàng 2 trở đi (hàng 1 là header).
     * Cột: Từ vựng | Nghĩa | Phiên âm | Loại từ | Ví dụ
     * Bỏ qua hàng trống, tối đa 500 từ.
     */
    List<CreateFlashcardRequest> parseExcelFile(MultipartFile file) throws IOException;
}
