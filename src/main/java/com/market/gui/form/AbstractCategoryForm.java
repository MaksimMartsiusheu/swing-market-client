package com.market.gui.form;

import com.market.service.impl.CategoryServiceImpl;

import javax.swing.*;

public abstract class AbstractCategoryForm extends EntityForm {

    protected JTextField categoryNameField;
    protected JTextField parentIdField;

    public AbstractCategoryForm(String name, boolean isUpdateForm) {
        super(name, isUpdateForm);

        JLabel categoryNameLabel = new JLabel("Category name");
        this.categoryNameField = new JTextField();
        JLabel categoryParentId = new JLabel("Parent id");
        this.parentIdField = new JTextField();
        super.fieldsLayout.setHorizontalGroup(super.fieldsLayout.createParallelGroup()
                .addGroup(this.fieldsLayout.createSequentialGroup()
                        .addComponent(categoryNameLabel)
                        .addComponent(this.categoryNameField))
                .addGroup(this.fieldsLayout.createSequentialGroup()
                        .addComponent(categoryParentId)
                        .addComponent(this.parentIdField))

        );

        super.fieldsLayout.setVerticalGroup(super.fieldsLayout.createSequentialGroup()
                .addGroup(this.fieldsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(categoryNameLabel)
                        .addComponent(this.categoryNameField))
                .addGroup(this.fieldsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(categoryParentId)
                        .addComponent(this.parentIdField)));

        super.fieldsLayout.linkSize(SwingConstants.HORIZONTAL, categoryNameLabel, categoryParentId);
    }
}
