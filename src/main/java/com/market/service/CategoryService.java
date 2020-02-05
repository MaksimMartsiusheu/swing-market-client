package com.market.service;

import com.market.model.CategoryDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> findAll();

    CategoryDTO findById(Long id);

    void add(CategoryDTO categoryDTO);

    void update(CategoryDTO categoryDTO);

    void deleteById(Long id);
}
