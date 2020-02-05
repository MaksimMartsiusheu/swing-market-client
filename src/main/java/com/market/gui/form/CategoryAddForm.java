package com.market.gui.form;

import com.market.model.CategoryDTO;
import com.market.service.impl.CategoryServiceImpl;
import org.springframework.web.client.RestClientException;

import javax.swing.*;

public class CategoryAddForm extends AbstractCategoryForm {

    private CategoryServiceImpl categoryEntityService;

    public CategoryAddForm(CategoryServiceImpl categoryEntityService) {
        super("Category add", EntityForm.ADD_FORM);
        this.categoryEntityService = categoryEntityService;
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
                categoryDTO.setCategoryName(categoryName);
                if (!parentIdString.isEmpty()) {
                    categoryDTO.setParentId(Long.parseLong(parentIdString));
                }
                categoryEntityService.add(categoryDTO);

                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Category name can't be empty",
                        "Warning!",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this,
                    "Illegal argument",
                    "Ooops",
                    JOptionPane.ERROR_MESSAGE);
        } catch (RestClientException ex) {
            JOptionPane.showMessageDialog(this,
                    "Couldn't add category",
                    "Ooops",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
