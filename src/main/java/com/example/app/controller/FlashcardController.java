package com.example.app.controller;

import com.example.app.dto.request.CreateFlashcardRequest;
import com.example.app.dto.request.CreateSetRequest;
import com.example.app.dto.response.ApiResponse;
import com.example.app.dto.response.FlashcardResponse;
import com.example.app.dto.response.FlashcardSetResponse;
import com.example.app.service.ExcelExportService;
import com.example.app.service.ExcelImportService;
import com.example.app.service.FlashcardService;
import jakarta.validation.Valid;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/flashcards")
public class FlashcardController {

    private final FlashcardService flashcardService;
    private final ExcelExportService excelExportService;
    private final ExcelImportService excelImportService;

    public FlashcardController(
            FlashcardService flashcardService,
            ExcelExportService excelExportService,
            ExcelImportService excelImportService) {
        this.flashcardService = flashcardService;
        this.excelExportService = excelExportService;
        this.excelImportService = excelImportService;
    }

    // ============ FLASHCARD SETS ============

    @PostMapping("/sets")
    public ResponseEntity<ApiResponse<FlashcardSetResponse>> createSet(
            @Valid @RequestBody CreateSetRequest request,
            Authentication auth) {
        FlashcardSetResponse result = flashcardService.createSet(request, auth.getName());
        return ResponseEntity.ok(new ApiResponse<>(true, "Set created successfully", result));
    }

    @GetMapping("/sets")
    public ResponseEntity<ApiResponse<List<FlashcardSetResponse>>> getMySets(Authentication auth) {
        List<FlashcardSetResponse> sets = flashcardService.getMySets(auth.getName());
        return ResponseEntity.ok(new ApiResponse<>(true, "Sets retrieved successfully", sets));
    }

    @GetMapping("/sets/{setId}")
    public ResponseEntity<ApiResponse<FlashcardSetResponse>> getSetById(
            @PathVariable UUID setId,
            @RequestParam(required = false) String status,
            Authentication auth) {
        FlashcardSetResponse set = flashcardService.getSetById(setId, auth.getName(), status);
        return ResponseEntity.ok(new ApiResponse<>(true, "Set retrieved successfully", set));
    }

    @PutMapping("/sets/{setId}")
    public ResponseEntity<ApiResponse<FlashcardSetResponse>> updateSet(
            @PathVariable UUID setId,
            @Valid @RequestBody CreateSetRequest request,
            Authentication auth) {
        FlashcardSetResponse result = flashcardService.updateSet(setId, request, auth.getName());
        return ResponseEntity.ok(new ApiResponse<>(true, "Set updated successfully", result));
    }

    @DeleteMapping("/sets/{setId}")
    public ResponseEntity<ApiResponse<Object>> deleteSet(
            @PathVariable UUID setId,
            Authentication auth) {
        flashcardService.deleteSet(setId, auth.getName());
        return ResponseEntity.ok(new ApiResponse<>(true, "Set deleted successfully", null));
    }

    @GetMapping("/sets/{setId}/export")
    public ResponseEntity<byte[]> exportSetToExcel(
            @PathVariable UUID setId,
            Authentication auth) throws IOException {
        byte[] excelBytes = excelExportService.exportFlashcardSetToExcel(setId, auth.getName());

        String filename = "flashcards_" + setId + ".xlsx";
        ContentDisposition contentDisposition = ContentDisposition.attachment()
                .filename(filename, StandardCharsets.UTF_8)
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentDisposition(contentDisposition);
        headers.setContentType(MediaType.parseMediaType(
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
        headers.setContentLength(excelBytes.length);

        return ResponseEntity.ok()
                .headers(headers)
                .body(excelBytes);
    }

    // ============ EXCEL IMPORT ============

    /**
     * GET /v1/flashcards/import/template
     * Download file Excel mẫu để người dùng điền vào.
     * 5 cột: Từ vựng | Nghĩa | Phiên âm | Loại từ | Ví dụ
     */
    @GetMapping("/import/template")
    public ResponseEntity<byte[]> downloadImportTemplate() throws IOException {
        byte[] templateBytes = excelExportService.generateImportTemplate();

        ContentDisposition contentDisposition = ContentDisposition.attachment()
                .filename("template_tu_vung.xlsx", StandardCharsets.UTF_8)
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentDisposition(contentDisposition);
        headers.setContentType(MediaType.parseMediaType(
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
        headers.setContentLength(templateBytes.length);

        return ResponseEntity.ok()
                .headers(headers)
                .body(templateBytes);
    }

    /**
     * POST /v1/flashcards/import/excel/preview
     * Parse file Excel upload, trả về danh sách từ để FE preview.
     * Chưa lưu vào DB.
     */
    @PostMapping("/import/excel/preview")
    public ResponseEntity<ApiResponse<List<CreateFlashcardRequest>>> previewExcelImport(
            @RequestParam("file") MultipartFile file,
            Authentication auth) throws IOException {
        List<CreateFlashcardRequest> words = excelImportService.parseExcelFile(file);
        return ResponseEntity.ok(new ApiResponse<>(true,
                "Đọc được " + words.size() + " từ từ file Excel", words));
    }

    // ============ FLASHCARDS IN A SET ============

    @PostMapping("/sets/{setId}/cards")
    public ResponseEntity<ApiResponse<List<FlashcardResponse>>> addCards(
            @PathVariable UUID setId,
            @Valid @RequestBody List<@Valid CreateFlashcardRequest> cards,
            Authentication auth) {
        List<FlashcardResponse> result = flashcardService.addCardsToSet(setId, cards, auth.getName());
        return ResponseEntity.ok(new ApiResponse<>(true, "Cards added successfully", result));
    }

    @GetMapping("/sets/{setId}/cards")
    public ResponseEntity<ApiResponse<List<FlashcardResponse>>> getCards(
            @PathVariable UUID setId,
            Authentication auth) {
        List<FlashcardResponse> cards = flashcardService.getCardsInSet(setId, auth.getName());
        return ResponseEntity.ok(new ApiResponse<>(true, "Cards retrieved successfully", cards));
    }

    @DeleteMapping("/sets/{setId}/cards/{cardId}")
    public ResponseEntity<ApiResponse<Object>> deleteCard(
            @PathVariable UUID setId,
            @PathVariable UUID cardId,
            Authentication auth) {
        flashcardService.deleteCard(setId, cardId, auth.getName());
        return ResponseEntity.ok(new ApiResponse<>(true, "Card deleted successfully", null));
    }

    // ============ PROGRESS ============

    @PutMapping("/cards/{cardId}/progress")
    public ResponseEntity<ApiResponse<com.example.app.dto.response.FlashcardProgressResponse>> updateProgress(
            @PathVariable UUID cardId,
            @RequestBody com.example.app.dto.request.UpdateFlashcardProgressRequest request,
            Authentication auth) {
        com.example.app.dto.response.FlashcardProgressResponse result = flashcardService.updateFlashcardProgress(cardId, request, auth.getName());
        return ResponseEntity.ok(new ApiResponse<>(true, "Progress updated successfully", result));
    }
}
