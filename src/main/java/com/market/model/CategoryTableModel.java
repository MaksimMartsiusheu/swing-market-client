package com.market.model;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class CategoryTableModel extends DefaultTableModel {

    private final static String[] columns = {"Category Id", "Category Name", "Parent Id"};
    private List<CategoryDTO> categories;

    public CategoryTableModel(List<CategoryDTO> categories) {
        super(columns, categories.size());
        this.categories = categories;
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0 || columnIndex == 2) {
            return Long.class;
        } else if (columnIndex == 1) {
            return String.class;
        } else {
            throw new IllegalArgumentException("Incorrect column index");
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CategoryDTO categoryDTO = categories.get(rowIndex);

        if (columnIndex == 0) {
            return categoryDTO.getId();
        } else if (columnIndex == 1) {
            return categoryDTO.getCategoryName();
        } else if (columnIndex == 2) {
            return categoryDTO.getParentId();
        } else {
            throw new IllegalArgumentException("Incorrect column index");
        }
    }

    @Override
    public void setValueAt(Object o, int rowIndex, int columnIndex) {
    }


}
