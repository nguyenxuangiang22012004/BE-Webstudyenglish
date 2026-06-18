package com.example.app.service;

import java.io.IOException;
import java.util.UUID;

public interface ExcelExportService {
    byte[] exportFlashcardSetToExcel(UUID setId, String ownerEmail) throws IOException;
}
