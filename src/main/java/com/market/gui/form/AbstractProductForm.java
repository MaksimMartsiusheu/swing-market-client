package com.market.gui.form;

import javax.swing.*;

public abstract class AbstractProductForm extends EntityForm {

    protected JTextField productNameField;
    protected JTextField productPriceField;
    protected JTextField productVendorField;
    protected JTextField productVendorCodeField;
    protected JTextField productCategoryId;

    public AbstractProductForm(String name, boolean isUpdateForm) {
        super(name, isUpdateForm);

        JLabel productNameLabel = new JLabel("Product name");
        this.productNameField = new JTextField();
        JLabel productPriceLabel = new JLabel("Product price");
        this.productPriceField = new JTextField();
        JLabel productVendorLabel = new JLabel("Product Vendor");
        this.productVendorField = new JTextField();
        JLabel productVendorCodeLabel = new JLabel("Vendor code");
        this.productVendorCodeField = new JTextField();
        JLabel productCategoryIdLabel = new JLabel("Category Id");
        this.productCategoryId = new JTextField();

        super.fieldsLayout.setHorizontalGroup(super.fieldsLayout.createParallelGroup()
                .addGroup(this.fieldsLayout.createSequentialGroup()
                        .addComponent(productNameLabel)
                        .addComponent(this.productNameField))
                .addGroup(this.fieldsLayout.createSequentialGroup()
                        .addComponent(productPriceLabel)
                        .addComponent(this.productPriceField))
                .addGroup(this.fieldsLayout.createSequentialGroup()
                        .addComponent(productVendorLabel)
                        .addComponent(this.productVendorField))
                .addGroup(this.fieldsLayout.createSequentialGroup()
                        .addComponent(productVendorCodeLabel)
                        .addComponent(this.productVendorCodeField))
                .addGroup(this.fieldsLayout.createSequentialGroup()
                        .addComponent(productCategoryIdLabel)
                        .addComponent(this.productCategoryId))

        );

        super.fieldsLayout.setVerticalGroup(super.fieldsLayout.createSequentialGroup()
                .addGroup(this.fieldsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(productNameLabel)
                        .addComponent(this.productNameField))
                .addGroup(this.fieldsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(productPriceLabel)
                        .addComponent(this.productPriceField))
                .addGroup(this.fieldsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(productVendorLabel)
                        .addComponent(this.productVendorField))
                .addGroup(this.fieldsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(productVendorCodeLabel)
                        .addComponent(this.productVendorCodeField))
                .addGroup(this.fieldsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(productCategoryIdLabel)
                        .addComponent(this.productCategoryId)));

        super.fieldsLayout.linkSize(SwingConstants.HORIZONTAL, productNameLabel,
                productPriceLabel,
                productVendorLabel,
                productVendorCodeLabel,
                productCategoryIdLabel);
    }


}
