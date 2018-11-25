package com.cybage.onlineexamsystem.model.dto;

import org.springframework.context.annotation.Bean;

import java.util.List;

public class CategoryDTO {

    private int categoryId;

    private String categoryName;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
