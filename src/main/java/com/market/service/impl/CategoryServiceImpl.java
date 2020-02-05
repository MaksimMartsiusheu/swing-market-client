package com.market.service.impl;

import com.market.api.CategoryRestControllerApi;
import com.market.model.CategoryDTO;
import com.market.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRestControllerApi categoryRestApi;

    @Autowired
    public CategoryServiceImpl(CategoryRestControllerApi categoryRestApi) {
        this.categoryRestApi = categoryRestApi;
    }

    @Override
    public List<CategoryDTO> findAll() {
        return this.categoryRestApi.getAllCategoriesUsingGET();
    }

    @Override
    public CategoryDTO findById(Long id) {
        return this.categoryRestApi.getCategoryUsingGET(id);
    }

    public void add(CategoryDTO category) {
        this.categoryRestApi.addCategoryUsingPOST(category);
    }

    @Override
    public void update(CategoryDTO categoryDTO) {
        this.categoryRestApi.updateCategoryUsingPUT(categoryDTO);
    }

    public void deleteById(Long id) {
        this.categoryRestApi.deleteCategoryUsingDELETE(id);
    }
}
