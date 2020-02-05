package com.market.gui.form;

import com.market.model.ProductDTO;
import com.market.service.ProductService;
import org.springframework.web.client.RestClientException;

import javax.swing.*;
import java.math.BigDecimal;

public class ProductAddForm extends AbstractProductForm {

    private ProductService productService;

    public ProductAddForm(ProductService productService) {
        super("Product add", EntityForm.ADD_FORM);
        this.productService = productService;
    }

    @Override
    protected void actionOnClose() {
        this.dispose();
    }

    @Override
    protected void actionOnConfirm() {
        try {
            String productNameFieldText = this.productNameField.getText();
            String productPriceFieldText = this.productPriceField.getText();
            String productVendorFieldText = this.productVendorField.getText();
            String vendorCodeFieldText = this.productVendorCodeField.getText();
            String productCategoryIdText = this.productCategoryId.getText();

            if (productNameFieldText.isEmpty()
                    || productPriceFieldText.isEmpty()
                    || productVendorFieldText.isEmpty()
                    || vendorCodeFieldText.isEmpty()
                    || productCategoryIdText.isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "Every field must be not empty",
                        "Warning!",
                        JOptionPane.ERROR_MESSAGE);

            } else {

                ProductDTO productDTO = new ProductDTO();
                productDTO.setProductName(productNameFieldText);
                productDTO.setProductPrice(new BigDecimal(productPriceFieldText));
                productDTO.setVendor(productVendorFieldText);
                productDTO.setVendorCode(vendorCodeFieldText);
                productDTO.setCategoryId(Long.valueOf(productCategoryIdText));

                this.productService.add(productDTO);
                this.dispose();
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this,
                    "Illegal argument",
                    "Ooops",
                    JOptionPane.ERROR_MESSAGE);
        } catch (RestClientException ex) {
            JOptionPane.showMessageDialog(this,
                    "Couldn't add product",
                    "Ooops",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}

