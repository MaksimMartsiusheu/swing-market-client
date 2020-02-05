package com.market.gui.panel;

import com.market.gui.table.EntityTable;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class EntityPanel extends JPanel {

    protected JPanel headerLabelPanel;
    protected JPanel headerButtonsPanel;
    protected JPanel tablePanel;
    protected JPanel footerPanel;

    protected EntityTable entityTable;

    protected JButton refreshButton;
    protected JButton updateButton;
    protected JButton deleteButton;
    protected JButton addButton;

    public EntityPanel(String panelName) {
        super();

        this.setLayout(new GridBagLayout());
        GridBagConstraints gridConstraints = new GridBagConstraints();
        Border eBorder = BorderFactory.createEtchedBorder();

        this.headerLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        headerLabelPanel.setBorder(BorderFactory.createTitledBorder(eBorder));

        JLabel categoryLabel = new JLabel(panelName);
        categoryLabel.setFont(categoryLabel.getFont().deriveFont(18.0f));
        headerLabelPanel.add(categoryLabel);

        gridConstraints.gridx = gridConstraints.gridy = 0;
        gridConstraints.gridwidth = gridConstraints.gridheight = 1;
        gridConstraints.fill = GridBagConstraints.BOTH;
        gridConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridConstraints.weightx = 30;
        gridConstraints.weighty = 2;

        this.add(headerLabelPanel, gridConstraints);

        this.headerButtonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        headerButtonsPanel.setBorder(BorderFactory.createTitledBorder(eBorder));
        this.refreshButton = new JButton("Refresh");
        headerButtonsPanel.add(this.refreshButton);

        gridConstraints.gridx = 1;
        gridConstraints.gridy = 0;
        gridConstraints.gridwidth = gridConstraints.gridheight = 1;
        gridConstraints.fill = GridBagConstraints.BOTH;
        gridConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridConstraints.weightx = 70;
        gridConstraints.weighty = 2;

        this.add(headerButtonsPanel, gridConstraints);

        this.tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createTitledBorder(eBorder));

        this.entityTable = new EntityTable();
        this.entityTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tablePanel.add(new JScrollPane(this.entityTable));

        gridConstraints.gridx = 0;
        gridConstraints.gridy = 1;
        gridConstraints.gridwidth = 2;
        gridConstraints.gridheight = 1;
        gridConstraints.fill = GridBagConstraints.BOTH;
        gridConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridConstraints.weightx = 100;
        gridConstraints.weighty = 96;

        this.add(tablePanel, gridConstraints);

        this.footerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        this.footerPanel.setBorder(BorderFactory.createTitledBorder(eBorder));

        this.addButton = new JButton("Add");
        this.footerPanel.add(this.addButton);

        this.updateButton = new JButton("Update");
        this.footerPanel.add(this.updateButton);

        this.deleteButton = new JButton("Delete");
        this.footerPanel.add(this.deleteButton);

        gridConstraints.gridx = 0;
        gridConstraints.gridy = 2;
        gridConstraints.gridwidth = 2;
        gridConstraints.gridheight = 1;
        gridConstraints.fill = GridBagConstraints.BOTH;
        gridConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridConstraints.weightx = 100;
        gridConstraints.weighty = 2;

        this.add(footerPanel, gridConstraints);

    }
}
