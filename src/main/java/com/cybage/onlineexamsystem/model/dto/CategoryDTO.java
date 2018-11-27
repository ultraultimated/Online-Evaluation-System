package com.cybage.onlineexamsystem.model.dto;

import java.util.List;

public class CategoryDTO {

    private int categoryId;

    private String categoryName;

    private List<SubCategoryDTO> subCategoryList;

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

    public List<SubCategoryDTO> getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(List<SubCategoryDTO> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }
}
