package com.market.model;

import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;

public class ProductTableModel extends DefaultTableModel {

    private final static String[] columns = {
            "Product Id",
            "Product Name",
            "Product Price",
            "Vendor",
            "Vendor Code",
            "Category Id"
    };
    private List<ProductDTO> products;

    public ProductTableModel(List<ProductDTO> products) {
        super(columns, products.size());
        this.products = products;
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
        if (columnIndex == 0 || columnIndex == 5) {
            return Long.class;
        } else if (columnIndex == 1 || columnIndex == 3 || columnIndex == 4) {
            return String.class;
        } else if (columnIndex == 2) {
            return BigDecimal.class;
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
        ProductDTO product = products.get(rowIndex);

        if (columnIndex == 0) {
            return product.getId();
        } else if (columnIndex == 1) {
            return product.getProductName();
        } else if (columnIndex == 2) {
            return product.getProductPrice();
        } else if (columnIndex == 3) {
            return product.getVendor();
        } else if (columnIndex == 4) {
            return product.getVendorCode();
        } else if (columnIndex == 5) {
            return product.getCategoryId();
        } else {
            throw new IllegalArgumentException("Incorrect column index");
        }

    }

    @Override
    public void setValueAt(Object o, int rowIndex, int columnIndex) {

    }
}
