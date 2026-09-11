package com.example.app.service;

import java.io.IOException;
import java.util.UUID;

public interface ExcelExportService {
    byte[] exportFlashcardSetToExcel(UUID setId, String ownerEmail) throws IOException;

    /**
     * Tạo file Excel mẫu để người dùng download và điền vào.
     * 5 cột: Từ vựng | Nghĩa | Phiên âm | Loại từ | Ví dụ
     * Không có cột STT hay ID.
     */
    byte[] generateImportTemplate() throws IOException;
}

