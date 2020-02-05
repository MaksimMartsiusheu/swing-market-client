package com.market.gui.form;

import com.market.model.ProductDTO;
import com.market.service.ProductService;
import org.springframework.web.client.RestClientException;

import javax.swing.*;
import java.math.BigDecimal;

public class ProductUpdateForm extends AbstractProductForm {

    private Long productId;
    private ProductService productService;

    public ProductUpdateForm(ProductService productService, Long productId) {
        super("Product update", EntityForm.UPDATE_FORM);
        this.productService = productService;
        this.productId = productId;

        ProductDTO productDTO = productService.findById(productId);
        super.productNameField.setText(productDTO.getProductName());
        super.productPriceField.setText(productDTO.getProductPrice().toString());
        super.productCategoryId.setText(productDTO.getCategoryId().toString());

        if (productDTO.getVendorCode() != null) {
            super.productVendorField.setText(productDTO.getVendor());
        }

        if (productDTO.getVendorCode() != null) {
            super.productVendorCodeField.setText(productDTO.getVendorCode());
        }
    }

    @Override
    protected void actionOnClose() {
        this.dispose();
    }

    @Override
    protected void actionOnConfirm() {
        try {
            String productNameFieldText = super.productNameField.getText();
            String productPriceFieldText = super.productPriceField.getText();
            String productVendorFieldText = super.productVendorField.getText();
            String productVendorCodeFieldText = super.productVendorCodeField.getText();
            String productCategoryIdText = super.productCategoryId.getText();

            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(productId);
            productDTO.setProductName(productNameFieldText);
            productDTO.setProductPrice(new BigDecimal(productPriceFieldText));
            productDTO.setVendor(productVendorFieldText);
            productDTO.setVendorCode(productVendorCodeFieldText);
            productDTO.setCategoryId(Long.valueOf(productCategoryIdText));

            productService.update(productDTO);
            this.dispose();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this,
                    "Illegal argument",
                    "Ooops",
                    JOptionPane.ERROR_MESSAGE);
        } catch (RestClientException ex) {
            JOptionPane.showMessageDialog(this,
                    "Couldn't update product",
                    "Ooops",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
