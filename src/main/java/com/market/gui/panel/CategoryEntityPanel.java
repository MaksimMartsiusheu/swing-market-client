package com.market.gui.panel;

import com.market.gui.form.CategoryAddForm;
import com.market.gui.form.CategoryUpdateForm;
import com.market.gui.form.EntityForm;
import com.market.model.CategoryDTO;
import com.market.model.CategoryTableModel;
import com.market.service.impl.CategoryServiceImpl;
import org.springframework.web.client.RestClientException;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class CategoryEntityPanel extends EntityPanel {

    private CategoryServiceImpl categoryEntityService;
    private CategoryTableModel categoryTableModel;


    public CategoryEntityPanel(CategoryServiceImpl categoryEntityService) {
        super("Category Management");
        this.categoryEntityService = categoryEntityService;

        List<CategoryDTO> categories = categoryEntityService.findAll();
        this.categoryTableModel = new CategoryTableModel(categories);

        super.entityTable.setModel(this.categoryTableModel);
        super.refreshButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                    CategoryEntityPanel.this.refresh();
                }
            }
        });

        super.deleteButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                    CategoryEntityPanel.this.deleteRow();
                }
            }
        });

        super.addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                    CategoryEntityPanel.this.addCategory();
                }
            }
        });

        super.updateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                    CategoryEntityPanel.this.updateCategory();
                }
            }
        });

    }

    private void refresh() {
        List<CategoryDTO> categories = categoryEntityService.findAll();
        this.categoryTableModel = new CategoryTableModel(categories);
        super.entityTable.setModel(this.categoryTableModel);

        this.revalidate();
        this.repaint();
    }

    private void deleteRow() {

        int dialogResult = JOptionPane.showConfirmDialog(this, "Delete this category?", "Confirm action", JOptionPane.OK_CANCEL_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            try {
                int selectedRowIndex = super.entityTable.getSelectedRow();
                categoryEntityService.deleteById(Long.valueOf(this.categoryTableModel.getValueAt(selectedRowIndex, 0).toString()));
                categoryTableModel.removeRow(selectedRowIndex);
                JOptionPane.showMessageDialog(this, "Category deleted successfully", "Success action", JOptionPane.INFORMATION_MESSAGE);
            } catch (RestClientException ex) {
                JOptionPane.showMessageDialog(this,
                        "Couldn't delete category",
                        "Ooops",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private JDialog addCategory() {

        CategoryAddForm dialogForm = new CategoryAddForm(categoryEntityService);

        dialogForm.setSize(360, 180);
        dialogForm.setResizable(false);
        dialogForm.setVisible(true);
        return dialogForm;
    }

    private void updateCategory() {
        int selectedRowIndex = super.entityTable.getSelectedRow();

        CategoryUpdateForm categoryUpdateForm = new CategoryUpdateForm(categoryEntityService,
                Long.parseLong(this.categoryTableModel.getValueAt(selectedRowIndex,0).toString()));
        categoryUpdateForm.setSize(360, 180);
        categoryUpdateForm.setResizable(false);
        categoryUpdateForm.setVisible(true);
    }
}
