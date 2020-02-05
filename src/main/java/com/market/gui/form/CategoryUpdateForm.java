package com.market.gui.form;

import com.market.model.CategoryDTO;
import com.market.service.CategoryService;
import org.springframework.web.client.RestClientException;

import javax.swing.*;

public class CategoryUpdateForm extends AbstractCategoryForm {

    private Long categoryId;
    private CategoryService categoryService;

    public CategoryUpdateForm(CategoryService categoryEntityService, Long categoryId) {
        super("Category update", EntityForm.UPDATE_FORM);
        this.categoryService = categoryEntityService;
        this.categoryId = categoryId;

        CategoryDTO categoryDTO = categoryEntityService.findById(categoryId);
        super.categoryNameField.setText(categoryDTO.getCategoryName());
        if (categoryDTO.getParentId() != null) {
            super.parentIdField.setText(categoryDTO.getParentId().toString());
        }
    }

    @Override
    protected void actionOnClose() {
        this.dispose();
    }

    @Override
    protected void actionOnConfirm() {
        try {
            String categoryName = super.categoryNameField.getText();
            String parentIdString = super.parentIdField.getText();

            if (!categoryName.isEmpty()) {
                CategoryDTO categoryDTO = new CategoryDTO();
                categoryDTO.setId(this.categoryId);
                categoryDTO.setCategoryName(categoryName);
                if (!parentIdString.isEmpty()) {
                    categoryDTO.setParentId(Long.parseLong(parentIdString));
                }
                categoryService.update(categoryDTO);

                this.dispose();
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this,
                    "Illegal argument",
                    "Ooops",
                    JOptionPane.ERROR_MESSAGE);
        } catch (RestClientException ex) {
            JOptionPane.showMessageDialog(this,
                    "Couldn't update category",
                    "Ooops",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
