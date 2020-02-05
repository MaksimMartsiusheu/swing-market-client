package com.market.gui.table;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.*;

public class EntityTable extends JTable {

    public EntityTable(TableModel tableModel) {
        super(tableModel);
    }

    public EntityTable() {
    }

    @Override
    public Component prepareRenderer(TableCellRenderer tableCellRenderer, int row, int column) {
        Component component = super.prepareRenderer(tableCellRenderer, row, column);
        int rendererWidth = component.getPreferredSize().width;
        TableColumn tableColumn = getColumnModel().getColumn(column);
        tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width,
                tableColumn.getPreferredWidth()));
        return component;
    }
}
