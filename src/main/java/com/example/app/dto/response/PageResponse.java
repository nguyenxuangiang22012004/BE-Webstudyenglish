package com.example.app.dto.response;

import org.springframework.data.domain.Page;

import java.util.List;

public class PageResponse<T> {
    private List<T> content;
    private long total;
    private int page;
    private int size;
    private int totalPages;

    public PageResponse() {
    }

    public PageResponse(List<T> content, long total, int page, int size) {
        this.content = content;
        this.total = total;
        this.page = page;
        this.size = size;
        this.totalPages = size > 0 ? (int) Math.ceil((double) total / size) : 0;
    }

    public PageResponse(Page<T> pageData) {
        this.content = pageData.getContent();
        this.total = pageData.getTotalElements();
        this.page = pageData.getNumber();
        this.size = pageData.getSize();
        this.totalPages = pageData.getTotalPages();
    }

    public static <T> PageResponse<T> of(Page<T> pageData) {
        return new PageResponse<>(pageData);
    }

    public static <T> PageResponse<T> of(List<T> content, long total, int page, int size) {
        return new PageResponse<>(content, total, page, size);
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
