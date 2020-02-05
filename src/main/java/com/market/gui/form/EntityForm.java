package com.market.gui.form;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class EntityForm extends JDialog {

    public final static boolean UPDATE_FORM = true;
    public final static boolean ADD_FORM = false;

    private JPanel buttonsPanel;
    protected JPanel fieldsPanel;
    protected GroupLayout fieldsLayout;

    public EntityForm(String name, boolean isUpdateForm) {
        super();
        this.setTitle(name);

        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        Border eBorder = BorderFactory.createEtchedBorder();

        if (isUpdateForm) {
            this.getRootPane().setBorder(BorderFactory.createTitledBorder(eBorder, "Update"));
        } else {
            this.getRootPane().setBorder(BorderFactory.createTitledBorder(eBorder, "Create"));
        }

        this.fieldsPanel = new JPanel();

        this.fieldsLayout = new GroupLayout(this.fieldsPanel);
        this.fieldsPanel.setLayout(this.fieldsLayout);
        this.fieldsLayout.setAutoCreateGaps(true);
        this.fieldsLayout.setAutoCreateContainerGaps(true);
        this.add(this.fieldsPanel);

        this.buttonsPanel = new JPanel();
        this.buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton confirmButton = new JButton("Confirm");

        confirmButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                    actionOnConfirm();
                }
            }
        });
        this.buttonsPanel.add(confirmButton);
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                    actionOnClose();
                }
            }
        });
        this.buttonsPanel.add(cancelButton);


        this.add(this.buttonsPanel);
    }

    protected abstract void actionOnClose();


    protected abstract void actionOnConfirm();

}
