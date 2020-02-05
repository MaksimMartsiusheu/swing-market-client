package com.market.gui.panel;

import com.market.gui.form.ProductAddForm;
import com.market.gui.form.ProductUpdateForm;
import com.market.model.ProductDTO;
import com.market.model.ProductTableModel;
import com.market.service.impl.ProductServiceImpl;
import org.springframework.web.client.RestClientException;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ProductEntityPanel extends EntityPanel {

    private ProductServiceImpl productEntityService;
    private ProductTableModel productTableModel;

    public ProductEntityPanel(ProductServiceImpl productEntityService) {
        super("Products Management");
        this.productEntityService = productEntityService;

        List<ProductDTO> products = productEntityService.findAll();
        this.productTableModel = new ProductTableModel(products);

        super.entityTable.setModel(productTableModel);

        super.refreshButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                    List<ProductDTO> products = productEntityService.findAll();
                    ProductEntityPanel.this.productTableModel = new ProductTableModel(products);
                    ProductEntityPanel.super.entityTable.setModel(productTableModel);

                    ProductEntityPanel.this.revalidate();
                    ProductEntityPanel.this.repaint();
                }
            }
        });

        super.deleteButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                    ProductEntityPanel.this.deleteRow();
                }
            }
        });

        super.addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                    ProductEntityPanel.this.addProduct();
                }
            }
        });

        super.updateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                    ProductEntityPanel.this.updateProduct();
                }
            }
        });
    }

    private void deleteRow() {

        int dialogResult = JOptionPane.showConfirmDialog(this, "Delete this product?", "Confirm action", JOptionPane.OK_CANCEL_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            try {
                int selectedRowIndex = super.entityTable.getSelectedRow();
                productEntityService.deleteById(Long.valueOf(this.productTableModel.getValueAt(selectedRowIndex, 0).toString()));
                this.productTableModel.removeRow(selectedRowIndex);
                JOptionPane.showMessageDialog(this, "Product deleted successfully", "Success action", JOptionPane.INFORMATION_MESSAGE);
            } catch (RestClientException ex) {
                JOptionPane.showMessageDialog(this,
                        "Couldn't delete product",
                        "Ooops",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private JDialog addProduct() {

        ProductAddForm dialogForm = new ProductAddForm(productEntityService);

        dialogForm.setSize(360, 240);
        dialogForm.setResizable(false);
        dialogForm.setVisible(true);
        return dialogForm;
    }

    private void updateProduct() {
        int selectedRowIndex = super.entityTable.getSelectedRow();

        ProductUpdateForm productUpdateForm = new ProductUpdateForm(productEntityService,
                Long.parseLong(this.productTableModel.getValueAt(selectedRowIndex, 0).toString()));
        productUpdateForm.setSize(360, 240);
        productUpdateForm.setResizable(false);
        productUpdateForm.setVisible(true);
    }
}
